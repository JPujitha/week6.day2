package CrossBrowsingDependencygroups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class BaseSnow {
	public RemoteWebDriver driver;
	@Parameters("browser")
	@BeforeMethod
	public void preCondition(String browser) throws InterruptedException {
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			ChromeDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else {
			ChromeDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.get("https://dev86082.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Pass@123");
		driver.findElement(By.id("sysverb_login")).click();
		driver.switchTo().defaultContent();
		WebElement filter = driver.findElement(By.id("filter"));
		filter.sendKeys("Incident");
		filter.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}
@AfterMethod
public void postCondition() {
		driver.close();
	}

}
