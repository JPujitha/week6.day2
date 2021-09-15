package snowsteps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateIncidents extends Login {

	@Given("Click on CreateNew")
	public void clinknewincident() throws InterruptedException {
		driver.findElement(By.xpath("(//div[text()='Create New'])[1]")).click();
	}

	@And("Click on search icon for caller and select name")
	public void clickcaller() throws InterruptedException {
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[1]")).click();
		Set<String> WH1 = driver.getWindowHandles();
		List<String> wh1 = new ArrayList<String>(WH1);
		driver.switchTo().window(wh1.get(1));
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(wh1.get(0));
		driver.switchTo().defaultContent();
	}

	@Given("Short description")
	public void enterShortdescription() {

		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("incident.short_description")).sendKeys("test");
	}

	@And("Captured Id")
	public void capture() {
		WebElement id = driver.findElement(By.id("incident.number"));
		Val = id.getAttribute("value");
	}

	@Given("Click on submit")
	public void clicksubmit() {
		driver.findElement(By.id("sysverb_insert")).click();
	}

	@And("Enter values in search")
	public void seachvalue() throws InterruptedException {
		WebElement ival = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		ival.sendKeys(Val);
		ival.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}

	@And("Get the result incident ID")
	public void getresultid() {
		WebElement ver = driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]"));
		result = ver.getText();
	}

	@Then("compare both crated and result incident")
	public void comparestring() {
		Assert.assertEquals(result,Val);
		System.out.println("Incident created");
	}
}
