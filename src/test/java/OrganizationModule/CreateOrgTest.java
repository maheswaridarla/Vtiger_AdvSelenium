package OrganizationModule;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtilities;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyfileUtility;
import GenericUtilities.WebdriverUtility;
import POMUtility.CreateNewOrgPomPge;
import POMUtility.HomePomPage;
import POMUtility.LoginPompage;
import POMUtility.OrgInfoPomPage;
import POMUtility.OrgPomPge;

public class CreateOrgTest {

	@Test
	public void CreateNewOrgTest() throws Exception {
		// FETCH THE DATA FROM PROPERTY FILE
		PropertyfileUtility prop = new PropertyfileUtility();
		String browser = prop.FetchingDtadaFromPropertyFile("browser");
		String URL = prop.FetchingDtadaFromPropertyFile("url");
		String UN = prop.FetchingDtadaFromPropertyFile("un");
		String PSWD = prop.FetchingDtadaFromPropertyFile("password");
		String TIME = prop.FetchingDtadaFromPropertyFile("timeouts");
		// fetch randum number
		JavaUtility jutil = new JavaUtility();
		int randumnum = jutil.GenerateRandumNum();
		// FETCH THE DATA FROM EXCEL FILE
		ExcelFileUtilities excelfile = new ExcelFileUtilities();
		String orgname = excelfile.FetchDataFromExcelFile("Org_data", 1, 2) + randumnum;

		// launche the browser
		WebDriver driver = new ChromeDriver();
		WebdriverUtility wutil = new WebdriverUtility();
		// maximize the window
		wutil.MaximizeTheWindow(driver);
		// implicitly wait
		wutil.WaitUntilElementFound(driver, TIME);
		// navigate to an application
		wutil.NavigateToAnApplication(driver, URL);

		// login to application
		LoginPompage login = new LoginPompage(driver);
		login.login(UN, PSWD);
		// identify orgnization link
		HomePomPage home = new HomePomPage(driver);
		home.getOrgtab();

		// Identify create plus icon n click
		OrgPomPge org = new OrgPomPge(driver);
		org.getOrgplusicon();

		//identify orgnization textfeild and click on save button
		CreateNewOrgPomPge neworg= new CreateNewOrgPomPge(driver);
		neworg.getOrgnametf(orgname);
		neworg.getSavebtn();
		
		// identify header in org info page and validate
		OrgInfoPomPage orginfo = new OrgInfoPomPage(driver);
		String actualOrgName = orginfo.getVerifyOrgName();
//		WebElement header = driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]"));

		if (actualOrgName.contains(orgname)) {
			System.out.println("create Org test pass");

		} else {

			System.out.println("create Org test fail");

		}
		// Identify organization link and click
		home.getOrgtab();
		// identify and click on del link
		driver.findElement(
				By.xpath("//a[text()='" + orgname + "']/ancestor::tr[@bgcolor=\"white\"]/descendant::a[text()='del']"))
				.click();

		// Handle delete pop up
		wutil.HandlingAlertPopupAndClickON(driver);
		Thread.sleep(3000);
		// sign out
		wutil.MouseOverOnAnElement(driver, home.getAdmin());
		home.getSignout();
		// close the browser
		wutil.QuitTheBrowser(driver);

	}

}
