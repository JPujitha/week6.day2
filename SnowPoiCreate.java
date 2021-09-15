package commonDataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SnowPoiCreate extends BaseSnowData {
	
	@BeforeClass
	public void setSheet() {
		Sheet="create";
	}
	
	@Test(dataProvider = "poiData")
	public void create(String frame1, String frame2, String dscrptn) throws InterruptedException {
		driver.findElement(By.xpath("(//div[text()='Create New'])[1]")).click();
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[1]")).click();
		Set<String> WH1 = driver.getWindowHandles();
		List<String> wh1 = new ArrayList(WH1);
		driver.switchTo().window(wh1.get(1));
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(wh1.get(0));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame2);
		driver.findElement(By.id("incident.short_description")).sendKeys(dscrptn);
		WebElement id = driver.findElement(By.id("incident.number"));
		String Val = id.getAttribute("value");
		driver.findElement(By.id("sysverb_insert")).click();
		WebElement ival = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		ival.sendKeys(Val);
		ival.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		WebElement ver = driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]"));
		String result = ver.getText();
		if (Val.equals(result)) {
			System.out.println("Incident created successfully");
		} else {
			System.out.println("Incident not created");
		}
	}
}
	
	