package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ExecutionStepsDeleteLead extends Conditions {
		@Then("Capture the first lead")
	public void capturefirstlead() {
		 leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		}
	
	@Then("Click on delete lead")
	public void deletelead() {
		driver.findElement(By.linkText("Delete")).click();
	}
	
	@Given("Enter the captured id")
	public void captureid() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		text = driver.findElement(By.className("x-paging-info")).getText();
	}
	@Then("Compare text")
public void comparetext() {
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
}
	}


