package POMUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPomPge {
//declaration
	@FindBy(linkText = "Organizations")
	private WebElement header;
	
	@FindBy(xpath = "//img[@title=\"Create Organization...\"]")
	private WebElement orgplusicon;
//declaration
	public OrgPomPge(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
//utilization
	public String getHeader() {
		return header.getText();
	}
	public void getOrgplusicon() {
		 orgplusicon.click();
	}
	

	
	
	
	
	
	
}
