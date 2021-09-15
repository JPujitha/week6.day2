package snowsteps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateIncident extends Login {
	public static boolean check1;
	public static boolean check2;
	public static SoftAssert soft;
	@Given("Click on All")
	public void clickAll() {
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
	}
	@When("Apply with {string}")
	public void applystate(String state) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		WebElement fltr = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select filter = new Select(fltr);
		filter.selectByValue(state);
	}
	@When("Enter filter value as {string}")
	public void enterfilters(String New) {
		WebElement up = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		up.sendKeys(New);
		up.sendKeys(Keys.ENTER);
	}
	@Then("Select first resultant incident")
	public void selectIncident() {
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	}

	@Given("Chnage state")
	public void changestate() {
		WebElement state = driver.findElement(By.id("incident.state"));
		Select State = new Select(state);
		State.selectByValue("2");
		check1 = State.equals(State);
	}
	
	@Given("Change Urgency")
	public void changeurgency() {
		WebElement urgency = driver.findElement(By.id("incident.urgency"));
		Select Urgency = new Select(urgency);
		Urgency.selectByVisibleText("1 - High");
		check2 = Urgency.equals(Urgency);

	}
	@Given("Check if update is successfull")
	public void check() {
		soft=new SoftAssert();
		soft.assertTrue(check1);
		soft.assertTrue(check2);
 System.out.println("Updated Successfully");
 driver.findElement(By.id("activity-stream-work_notes-textarea")).sendKeys("Test");
	}
 @Given("click update")
 public void clickonupdate() {
 driver.findElement(By.id("sysverb_update")).click();
}
}
