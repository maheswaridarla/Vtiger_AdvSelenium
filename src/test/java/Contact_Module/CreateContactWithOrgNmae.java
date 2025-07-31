package Contact_Module;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

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
import POMUtility.ContactInfoPomPage;
import POMUtility.ContactPompage;
import POMUtility.CreateNewContactPomPge;
import POMUtility.CreateNewOrgPomPge;
import POMUtility.HomePomPage;
import POMUtility.LoginPompage;
import POMUtility.OrgInfoPomPage;
import POMUtility.OrgPomPge;

public class CreateContactWithOrgNmae {

	@Test
	public void Create_Orgwith_Cont() throws Exception {

		// Fetch the data from Property file
		PropertyfileUtility prop = new PropertyfileUtility();
		String browser = prop.FetchingDtadaFromPropertyFile("browser");
		String URL = prop.FetchingDtadaFromPropertyFile("url");
		String UN = prop.FetchingDtadaFromPropertyFile("un");
		String PSWD = prop.FetchingDtadaFromPropertyFile("password");
		String TIME = prop.FetchingDtadaFromPropertyFile("timeouts");
		// fetch randum number
		JavaUtility jutil = new JavaUtility();
		int randumnum = jutil.GenerateRandumNum();

		// Fetch data from Excel
		ExcelFileUtilities excelfile = new ExcelFileUtilities();
		String Org_name = excelfile.FetchDataFromExcelFile("cont_data", 7, 2) + randumnum;
		String Contact_name = excelfile.FetchDataFromExcelFile("cont_data", 7, 3) + randumnum;

		// Launch the browser
		WebDriver driver = new ChromeDriver();
		WebdriverUtility wutil = new WebdriverUtility();
		// Maximize the window
		wutil.MaximizeTheWindow(driver);
		// Implicit wait
		wutil.WaitUntilElementFound(driver, TIME);
		// Navigate to appln
		wutil.NavigateToAnApplication(driver, URL);

		// login to application
		LoginPompage login = new LoginPompage(driver);
		login.login(UN, PSWD);

		
		// identify orgnization link and click on organization tab
				HomePomPage home = new HomePomPage(driver);
				home.getOrgtab();

				//  Identify organization link and click
				OrgPomPge org = new OrgPomPge(driver);
				org.getOrgplusicon();
		
//		// Identify organization link and click
//		driver.findElement(By.linkText("Organizations")).click();
//
//		// Identify create plus icon n click
//		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();

//		// click on org name textfield enter data
		CreateNewOrgPomPge neworg= new CreateNewOrgPomPge(driver);
		neworg.getOrgnametf(Org_name);
		
//		driver.findElement(By.name("accountname")).sendKeys(Org_name);
//
//		// identify save button and click
		neworg.getSavebtn();

		// identify header in org info page and validate
		OrgInfoPomPage orginfo=new OrgInfoPomPage(driver);
		String actualOrgName = orginfo.getVerifyOrgName();
//		WebElement header = driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]"));

		if (actualOrgName.contains(Org_name)) {
			System.out.println("create Org test pass");

		} else {

			System.out.println("create Org test fail");

		}

		// Identify Contacts link and click
		
		home.getConttab();

		// Identify create plus icon n click
		 ContactPompage cont = new ContactPompage(driver);
		 cont.getConplusicon();
		
		
		// Identify contactname tf and enter contact name
         CreateNewContactPomPge contact = new CreateNewContactPomPge(driver);
         contact.getLastnametf(Contact_name);
//		driver.findElement(By.name("lastname")).sendKeys(Contact_name);

		// Fetch parent window id
//		String pwid = driver.getWindowHandle();
         String pwid=wutil.FetchParentWindowId(driver);

		// Identify orgname + icon
		contact.getOrgplusicon();
		wutil.SwitchToChildWindowUsingUrl(driver, "module=Accounts&action=Popup");
//		driver.findElement(By.xpath("//img[contains(@onclick,'specific_contact_account_address')]")).click();

		// Fetch all the window handles
	contact.getOrgsearchtf(Org_name);
	contact.getOrgsearchbtn();
	
//		driver.findElement(By.name("search_text")).sendKeys(Org_name);
//		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='" + Org_name + "']")).click();
		wutil.SwitchToPrentWindow(driver, pwid);

        // identify save button and click
		neworg.getSavebtn();
//           driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		// identify header in contact info page and validate
         
          ContactInfoPomPage info = new ContactInfoPomPage(driver);
          String header1 = info.getHeader();
		if (header1.contains(Contact_name)) {
			System.out.println("create Contact with org verified last name test pass");

		} else {

			System.out.println("create Contact with org verified last name  test fail");

		}
 
		// identify orgname in contact page

		String Verifyorgname = driver.findElement(By.id("mouseArea_Organization Name")).getText();

		if (Verifyorgname.contains(Org_name)) {
			System.out.println("create contact with Org verified orgname test pass");

		} else {

			System.out.println("create contact with Org verified orgname test fail");

		}

		// Identify Contact tab and click

		home.getConttab();

		// identify and click on del link

		driver.findElement(By.xpath(
				"//a[text()='" + Contact_name + "']/ancestor::tr[@bgcolor=\"white\"]/descendant::a[text()='del']"))
				.click();

		Thread.sleep(3000);

		// Handle delete pop up
           wutil.HandlingAlertPopupAndClickON(driver);

		Thread.sleep(3000);
		// Identify organization link and click
		home.getOrgtab();
		
        // identify and click on del link
           driver.findElement(
				By.xpath("//a[text()='" + Org_name + "']/ancestor::tr[@bgcolor=\"white\"]/descendant::a[text()='del']"))
				.click();

		Thread.sleep(3000);

		// Handle delete pop up
		wutil.HandlingAlertPopupAndClickON(driver);
		Thread.sleep(3000);

		// WebElement acts1 =
		// driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
WebElement admin=home.getAdmin();
		// mouse over on the sign in link and click on sign out
		wutil.MouseOverOnAnElement(driver, admin);
		home.getSignout();

		driver.quit();
	}

}
