package commonDataProvider;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLeadData {
	ChromeDriver driver;
	public static String SheetName;
	
	@DataProvider
	public static String[][] POI() throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook wb1 = new XSSFWorkbook("./data/CreateLead.xlsx");
		XSSFSheet ws1 = wb1.getSheet(SheetName);
		//get row count
		int rc = ws1.getLastRowNum();
		//get column count
		int cc = ws1.getRow(0).getLastCellNum();
		String[][] D = new String[rc][cc];
		for (int i = 1; i <= rc; i++) {
			for (int j = 0; j < cc; j++) {
				String data = ws1.getRow(i).getCell(j).getStringCellValue();
				// System.out.println(data);
				D[i - 1][j] = data;
			}
		}
		wb1.close();
		System.out.println("Create inputs are : " + D);
		return D;
	}

@Parameters({"URL","Name","Password"})
	@BeforeMethod
	public void login(String url,String name,String password) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys(name);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
	}
	@AfterMethod
	public void logoff() {
		driver.close();
	}

}
