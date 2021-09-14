package steps;

import org.openqa.selenium.By;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExecutionStepsCreate extends Conditions {
	public static String leadID;
	@Then("click on createleads")
	public void clickcreatelead() {
		driver.findElement(By.linkText("Create Lead")).click();
	}

	@Given("Enter first name of person {string}")
	public void enterfirstnametocreate(String FirstName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(FirstName);
	}

	@And("Enter last name of person {string}")
	public void enterlastnametocreate(String LastName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(LastName);
	}

	@And("Enter Company name as {string}")
	public void givecmpnynametocreate(String Companyname) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(Companyname);
	}

	@And("Enter phone numbers {string}")
	public void givephnnumtocreate(String PhoneNumbers) {
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(PhoneNumbers);
	}

	@Given("Click {string}")
	public void givesubmittocreate(String submit) {
		driver.findElement(By.name(submit)).click();
	}
	

	
}