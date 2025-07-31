package POMUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrgPomPge {
@FindBy(xpath = "//span[text()='Creating New Organization']")
private WebElement header;

@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
private WebElement savebtn;

@FindBy(name = "accountname")
private WebElement orgnametf;

@FindBy(id = "phone")
private WebElement phoneTf;

@FindBy(name="industry")
private WebElement industryDD;

@FindBy(name="accounttype")
private WebElement typeDD;

//initialization
public CreateNewOrgPomPge(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}
//utilization

public WebElement getHeader() {
	return header;
}

public void getSavebtn() {
	 savebtn.click();
	
}

public void getOrgnametf(String orgname) {
	 orgnametf.sendKeys(orgname);
}
public void getPhoneTf(String phonenum) {
	phoneTf.sendKeys(phonenum);
}

public WebElement getIndustryDD() {
	return industryDD;
}

public WebElement getTypeDD() {
	return typeDD;
}



}







