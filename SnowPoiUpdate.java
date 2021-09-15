package commonDataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SnowPoiUpdate extends BaseSnowData {
	@BeforeClass
	public void setSheet() {
		Sheet="update";
	}
	
	@Test(dataProvider = "poiData")
	public void update(String frm, String fltrwith) {
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frm);
		WebElement fltr = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select filter = new Select(fltr);
		filter.selectByValue("state");
		WebElement up = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		up.sendKeys(fltrwith);
		up.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		WebElement state = driver.findElement(By.id("incident.state"));
		Select State = new Select(state);
		State.selectByValue("2");
		boolean check1 = State.equals(State);

		WebElement urgency = driver.findElement(By.id("incident.urgency"));
		Select Urgency = new Select(urgency);
		Urgency.selectByVisibleText("1 - High");
		boolean check2 = Urgency.equals(Urgency);
		if (check1 && check2 == true) {
			System.out.println("Incident Updated Successfully");
		} else {
			System.out.println("Incident not Updated");

		}

	}


}
