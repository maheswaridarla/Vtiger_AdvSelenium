package Contact_Module;

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
import POMUtility.ContactInfoPomPage;
import POMUtility.ContactPompage;
import POMUtility.CreateNewContactPomPge;
import POMUtility.HomePomPage;
import POMUtility.LoginPompage;

public class Create_Contact {

	@Test(groups= {"smoke"})
	public void CreateNewContact() throws Exception {
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
		String Contact_name = excelfile.FetchDataFromExcelFile("cont_data", 1, 2) + randumnum;

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

		// identify contact tab and click
		HomePomPage home = new HomePomPage(driver);
		home.getConttab();

		//
		
		// Identify create plus icon n click
		ContactPompage cont = new ContactPompage(driver);
		cont.getConplusicon();

		// identify contact last name textfeild
		CreateNewContactPomPge contact = new CreateNewContactPomPge(driver);
		contact.getLastnametf(Contact_name);
		//driver.findElement(By.name("lastname")).sendKeys(Contact_name);

		// identify save button and click
		contact.getSavebtn();
		//driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		// identify header in contact info page and validate
		ContactInfoPomPage coninfo=new ContactInfoPomPage(driver);
		String header = coninfo.getHeader();
	
		if (header.contains(Contact_name)) {
			System.out.println("Create contact verified contact test pass");

		} else {

			System.out.println("create contact  verified contact test fail");

		}
		// Identify contcat tab and click
		home.getConttab();

		// identify and click on del link
		driver.findElement(By.xpath(
				"//a[text()='" + Contact_name + "']/ancestor::tr[@bgcolor=\"white\"]/descendant::a[text()='del']"))
				.click();

		// Handle delete pop up
		wutil.HandlingAlertPopupAndClickON(driver);

		Thread.sleep(3000);
		// mouse over on sign in icon and click on sign out
		wutil.MouseOverOnAnElement(driver, home.getAdmin());
		home.getSignout();

		// close the browser
		wutil.QuitTheBrowser(driver);

	}
}