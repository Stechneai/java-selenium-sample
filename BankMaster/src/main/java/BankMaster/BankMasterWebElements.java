
package BankMaster;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankMasterWebElements extends BaseClass {

	public BankMasterWebElements() {
		PageFactory.initElements(driver, this);
	}

//	Login
	@FindBy(id = "otherTileText")
	private WebElement anotherAct;

	public WebElement anotherAccount() {
		return anotherAct;
	}

	// email
	@FindBy(id = "i0116")
	private WebElement email;

	public WebElement enterEmail() {
		return email;
	}

//	next button
	@FindBy(xpath = "//input[@value='Next']")
	private WebElement nxtbtn;

	public WebElement nextBtn() {
		return nxtbtn;
	}

// password
	@FindBy(id = "i0118")
	private WebElement pwd;

	public WebElement enterPwd() {
		return pwd;
	}

//sign in button
	@FindBy(xpath = "//input[@value='Sign in']")
	private WebElement signin;

	public WebElement signInBtn() {
		return signin;
	}

	@FindBy(xpath = "//input[@value='Yes']")
	private WebElement yesbtn;

	public WebElement yesBtn() {
		return yesbtn;
	}

// modules
	@FindBy(id = "navPaneModuleID")
	private WebElement module;

	public WebElement modules() {
		return module;
	}

//Jewellery master
	@FindBy(xpath = "//a[text()='Jewellery']")
	private WebElement jewel;

	public WebElement selectModule() {
		return jewel;
	}

//expand All
	@FindBy(xpath = "//button[@title='Expand all']")
	private WebElement expnd;

	public WebElement expandAll() {
		return expnd;
	}

	// ---Webelement of new button
	@FindBy(xpath = "//button[contains(@name,'SystemDefinedNewButton')]")
	private WebElement new_button;

	public WebElement NewBtn() {
		return new_button;
	}

	// Click on Color Master
	@FindBy(xpath = "//a[text()='Bank Master']")
	private WebElement bMaster;

	public WebElement bankMaster() {
		return bMaster;
	}

	// ---WebElement of Color Field
	@FindBy(xpath = "//input[contains(@name,'AcxBankMaster_Description')]")
	private WebElement dField;

	public WebElement descriptionField() {
		return dField;
	}
	@FindBy(xpath = "(//input[contains(@id,'MainGrid_Description_')])[1]")
	private WebElement deditField;

	public WebElement descriptionEDIT() {
		return deditField;
	}


	
	@FindBy(xpath = "//input[contains(@name,'AcxBankMaster_BankName')]")
	private WebElement bankName;

	public WebElement bankName_Field() {
		return bankName;
	}
	@FindBy(xpath = "//input[contains(@id,'MainGrid_BankName_')]")
	private WebElement AbankName;

	public WebElement bankName_Edit() {
		return AbankName;
	}

	

	// ---WebElement of Active field
	@FindBy(xpath = "(//div[contains(@class, 'dyn-container')]/div[@role='checkbox'])[1]")
	private WebElement ActiveField;

	public WebElement getActiveField() {
		return ActiveField;
	}

	@FindBy(xpath = "//span[contains(@id, 'SystemDefinedSaveButton_label') and contains(@class, 'button-label')]")
	private WebElement Save_B;

	public WebElement SaveButton() {
		return Save_B;
	}

	@FindBy(xpath = "//span[contains(@class, 'button-commandRing') and contains(@class, 'Back-symbol') and contains(@data-dyn-bind, 'img: $dyn.ui.img($data)') and @data-dyn-image-type='Symbol']")
	private WebElement BackBtn;

	public WebElement Back_Btn() {
		return BackBtn;
	}

	@FindBy(xpath = "//div[text()='Bank Name']")
	private WebElement THeader;

	public WebElement TableHeader() {
		return THeader;
	}

	@FindBy(xpath = "//input[contains(@id, '__FilterField_MainGrid_BankName_BankName_Input')]")
	private WebElement TableSearch;

	public WebElement Table_Search() {
		return TableSearch;
	}

	@FindBy(id = "__MainGrid_BankName_ApplyFilters_label")
	private WebElement TableApply;

	public WebElement Table_Apply() {
		return TableApply;
	}

	@FindBy(xpath = "//span[contains(@id, '_label') and contains(@data-dyn-bind, 'button-label') and text()='Edit']")
	private WebElement Edit;

	public WebElement Edit_btn() {
		return Edit;
	}

	@FindBy(xpath = "//span[contains(@id, 'SystemDefinedDeleteButton_label')]")
	private WebElement Delete;

	public WebElement Delete_btn() {
		return Delete;
	}
	@FindBy(xpath = "//span[contains(@id, '_label') and text()='Yes']")
	private WebElement DeleteCfm;

	public WebElement Delete_Cfm_btn() {
		return DeleteCfm;
	}	
	@FindBy(xpath = "//div[contains(@class, 'dyn-container') and contains(@class, '_ln972h') and contains(@class, 'dyn-svg-symbol')]")
	private WebElement select;

	public WebElement select_btn() {
		return select;
	}
	
}
