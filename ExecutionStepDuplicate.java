package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ExecutionStepDuplicate extends Conditions {
		@Then("Click on duplicare lead")
	public void duplicatelead() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
	
}
