package commonDataProvider;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PoiCreateLead extends BaseLeadData {
	@BeforeClass
	public void setSheetName() {
		SheetName="create";
	}
	@Test(dataProvider = "POI", enabled = true, priority = 1)
	public void create(String cmpny, String fname, String lname, String phn) {

		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cmpny);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phn);
		driver.findElement(By.name("submitButton")).click();
	}
	}
