package snowsteps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Login extends AbstractTestNGCucumberTests{
public	static String  result;
public	static String Val;
public static WebDriver driver;


	@BeforeMethod
	public void preCondition() throws InterruptedException{
		ChromeDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://dev86082.service-now.com/");
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
		Thread.sleep(9000);

	}
	
	/*
	 * @AfterMethod public void postCondition() { driver.close(); }
	 */

}
