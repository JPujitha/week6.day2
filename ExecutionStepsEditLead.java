package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ExecutionStepsEditLead extends Conditions {
	@Given("Click find leads")
	public void clickfindleadstoedit() {
		driver.findElement(By.linkText("Find Leads")).click();
	}
	@Then("Click phone")
	public void clickphonetoedit() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}
	@Given("Enter phone number {string}")
	public void phonenumbertoedit(String PhoneNumbertoedit) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(PhoneNumbertoedit);
	}
	
	@Then("Click on find leads")
	public void findleadstoedit() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}
	
	@Then("Click on first lead id")
	public void clickfirstleadidtoedit() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	
	@Given("Click on edit")
	public void clickonedittoedit() {
		driver.findElement(By.linkText("Edit")).click();
	}
	
	@Then("Updated company name {string}")
	public void updatecmpnynametoedit(String CompanyNametoedit) {
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(CompanyNametoedit);

	}
	}
