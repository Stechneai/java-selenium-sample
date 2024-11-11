package BankMaster;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class BankMasterTest extends BaseClass {

	@Test(priority = 1)
	public void LogIN() throws InterruptedException {
		// Test Case: Verify successful login
		a.anotherAccount();
		Thread.sleep(3000);
		a.enterEmail().sendKeys("Gokul.bhoi@techneai.com");
		Thread.sleep(3000);
		a.nextBtn().click();
		a.enterPwd().sendKeys("Techne@0126");
		Thread.sleep(3000);
		a.signInBtn().click();
		a.yesBtn().click();
		Thread.sleep(3000);

		// Assert that login is successful by checking the presence of a unique element
		// on the dashboard
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='TechneAI 2023']")).isDisplayed(), "Login failed");
	}

	@Test(priority = 2, dependsOnMethods = { "LogIN" })
	public void company() throws InterruptedException {
		// Test Case: Verify selecting a company from the dropdown
		WebElement dd = driver.findElement(By.id("CompanyButton"));
		act.doubleClick(dd).sendKeys(Keys.BACK_SPACE).build().perform();
		Thread.sleep(3000);
		act.click(dd).pause(15).sendKeys("HCSJ").build().perform();
		driver.findElement(By.xpath("//input[@title='HCSJ']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("NavBarDashboard_label")).click();
		a.modules().click();

		// Assert that company selection is successful by verifying the dashboard loads
		Assert.assertTrue(driver.findElement(By.xpath("//button[text()='CSPL']")).isDisplayed(),
				"Company selection failed");
	}

	@Test(priority = 3, dependsOnMethods = { "company" })
	public void addNew() throws InterruptedException, AWTException, IOException {
		// Test Case: Verify adding a new bank entry
		a.NewBtn().click();
		Thread.sleep(3000);
		a.bankName_Field().click();
		Thread.sleep(5000);
		a.bankName_Field().sendKeys(ex.fetchData_bm(1, 0));
		Thread.sleep(3000);
		a.descriptionField().click();
		a.descriptionField().sendKeys(ex.fetchData_bm(1, 1));
		Thread.sleep(3000);
		a.SaveButton().click();
		Thread.sleep(3000);

		// Verify that the new entry appears in the bank list
		a.TableHeader().click();
		a.Table_Search().sendKeys(ex.fetchData_bm(1, 0));
		Thread.sleep(3000);
		a.Table_Apply().click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='" + ex.fetchData_bm(1, 0) + "']")).isDisplayed(),
				"New bank entry not found in the list");
		a.Back_Btn().click();
	}

	@Test(priority = 4, dependsOnMethods = { "addNew" })
	public void editFunctions() throws InterruptedException, AWTException, IOException {
		// Test Case: Verify editing an existing bank entry
		a.modules().click();
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();", a.selectModule());
		a.selectModule().click();
		Thread.sleep(3000);
		a.expandAll().click();
		a.bankMaster().click();
		Thread.sleep(3000);

		// Search and Edit the bank entry
		a.TableHeader().click();
		a.Table_Search().sendKeys(ex.fetchData_bm(1, 0));
		Thread.sleep(3000);
		a.Table_Apply().click();
		Thread.sleep(3000);
		a.Edit_btn().click();
		Thread.sleep(3000);

		// Edit bank name and description
		a.bankName_Edit().click();
		a.bankName_Edit().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(3000);
		a.bankName_Edit().sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		a.bankName_Edit().sendKeys(ex.fetchData_bm(2, 0));

		a.descriptionEDIT().click();
		a.descriptionEDIT().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		a.descriptionEDIT().sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		a.descriptionEDIT().sendKeys(ex.fetchData_bm(2, 1));
		Thread.sleep(3000);
		a.SaveButton().click();

		// Verify that the entry has been updated
		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='" + ex.fetchData_bm(2, 0) + "']")).isDisplayed(),
				"Edited bank entry not found");
		a.Back_Btn().click();
	}

	@Test(priority = 5, dependsOnMethods = { "editFunctions" })
	public void delete() throws InterruptedException, AWTException, IOException {
		// Test Case: Verify deleting a bank entry
		a.modules().click();
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();", a.selectModule());
		a.selectModule().click();
		Thread.sleep(3000);
		a.expandAll().click();
		a.bankMaster().click();
		Thread.sleep(3000);

		// Search and delete the bank entry
		a.TableHeader().click();
		a.Table_Search().sendKeys(ex.fetchData_bm(2, 0));
		Thread.sleep(3000);
		a.Table_Search().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		a.Delete_btn().click();
		Thread.sleep(3000);
		a.Delete_Cfm_btn().click();

		// Verify the entry is deleted
		Assert.assertFalse(driver.findElements(By.xpath("//*[text()='" + ex.fetchData_bm(2, 0) + "']")).size() > 0,
				"Deleted bank entry is still present");
		a.Back_Btn().click();
	}
}
	