package GenericUtilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	/**
	 * This method is used to maximize the window
	 * 
	 * @param driver
	 */
	public void MaximizeTheWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * this method is used to give implict wait
	 * 
	 * @param driver
	 * @param time
	 */
	public void WaitUntilElementFound(WebDriver driver, String time) {
		long Timeouts = Long.parseLong(time);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Timeouts));
	}

	/**
	 * 
	 * @param driver
	 * @param url
	 */
	public void NavigateToAnApplication(WebDriver driver, String url) {
		driver.get(url);
	}

	/**
	 * 
	 * @param driver
	 */
	public void HandlingAlertPopupAndClickON(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void MouseOverOnAnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * 
	 * @param driver
	 */
	public void QuitTheBrowser(WebDriver driver) {
		driver.quit();
	}

	/**
	 * 
	 * @param driver
	 * @param ddEle
	 * @param value
	 */
	public void SelectDD_UsingValue(WebDriver driver, WebElement ddEle, String value) {
		Select s = new Select(ddEle);
		s.selectByValue(value);
	}

	/**
	 * 
	 * @param driver
	 * @param ddEle
	 * @param index
	 */
	public void SelectDD_UsingIndex(WebDriver driver, WebElement ddEle, int index) {
		Select s = new Select(ddEle);
		s.selectByIndex(index);

	}

	/**
	 * 
	 * @param driver
	 * @return
	 */
	public String FetchParentWindowId(WebDriver driver) {
		String pwid = driver.getWindowHandle();
		return pwid;
	}

	/**
	 * 
	 * @param driver
	 * @return
	 */
	public Set<String> FetchMutipleWindowIds(WebDriver driver) {
		Set<String> wids = driver.getWindowHandles();
		return wids;
	}

	/**
	 * 
	 * @param driver
	 * @param title
	 * @param wids
	 */
	public void SwitchToChildWindowUsingTitle(WebDriver driver, String title, Set<String> wids) {
		for (String s : wids) {
			driver.switchTo().window(s);
			if (driver.getTitle().contains(title)) {
				break;
			}
		}
	}

	/**
	 * 
	 * @param driver
	 * @param title
	 */
	public void SwitchToChildWindowUsingTitle(WebDriver driver, String title) {

		Set<String> wids = driver.getWindowHandles();
		for (String s : wids) {
			driver.switchTo().window(s);
			if (driver.getTitle().contains(title)) {
				break;
			}
		}

	}

	/**
	 * 
	 * @param driver
	 * @param url
	 */
	public void SwitchToChildWindowUsingUrl(WebDriver driver, String url) {
		Set<String> wids = driver.getWindowHandles();
		for (String s : wids) {
			driver.switchTo().window(s);
			if (driver.getCurrentUrl().contains(url)) {
				break;
			}
		}

	}

	/**
	 * 
	 * @param driver
	 * @param pwid
	 */
	public void SwitchToPrentWindow(WebDriver driver, String pwid) {
		driver.switchTo().window(pwid);
	}

	/**
	 * 
	 * @param driver
	 * @param ele
	 */
	public void WaitTillElementIsClickable(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	/**
	 * 
	 * @param driver
	 * @param ele
	 */
	public void WaitTillElementIsVisible(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	/**
	 * 
	 * @param driver
	 * @param title
	 */
	public void WaitTillTitleVisible(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains(title));
	}

	/**
	 * 
	 * @param driver
	 * @param ddEle
	 * @param index
	 */
	public void Select_DDUsingIndex(WebDriver driver, WebElement ddEle, int index) {
		Select s = new Select(ddEle);
		s.selectByIndex(index);

	}

	/**
	 * 
	 * @param driver
	 * @param ddEle
	 * @param text
	 */
	public void Select_DDUsingVisibleText(WebDriver driver, WebElement ddEle, String text) {
		Select s = new Select(ddEle);
		s.selectByVisibleText(text);

	}

	/**
	 * 
	 * @param driver
	 */
	public void HandlingAlertPopupAndClickCncel(WebDriver driver) {
		driver.switchTo().alert().dismiss();

	}

	/**
	 * 
	 * @param driver
	 * @return
	 */
	public String HandlingAlertPopupAndFetchText(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;

	}

	/**
	 * 
	 * @param driver
	 * @param Text
	 */
	public void HandlingAlertPopupAndPassTheText(WebDriver driver, String Text) {
		driver.switchTo().alert().sendKeys(Text);

	}

	/**
	 * 
	 * @param driver
	 * @param index
	 */
	public void SwitchToFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * 
	 * @param driver
	 * @param Id_Name
	 */
	public void SwitchToFrameById_Name(WebDriver driver, String Id_Name) {
		driver.switchTo().frame(Id_Name);
	}

	/**
	 * 
	 * @param driver
	 * @param frameele
	 */
	public void SwitchToFrameByElement(WebDriver driver, WebElement frameele) {
		driver.switchTo().frame(frameele);
	}

	/**
	 * 
	 * @param driver
	 */
	public void swutchToMainWebpageFromFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

}