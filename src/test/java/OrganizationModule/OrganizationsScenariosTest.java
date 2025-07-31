package OrganizationModule;

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
import POMUtility.CreateNewOrgPomPge;
import POMUtility.HomePomPage;
import POMUtility.LoginPompage;
import POMUtility.OrgInfoPomPage;
import POMUtility.OrgPomPge;
@Listeners(liteners_Utility.Listeners.class)
public class OrganizationsScenariosTest extends Baseclass {
	// @Parameters("browser")
	@Test(groups = "smoke", retryAnalyzer = liteners_Utility.IRetryAnalyzerUtility.class)
	public void CreateNewOrgTest() throws Exception {
		// FETCH THE DATA FROM PROPERTY FILE
//		PropertyfileUtility prop = new PropertyfileUtility();
//		String browser = prop.FetchingDtadaFromPropertyFile("browser");
//		String URL = prop.FetchingDtadaFromPropertyFile("url");
//		String UN = prop.FetchingDtadaFromPropertyFile("un");
//		String PSWD = prop.FetchingDtadaFromPropertyFile("password");
//		String TIME = prop.FetchingDtadaFromPropertyFile("timeouts");
		// fetch randum number
		JavaUtility jutil = new JavaUtility();
		int randumnum = jutil.GenerateRandumNum();
		// FETCH THE DATA FROM EXCEL FILE
		ExcelFileUtilities excelfile = new ExcelFileUtilities();
		String orgname = excelfile.FetchDataFromExcelFile("Org_data", 1, 2) + randumnum;

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
//		// implicitly wait
//		wutil.WaitUntilElementFound(driver, TIME);
//		// navigate to an application
//		wutil.NavigateToAnApplication(driver, URL);
//
//		// login to application
//		LoginPompage login = new LoginPompage(driver);
//		login.login(UN, PSWD);
		// identify orgnization link
		HomePomPage home = new HomePomPage(driver);
		home.getOrgtab();

		// Identify create plus icon n click
		OrgPomPge org = new OrgPomPge(driver);
		org.getOrgplusicon();

		// identify orgnization textfeild and click on save button
		CreateNewOrgPomPge neworg = new CreateNewOrgPomPge(driver);
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
		Thread.sleep(3000);

		// Handle delete pop up
		wutil.HandlingAlertPopupAndClickON(driver);
		
//		// sign out
//		wutil.MouseOverOnAnElement(driver, home.getAdmin());
//		home.getSignout();
//		// close the browser
//		wutil.QuitTheBrowser(driver);

	}

	// @Parameters("browser")
	@Test(groups = "reg", retryAnalyzer = liteners_Utility.IRetryAnalyzerUtility.class)
	public void CreateNewOrgTest11() throws Exception {
		// FETCH THE DATA FROM PROPERTY FILE
//		PropertyfileUtility prop = new PropertyfileUtility();
//		String browser = prop.FetchingDtadaFromPropertyFile("browser");
//		String URL = prop.FetchingDtadaFromPropertyFile("url");
//		String UN = prop.FetchingDtadaFromPropertyFile("un");
//		String PSWD = prop.FetchingDtadaFromPropertyFile("password");
//		String TIME = prop.FetchingDtadaFromPropertyFile("timeouts");

		// fetch randum number
		JavaUtility jutil = new JavaUtility();
		int randumnum = jutil.GenerateRandumNum();

		// FETCH THE DATA FROM EXCEL FILE
		ExcelFileUtilities excelfile = new ExcelFileUtilities();
		String orgname = excelfile.FetchDataFromExcelFile("Org_data", 4, 2) + randumnum;
		String phno = excelfile.FetchDataFromExcelFile("Org_data", 4, 3);

//		// launche the browser
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
//		wutil.NavigateToAnApplication(driver, URL);
//
//		// login to application
//		LoginPompage login = new LoginPompage(driver);
//		login.login(UN, PSWD);

		// identify orgnization link
		HomePomPage home = new HomePomPage(driver);
		home.getOrgtab();

		// Identify create plus icon n click
		OrgPomPge org = new OrgPomPge(driver);
		org.getOrgplusicon();

		// click on org name textfield enter data
		// identify orgnization textfeild and click on save button
		CreateNewOrgPomPge neworg = new CreateNewOrgPomPge(driver);
		neworg.getOrgnametf(orgname);
		neworg.getPhoneTf(phno);
//		driver.findElement(By.name("accountname")).sendKeys(orgname);
//		driver.findElement(By.id("phone")).sendKeys(phno);

		// identify save button and click
//		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
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
		// validate phone
		String actualPhno = orginfo.getVerifyPhno();
//		WebElement verifyphone = driver.findElement(By.id("mouseArea_Phone"));
		if (actualPhno.contains(phno)) {
			System.out.println("create Org with phno verified phno test pass");

		} else {

			System.out.println("create Org with phno verified phno test fail");

		}
		// Identify organization link and click
		home.getOrgtab();

		// identify and click on del link
		driver.findElement(
				By.xpath("//a[text()='" + orgname + "']/ancestor::tr[@bgcolor=\"white\"]/descendant::a[text()='del']"))
				.click();
		Thread.sleep(3000);

		// Handle delete pop up
		wutil.HandlingAlertPopupAndClickON(driver);
		

//		// mouse over on sign in icon and click on sign out
//		wutil.MouseOverOnAnElement(driver, home.getAdmin());
//		home.getSignout();
//
//		// close the browser
//		wutil.QuitTheBrowser(driver);

	}

	// @Parameters("browser")
	@Test(groups = "reg", retryAnalyzer = liteners_Utility.IRetryAnalyzerUtility.class)
	public void CreateNewOrgTest1() throws Exception {
		// FETCH THE DATA FROM PROPERTY FILE
//		PropertyfileUtility prop = new PropertyfileUtility();
//		String browser = prop.FetchingDtadaFromPropertyFile("browser");
//		String URL = prop.FetchingDtadaFromPropertyFile("url");
//		String UN = prop.FetchingDtadaFromPropertyFile("un");
//		String PSWD = prop.FetchingDtadaFromPropertyFile("password");
//		String TIME = prop.FetchingDtadaFromPropertyFile("timeouts");

		// fetch randum number
		//org test scenarios
		//org test scenarios
		liteners_Utility.Listeners.test.log(Status.INFO, "fetch randum number");
		JavaUtility jutil = new JavaUtility();
		int randumnum = jutil.GenerateRandumNum();

		// FETCH THE DATA FROM EXCEL FILE
		ExcelFileUtilities excelfile = new ExcelFileUtilities();
		String orgname = excelfile.FetchDataFromExcelFile("Org_data", 9, 2) + randumnum;
		String Industry = excelfile.FetchDataFromExcelFile("Org_data", 9, 3);
		String Type = excelfile.FetchDataFromExcelFile("Org_data", 9, 4);

//		// launche the browser
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

		// identify orgnization link
		HomePomPage home = new HomePomPage(driver);
		home.getOrgtab();

		// Identify create plus icon n click
		OrgPomPge org = new OrgPomPge(driver);
		org.getOrgplusicon();

//		// click on org name textfield enter data
		CreateNewOrgPomPge neworg = new CreateNewOrgPomPge(driver);
		neworg.getOrgnametf(orgname);

//
//		// handel the industry dd
		WebElement indutrydd = neworg.getIndustryDD();
		wutil.SelectDD_UsingValue(driver, indutrydd, Industry);
//
//		// handel the type dd
		WebElement typedd = neworg.getTypeDD();
		wutil.SelectDD_UsingValue(driver, typedd, Type);
//
//		// identify save button and click
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
		// identify header in org info page and validate
		String actualIndustry = orginfo.getVerifyIndustryDD();
//		WebElement verifyindtf = driver.findElement(By.id("mouseArea_Industry"));
		if (actualIndustry.contains(Industry)) {
			System.out.println("Create Organization with Industry and type verify pass");

		} else {

			System.out.println("Create Organization with Industry and type verify fail");

		}

		// identify header in org info page and validate
		String actualType = orginfo.getVerifyTypeDD();
//		WebElement verifytypetf = driver.findElement(By.id("dtlview_Type"));

		if (actualType.contains(Type)) {
			System.out.println("Create Organization with  type verify type pass");

		} else {

			System.out.println("Create Organization with  type verify type fail");

		}

		// Identify organization link and click
		home.getOrgtab();

		// identify and click on del link
		driver.findElement(
				By.xpath("//a[text()='" + orgname + "']/ancestor::tr[@bgcolor=\"white\"]/descendant::a[text()='del']"))
				.click();
		Thread.sleep(5000);

		// Handle delete pop up
		wutil.HandlingAlertPopupAndClickON(driver);

//		// mouse over on sign in icon And click on sign out button
//		wutil.MouseOverOnAnElement(driver, home.getAdmin());
//
//		home.getSignout();
//
//		// close the browser
//		wutil.QuitTheBrowser(driver);
	}

}
