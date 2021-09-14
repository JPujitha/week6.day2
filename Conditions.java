package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import io.cucumber.java.en.Given;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Conditions extends AbstractTestNGCucumberTests {
	public static ChromeDriver driver;
	public static String leadID;
	public static String text;

	@BeforeMethod
	public void precondition() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		Boolean isdisplayed = driver.findElement(By.linkText("CRM/SFA")).isDisplayed();
		if (isdisplayed) {
			System.out.println("is Displayed");
		}
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();

	}
}
