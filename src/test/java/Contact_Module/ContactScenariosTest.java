package Contact_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseClassUtility.Baseclass;
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
@Listeners (liteners_Utility.Listeners.class)
public class ContactScenariosTest extends Baseclass {
	// @Parameters("browser")
	@Test(groups = "smoke", retryAnalyzer = liteners_Utility.IRetryAnalyzerUtility.class)
	public void CreateNewContact1() throws Exception {
		// FETCH THE DATA FROM PROPERTY FILE
//		PropertyfileUtility prop = new PropertyfileUtility();
//		String browser = prop.FetchingDtadaFromPropertyFile("browser");
//		String URL = prop.FetchingDtadaFromPropertyFile("url");
//		String UN = prop.FetchingDtadaFromPropertyFile("un");
//		String PSWD = prop.FetchingDtadaFromPropertyFile("password");
//		String TIME = prop.FetchingDtadaFromPropertyFile("timeouts");
		// fetch  the randum number
		liteners_Utility.Listeners.test.log(Status.INFO, "fetch randum number");
		JavaUtility jutil = new JavaUtility();
		int randumnum = jutil.GenerateRandumNum();

		// FETCH THE DATA FROM EXCEL FILE
		liteners_Utility.Listeners.test.log(Status.INFO, "FETCH THE DATA FROM EXCEL FILE");
		ExcelFileUtilities excelfile = new ExcelFileUtilities();
		String Contact_name = excelfile.FetchDataFromExcelFile("cont_data", 1, 2) + randumnum;

//		// launche the browser
//	WebDriver driver = null;
//		if(BROWSER.equals("chrome")) {
//			driver=new ChromeDriver();
//		}
//		else if(BROWSER.equals("edge")) {
//			driver=new EdgeDriver();
//		}
//		else {
//			driver=new ChromeDriver();
//		}
		WebdriverUtility wutil = new WebdriverUtility();

//		// maximize the window
//		wutil.MaximizeTheWindow(driver);
//
//		// implicitly wait
//		wutil.WaitUntilElementFound(driver, TIME);
//
//		// navigate to an application
//		wutil.NavigateToAnApplication(driver, URL);
//
//		// login to application
//		LoginPompage login = new LoginPompage(driver);
//		login.login(UN, PSWD);

		// identify contact tab and click
		liteners_Utility.Listeners.test.log(Status.INFO, "identify contact tab and click");
		HomePomPage home = new HomePomPage(driver);
		home.getConttab();

		//

		// Identify create plus icon n click
		liteners_Utility.Listeners.test.log(Status.INFO, "Identify create plus icon n click");
		ContactPompage cont = new ContactPompage(driver);
		cont.getConplusicon();

		// identify contact last name textfeild
		liteners_Utility.Listeners.test.log(Status.INFO, "identify contact last name textfeild");
		CreateNewContactPomPge contact = new CreateNewContactPomPge(driver);
		contact.getLastnametf(Contact_name);
		// driver.findElement(By.name("lastname")).sendKeys(Contact_name);

		// identify save button and click
		liteners_Utility.Listeners.test.log(Status.PASS, "identify save button and click");
		contact.getSavebtn();
		// driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		// identify header in contact info page and validate
		liteners_Utility.Listeners.test.log(Status.PASS, "identify header in contact info page and validate");
		ContactInfoPomPage coninfo = new ContactInfoPomPage(driver);
		String actual_lastname = coninfo.getVerifylastname();

		if (actual_lastname.contains(Contact_name)) {
			System.out.println("Create contact verified contact test pass");

		} else {

			System.out.println("create contact  verified contact test fail");

		}
		// Identify contcat tab and click
		liteners_Utility.Listeners.test.log(Status.PASS, "Identify contcat tab and click");

		home.getConttab();

		// identify and click on del link
		liteners_Utility.Listeners.test.log(Status.PASS, "identify and click on del link");
		driver.findElement(By.xpath(
				"//a[text()='" + Contact_name + "']/ancestor::tr[@bgcolor=\"white\"]/descendant::a[text()='del']"))
				.click();

		// Handle delete pop up
		liteners_Utility.Listeners.test.log(Status.PASS, "Handle delete pop up");
		wutil.HandlingAlertPopupAndClickON(driver);

		Thread.sleep(3000);
		// mouse over on sign in icon and click on sign out
		
//		wutil.MouseOverOnAnElement(driver, home.getAdmin());
//		home.getSignout();
//
//		// close the browser
//		wutil.QuitTheBrowser(driver);

	}

	// @Parameters("browser")
	@Test(groups = "reg", retryAnalyzer = liteners_Utility.IRetryAnalyzerUtility.class)
	public void CreateNewContact() throws Exception {
		// FETCH THE DATA FROM PROPERTY FILE
//		PropertyfileUtility prop = new PropertyfileUtility();
//		String browser = prop.FetchingDtadaFromPropertyFile("browser");
//		String URL = prop.FetchingDtadaFromPropertyFile("url");
//		String UN = prop.FetchingDtadaFromPropertyFile("un");
//		String PSWD = prop.FetchingDtadaFromPropertyFile("password");
//		String TIME = prop.FetchingDtadaFromPropertyFile("timeouts");

		// fetch randum number
		liteners_Utility.Listeners.test.log(Status.INFO, "fetch randum number");
		JavaUtility jutil1 = new JavaUtility();
		int randumnum = jutil1.GenerateRandumNum();

		// FETCH THE DATA FROM EXCEL FILE
		liteners_Utility.Listeners.test.log(Status.INFO, "FETCH THE DATA FROM EXCEL FILE");
		ExcelFileUtilities excelfile = new ExcelFileUtilities();
		String Contact_name = excelfile.FetchDataFromExcelFile("cont_data", 4, 2) + randumnum;
		System.out.println(Contact_name);

//		// launche the browser
		liteners_Utility.Listeners.test.log(Status.INFO, "launche the browser");
//		WebDriver driver = null;
//		if(BROWSER.equals("chrome")) {
//			driver=new ChromeDriver();
//		}
//		else if(BROWSER.equals("edge")) {
//			driver=new EdgeDriver();
//		}
//		else {
//			driver=new ChromeDriver();
//		}

		WebdriverUtility wutil = new WebdriverUtility();
//		// maximize the window
//		wutil.MaximizeTheWindow(driver);
//
//		// implicitly wait
//		wutil.WaitUntilElementFound(driver, TIME);
//
//		// navigate to an application
//		wutil.NavigateToAnApplication(driver, URL);
//
//		// login to application
//		LoginPompage login = new LoginPompage(driver);
//		login.login(UN, PSWD);

		// identify contact tab and click on it
		liteners_Utility.Listeners.test.log(Status.PASS, "identify contact tab and click on it");
		HomePomPage home = new HomePomPage(driver);
		home.getConttab();

		// Identify create plus icon n click
		liteners_Utility.Listeners.test.log(Status.PASS, "Identify create plus icon n click");
		ContactPompage cont = new ContactPompage(driver);
		cont.getConplusicon();

		// identify contact last name textfeild
		liteners_Utility.Listeners.test.log(Status.PASS, "identify contact last name textfeild");
		CreateNewContactPomPge contact = new CreateNewContactPomPge(driver);
		contact.getLastnametf(Contact_name);
//		driver.findElement(By.name("lastname")).sendKeys(Contact_name);

		// identify support data textfeild
		liteners_Utility.Listeners.test.log(Status.INFO, "identify support data textfeild");

		WebElement startdatetf = contact.getStartdatetf();
		startdatetf.clear();

		// fetching the cuurent date
		liteners_Utility.Listeners.test.log(Status.INFO, "fetching the cuurent date");

		String startDate = jutil1.SystemCurrentDate();
		startdatetf.sendKeys(startDate);
		System.out.println(startDate);

		// identify support end date
		liteners_Utility.Listeners.test.log(Status.INFO, "identify support end date");
		WebElement enddatetf = contact.getEnddatetf();
		enddatetf.clear();

		// fetch data from after 30 days
		liteners_Utility.Listeners.test.log(Status.INFO, "fetch data from after 30 days");
		String enddate = jutil1.getDateAfterSpecifiedDays(30);
		enddatetf.sendKeys(enddate);

		// identify save button and click
		liteners_Utility.Listeners.test.log(Status.INFO, "identify save button and click");
//		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		contact.getSavebtn();
		// identify header in contact info page and validate
		liteners_Utility.Listeners.test.log(Status.INFO, "identify header in contact info page and validate");

		ContactInfoPomPage coninfo = new ContactInfoPomPage(driver);
		String contact_header = coninfo.getHeader();
		if (contact_header.contains(Contact_name)) {
			System.out.println("Create contact verified contact test pass");

		} else {

			System.out.println("create contact  verified contact test fail");

		}

		// validate support start date
		liteners_Utility.Listeners.test.log(Status.INFO, "validate support start date");

		String verifystartdate = coninfo.getVerifyStartDate();
		if (verifystartdate.contains(startDate)) {
			System.out.println("Create contact with support  start date  verify test pass");
		} else {
			System.out.println("Create contact with support  start date  verify test fail");

		}

		// validate support end date
		liteners_Utility.Listeners.test.log(Status.INFO, " validate support end date");
		String verifyenddate = coninfo.getVerifyEndDate();
		if (verifyenddate.contains(enddate)) {
			System.out.println("Create contact with support  end date  verify test pass");
		} else {
			System.out.println("Create contact with support  end date  verify test fail");
		}

		// Identify contcat tab and click
		home.getConttab();

		// identify and click on del link
		driver.findElement(By.xpath(
				"//a[text()='" + Contact_name + "']/ancestor::tr[@bgcolor=\"white\"]/descendant::a[text()='del']"))
				.click();
		Thread.sleep(3000);

		// Handle delete pop up
		liteners_Utility.Listeners.test.log(Status.INFO, "Handle delete pop up");
		wutil.HandlingAlertPopupAndClickON(driver);
		Thread.sleep(3000);

//		// mouse over on sign in button and click on it
//		WebElement admin = home.getAdmin();
//		wutil.MouseOverOnAnElement(driver, admin);
//		home.getSignout();
//		Thread.sleep(2000);
//
//		// close the browser
//		wutil.QuitTheBrowser(driver);

	}

	// @Parameters("browser")
	@Test(groups = "reg", retryAnalyzer = liteners_Utility.IRetryAnalyzerUtility.class)
	public void Create_Orgwith_Cont() throws Exception {

		// Fetch the data from Property file
//		PropertyfileUtility prop = new PropertyfileUtility();
//		String browser = prop.FetchingDtadaFromPropertyFile("browser");
//		String URL = prop.FetchingDtadaFromPropertyFile("url");
//		String UN = prop.FetchingDtadaFromPropertyFile("un");
//		String PSWD = prop.FetchingDtadaFromPropertyFile("password");
//		String TIME = prop.FetchingDtadaFromPropertyFile("timeouts");
		
		// fetch randum number
		liteners_Utility.Listeners.test.log(Status.INFO, "fetch randum number");
		JavaUtility jutil = new JavaUtility();
		int randumnum = jutil.GenerateRandumNum();

		// Fetch data from Excel
		liteners_Utility.Listeners.test.log(Status.INFO, "Fetch data from Excel");
		ExcelFileUtilities excelfile = new ExcelFileUtilities();
		String Org_name = excelfile.FetchDataFromExcelFile("cont_data", 7, 2) + randumnum;
		String Contact_name = excelfile.FetchDataFromExcelFile("cont_data", 7, 3) + randumnum;

//		// Launch the browser
//		WebDriver driver = null;
//		if(BROWSER.equals("chrome")) {
//			driver=new ChromeDriver();
//		}
//		else if(BROWSER.equals("edge")) {
//			driver=new EdgeDriver();
//		}
//		else {
//			driver=new ChromeDriver();
//		}
		WebdriverUtility wutil = new WebdriverUtility();
		liteners_Utility.Listeners.test.log(Status.INFO, "Launch the browser");
//		// Maximize the window
//		wutil.MaximizeTheWindow(driver);
//		// Implicit wait
//		wutil.WaitUntilElementFound(driver, TIME);
//		// Navigate to appln
//		wutil.NavigateToAnApplication(driver, URL);
//
//		// login to application
//		LoginPompage login = new LoginPompage(driver);
//		login.login(UN, PSWD);

		// identify orgnization link and click on organization tab
		HomePomPage home = new HomePomPage(driver);
		home.getOrgtab();

		// Identify organization link and click
		liteners_Utility.Listeners.test.log(Status.INFO, "Identify organization link and click");
		OrgPomPge org = new OrgPomPge(driver);
		org.getOrgplusicon();

//		// Identify organization link and click
//		driver.findElement(By.linkText("Organizations")).click();
//
//		// Identify create plus icon n click
//		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();

//		// click on org name textfield enter data
		liteners_Utility.Listeners.test.log(Status.INFO, "click on org name textfield enter data");
		CreateNewOrgPomPge neworg = new CreateNewOrgPomPge(driver);
		neworg.getOrgnametf(Org_name);

//		driver.findElement(By.name("accountname")).sendKeys(Org_name);
//
//		// identify save button and click
		liteners_Utility.Listeners.test.log(Status.PASS, "identify save button and click");
		neworg.getSavebtn();

		// identify header in org info page and validate
		OrgInfoPomPage orginfo = new OrgInfoPomPage(driver);
		String actualOrgName = orginfo.getVerifyOrgName();
//		WebElement header = driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]"));
		liteners_Utility.Listeners.test.log(Status.PASS, "identify header in org info page and validate");
		if (actualOrgName.contains(Org_name)) {
			System.out.println("create Org test pass");

		} else {

			System.out.println("create Org test fail");

		}

		// Identify Contacts link and click

		home.getConttab();

		// Identify create plus icon n click
		liteners_Utility.Listeners.test.log(Status.PASS, "Identify Contacts link and click");
		ContactPompage cont = new ContactPompage(driver);
		cont.getConplusicon();

		// Identify contactname tf and enter contact name
		CreateNewContactPomPge contact = new CreateNewContactPomPge(driver);
		contact.getLastnametf(Contact_name);
//		driver.findElement(By.name("lastname")).sendKeys(Contact_name);

		// Fetch parent window id
//		String pwid = driver.getWindowHandle();
		String pwid = wutil.FetchParentWindowId(driver);

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
		liteners_Utility.Listeners.test.log(Status.PASS, "identify header in contact info page and validate");

		ContactInfoPomPage info = new ContactInfoPomPage(driver);
		String header1 = info.getHeader();
		if (header1.contains(Contact_name)) {
			System.out.println("create Contact with org verified last name test pass");

		} else {

			System.out.println("create Contact with org verified last name  test fail");

		}

		// identify orgname in contact page
		liteners_Utility.Listeners.test.log(Status.PASS, "identify orgname in contact page");

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
		liteners_Utility.Listeners.test.log(Status.PASS, "Handle delete pop up");
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
//		// driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
//		WebElement admin = home.getAdmin();
//		// mouse over on the sign in link and click on sign out
//		wutil.MouseOverOnAnElement(driver, admin);
//		home.getSignout();
//
//		driver.quit();
	}

}
