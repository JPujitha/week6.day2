package snowsteps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssignIncident extends Login{
	public static String ID;
	static WebElement val;
	static String grp;
	@And("Find Id and store it")
	public void storeid() {
		WebElement id = driver.findElement(By.id("incident.number"));
		ID = id.getAttribute("value");
	}
	
	@And("Click to search assignment group")
	public void clickgroupicon() {
		driver.findElement(By.id("lookup.incident.assignment_group")).click();
	}
	
	@And("In groups click {string}")
	public void choosesoftware(String grp) {
		Set<String> wh = driver.getWindowHandles();
		List<String> WH = new ArrayList<String>(wh);
		driver.switchTo().window(WH.get(1));
		driver.findElement(By.xpath("//a[text()='"+grp+"']")).click();
	}
	@And("Enter worknotes as {string}")
	public void enterNote(String des) {
		Set<String> wh = driver.getWindowHandles();
		List<String> WH = new ArrayList<String>(wh);
		driver.switchTo().window(WH.get(0));
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys(des);
	}
	@When("Apply with  the {string}")
	public void applyNumberFilter(String num) {
		WebElement fltrs = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select filters = new Select(fltrs);
		filters.selectByValue(num);
	}
	
	@When("Enter filter value {string}")
	public void searchID(String id) {
		WebElement srch = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		srch.sendKeys(id);
		srch.sendKeys(Keys.ENTER);

	}
	@And("Get the assignment_group")
	public void getGroup() {
		val = driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']"));
	}
	@Then("Verify the assignment is successfull or not with")
	public void verifyassigned() {
		String Value = val.getAttribute("value");
		Assert.assertEquals("Software",Value);	
		System.out.println("Assigned successfully");
	}
	
}
