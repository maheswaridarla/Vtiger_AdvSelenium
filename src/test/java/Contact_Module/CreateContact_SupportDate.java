package Contact_Module;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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
import POMUtility.ContactInfoPomPage;
import POMUtility.ContactPompage;
import POMUtility.CreateNewContactPomPge;
import POMUtility.HomePomPage;
import POMUtility.LoginPompage;

public class CreateContact_SupportDate {
	@Test(groups= {"smoke"})
	public void CreateNewContact() throws Exception {
		JavaUtility jutil = new JavaUtility();
		// FETCH THE DATA FROM PROPERTY FILE
		PropertyfileUtility prop = new PropertyfileUtility();
		String browser = prop.FetchingDtadaFromPropertyFile("browser");
		String URL = prop.FetchingDtadaFromPropertyFile("url");
		String UN = prop.FetchingDtadaFromPropertyFile("un");
		String PSWD = prop.FetchingDtadaFromPropertyFile("password");
		String TIME = prop.FetchingDtadaFromPropertyFile("timeouts");

		// fetch randum number
		JavaUtility jutil1 = new JavaUtility();
		int randumnum = jutil1.GenerateRandumNum();

		// FETCH THE DATA FROM EXCEL FILE
		ExcelFileUtilities excelfile = new ExcelFileUtilities();
		String Contact_name = excelfile.FetchDataFromExcelFile("cont_data", 4, 2) + randumnum;
		System.out.println(Contact_name);

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

		// identify contact tab and click on it
		HomePomPage home = new HomePomPage(driver);
		home.getConttab();
         
		// Identify create plus icon n click
		   ContactPompage cont = new ContactPompage(driver);
		   cont.getConplusicon();
		
		
		// identify contact last name textfeild
		   CreateNewContactPomPge contact = new CreateNewContactPomPge(driver);
		   contact.getLastnametf(Contact_name);
//		driver.findElement(By.name("lastname")).sendKeys(Contact_name);

		// identify support data textfeild
	WebElement startdatetf = contact.getStartdatetf();
	startdatetf.clear();
		   

		// fetching the cuurent date

		String startDate = jutil1.SystemCurrentDate();
		startdatetf.sendKeys(startDate);
		System.out.println(startDate);

		// identify support end date
	   WebElement enddatetf =contact.getEnddatetf(); 
		enddatetf.clear();
		   
		   

		 //fetch data from after 30 days
		
		String enddate = jutil1.getDateAfterSpecifiedDays(30);
		enddatetf.sendKeys(enddate);

		// identify save button and click
//		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
        contact.getSavebtn();
		// identify header in contact info page and validate
        ContactInfoPomPage coninfo=new ContactInfoPomPage(driver);
		  String contact_header = coninfo.getHeader();
		if (contact_header.contains(Contact_name)) {
			System.out.println("Create contact verified contact test pass");

		} else {

			System.out.println("create contact  verified contact test fail");

		}

		// validate support start date
		 String verifystartdate = coninfo.getVerifyStartDate();
		if (verifystartdate.contains(startDate)) {
			System.out.println("Create contact with support  start date  verify test pass");
		} else {
			System.out.println("Create contact with support  start date  verify test fail");

		}

		// validate support end date
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
		wutil.HandlingAlertPopupAndClickON(driver);
		Thread.sleep(3000);

		// mouse over on sign in button and click on it
		WebElement admin = home.getAdmin();
		wutil.MouseOverOnAnElement(driver, admin);
		home.getSignout();
		Thread.sleep(2000);

		// close the browser
		wutil.QuitTheBrowser(driver);

	}
}
