
package BaseClassUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import GenericUtilities.DatabaseUtility;
import GenericUtilities.PropertyfileUtility;
import GenericUtilities.WebdriverUtility;
import POMUtility.HomePomPage;
import POMUtility.LoginPompage;

public class Baseclass {
	DatabaseUtility dutil = new DatabaseUtility();
	PropertyfileUtility prop = new PropertyfileUtility();
	WebdriverUtility wutil = new WebdriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite
	public void getConnectionToDb() throws SQLException {
		dutil.getDataBaseConnection();
	}

	@BeforeTest
	public void conparallelExe() {
		Reporter.log("configure parallel execution", true);
	}

//	@Parameters("browser")
	@BeforeClass
	public void launchTheBrowser() throws IOException {
		String BROWSER = prop.FetchingDtadaFromPropertyFile("browser");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;

	}

	@BeforeMethod
	public void login() throws IOException {

		String URL = prop.FetchingDtadaFromPropertyFile("url");
		String UN = prop.FetchingDtadaFromPropertyFile("un");
		String PSWD = prop.FetchingDtadaFromPropertyFile("password");
		String TIME = prop.FetchingDtadaFromPropertyFile("timeouts");

		wutil.MaximizeTheWindow(driver);
		wutil.WaitUntilElementFound(driver, TIME);
		wutil.NavigateToAnApplication(driver, URL);
		LoginPompage login = new LoginPompage(driver);
		login.login(UN, PSWD);

	}

	@AfterMethod
	public void logout() {
		HomePomPage home = new HomePomPage(driver);
		home.logout(driver);
	}

	@AfterClass
	public void closeTheBrowser() {
		wutil.QuitTheBrowser(driver);

	}

	@AfterTest
	public void closeParllelExe() {
		Reporter.log("close configaration of parallel Execution", true);
	}

	@AfterSuite
	public void closeTheConnectionWithDb() throws SQLException {
		dutil.CloseDatabaseConnection();
	}

}