package POMUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPompage {
//declaration
	@FindBy(linkText = "Contacts")
	private WebElement header;
	
	@FindBy(xpath = "//img[@alt=\"Create Contact...\"]")
	private WebElement conplusicon ;

	//initialization
	public ContactPompage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public String getHeader() {
		return header.getText();
	}

	public void getConplusicon() {
		 conplusicon.click();;
	}
	

	
	
	
	
	
	
	
	
	
	
}
