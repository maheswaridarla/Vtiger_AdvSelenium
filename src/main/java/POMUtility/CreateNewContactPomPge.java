package POMUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPomPge {

	//declaration
	@FindBy(xpath = "//span[text()=\"Creating New Contact\"]")
	private WebElement header;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement savebtn;
	
	@FindBy(name = "lastname")
	private WebElement lastnametf ;
	
	@FindBy(name = "support_start_date")
	private WebElement startdatetf ;
	
	@FindBy(name = "support_end_date")
	private WebElement  enddatetf;
	
	@FindBy(xpath = "//img[contains(@onclick,'specific_contact_account_address')]")
	private WebElement orgplusicon;
	
	@FindBy(name = "search_text")
	private WebElement  orgsearchtf;
	
	@FindBy(name = "search")
	private WebElement  orgsearchbtn;
	
	//initialization
	
	public CreateNewContactPomPge(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//utilization
	
	public String getHeader() {
		return header.getText();
	}

	public void getSavebtn() {
		 savebtn.click();;
	}

	public void getLastnametf(String lastname) {
		 lastnametf.sendKeys(lastname);
	}

	public WebElement getStartdatetf() {
		return startdatetf;
	}

	public WebElement getEnddatetf() {
		return enddatetf;
	}

	public void getOrgplusicon() {
		 orgplusicon.click();
	}

	public void getOrgsearchtf(String orgname) {
		 orgsearchtf.sendKeys(orgname);
	}

	public void getOrgsearchbtn() {
		 orgsearchbtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
