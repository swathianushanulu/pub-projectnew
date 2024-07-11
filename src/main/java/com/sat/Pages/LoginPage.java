package com.sat.Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.sat.constants.AppConstants;
import com.sat.testUtil.ElementUtil;
import com.sat.testbase.TestBase;

public class LoginPage extends CommonActionsPage{

/*	private WebDriver driver;
	private Properties prop;
	private ElementUtil eleUtil;
	private TestBase testbase;  */

	// Locators to login the application
	private By app_emailID = By.xpath("//input[@name='loginfmt']");
	private By next_Btn = By.xpath("//input[@type='submit']");
	private By app_password = By.name("passwd");
	private By signin = By.xpath("//input[@value='Sign in']");
	private By DontShowcheckbox = By.name("DontShowAgain");
	private By yesbtn = By.xpath("//*[@type='submit']");
	private By yes = By.id("idSIButton9");

	// Locators after login
	private By appframeLoc = By.xpath("//iframe[@title='AppLandingPage']");
	private By appText = By.xpath("//span[text()='Published Apps']");
	private By app_Name = By.xpath("a[contains(@aria-label,'DQB - Case Management')]");

	// Locators for home page
	private By changeAreaLocatoin = By.id("areaSwitcherId");
	private By select_ChangeArea = By.xpath("//li[@role='menuitemradio']//span[text()='GWC Tanker']");
	// sprivate By entityName = By.xpath("//span[text()='NEA List']");
	private By signoutPic = By.xpath("//div[@id='mectrl_headerPicture']");
	private By signoutBtn = By.xpath("//button[text()='Sign out']");
	private By useanotheraccount = By.xpath("//div[text()='Use another account']");

	public LoginPage(WebDriver driver) {
		super(driver);
	/*	this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
		prop = eleUtil.readProperties();*/

	}

	public void appLogin(String userid, String password) throws InterruptedException {
		// eleUtil.isPageLoaded(AppConstants.MEDIUM_DEFAUTT_WAIT);
		eleUtil.doElementClickable(app_emailID, 10);
		eleUtil.doSendKeys(app_emailID, prop.getProperty(userid));
		// eleUtil.clickElementWhenReady(next_Btn, AppConstants.SHORT_DEFAUTT_WAIT);
		eleUtil.waitForVisibilityOfElement(next_Btn, AppConstants.MEDIUM_DEFAUTT_WAIT);
		eleUtil.doClick(next_Btn);
		eleUtil.clickElementWhenReady(app_password, AppConstants.SHORT_DEFAUTT_WAIT);
		eleUtil.doSendKeys(app_password, prop.getProperty(password));
		// eleUtil.clickElementWhenReady(signin, AppConstants.SHORT_DEFAUTT_WAIT);
		eleUtil.doClick(signin);
		// eleUtil.doActionsClick(signin);
		// eleUtil.isPageLoaded(AppConstants.LONG_DEFAUTT_WAIT);
		// Wait.untilPageLoadComplete(driver, 10);
	/*	if (driver.findElement(DontShowcheckbox).isDisplayed()) {
			eleUtil.clickElementWhenReady(DontShowcheckbox, AppConstants.SHORT_DEFAUTT_WAIT);
			eleUtil.doClick(DontShowcheckbox);
			eleUtil.doClick(yesbtn);
		} else {
			System.out.println("Dont show box is not there");
		}*/

		List<WebElement> li = driver.findElements(DontShowcheckbox);
		if (li.size() > 0) {
			eleUtil.waitForVisibilityOfElement(DontShowcheckbox, AppConstants.MEDIUM_DEFAUTT_WAIT);
			eleUtil.clickElementWhenReady(DontShowcheckbox, AppConstants.SHORT_DEFAUTT_WAIT);
			eleUtil.doClick(DontShowcheckbox);
			eleUtil.doClick(yesbtn);
			
		} else {
			System.out.println("no alert present");
		}

	}

	public void GetApp(String appName) throws InterruptedException {
		Thread.sleep(4000);
		eleUtil.waitForFrameByLocator(appframeLoc, AppConstants.SHORT_DEFAUTT_WAIT);
		Thread.sleep(4000);
		String acttitle = eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, AppConstants.SHORT_DEFAUTT_WAIT);
		System.out.println("login title is" + acttitle);
		Assert.assertEquals(acttitle, AppConstants.LOGIN_PAGE_TITLE);
		WebElement appname = driver.findElement(By.xpath("//div[@title='" + appName + "']"));
		appname.click();
		driver.switchTo().defaultContent();
		System.out.println("App name is : " + appName);
	/*	String actualtitle = eleUtil.waitForTitleIs(AppConstants.HOME_PAGE_TITLE, AppConstants.SHORT_DEFAUTT_WAIT);
		System.out.println("homepage title is" + acttitle);
		Assert.assertEquals(actualtitle, AppConstants.HOME_PAGE_TITLE); */
	}

	public void signoutApp() {
		eleUtil.waitForVisibilityOfElement(signoutPic, 10);
		eleUtil.doClick(signoutPic);
		eleUtil.waitForVisibilityOfElement(signoutBtn, 10);
		eleUtil.doClick(signoutBtn);
		eleUtil.waitForVisibilityOfElement(useanotheraccount, 10);
		eleUtil.doClick(useanotheraccount);
	}

}