package POMUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPomPage {

//declaration

	@FindBy(xpath = "//td[text()='Contact Information']")
	private WebElement header;

	@FindBy(id = "mouseArea_Last Name")
	private WebElement verifylastname;

	@FindBy(id = "mouseArea_Organization Name")
	private WebElement verifyorgname;

	@FindBy(id = "mouseArea_Support Start Date")
	private WebElement verifyStartDate;

	@FindBy(id = "mouseArea_Support End Date")
	private WebElement verifyEndDate;

//initialization

	public ContactInfoPomPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilization

	public String getHeader() {
		return header.getText();
	}

	public String getVerifylastname() {
		return verifylastname.getText();
	}

	public String getVerifyorgname() {
		return verifyorgname.getText();
	}

	public String getVerifyStartDate() {
		return verifyStartDate.getText();
	}

	public String getVerifyEndDate() {
		return verifyEndDate.getText();
	}

}
