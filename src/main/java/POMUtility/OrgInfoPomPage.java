package POMUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPomPage {

	// declartion
	@FindBy(xpath = "//td[text()='Organization Information']")
	private WebElement header;

	@FindBy(id = "dtlview_Organization Name")
	private WebElement verifyOrgName;

	@FindBy(id = "dtlview_Phone")
	private WebElement verifyPhno;

	@FindBy(id = "dtlview_Industry")
	private WebElement verifyIndustryDD;

	@FindBy(id = "dtlview_Type")
	private WebElement verifyTypeDD;

	// initialization

	public OrgInfoPomPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization

	public String getHeader() {
		return header.getText();
	}

	public String getVerifyOrgName() {
		return verifyOrgName.getText();
	}

	public String getVerifyPhno() {
		return verifyPhno.getText();
	}

	public String getVerifyIndustryDD() {
		return verifyIndustryDD.getText();
	}

	public String getVerifyTypeDD() {
		return verifyTypeDD.getText();
	}

}
