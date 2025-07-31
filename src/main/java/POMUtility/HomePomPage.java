package POMUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebdriverUtility;

public class HomePomPage {

	//declaration
	
	@FindBy(partialLinkText = "Home")
	private WebElement header;
	
	@FindBy(linkText = "Organizations")
	private WebElement orgtab;
	
	@FindBy(linkText = "Contacts")
	private WebElement conttab;
	
	@FindBy(xpath = "//span[text()=\" Administrator\"]/../..//img")
	private WebElement admin;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signout;

	//initailization
	public HomePomPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public String getHeader() {
		return header.getText();
	}

	public void getOrgtab() {
		 orgtab.click();
	}

	public void getConttab() {
		 conttab.click();
	}

	public WebElement getAdmin() {
		return admin;
	}

	public void getSignout() {
		signout.click();
	}

	//bussiness logic or log out
	public void logout(WebDriver driver) {
		WebdriverUtility wutil=new WebdriverUtility();
		wutil.MouseOverOnAnElement(driver, admin);
		signout.click();
	}
	
}
