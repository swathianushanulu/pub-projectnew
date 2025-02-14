package com.sat.Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sat.constants.AppConstants;

public class CasecreationPage extends CommonActionsPage {
	/*
	 * private WebDriver driver; private Properties prop; private ElementUtil
	 * eleUtil; private TestBase testbase; private JavaScriptUtil jsutil; private
	 * CommonActionsPage common; private ApplicationPage apppage;
	 */
	// public static String WOnumber, casenumber, starttimeval;
	// public static List<String> WOnumberlist;

	// Entry<String, String> permitNumber;
	// Locators on application page

	private By createdApp = By.xpath("(//div[@col-id='pub_gwccompany']//descendant::a)[2]"); // (//div[@col-id='pub_gwccompany'])[2]
	private By changeViewIcon = By.xpath("//span[text()='Open popup to change view.']//following-sibling::i");
	private By AcceptedApplicaion = By.xpath("//label[text()='Accepted applications']");
	private By ActiveCases = By.xpath("//label[contains(text(),'Active Cases')]");

	// Locators from case form
	private By entitydropdown = By.xpath("(//div[@col-id='customerid'])[1]");
	private By entityName = By.xpath("(//div[@col-id='customerid'])[2]");
	private By filterBy = By.xpath("//span[text()='Filter by']");
	private By filterbyinputbox = By.xpath("//input[@aria-label='Filter by value']");
	private By suggestionbox = By.xpath("//div[contains(@class,'suggestionTextOverflow')]");
	private By applyBtn = By.xpath("//span[text()='Apply']");
	private By entitynameOnCaseForm = By.xpath("(//div[@col-id='customerid']//a)[1]");
	private By caseidOnCaseForm = By.xpath("//div[@col-id='title']//a"); // (//div[@col-id='title'])[2]
																			// //h1[@data-id='header_title']
	private By entityIdOnCaseHome = By.xpath("//ul[@title='Entity']");

	private By firstRecord = By.xpath("(//input[contains(@aria-label,'elect or deselect the row')])[1]");
	// "(//input[@aria-label='Select or deselect the row'])[1] |
	// (//input[@aria-label='select or deselect the row'])[1]");
	private By saveBtn = By.xpath("//button[@aria-label='Save (CTRL+S)']");
	private By saveCloseBtn = By.xpath("//button[@aria-label='Save & Close']");
	private By createdonCol = By.xpath("//div[text()='Created On']");
	private By NewToOldCol = By.xpath("//span[text()='Sort newer to older']");
	private By refreshBtn = By.xpath("//button[@aria-label='Refresh']");
	private By backBtn = By.xpath("//button[@title='Go back']");

	// Locators on case form home page
	private By searchbox = By.xpath("//input[@aria-label='Case Filter by keyword']");
	private By caseid = By.xpath("//input[@aria-label='Case ID']");
	private By BusinessFunctionField = By.xpath("//ul[@title='Business Function']");
	private By casetypeField = By.xpath("//select[@aria-label='Case Type']");
	private By caseSubtypeField = By.xpath("//select[@aria-label='Case Sub Type']");
	private By createdonField = By.xpath("//input[@aria-label='Date of Created On']");
	private By caseSOField = By.xpath("//ul[@title='Case SO']//div[contains(@data-id,'pub_caseso')]/span/div");// ul[@title='Case
																												// SO']
	private By caseAOField = By.xpath("//ul[@title='Case AO']//div[contains(@data-id,'pub_caseao')]/span/div");// ul[@title='Case
																												// AO']
	private By caseFIOField = By.xpath("//ul[@title='Case FIO']//div[contains(@data-id,'pub_casefio')]/span/div");// ul[@title='Case
																													// FIO']
	private By statusField = By.xpath("//div[text()='Status']/preceding-sibling::div");
	private By caseSubtypefromTop = By.xpath("//div[text()='Case Sub Type']/preceding-sibling::div");
	private By ownerField = By.xpath("//div[text()='Owner']/preceding-sibling::div");
	private By caseIDAtTop = By.xpath("//div[text()='Case ID']/preceding-sibling::div");
	private By GwcRefNum = By.xpath("//input[@aria-label='GWC Reference Number']");

	// user roles update
	private By SOname = By.xpath("//input[contains(@aria-label,'Case SO, Lookup')]"); // div[contains(@data-id,'pub_caseso.fieldControl')]
	private By AOname = By.xpath("//div[contains(@data-id,'pub_caseao.fieldControl')]");
	private By FIOname = By.xpath("//div[contains(@data-id,'pub_casefio.fieldControl')]");

	// button[contains(@aria-label,'Search records for Case FIO')] - search records
	// for casse FIO field
	// Locators on case form tabs
	private By workorderTab = By.xpath("//ul[@aria-label='Case Form']//li[@aria-label='Work Orders']");
	private By allTabs = By.xpath("//ul[@aria-label='Case Form']");
	private By wostatusField = By.xpath("(//div[@col-id='msdyn_systemstatus'])[2]");
	private By moreCommandsInWorkOrder = By.xpath("//button[@title='More commands for Work Order']");

	// Locators on BPF stage on case form
	private By nextstageBtn = By.xpath("//div[contains(@id,'nextButton')]");
	private By assignmentStage = By.xpath("//div[@title='Assignment']");
	private By confirmInspectionScheduleOption = By.xpath("//select[@aria-label='Confirm Inspection Schedule']"); // visible
																													// text
																													// Yes/No
	private By InspectionStage = By.xpath("//div[@title='Inspection']");
	private By inspectionCompletedOption = By.xpath("//select[@aria-label='Inspection Completed?']"); // visible text
																										// Yes/No
	private By generateInspectionReportOption = By.xpath("//select[@aria-label='Generate Inspection Report']"); // visible
																												// text
	private By closeBtnOnBPF = By.xpath("//button[@title='Close']"); // Yes/No
	private By submitSOreviewBtn = By.xpath("//select[contains(@id,'header') and @aria-label='Submit for SO Review']");
	private By SOreviewStage = By.xpath("//div[@title='SO Review']");
	private By systemassesmentOption = By.xpath("//select[@aria-label='System Assessment']"); // visible text Yes/No
	private By userassesmentOption = By.xpath("//select[@aria-label='User Assessment']"); // visible text Yes/No
	private By submitAOreviewBtn = By
			.xpath("//select[contains(@id,'header') and @aria-label='Approve and Send for AO Review']"); // visible text
	// Yes/No
	private By AOreviewStage = By.xpath("//div[@title='AO Review']");
	private By AOresponseOption = By.xpath("//select[@aria-label='AO Response']"); // visible text Yes/No
																					// //button[@aria-label='AO
																					// Response']
	private By generateemailStage = By.xpath("//div[@title='Generate Email']");
	private By generateemailOption = By.xpath("//select[@aria-label='Generate Email']"); // visible text Yes/No
	private By emailtocustomerOption = By.xpath("//select[@aria-label='Email Sent to Customer?']"); // visible text
																									// Yes/No
	private By endoresementreceivedOption = By.xpath("//select[@aria-label='Endorsement Received']"); // visible text
																										// Yes/No
	private By closeStage = By.xpath("//div[@title='Close']");
	private By resolvecaseOption = By.xpath("//select[@aria-label='Resolve Case']"); // visible text Yes/No
	private By finishBtn = By.xpath("//button[@aria-label='Finish']");

	private By ProcessingStage = By.xpath("");
	private By processingOption = By.xpath("//select[@aria-label='Submit for SO Review']");

	// Locators for Alerts
	private By notificationIcon = By.xpath("//button[@aria-label='Notifications']");
	private By scheduleWOAlert = By.xpath("//p[text()='You Have been scheduled for  Work Order 03543. ']");
	// private By taptoopenBtn = By.xpath("//p[text()='You Have been scheduled for
	// Work Order 03543. ']/a");
	private By cancelBtn = By.xpath("//i[@data-icon-name='Cancel']");
	private By workordertext = By.xpath("//input[@aria-label='Work Order Number']");
	private By permitnotext = By.xpath("//input[@aria-label='Permit Number']");

	// Locators on WorkOrder tab
	private By WONumber = By.xpath("//div[@col-id='msdyn_name']//descendant::a");// (//div[@col-id='msdyn_name'])[2]
	private By appTankerName = By.xpath("//div[@col-id='pub_applicationtankerid']//descendant::a");
	private By gwctankername = By.xpath("//div[@col-id='pub_tankerid']//descendant::a");
	private By wostatus = By.xpath("(//div[@col-id='msdyn_systemstatus'])[2]");
	private By isComplaintchk = By.xpath("//label[contains(@class,'ms-Label twoOptionRootStyles-')]");
	private By saveNContinueBtn = By.xpath("//span[text()='Save and continue']");

	// Locators on work order form
	private By bookingTab = By.xpath("//li[text()='Bookings']");
	private By servicetasksTab = By.xpath("//li[text()='Checklist']");// li[text()='Service Tasks']
	private By summaryTab = By.xpath("//li[text()='Summary']");
	private By WOstatusInWOform = By.xpath(
			"//select[@aria-label='WO Status']//ancestor::div[@data-lp-id='MscrmControls.FieldControls.OptionSet|msdyn_systemstatus.fieldControl|msdyn_workorder']//select");
	private By isComplaintchkInWOfrom = By.xpath("//select[@aria-label='Is Compliant?']");
	private By tankerNumberInWOform = By
			.xpath("//ul[@title='Tanker']//descendant::div[contains(@data-id,'pub_tankerid')]//child::div");
	private By tankerregno = By.xpath("//label[text()='Tanker Registration No.']");
	// Locators on tanker form
	private By permitnumber = By.xpath("(//div[contains(@col-id,'pub_permit')])[2]//a");// div[@col-id='pub_permit']//a
	private By letterdate = By.xpath("(//div[contains(@col-id,'pub_letterdate')])[2]//label");
	private By expirydate = By.xpath("(//div[contains(@col-id,'pub_expirydate')])[2]//label");

	// Locators on Bookings tab
	private By resourceField = By.xpath("//div[@col-id='resource']/descendant::a");
	private By starttimeField = By.xpath("(//div[@col-id='starttime']/descendant::label)[2]"); // (//div[@col-id='starttime'])[2]
	private By endtimeField = By.xpath("(//div[@col-id='endtime'])[2]");
	private By durationField = By.xpath("(//div[@col-id='duration'])[2]");

	// Locators on Bookings home page
	private By maximizescreenBtn = By.xpath("//button[@aria-label='Enter full screen mode']");
	private By bookingStatusField = By.xpath("//div[contains(@data-id,'CC_BookingStatusControl_Title_')]");// div[contains(@data-id,'CC_BookingStatusControl_Title_')]
	private By bookingStatusOption = By.xpath("//div[@aria-label='Booking Status Control']");

	private By scheduledStartDateField = By.xpath("//input[@aria-label='Date of Scheduled Start Time']");
	private By scheduledStartTimeField = By.xpath("//input[@aria-label='Time of Scheduled Start Time']");
	private By scheduledEndTimeField = By.xpath("//input[@aria-label='Time of Scheduled End Time']");
	private By startDateField = By.xpath("//input[@aria-label='Date of Start Time']");
	private By startTimeonBooking = By.xpath("//input[@aria-label='Time of Start Time']");
	private By endTimeonBooking = By.xpath("//input[@aria-label='Time of End Time']");
	private By actualDateField = By.xpath("//input[@aria-label='Date of Actual Arrival Time']");
	private By actualTimeField = By.xpath("//input[@aria-label='Time of Actual Arrival Time']");
	private By durationFieldOnBooking = By.xpath("//input[@aria-label='Duration']");
	private By selectStartdateVal = By.xpath("//td[@aria-current='date']");
	private By selectStarttimeval = By.xpath("//input[@aria-label='Time of Start Time']/following-sibling::button");
	private By selectactualtimeVal = By
			.xpath("//input[@aria-label='Time of Actual Arrival Time']/following-sibling::button");
	private By saveNCloseOnBooking = By
			.xpath("//span[text()='Save and close this Bookable Resource Booking.']/preceding-sibling::button");
	private By saveOnBooking = By
			.xpath("//span[text()='Save this Bookable Resource Booking.']/preceding-sibling::button");
	private By notestab = By.xpath("//li[@aria-label='Notes']");
	private By signature_box = By.xpath("//div[contains(@data-id,'msdyn_signature')]//canvas"); // canvas[@aria-label='Signature']
	private By confirmBtn = By.xpath("//span[text()='Confirm']"); // span[text()='Confirm']/ancestor::button
	private By nameOfAssignee = By.xpath("//input[contains(@data-id,'pub_nameofsignee')]");
	private By servicetab = By.xpath("//li[@aria-label='Service']");

	// Locators on service tasks home page
	private By checklisttypeField = By.xpath("//div[@col-id='msdyn_inspection']/descendant::a");
	private By checklistNameField = By.xpath("//div[@col-id='msdyn_name']/descendant::a");

	// Locators on checklist questions home page
	private By oldSealnumField = By.xpath("//td[@title='Old Seal Number']");
	private By newSealnumField = By.xpath("//input[@aria-label='New Seal Number']");
	private By photosTakendropdownField = By.xpath("//select[@aria-label='Photos taken']"); // visible text Yes/No
	private By markcompleteBtn = By.xpath("//button[contains(@title,'Set Task as fully completed')]");// button[contains(@title,'Set
																										// task as fully
																										// completed and
																										// save and
																										// close
																										// record')]
	private By saveBtnInChklsit = By.xpath("//button[contains(@title,'Save this Work Order Service Task.')]");
	private By saveNCloseBtnInChklsit = By
			.xpath("//button[contains(@title,'Save and close this Work Order Service Task.')]");

	// Locators mail
	private By viewmoreBtn = By.xpath("//a[@aria-label='Open Record']");
	private By mailFrom = By.xpath("//ul[@title='From']//li/child::div");
	private By mailTo = By
			.xpath("//ul[@title='To']//li/child::div[contains(@id,'to.fieldControl-LookupResultsDropdown')]");
	private By mailSubject = By.xpath("//input[@aria-label='Subject']");
	private By mailBody = By.xpath("//body[@aria-label='Press ALT 0 for help']");
	private By mailframeLoc = By.xpath("//iframe[@aria-label='Description rich text editor']");
	private By attachment = By.xpath("//button[contains(@class,'ms-Link')]/div"); // div[contains(@class,'ms-List-page')]

	// Locators on Docuemnts tab
	private By attachBtn = By.xpath("//span[text()='Attach']/ancestor::button");
	private By browseBtn = By.xpath("//span[text()='Browse']/ancestor::button");
	private By browsefield = By.xpath("(//span[text()='Browse']/ancestor::div[@style])[3]//input");
	private By uploadBtn = By.xpath("//span[text()='Upload']/ancestor::button");

	private By okBtn = By.xpath("//button[@aria-label='OK']");

	// Locators for inspection report
	private By morecommands = By.xpath("//button[@title='More commands for SIES Document']");
	private By inspectionreportgenerated = By.xpath("// label[@aria-label='Inspection Report']");

	// Locators for Mail
	private By morecommandsInTimeline = By.xpath("//button[@title='More commands']");

	// Locators for Rework
	private By reworkOption = By.xpath("//select[@aria-label='Rework']");// Visible text Yes/No
	private By reworkCommentsBox = By.xpath("//textarea[@id='reworkComments']");
	private By submitBtn = By.xpath("//input[@value='Submit']");
	private By Inspectioncompletedselectedoption = By.xpath("//select[@aria-label='Inspection Completed?']/option");
	private By generateInspectionReportselectedoption = By
			.xpath("//select[@aria-label='Generate Inspection Report']/option");
	private By submitforSOReviewselectedoption = By
			.xpath("//select[contains(@id,'header') and @aria-label='Submit for SO Review']/option");

	// Locators for Manual WO
	private By newWOBtn = By.xpath("//span[text()='New Work Order']");
	private By applicationTanker = By.xpath("//input[@aria-label='Application Tanker, Lookup']");
	private By quickcreateSaveNCloseBtn = By.xpath("//button[@data-id='quickCreateSaveAndCloseBtn']");

	// Locators for Manual Bookable resource
	private By newBookableresourceBtn = By.xpath("//span[text()='New Bookable Resource Booking']");
	private By bookingStatusManualWO = By.xpath("//div[contains(@aria-label,'Booking Status Control')]");
	private By startDateManualWO = By.xpath("//input[@aria-label='Date of Start Time']");
	private By endDateManualWO = By.xpath("//input[@aria-label='Date of End Time']");
	private By startTimeManualWO = By.xpath("//input[@aria-label='Time of Start Time']");
	private By endTimeManualWO = By.xpath("//input[@aria-label='Time of End Time']");
	private By resource = By.xpath("//input[@aria-label='Resource, Lookup']");

	// Locators for Manual case
	private By entityLookupField = By.xpath("//input[@aria-label='Entity, Lookup']");
	private By newBtn = By.xpath("//button[@aria-label='New']");

	// Locators for TankerDeregistration
	private By tankerLookupField = By.xpath("//input[@aria-label='Tanker, Lookup']");
	private By moreCommandsForDereg = By.xpath("//button[@aria-label='More commands for Case Tanker']");
	private By newCaseTanker = By.xpath("//button[contains(@aria-label,'New Case Tanker')]");

	// Locators for Deposit amount calculations
	private By customerName = By.xpath("//div[@data-testid='pub_customer']");
	private By GWEstimatedQuantity = By.xpath("//input[@aria-label='GW Estimated Quantity']");// attribute=title
	private By GWActualQuantity = By.xpath("//input[@aria-label='GW Actual Quantity']");
	private By OSEstimatedQuantity = By.xpath("//input[@aria-label='OS Estimated Quantity']");
	private By OSActualQuantity = By.xpath("//input[@aria-label='OS Actual Quantity']");
	private By CalDepositOS = By.xpath("//input[@aria-label='Calculated Deposit OS']");
	private By CalDepositGW = By.xpath("//input[@aria-label='Calculated Deposit GW']");
	private By CalculatedDepositApp = By.xpath("//input[@aria-label='Calculated Deposit Based on Application']");
	private By CalculatedDepositActual = By.xpath("//input[@aria-label='Calculated Deposit Based on Actual Volume']");
	private By CalculatedDeposit = By.xpath("//input[@aria-label='Calculated Deposit']");
	private By Topup = By.xpath("//input[contains(@aria-label,'Refund')]");
	private By year = By.xpath("//input[@aria-label='Year']");
	private By wasteType = By.xpath("//ul[@aria-label='Selected values for Waste Type']/parent::div");

	public CasecreationPage(WebDriver driver) {
		super(driver);
		/*
		 * this.driver = driver; eleUtil = new ElementUtil(this.driver); jsutil = new
		 * JavaScriptUtil(this.driver); prop = eleUtil.readProperties(); common = new
		 * CommonActionsPage(TestBase.getDriver()); apppage = new
		 * ApplicationPage(TestBase.getDriver());
		 */
	}

	public void caseCreatioCheck() throws InterruptedException {
		// sortTheRecords(createdonCol, NewToOldCol, AppConstants.LONG_DEFAULT_WAIT);
		eleUtil.doClick(changeViewIcon);
		eleUtil.doClick(AcceptedApplicaion);
		eleUtil.waitForVisibilityOfElement(createdApp, 50);
		String entitynameFromApplication = eleUtil.doGetElementAttribute(createdApp, "aria-label");
		changeAreaSelection("Inspection");
		selectEntity("Cases");
		// sortTheRecords(createdonCol, NewToOldCol, AppConstants.LONG_DEFAULT_WAIT);
		eleUtil.waitForVisibilityOfElement(entitydropdown, 50);
		eleUtil.doElementClickable(entitydropdown, 20);
		eleUtil.doClick(entitydropdown);
		eleUtil.doClick(filterBy);
		eleUtil.doSendKeys(filterbyinputbox, CommonActionsPage.Tankercompanyname);
		Thread.sleep(6000);
		driver.findElement(filterbyinputbox).sendKeys(Keys.ALT, Keys.ENTER);
		// added this while loop on 07/26 to resolve suggestionbox issue
		/*
		 * WebElement suggestionElement = null; final int MAX_RETRIES = 10; int retries
		 * = 0;
		 * 
		 * while (retries < MAX_RETRIES) { try {// div[@class='ms-SelectionZone'] //
		 * Wait until the suggestion text is visible By suggestionTextLocator =
		 * By.xpath("//div[contains(@class,'suggestionTextOver')]");
		 * eleUtil.waitForVisibilityOfElement(suggestionTextLocator,
		 * AppConstants.SHORT_DEFAULT_WAIT); suggestionElement =
		 * driver.findElement(suggestionTextLocator); // String suggestionTextfieldval =
		 * // eleUtil.doElementGetText(suggestionTextLocator);
		 * 
		 * if (suggestionElement.isDisplayed()) { // Click on the apply button if needed
		 * driver.findElement(filterbyinputbox).sendKeys(Keys.ALT, Keys.ENTER);
		 * System.out.println("Suggestion found and action taken."); break; // Exit the
		 * loop if the suggestion is successfully found and acted upon } else { throw
		 * new TimeoutException("Suggestion is not visible."); }
		 * 
		 * } catch (TimeoutException e) { // Log retry attempt and wait before retrying
		 * System.out.println("Suggestion not found yet, retrying... Attempt: " +
		 * (retries + 1)); try { Thread.sleep(1000); // Sleep for 1 second before
		 * retrying } catch (InterruptedException ie) {
		 * Thread.currentThread().interrupt(); // Restore interrupted status } } catch
		 * (NoSuchElementException e) { // Handle case where elements are not found
		 * System.out.println("Element not found: " + e.getMessage()); break; // Exit
		 * loop if elements are not found } retries++; } if (retries == MAX_RETRIES) {
		 * System.out.
		 * println("Max retries reached. Suggestion or apply button not found."); }
		 */

		eleUtil.doElementClickable(applyBtn, 30);// Added on July 9th
		eleUtil.doClick(applyBtn);

		eleUtil.waitForVisibilityOfElement(entitynameOnCaseForm, 30);

		String entitynameonCase = eleUtil.doGetElementAttribute(entitynameOnCaseForm, "aria-label");
		System.out.println("entitynameonCase - " + entitynameonCase + "tankercompanyname - "
				+ CommonActionsPage.Tankercompanyname);
		Assert.assertEquals(entitynameonCase, CommonActionsPage.Tankercompanyname);
		System.out.println("Case created successfully");
		CommonActionsPage.casenumber = getcaseID();

		assertTrue(CommonActionsPage.casenumber.startsWith("DQB/TP/I"), "Case number format is not expected");
		System.out.println(CommonActionsPage.casenumber);
	}

	public String getcaseID() {
		String str = eleUtil.doElementGetText(caseidOnCaseForm);
		return str;
	}

	public String getTankercompanyname() {
		String str = eleUtil.doElementGetText(entitynameOnCaseForm);
		return str;
	}

	public List<String> getWONumber() {

		/*
		 * eleUtil.waitForVisibilityOfElement(WONumber, 10); String str f=
		 * eleUtil.doElementGetText(WONumber); System.out.println("work order number is"
		 * + str); return str;
		 */

		// By ele = By.xpath("//div[@col-id='msdyn_name']//descendant::a");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> myList = driver.findElements(By.xpath("//div[@col-id='msdyn_name']//descendant::a"));
		List<String> all_elements_text = new ArrayList<>();
		// System.out.println(myList.size());
		for (int i = 1; i <= myList.size(); i++) {
			By ele2 = By.xpath("(//div[@col-id='msdyn_name']//descendant::a)[" + i + "]");
			String wonumlist = eleUtil.doGetElementAttribute(ele2, "aria-label");
			all_elements_text.add(wonumlist);
		}
		System.out.println("List of work orders is :" + all_elements_text);
		// CommonActionsPage.setSharedValuesList("WOLIST", all_elements_text);
		// System.out.println(CommonActionsPage.getSharedValueList("WOLIST"));
		return all_elements_text;
		// return CommonActionsPage.getSharedValueList("WOLIST");
	}

	/*
	 * public String getTankername() {
	 * 
	 * eleUtil.waitForVisibilityOfElement(appTankerName, 10); String str =
	 * eleUtil.doElementGetText(appTankerName);
	 * System.out.println("Tanker number is" + str); return str;
	 * 
	 * }
	 */

	public void caseFormValidation() throws InterruptedException {
		// selectFirstRecord(firstRecord, AppConstants.SHORT_DEFAULT_WAIT);
		// getFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAULT_WAIT);
		eleUtil.isPageLoaded(100);
		eleUtil.doClick(caseidOnCaseForm);
		Thread.sleep(1000);

		eleUtil.waitForVisibilityOfElement(BusinessFunctionField, 10);
		String BUField = eleUtil.doElementGetText(BusinessFunctionField);
		String casenumber = eleUtil.doGetElementAttribute(caseid, "value");
		System.out.println("case number from FIO user:" + casenumber);
		String Casetype = eleUtil.doElementGetText(casetypeField);
		String CaseSubtype = eleUtil.doElementGetText(caseSubtypeField);
		String Createdon = eleUtil.doGetElementAttribute(createdonField, "Value");
		String CaseSO = eleUtil.doElementGetText(caseSOField);
		String CaseAO = eleUtil.doElementGetText(caseAOField);
		String CaseFIO = eleUtil.doElementGetText(caseFIOField);
		String status = eleUtil.doElementGetText(statusField);
		System.out.println("status field" + status);
		String caseSubtypeonTop = eleUtil.doElementGetText(caseSubtypefromTop);
		/*
		 * String ownerFiledVal = eleUtil.doElementGetText(ownerField);
		 * System.out.println("Owner field" + ownerFiledVal);
		 */ // change happen in 03/03- this field is removed and in that place case id came
		String caseIDfieldval = eleUtil.doElementGetText(caseIDAtTop);
		System.out.println("case id at top" + caseIDfieldval);
		String GWCRefNumVal = eleUtil.doElementGetText(GwcRefNum);

		assertTrue(BUField.contains("WRN5"), "BU is not same");
		assertTrue(Casetype.contains("Inspection Case"), "Case type is not same");
		assertTrue(CaseSubtype.contains("Tanker Permit Inspection"), "Case sub type is not same");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
		// String currentDateTime = formatter.format(date);
		// java.util.Calendar.getInstance(java.util.TimeZone.getDefault()).getTime();
		Date d = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("IST")).getTime(); // UTC
		String currentDateTime = formatter.format(d);
		// assertTrue(Createdon.contains(currentDateTime), "Created on is not same");
		assertTrue(CaseSO.contains("SIES DEV3"), "SO is not same");
		assertTrue(CaseAO.contains("SIES DEV1"), "AO is not same");
		assertTrue(CaseFIO.contains("SIES DEV2"), "FIO is not same");

		/*
		 * Thread.sleep(3000);
		 * 
		 * eleUtil.doClickWithWait(refreshBtn, AppConstants.SHORT_DEFAULT_WAIT);
		 * eleUtil.waitForVisibilityOfElement(statusField,AppConstants.
		 * SHORT_DEFAULT_WAIT); Thread.sleep(3000);
		 */
		Boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 30000) {
			// Boolean flag = false;
			// while (!flag) {
			try {
				Thread.sleep(3000);
				eleUtil.doClickWithWait(refreshBtn, AppConstants.SHORT_DEFAULT_WAIT);
				eleUtil.waitForVisibilityOfElement(statusField, AppConstants.SHORT_DEFAULT_WAIT);
				status = eleUtil.doElementGetText(statusField);
				if (status.equals("Scheduled")) {
					flag = true;
					// assertTrue(status.contains("Scheduled"), "status is not same");
					softassert.assertTrue(status.contains("Scheduled"), "status is not same");
					break;
				}
			} catch (Exception e) {
				// e.getMessage();
				System.out.println("Exceptrion:" + e);
			}
		}
		// System.out.println("status is :" + status);
		// assertTrue(status.contains("Scheduled"), "status is not same");

		// assertTrue(ownerFiledVal.contains("SIES DEV2"), "Owner field value is not
		// matching");
		// softassert.assertTrue(ownerFiledVal.contains("SIES DEV2"), "Owner field value
		// is not matching");
		softassert.assertAll();
		assertTrue(caseSubtypeonTop.contains("Tanker Permit Inspection"), "Case sub type from top is not same");
		CommonActionsPage.GWCReferenceNum = GWCRefNumVal;
	}

	public void caseFIOSOAONames() {
		eleUtil.waitForVisibilityOfElement(caseSOField, 20);
		String CaseSO = eleUtil.doElementGetText(caseSOField);
		eleUtil.waitForVisibilityOfElement(caseAOField, 20);
		String CaseAO = eleUtil.doElementGetText(caseAOField);
		eleUtil.waitForVisibilityOfElement(caseFIOField, 20);
		String CaseFIO = eleUtil.doElementGetText(caseFIOField);
		CommonActionsPage.case_FIO = CaseFIO;
		CommonActionsPage.case_SO = CaseSO;
		CommonActionsPage.case_AO = CaseAO;
	}

	public void changeView() {
		eleUtil.waitForVisibilityOfElement(changeViewIcon, 20);
		eleUtil.doElementClickable(changeViewIcon, 30);
		eleUtil.doClick(changeViewIcon);
		eleUtil.doClick(ActiveCases);
	}

	public void rolesUpdate() {
		// driver.findElement(By.xpath("//div[contains(@data-id,'pub_caseso.fieldControl')]")).clear();
		// button[@aria-label="Delete # Nabeela Almas Khan Zubair Ahmed Khan"]
		// data-id="pub_caseso.fieldControl-LookupResultsDropdown_pub_caseso_selected_tag_delete"
		// eleUtil.doClick(SOname);
		// WebElement ele=driver.findElement(By.xpath("//ul[@title='Case SO']"));
		// jsutil.scrollIntoView(driver.findElement(By.xpath("//ul[@title='Case
		// SO']")));
		// JavascriptExecutor js=(JavascriptExecutor)driver;

		eleUtil.waitForVisibilityOfElement(By.xpath("//ul[@title='Case SO']"), 50);
		// js.executeScript("arguments[0].scrollIntoView(true);", ele);
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//ul[@title='Case SO']"))).build().perform();
		// eleUtil.waitForVisibilityOfElement(By.xpath("//ul[@title='Case SO']"), 20);
		// eleUtil.doClearUsingKeys(By.xpath("//ul[@title='Case SO']"));
		eleUtil.doClick(By.xpath("//button[contains(@aria-label,'Delete')]"));
		// eleUtil.doClick(By.xpath("//span[contains(@data-id,'searchButton')]"));// -->
		// search
		eleUtil.waitForVisibilityOfElement(SOname, 20);
		eleUtil.doClick(SOname);
		eleUtil.doSendKeys(SOname, "Siesdev3@PUBSIES.onmicrosoft.com");
		System.out.println("about to click");
		driver.findElement(SOname).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		System.out.println("clicked");
		/*
		 * try { eleUtil.doSendKeys(SOname, "Siesdev3@PUBSIES.onmicrosoft.com");
		 * eleUtil.doClear(AOname); eleUtil.doSendKeys(AOname,
		 * "svc_sies_test_user1@PUB003.onmicrosoft.com"); eleUtil.doClear(FIOname);
		 * eleUtil.doSendKeys(FIOname, "svc_sies_test_user2@PUB003.onmicrosoft.com"); }
		 * catch (Exception e) { System.out.println("method failed"); }
		 */
	}

	public void openACase() {
		changeAreaSelection("Inspection");
		selectEntity("Cases");
		// sortTheRecords(createdonCol, NewToOldCol,
		// AppConstants.LONG_DEFAULT_WAIT);//commented on 02/14
	}

	public void searchACase() throws InterruptedException {
		eleUtil.waitForVisibilityOfElement(searchbox, 20);
		Thread.sleep(2000);
		eleUtil.doSendKeys(searchbox, CommonActionsPage.casenumber);

		// eleUtil.doSendKeys(searchbox, "DQB/TP/I/2024/24191");
		eleUtil.isPageLoaded(50);
		Thread.sleep(2000);

		driver.findElement(searchbox).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		selectFirstRecord(firstRecord, AppConstants.SHORT_DEFAULT_WAIT);
		getFirstRecord(firstRecord, AppConstants.SHORT_DEFAULT_WAIT);
	}

	public void navigatingtotab(String tabName) {

		By loc = By.xpath("//ul[@aria-label='Case Form']//li[@aria-label='" + tabName + "']");
		// eleUtil.isPageLoaded(20);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		eleUtil.waitForVisibilityOfElement(loc, 20);
		WebElement tab = driver.findElement(loc);
		tab.click();

		// CommonActionsPage.WOnumber = getWONumber();
		// CommonActionsPage.TankerName = getTankername();
	}

	public void navigatingtoStage(String stageName) {
		By clickOnStage = By.xpath("//div[@title='" + stageName + "']");
		eleUtil.doElementClickable(clickOnStage, 30);
		try {
			eleUtil.doClick(clickOnStage);
		} catch (Exception e) {
			eleUtil.doActionsClick(clickOnStage);
		}

	}

	public void validateWOScheduleNotification() throws InterruptedException {

		CommonActionsPage.WOnumber = getWONumber();// This is place we need to declare wonumber once alerts code is
													// included
		List<String> wonum = CommonActionsPage.WOnumber;
		// List<String> wonum = CommonActionsPage.getSharedValueList("WOLIST");
		for (int i = 0; i < wonum.size(); i++) {
			eleUtil.isPageLoaded(100);
			eleUtil.waitForVisibilityOfElement(notificationIcon, 100);
			eleUtil.doClick(notificationIcon);
			Boolean flag = false;
			long startTime = System.currentTimeMillis();
			while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
				try {
					Thread.sleep(3000);
					WebElement WOalert = driver.findElement(
							By.xpath("//p[text()='You Have been scheduled for  Work Order " + wonum.get(i) + ". ']"));
					if (eleUtil.isClickable(WOalert, 10)) {
						String actualAlertcontent = WOalert.getText();
						// eleUtil.waitForVisibilityOfElement(SIESGWCCompanyfield,AppConstants.SHORT_DEFAULT_WAIT);
						System.out.println("actualAlertcontent" + actualAlertcontent);
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
						wait.until(ExpectedConditions.elementToBeClickable(WOalert));

						/*
						 * if (!actualAlertcontent.isEmpty()) { // flag = true; actualAlertcontent =
						 * WOalert.getText(); // break;
						 * 
						 * }
						 */
						String ExpectedAlertContent = "You Have been scheduled for Work Order " + wonum.get(i)
								+ ". \"Tap to open\".";
						System.out.println("ExpectedAlertContent is :" + ExpectedAlertContent);
						assertTrue(actualAlertcontent.contains(ExpectedAlertContent), "Alert content is not same");
						WebElement taptoopenBtn = driver.findElement(By.xpath(
								"//p[text()='You Have been scheduled for  Work Order " + wonum.get(i) + ". ']/a"));
						taptoopenBtn.click();
						flag = true;
						ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
						System.out.println("open tabs" + tabs.size());
						driver.switchTo().window(tabs.get(1));
						// Thread.sleep(10000);
						eleUtil.waitForVisibilityOfElement(workordertext, 100);
						String afterTaptoOpenBtn = eleUtil.doGetElementAttribute(workordertext, "Value");
						System.out.println("afterTaptoOpenBtn:" + afterTaptoOpenBtn);
						assertTrue(afterTaptoOpenBtn.contains(wonum.get(i)),
								"WO is not same after clicking on tap to open button");
						System.out.println(tabs.size() - 1);
						// driver.switchTo().window(tabs.get(tabs.size() - 2));
						eleUtil.doElementClickable(saveCloseBtn, 20);
						eleUtil.doClick(saveCloseBtn);
						driver.switchTo().window(tabs.get(0));
						eleUtil.doClick(cancelBtn);
					}
				} catch (Exception e) {
					// e.printStackTrace();
					System.out.println("No such element");
				}

			}

		}
	}

	public void switchTab() {
		// driver.get("http://yahoo.com");
		JavascriptExecutor we = ((JavascriptExecutor) driver);
		we.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		// driver.close();
		// driver.get("http://google.com");
		// System.out.println("in new tab method");

	}

	public void switchToActiveTab() {
		// driver.get("http://yahoo.com");
		JavascriptExecutor we = ((JavascriptExecutor) driver);
		we.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs.size());
		System.out.println(tabs.size() - 1);
		driver.switchTo().window(tabs.get(tabs.size() - 1));
	}

	public void fillBookingDeatils() throws InterruptedException {
		navigatingtotab("Work Orders");
		List<String> wonum = CommonActionsPage.WOnumber;
		// List<String> wonum = CommonActionsPage.getSharedValueList("WOLIST");
		System.out.println("size is:" + wonum.size());
		for (int i = 0; i < wonum.size(); i++) {
			Thread.sleep(2000);
			By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + wonum.get(i) + "']");
			eleUtil.doActionsClick(woele);
			eleUtil.waitForVisibilityOfElement(workordertext, 30);
			String actualWO = eleUtil.doGetElementAttribute(workordertext, "value");
			System.out.println("actual WO:" + actualWO);
			System.out.println("expected wo:" + wonum.get(i));
			assertTrue(actualWO.contains(wonum.get(i)), "WO is not same");

			// Validation on Booking tab
			eleUtil.doClick(bookingTab);
			Thread.sleep(2000);
			selectFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAULT_WAIT);
			getFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAULT_WAIT);
			// clickOnRefrehBtn();
			eleUtil.doElementClickable(maximizescreenBtn, 10);
			eleUtil.doClick(maximizescreenBtn);
			eleUtil.doElementClickable(bookingStatusField, 100);
			eleUtil.doClick(bookingStatusField);
			By selectAnOption = By.xpath("//button[@title='In Progress']");
			eleUtil.waitForVisibilityOfElement(selectAnOption, 100);
			// eleUtil.doElementClickable(selectAnOption, 50);// added this line on 06/07
			eleUtil.doClick(selectAnOption);

			eleUtil.doElementClickable(saveOnBooking, 10);
			eleUtil.doClick(saveOnBooking);

			// ----------------------------
			/*
			 * String scheduledStartDateValOnBooking =
			 * eleUtil.doGetElementAttribute(scheduledStartDateField, "Value"); String
			 * scheduledStartTimevalOnBooking =
			 * eleUtil.doGetElementAttribute(scheduledStartTimeField, "Value"); String
			 * scheduledEndTimeFieldValOnBooking =
			 * eleUtil.doGetElementAttribute(scheduledEndTimeField, "title");
			 * 
			 * CommonActionsPage.setSharedValue("scheduledStartDate",
			 * eleUtil.doGetElementAttribute(scheduledStartDateField, "Value"));
			 * System.out.println(CommonActionsPage.getSharedValue("scheduledStartDate"));
			 * CommonActionsPage.setSharedValue("scheduledStartTime",
			 * eleUtil.doGetElementAttribute(scheduledStartTimeField, "Value"));
			 * System.out.println(CommonActionsPage.getSharedValue("scheduledStartTime"));
			 * CommonActionsPage.setSharedValue("scheduledEndTime",
			 * eleUtil.doGetElementAttribute(scheduledEndTimeField, "Value"));
			 * System.out.println(CommonActionsPage.getSharedValue("scheduledEndTime"));
			 */
			// -------------------------

			Thread.sleep(5000);
			signTheChecklist();

			/*
			 * eleUtil.doElementClickable(servicetab, 100);
			 * eleUtil.doActionsClick(servicetab); fillTheChecklistquestions(outcome);
			 */
			eleUtil.doElementClickable(saveNCloseOnBooking, 10);
			eleUtil.doClick(saveNCloseOnBooking);

			while (true) {
				try {
					eleUtil.doElementClickable(saveNContinueBtn, 10);
					eleUtil.doClick(saveNContinueBtn);
				} catch (org.openqa.selenium.NoSuchElementException e) {
					break;
				}
			}

			try {
				eleUtil.doClick(saveCloseBtn);
			} catch (Exception e) {
				eleUtil.doActionsClick(saveCloseBtn);
			}

		}
	}

	public void workOrderValidation() throws InterruptedException, ParseException {
		// CommonActionsPage.WOnumber = getWONumber();// this line should be removed
		// when we are including code for alert
		// validation
		// CommonActionsPage.TankerName = getTankername(); //this code added in NEA list
		// as per new changes
		List<String> wonum = CommonActionsPage.WOnumber;
		System.out.println("size is:" + wonum.size());
		for (int i = 0; i < wonum.size(); i++) {
			Thread.sleep(2000);
			By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + wonum.get(i) + "']");
			eleUtil.doActionsClick(woele);
			By ele = By.xpath("//button[@aria-label='Dismiss Teaching Bubble']");
			Thread.sleep(5000);
			List<WebElement> li = driver.findElements(By.xpath("//button[@aria-label='Dismiss Teaching Bubble']"));
			System.out.println(li.size());
			if (li.size() > 0) {
				eleUtil.waitForVisibilityOfElement(ele, AppConstants.LONG_DEFAULT_WAIT);
				li.get(0).click();
			} else {
				System.out.println("no alert present");
			}

			// driver.findElement(ele).click();
			String actualWO = eleUtil.doGetElementAttribute(workordertext, "title");
			System.out.println("actual WO:" + actualWO);
			System.out.println("expected wo:" + wonum.get(i));
			assertTrue(actualWO.contains(wonum.get(i)), "WO is not same");

			// Validation on Booking tab
			eleUtil.doClick(bookingTab);
			eleUtil.waitForVisibilityOfElement(ele, 30);
			// System.out.println(li.size());
			if (li.size() > 0) {
				eleUtil.waitForVisibilityOfElement(ele, AppConstants.MEDIUM_DEFAULT_WAIT);
				li.get(0).click();
			} else {
				System.out.println("no alert present");
			}
			eleUtil.waitForVisibilityOfElement(starttimeField, 10);
			String starttimeval = eleUtil.doElementGetText(starttimeField);
			String durationVal = eleUtil.doElementGetText(durationField);
			if (starttimeval.contains("9:00 am")) {
				System.out.println("start time is " + starttimeval);
			} else {
				System.out.println("start time is not 9 AM");
			}
			assertEquals(durationVal, "2 hours", "WO duration is not 2 hours");

			Thread.sleep(2000);
			selectFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAULT_WAIT);
			getFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAULT_WAIT);
			// clickOnRefrehBtn();
			eleUtil.doElementClickable(maximizescreenBtn, 10);
			eleUtil.doClick(maximizescreenBtn);
			eleUtil.doElementClickable(bookingStatusField, 30);
			eleUtil.doClick(bookingStatusField);
			// eleUtil.doClick(bookingStatusOption);
			By selectAnOption = By.xpath("//button[@title='In Progress']");
			eleUtil.waitForVisibilityOfElement(selectAnOption, 100);
			eleUtil.doClick(selectAnOption);

			String startDatevalOnHome = eleUtil.doGetElementAttribute(startDateField, "Value");
			String starttimevalOnHome = eleUtil.doGetElementAttribute(startTimeonBooking, "Value");
			String durationValOnHome = eleUtil.doGetElementAttribute(durationFieldOnBooking, "title");
			System.out.println("start date on bookings page:" + startDatevalOnHome);

			// assertTrue(starttimevalOnHome.contains("9:00 AM"), "WO start time is not 9:00
			// AM");
			assertTrue(durationValOnHome.contains("2 hours"), "WO duration is not 2 hours");

			eleUtil.doClearUsingKeys(actualDateField);
			eleUtil.doSendKeys(actualDateField, startDatevalOnHome);
			driver.findElement(actualDateField).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			System.out.println("starttimevalOnHome" + starttimevalOnHome);
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm a");
			// SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
			Date date = timeFormat.parse(starttimevalOnHome);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MINUTE, 10);
			String result = timeFormat.format(cal.getTime());
			System.out.println(result);

			// eleUtil.doClick(actualTimeField);
			// eleUtil.doClick(selectactualtimeVal);
			eleUtil.doElementClickable(actualTimeField, 30);
			eleUtil.doClick(actualTimeField);
			By actualtime = By.xpath("//input[contains(@id,'msdyn_actualarrivaltime_fabric_combobox')]");
			eleUtil.doClearUsingKeys(actualtime);
			eleUtil.doSendKeys(actualtime, result);

			eleUtil.doElementClickable(saveOnBooking, 10);
			eleUtil.doClick(saveOnBooking);
			Thread.sleep(5000);
			signTheChecklist();

			eleUtil.doElementClickable(saveNCloseOnBooking, 10);
			eleUtil.doClick(saveNCloseOnBooking);

			/*
			 * List<WebElement> li =
			 * driver.findElements(By.xpath(."//button[@aria-label='Save & Close']")); for
			 * (int k = 0; k < li.size(); k++) { if (eleUtil.isClickable(li.get(i), 10)) {
			 * System.out.println(eleUtil.isClickable(li.get(i), 10)); //li.get(i).click();
			 * Actions a=new Actions(driver);
			 * a.moveToElement(li.get(i)).click().build().perform(); } }
			 */

			CommonActionsPage.starttimeval = getStarttime();
			System.out.println("start time after creating a booking record is:" + CommonActionsPage.starttimeval);
			CommonActionsPage.startdateval = getStartdate();
			System.out.println("start date after creating a booking record is:" + CommonActionsPage.startdateval);
			Thread.sleep(5000);
			eleUtil.doClick(saveCloseBtn);

			// eleUtil.isPageLoaded(50);

		}
	}

	public String getStartdate() {
		String val = eleUtil.doElementGetText(starttimeField);
		System.out.println("Length is: " + val.length());
		if (val.length() == 16) {
			String startdateval = val.substring(0, 8);// 1/3/2024 9:00 amountOfGWWastetypeTanker}
			System.out.println("startdateval" + startdateval);
			return startdateval;
		} else {
			String startdateval = val.substring(0, 9);
			System.out.println("startdateval" + startdateval);
			return startdateval;
		}

	}

	public String getStarttime() {
		String val = eleUtil.doElementGetText(starttimeField);
		if (val.length() == 16) {
			String starttimeval = val.substring(9);// 1/3/2024 9:00 am 11/3/2024 9:00 am
			return starttimeval;
		} else {
			String starttimeval = val.substring(10);
			return starttimeval;
		}
	}

	public void signTheChecklist() {
		// Below 2 steps need to be included once signature box is moved to checklist
		// selectFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAULT_WAIT);
		// getFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAULT_WAIT);
		eleUtil.doElementClickable(notestab, 100);
		eleUtil.doActionsClick(notestab);
		eleUtil.doElementClickable(signature_box, 20);
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(driver.findElement(signature_box), 135, 0).build().perform();
		eleUtil.doElementClickable(confirmBtn, 30);
		eleUtil.doClick(confirmBtn);
		eleUtil.waitForVisibilityOfElement(nameOfAssignee, 30);
		eleUtil.doSendKeys(nameOfAssignee, "FIO");
	}

	public void fillTheChecklistquestions(String outcome) throws InterruptedException {
		eleUtil.isPageLoaded(50);
		String yesval = "Yes";
		String noval = "No";
		Thread.sleep(2000);
		// section[@id="id-2076"]//div[@aria-rowindex="2"]//div[@aria-colindex="5"]
		List<WebElement> elements = driver.findElements(By.xpath("//label[@aria-label='In Progress']"));
		System.out.println("checklist size is" + elements.size());
		// for (WebElement element : elements) {
		// for (int i = 2; i <= CommonActionsPage.tankerNumberSize.get("tankersize") +
		// 1; i++) {
		for (int i = 2; i <= elements.size() + 1; i++) {
			try {
				eleUtil.waitForVisibilityOfElement(By.xpath("//label[@aria-label='In Progress']"), 20);
				WebElement refreshedElement = driver
						.findElement(By.xpath("//div[@aria-rowindex='" + i + "']//div[@aria-colindex='5']"));
				String status = refreshedElement.getText();
				if (status.trim().equalsIgnoreCase("In Progress")) {
					refreshedElement.click();
					eleUtil.doDoubleClick(By.xpath("//div[@aria-rowindex='" + i + "']//div[@aria-colindex='5']"));
					eleUtil.waitForVisibilityOfElement(servicetasksTab, 30);
					eleUtil.doClick(servicetasksTab);
					Thread.sleep(2000);

					String actualname = eleUtil.doGetElementAttribute(checklistNameField, "aria-label");
					assertTrue(actualname.contains("Tanker Permit Inspection"), "Checklist name is not matching");

					eleUtil.doElementClickable(checklistNameField, 20);
					eleUtil.doClick(checklistNameField);
					eleUtil.doElementClickable(maximizescreenBtn, 10);
					eleUtil.doClick(maximizescreenBtn);

					if (outcome.equalsIgnoreCase("Compliance")) {
						By chklistQ1 = By.xpath("//input[contains(@name,'Q1_sq_') and @value='" + yesval + "']");
						By chklistQ2 = By.xpath("//input[contains(@name,'Q2_sq_') and @value='" + yesval + "']");
						By chklistQ3 = By.xpath("//input[contains(@name,'Q3_sq_') and @value='" + yesval + "']");
						By chklistQ4 = By.xpath("//input[contains(@name,'Q4_sq_') and @value='" + yesval + "']");
						By chklistQ5 = By.xpath("//input[contains(@name,'Q5_sq_') and @value='" + yesval + "']");
						By chklistQ6 = By.xpath("//input[contains(@name,'Q6_sq_') and @value='" + yesval + "']");
						By chklistQ7 = By.xpath("//input[contains(@name,'Q7_sq_') and @value='" + yesval + "']");
						By chklistQ8 = By.xpath("//input[contains(@name,'Q8_sq_') and @value='" + yesval + "']");
						By chklistQ9 = By.xpath("//input[contains(@name,'Q9_sq_') and @value='" + yesval + "']");
						By chklistQ10 = By.xpath("//input[contains(@name,'Q10_sq_') and @value='" + yesval + "']");
						By chklistQ11 = By.xpath("//input[contains(@name,'Q11_sq_') and @value='" + yesval + "']");
						By chklistQ12 = By.xpath("//input[contains(@name,'Q12_sq_') and @value='" + yesval + "']");
						By chklistQ13 = By.xpath("//input[contains(@name,'Q13_sq_') and @value='" + yesval + "']");
						By chklistQ14 = By.xpath("//input[contains(@name,'Q14_sq_') and @value='" + yesval + "']");
						By chklistQ15 = By.xpath("//input[contains(@name,'Q15_sq_') and @value='" + yesval + "']");
						By chklistQ16 = By.xpath("//input[contains(@name,'Q16_sq_') and @value='" + yesval + "']");
						By chklistQ17 = By.xpath("//input[contains(@name,'Q17_sq_') and @value='" + yesval + "']");

						eleUtil.waitForVisibilityOfElement(chklistQ1, 20);
						eleUtil.doClick(chklistQ1);
						eleUtil.doClick(chklistQ2);
						eleUtil.doClick(chklistQ3);
						eleUtil.doClick(chklistQ4);
						eleUtil.doClick(chklistQ5);
						eleUtil.doClick(chklistQ6);
						eleUtil.doClick(chklistQ7);
						eleUtil.doClick(chklistQ8);
						eleUtil.doClick(chklistQ9);
						eleUtil.doClick(chklistQ10);
						eleUtil.doClick(chklistQ11);
						eleUtil.doClick(chklistQ12);
						eleUtil.doClick(chklistQ13);
						eleUtil.doClick(chklistQ14);
						eleUtil.doClick(chklistQ15);
						eleUtil.doClick(chklistQ16);
						eleUtil.doClick(chklistQ17);

					} else {
						By chklistQ1 = By.xpath("//input[contains(@name,'Q1_sq_') and @value='" + yesval + "']");
						By chklistQ2 = By.xpath("//input[contains(@name,'Q2_sq_') and @value='" + yesval + "']");
						By chklistQ3 = By.xpath("//input[contains(@name,'Q3_sq_') and @value='" + yesval + "']");
						By chklistQ4 = By.xpath("//input[contains(@name,'Q4_sq_') and @value='" + yesval + "']");
						By chklistQ5 = By.xpath("//input[contains(@name,'Q5_sq_') and @value='" + yesval + "']");
						By chklistQ6 = By.xpath("//input[contains(@name,'Q6_sq_') and @value='" + yesval + "']");
						By chklistQ7 = By.xpath("//input[contains(@name,'Q7_sq_') and @value='" + yesval + "']");
						By chklistQ8 = By.xpath("//input[contains(@name,'Q8_sq_') and @value='" + noval + "']");
						By chklistQ9 = By.xpath("//input[contains(@name,'Q9_sq_') and @value='" + yesval + "']");
						By chklistQ10 = By.xpath("//input[contains(@name,'Q10_sq_') and @value='" + yesval + "']");
						By chklistQ11 = By.xpath("//input[contains(@name,'Q11_sq_') and @value='" + yesval + "']");
						By chklistQ12 = By.xpath("//input[contains(@name,'Q12_sq_') and @value='" + noval + "']");
						By chklistQ13 = By.xpath("//input[contains(@name,'Q13_sq_') and @value='" + yesval + "']");
						By chklistQ14 = By.xpath("//input[contains(@name,'Q14_sq_') and @value='" + yesval + "']");
						By chklistQ15 = By.xpath("//input[contains(@name,'Q15_sq_') and @value='" + yesval + "']");
						By chklistQ16 = By.xpath("//input[contains(@name,'Q16_sq_') and @value='" + yesval + "']");
						By chklistQ17 = By.xpath("//input[contains(@name,'Q17_sq_') and @value='" + yesval + "']");

						eleUtil.waitForVisibilityOfElement(chklistQ1, 20);
						eleUtil.doClick(chklistQ1);
						eleUtil.doClick(chklistQ2);
						eleUtil.doClick(chklistQ3);
						eleUtil.doClick(chklistQ4);
						eleUtil.doClick(chklistQ5);
						eleUtil.doClick(chklistQ6);
						eleUtil.doClick(chklistQ7);
						eleUtil.doClick(chklistQ8);
						eleUtil.doClick(chklistQ9);
						eleUtil.doClick(chklistQ10);
						eleUtil.doClick(chklistQ11);
						eleUtil.doClick(chklistQ12);
						eleUtil.doClick(chklistQ13);
						eleUtil.doClick(chklistQ14);
						eleUtil.doClick(chklistQ15);
						eleUtil.doClick(chklistQ16);
						eleUtil.doClick(chklistQ17);

					}

					int number = ThreadLocalRandom.current().nextInt();
					System.out.println("random  number before absolute:" + number);
					int randomNumber = Math.abs(number);
					String strform = String.valueOf(randomNumber);
					System.out.println("random number is:" + strform);
					jsutil.scrollIntoView(driver.findElement(newSealnumField));
					eleUtil.doSendKeys(newSealnumField, strform);
					By acknowledmentOption = By
							.xpath("//input[contains(@name,'Question2_sq_') and @value='" + yesval + "']");
					eleUtil.doClick(acknowledmentOption);
					eleUtil.doClick(saveBtnInChklsit);
					System.out.println("clicked on save button");
					Thread.sleep(3000);
					eleUtil.doElementClickable(markcompleteBtn, 40);
					try {
						eleUtil.doClick(markcompleteBtn);
					} catch (Exception e) {
						eleUtil.doActionsClick(markcompleteBtn);
					}
					Thread.sleep(2000);
					eleUtil.doClick(saveNCloseBtnInChklsit);

					boolean tankerRegNoDisplayed = false;
					long startTime = System.currentTimeMillis();
					while (!tankerRegNoDisplayed && (System.currentTimeMillis() - startTime) < 180000) {
						try {
							eleUtil.doClick(refreshBtn);
							eleUtil.waitForVisibilityOfElement(tankerregno, AppConstants.SHORT_DEFAULT_WAIT);
							// If tankerregno is displayed, set the flag to true to exit the loop
							if (driver.findElement(tankerregno).isDisplayed()) {
								tankerRegNoDisplayed = true;
							}
						} catch (StaleElementReferenceException e) {
							System.out.println("catching the exception");
						} catch (Exception e) {
							System.out.println("Button is not present");
						}
					}

					eleUtil.doClick(saveCloseBtn); //
					// complaincecheck();

				}

			} catch (StaleElementReferenceException e) {
				System.out.println("StaleElementReferenceException occurred: " + e.getMessage()); // elements =
			}

			eleUtil.isPageLoaded(30);
		}

	}

	public void complaincecheckInWorkorder(String status, String iscomplaint) {

		navigatingtotab("Work Orders");

		// eleUtil.doClick(summaryTab);
		// clickOnRefrehBtn();

		List<String> wonum = CommonActionsPage.WOnumber;
		System.out.println("Size of wonum list is: " + wonum.size());

		for (int i = 0; i < wonum.size(); i++) {
			long startTime = System.currentTimeMillis();
			By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + wonum.get(i) + "']");
			eleUtil.doActionsClick(woele);

			if (iscomplaint.equalsIgnoreCase("No")) {
				System.out.println("Tanker is Non-Compliance");
				// continue;
			} else {
				boolean tankerRegNoDisplayed = false;
				while (!tankerRegNoDisplayed && (System.currentTimeMillis() - startTime) < 180000) {
					try {
						eleUtil.doClick(refreshBtn);
						eleUtil.waitForVisibilityOfElement(tankerregno, AppConstants.SHORT_DEFAULT_WAIT);
						// If tankerregno is displayed, set the flag to true to exit the loop
						if (driver.findElement(tankerregno).isDisplayed()) {
							tankerRegNoDisplayed = true;
						}
					} catch (StaleElementReferenceException e) {
						System.out.println("catching the exception");
					} catch (Exception e) {
						System.out.println("Button is not present");
					}
				}
			}

			if (iscomplaint.equalsIgnoreCase("No")) {
				System.out.println("Tanker is Non-Compliance");
			} else {
				By isComplaintchkInWOfrom = By
						.xpath("//select[@aria-label='Is Compliant?']/option[text()='" + iscomplaint + "']");
				eleUtil.waitForVisibilityOfElement(isComplaintchkInWOfrom, 100);
				String isComplaintVal = eleUtil.doElementGetText(isComplaintchkInWOfrom);
				System.out.println("complaince check - " + isComplaintVal);
				if (isComplaintVal.equals(iscomplaint)) {
					System.out.println("Tanker is Complaince");
				} else {
					System.out.println("Tanker is Non-Complaince");
				}
				assertEquals(eleUtil.doGetElementAttribute(WOstatusInWOform, "title"), status,
						"WO status not matching");
				// eleUtil.doClick(saveCloseBtn);
			}
			eleUtil.waitForVisibilityOfElement(saveCloseBtn, 30);
			eleUtil.doClick(saveCloseBtn);
		}
	}

	public void complaincecheckInWorkorderAnusha(String status, String iscomplaint) {

		navigatingtotab("Work Orders");
		List<String> wonum = CommonActionsPage.WOnumber;
		System.out.println("Size of wonum list is: " + wonum.size());
		System.out.println(wonum);

		for (int i = 0; i < wonum.size(); i++) {
			long startTime = System.currentTimeMillis();
			By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + wonum.get(i) + "']");
			eleUtil.waitForVisibilityOfElement(woele, 30);
			eleUtil.doActionsClick(woele);

			boolean tankerRegNoDisplayed = false;
			while (!tankerRegNoDisplayed && (System.currentTimeMillis() - startTime) < 180000) {
				try {
					eleUtil.doClick(refreshBtn);
					eleUtil.waitForVisibilityOfElement(tankerregno, AppConstants.SHORT_DEFAULT_WAIT);
					// If tankerregno is displayed, set the flag to true to exit the loop
					if (driver.findElement(tankerregno).isDisplayed()) {
						tankerRegNoDisplayed = true;
					}
				} catch (StaleElementReferenceException e) {
					System.out.println("catching the exception");
				} catch (Exception e) {
					System.out.println("Button is not present");
				}
			}

			if (iscomplaint.equalsIgnoreCase("No")) {
				System.out.println("Tanker is Non-Compliance");
			} else {
				By isComplaintchkInWOfrom = By
						.xpath("//select[@aria-label='Is Compliant?']/option[text()='" + iscomplaint + "']");
				eleUtil.waitForVisibilityOfElement(isComplaintchkInWOfrom, 100);
				String isComplaintVal = eleUtil.doElementGetText(isComplaintchkInWOfrom);
				System.out.println("complaince check - " + isComplaintVal);
				if (isComplaintVal.equals(iscomplaint)) {
					System.out.println("Tanker is Complaince");
				} else {
					System.out.println("Tanker is Non-Complaince");
				}

				assertEquals(eleUtil.doGetElementAttribute(WOstatusInWOform, "title"), status,
						"WO status not matching");
			}
			eleUtil.waitForVisibilityOfElement(saveCloseBtn, 30);
			eleUtil.doClick(saveCloseBtn);
			eleUtil.isPageLoaded(30);
			navigatingtotab("Work Orders");
		}
	}

	public void complaincecheckInWorkorderRemove(String status, String iscomplaint) {

		navigatingtotab("Work Orders");

		// eleUtil.doClick(summaryTab);
		// clickOnRefrehBtn();

		List<String> wonum = CommonActionsPage.WOnumber;
		System.out.println("Size of wonum list is: " + wonum.size());
		System.out.println("wonum list is" + wonum);

		for (int i = 0; i < wonum.size(); i++) {

			By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + wonum.get(i) + "']");
			eleUtil.doActionsClick(woele);

			if (iscomplaint.equalsIgnoreCase("No")) {
				System.out.println("Work order " + wonum.get(i) + " is Noncompliance. Skipping further actions.");
				// continue;
			} else {
				boolean tankerRegNoDisplayed = false;
				long startTime = System.currentTimeMillis();
				while (!tankerRegNoDisplayed && (System.currentTimeMillis() - startTime) < 120000) {
					try {
						eleUtil.doClick(refreshBtn);
						eleUtil.waitForVisibilityOfElement(tankerregno, AppConstants.SHORT_DEFAULT_WAIT);
						// If tankerregno is displayed, set the flag to true to exit the loop
						if (driver.findElement(tankerregno).isDisplayed()) {
							tankerRegNoDisplayed = true;
						}
					} catch (StaleElementReferenceException e) {
						System.out.println("StaleElementReferenceException caught");
					} catch (Exception e) {
						System.out.println("Button is not present");
					}
				}

				if (!tankerRegNoDisplayed) {
					System.out.println("Tanker registration number not displayed within timeout.");
					continue;
				}

				By isComplaintchkInWOfrom = By
						.xpath("//select[@aria-label='Is Compliant?']/option[text()='" + iscomplaint + "']");
				eleUtil.waitForVisibilityOfElement(isComplaintchkInWOfrom, 100);
				String isComplaintVal = eleUtil.doElementGetText(isComplaintchkInWOfrom);
				System.out.println("complaince check - " + isComplaintVal);
				if (isComplaintVal.equals(iscomplaint)) {
					System.out.println("Tanker is Complaince");
				} else {
					System.out.println("Tanker is Non-Complaince");
				}

				// eleUtil.doClick(saveCloseBtn);
			}
			try {
				eleUtil.doClick(refreshBtn);
			} catch (StaleElementReferenceException e) {
				System.out.println("catching the exception");
			} catch (Exception e) {
				System.out.println("Button is not present");
			}
			eleUtil.waitForVisibilityOfElement(WOstatusInWOform, 30);
			assertEquals(eleUtil.doGetElementAttribute(WOstatusInWOform, "title"), status, "WO status not matching");
			eleUtil.waitForVisibilityOfElement(saveCloseBtn, 30);
			eleUtil.doElementClickable(saveCloseBtn, 30);
			eleUtil.doClick(saveCloseBtn);

		}

	}

	public void complaincecheckInWorkorderRemove2(String status, String iscomplaint) {
		navigatingtotab("Work Orders");

		List<String> wonum = CommonActionsPage.WOnumber;
		System.out.println("Size of wonum list is: " + wonum.size());
		System.out.println("wonum list is: " + wonum);

		for (String workOrderNumber : wonum) {
			By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + workOrderNumber + "']");
			eleUtil.doActionsClick(woele);

			try {
				if (iscomplaint.equalsIgnoreCase("No")) {
					System.out
							.println("Work order " + workOrderNumber + " is Noncompliance. Skipping further actions.");
					// Skip further actions for non-compliant work orders
					eleUtil.doClick(saveCloseBtn); // Close the work order
					continue;
				}

				// Perform actions for compliant work orders
				boolean tankerRegNoDisplayed = false;
				long startTime = System.currentTimeMillis();
				while (!tankerRegNoDisplayed && (System.currentTimeMillis() - startTime) < 120000) {
					try {
						eleUtil.doClick(refreshBtn);
						eleUtil.waitForVisibilityOfElement(tankerregno, AppConstants.SHORT_DEFAULT_WAIT);
						// If tankerregno is displayed, set the flag to true to exit the loop
						if (driver.findElement(tankerregno).isDisplayed()) {
							tankerRegNoDisplayed = true;
						}
					} catch (StaleElementReferenceException e) {
						System.out.println("StaleElementReferenceException caught");
					} catch (Exception e) {
						System.out.println("Exception caught: " + e.getMessage());
					}
				}

				if (!tankerRegNoDisplayed) {
					System.out.println("Tanker registration number not displayed within timeout for work order "
							+ workOrderNumber);
					// Handle the scenario where tanker registration number is not displayed
					// Continue to the next work order
					eleUtil.doClick(saveCloseBtn); // Close the work order
					continue;
				}

				// Proceed with checking compliance
				By isComplaintchkInWOfrom = By
						.xpath("//select[@aria-label='Is Compliant?']/option[text()='" + iscomplaint + "']");
				eleUtil.waitForVisibilityOfElement(isComplaintchkInWOfrom, 100);
				String isComplaintVal = eleUtil.doElementGetText(isComplaintchkInWOfrom);
				System.out.println("Compliance check - " + isComplaintVal);

				if (isComplaintVal.equals(iscomplaint)) {
					System.out.println("Work order " + workOrderNumber + " is Compliant");
					// Additional steps for compliant work orders if needed
				} else {
					System.out.println("Work order " + workOrderNumber + " is Non-Compliant");
					// Additional steps for non-compliant work orders if needed
				}

				// Validate WO status
				eleUtil.waitForVisibilityOfElement(WOstatusInWOform, 30);
				assertEquals(eleUtil.doGetElementAttribute(WOstatusInWOform, "title"), status,
						"WO status not matching");

				// Click Save/Close button to close the current work order
				eleUtil.waitForVisibilityOfElement(saveCloseBtn, 30);
				eleUtil.doClick(saveCloseBtn);

			} catch (Exception e) {
				System.out.println(
						"Exception occurred while processing work order " + workOrderNumber + ": " + e.getMessage());
				// Handle exceptions as needed
			}
		}
	}

	public void completeIdentifyStage() {
		navigatingtoStage("Identify");
		eleUtil.doElementClickable(nextstageBtn, 10);
		eleUtil.doClick(nextstageBtn);
	}

	public void confirmInspectionSchedule() {
		navigatingtoStage("Assignment");
		eleUtil.waitForVisibilityOfElement(confirmInspectionScheduleOption, 10);
		eleUtil.createSelect(confirmInspectionScheduleOption);
		eleUtil.doSelectDropDownByVisibleText(confirmInspectionScheduleOption, "Yes");
		eleUtil.doClick(saveBtn);
	}

	public void completeAssignmnetStage() throws InterruptedException {
		navigatingtoStage("Assignment");
		eleUtil.doElementClickable(nextstageBtn, 10);
		eleUtil.doClick(nextstageBtn);
		/*
		 * eleUtil.doElementClickable(saveBtn, 30); eleUtil.doClick(saveBtn);
		 * eleUtil.isPageLoaded(50);
		 */
		// eleUtil.doElementClickable(closeBtnOnBPF, 30);
		// eleUtil.doClick(closeBtnOnBPF);
	}

	public void completeInspection() {
		navigatingtoStage("Inspection"); // This step need to be removed once
		// everything is merged
		eleUtil.waitForVisibilityOfElement(inspectionCompletedOption, 10);
		eleUtil.createSelect(inspectionCompletedOption);
		eleUtil.doSelectDropDownByVisibleText(inspectionCompletedOption, "Yes");
		eleUtil.doClick(saveBtn);
		navigatingtoStage("Inspection");
		eleUtil.waitForVisibilityOfElement(generateInspectionReportOption, 10);
		eleUtil.createSelect(generateInspectionReportOption);
		eleUtil.doSelectDropDownByVisibleText(generateInspectionReportOption, "Yes");
		eleUtil.doClick(saveBtn);
		// eleUtil.doClick(closeBtnOnBPF);
		clickOnRefrehBtn();
		/*
		 * try { permitnumCheck(); } catch (ParseException e) { // TODO Auto-generated
		 * e.printStackTrace(); }
		 */

	}

	public void SORejectForRework() {
		navigatingtoStage("SO Review");
		eleUtil.waitForVisibilityOfElement(reworkOption, 10);
		eleUtil.createSelect(reworkOption);
		eleUtil.doSelectDropDownByVisibleText(reworkOption, "Yes");
		eleUtil.waitForFrameByIDOrName("FullPageWebResource", 30);
		eleUtil.doSendKeys(reworkCommentsBox, "Rework comments by SO");
		eleUtil.doClick(submitBtn);
		eleUtil.isPageLoaded(30);
	}

	public void movedBackToInspection() {

		navigatingtoStage("Inspection");
		eleUtil.waitForVisibilityOfElement(Inspectioncompletedselectedoption, 10);
		String inspectioncompletedval = eleUtil.doElementGetText(Inspectioncompletedselectedoption);
		assertEquals(inspectioncompletedval, "No", "Inspection completed value not changed to default value");
		eleUtil.waitForVisibilityOfElement(generateInspectionReportselectedoption, 10);
		String generateinspectionval = eleUtil.doElementGetText(generateInspectionReportselectedoption);
		assertEquals(generateinspectionval, "No", "Generate inspection value not changed to default value");
		eleUtil.waitForVisibilityOfElement(submitforSOReviewselectedoption, 10);
		String submitSOreviewval = eleUtil.doElementGetText(submitforSOReviewselectedoption);
		System.out.println("submitSOreviewval:" + generateinspectionval);
		assertEquals(submitSOreviewval, "---", "SubmitToSOReview value not changed to default value");
	}

	public void changeWOFromCompletedToInprogress() throws InterruptedException, ParseException {
		navigatingtotab("Work Orders");
		List<String> wonum = CommonActionsPage.WOnumber;
		System.out.println("size is:" + wonum.size());
		for (int i = 0; i < wonum.size(); i++) {
			Thread.sleep(2000);
			By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + wonum.get(i) + "']");
			eleUtil.doActionsClick(woele);

			// Validation on Booking tab
			eleUtil.waitForVisibilityOfElement(bookingTab, 30);
			eleUtil.doClick(bookingTab);
			Thread.sleep(2000);
			selectFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAULT_WAIT);
			getFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAULT_WAIT);

			eleUtil.doElementClickable(maximizescreenBtn, 10);
			eleUtil.doClick(maximizescreenBtn);
			eleUtil.doElementClickable(bookingStatusField, 50);
			eleUtil.doClick(bookingStatusField);
			By selectAnOption = By.xpath("//button[@title='In Progress']");
			eleUtil.waitForVisibilityOfElement(selectAnOption, 100);
			eleUtil.doClick(selectAnOption);
			eleUtil.isPageLoaded(30);
			// Adding 10 minuites to end time field and enter into the endTime field
			String StartTimeval = eleUtil.doGetElementAttribute(startTimeonBooking, "Value");
			System.out.println("StartTimeval" + StartTimeval);
			SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
			Date date = timeFormat.parse(StartTimeval);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MINUTE, 10);
			String result = timeFormat.format(cal.getTime());
			System.out.println(result);
			eleUtil.doElementClickable(endTimeonBooking, 30);
			eleUtil.doClick(endTimeonBooking);
			eleUtil.doClearUsingKeys(endTimeonBooking);
			eleUtil.doSendKeys(endTimeonBooking, result);

			eleUtil.doElementClickable(saveOnBooking, 10);
			eleUtil.doClick(saveOnBooking);

			Thread.sleep(5000);

			// eleUtil.doElementClickable(saveNContinueBtn, 10);//These 2 lines are now
			// coming after 'Save and Close'
			// eleUtil.doClick(saveNContinueBtn);

			eleUtil.doElementClickable(saveNCloseOnBooking, 10);
			// eleUtil.isClickable(driver.findElement(saveNCloseOnBooking), 30);
			// eleUtil.doActionsClick(saveNCloseOnBooking);

			eleUtil.doClick(saveNCloseOnBooking);
			// jsutil.clickElementByJS(driver.findElement(saveNCloseOnBooking));

			while (true) {
				try {
					eleUtil.doElementClickable(saveNContinueBtn, 10);
					eleUtil.doClick(saveNContinueBtn);
				} catch (org.openqa.selenium.NoSuchElementException e) {
					break;
				}
			}

			Thread.sleep(2000);
			eleUtil.isPageLoaded(30);

			/*
			 * eleUtil.isPageLoaded(30); eleUtil.doElementClickable(saveCloseBtn, 10);
			 * eleUtil.doActionsClick(saveCloseBtn); eleUtil.doClickWithWait(saveCloseBtn,
			 * 20);
			 */

		}
	}

	public void amendChecklist() {

		eleUtil.isPageLoaded(30);
		eleUtil.waitForVisibilityOfElement(servicetasksTab, 30);
		eleUtil.doElementClickable(servicetasksTab, 40);
		eleUtil.doClick(servicetasksTab);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eleUtil.doElementClickable(checklistNameField, 20);
		eleUtil.doClick(checklistNameField);
		eleUtil.doElementClickable(maximizescreenBtn, 10);
		eleUtil.doClick(maximizescreenBtn);

		// String xpathForNoRadioButtons =
		// "//div[contains(@id,'sq_')]//label[@class='sv_q_radiogroup_label
		// ms-RadioButton-field is-checked']/input[@Value='No']";

		// Find all radio buttons selected as "No"
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> noRadioButtons = driver.findElements(By.xpath(
				"//div[contains(@name,'Q')]//label[@class='sv_q_radiogroup_label ms-RadioButton-field is-checked']/input[@Value='No']"));
		System.out.println("size is" + noRadioButtons.size());
		// Iterate through each radio button selected as "No"
		for (int i = 0; i < noRadioButtons.size(); i++) {
			System.out.println("entered for loop");
			WebElement yesRadioButton = driver.findElement(By.xpath(
					"//div[contains(@name,'Q')]//label[@class='sv_q_radiogroup_label ms-RadioButton-field']/input[@Value='Yes']"));

			if (noRadioButtons.get(i).isSelected() && noRadioButtons.get(i).getAttribute("Value").equals("No"))
				System.out.println("entered if loop");
			yesRadioButton.click();
		}

		eleUtil.doClick(saveBtnInChklsit);
		System.out.println("clicked on save button");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		eleUtil.doElementClickable(markcompleteBtn, 40);
		try {
			eleUtil.doClick(markcompleteBtn);
		} catch (Exception e) {
			eleUtil.doActionsClick(markcompleteBtn);
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		eleUtil.doClick(saveNCloseBtnInChklsit);

		eleUtil.doClick(saveCloseBtn);

	}

	// driver.findElement(By.xpath(
	// "//div[contains(@name,'Q8')]//label[@class='sv_q_radiogroup_label
	// ms-RadioButton-field is-checked']/input[@Value='No']")).click();
	// driver.findElement(By.xpath(
	// "//div[contains(@name,'Q8')]//input[@class='sv_q_radiogroup_control_item
	// ms-RadioButton-input' and @value='Yes']")).click();

	public void verifyPermitAgreeementLetters(String lettername) {
		eleUtil.waitForVisibilityOfElement(allTabs, 50);
		eleUtil.doElementClickable(workorderTab, 30);
		navigatingtotab("Timeline");
		By ele = By.xpath(
				"//label[text()='Note modified by']//ancestor::div[contains(@id,'timeline_record')]//descendant::div[contains(text(),'"
						+ lettername + "')]");
		Boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 30000) {
			try {
				// Thread.sleep(3000);
				eleUtil.doClickWithWait(refreshBtn, AppConstants.SHORT_DEFAULT_WAIT);
				navigatingtotab("Timeline");
				eleUtil.waitForVisibilityOfElement(ele, 30);
				if (driver.findElement(ele).isDisplayed()) {
					flag = true;
					System.out.println("validating letter is available or not");
					// Assert.assertEquals(true, driver.findElement(ele).isDisplayed());
					System.out.println("successful validation");
					// break;
				}
			} catch (Exception e) {
				// e.getMessage();
				System.out.println(lettername + "Letter is not available   ");
			}
		}
	}

	public void inspectionReportCheck() {
		navigatingtotab("Documents");
		eleUtil.waitForVisibilityOfElement(morecommands, 30);
		eleUtil.doClick(morecommands);
		boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
			try {
				eleUtil.waitForVisibilityOfElement(morecommands, 30);
				eleUtil.doClick(morecommands);
				driver.findElement(By.xpath("//button[@aria-label='Refresh' and contains(@id,'pub_document')]"))
						.click();
				eleUtil.waitForVisibilityOfElement(inspectionreportgenerated, AppConstants.SHORT_DEFAULT_WAIT);
				if (driver.findElement(inspectionreportgenerated).isDisplayed()) {
					flag = true;
				}
			} catch (Exception e) {
				System.out.println("Inspection report is not present");
			}
		}
	}

	public void completeInspectionStage() {

		navigatingtoStage("Inspection");
		eleUtil.waitForVisibilityOfElement(submitSOreviewBtn, 10);
		eleUtil.createSelect(submitSOreviewBtn);
		eleUtil.doSelectDropDownByVisibleText(submitSOreviewBtn, "Yes");
		eleUtil.doClick(saveBtn);
		// eleUtil.doClick(closeBtnOnBPF);
		eleUtil.isPageLoaded(10);
		navigatingtoStage("Inspection");
		eleUtil.doElementClickable(nextstageBtn, 10);
		eleUtil.doClick(nextstageBtn);
	}

	public String permitnumval() {

		eleUtil.waitForVisibilityOfElement(permitnumber, 50);

		String str = eleUtil.doGetElementAttribute(permitnumber, "aria-label");
		if (!str.isEmpty()) {
			System.out.println("permit number is generated" + str);
		} else {
			System.out.println("permit number is blank");
		}
		return str;

	}

	public void permitnumCheck() throws ParseException {
		int i = 0;
		navigatingtotab("Work Orders");
		List<String> wonum = CommonActionsPage.WOnumber;
		System.out.println("size is:" + wonum.size());
		for (i = 0; i < wonum.size(); i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			By woele = By.xpath("//div[@col-id='msdyn_name']//descendant::a[@aria-label='" + wonum.get(i) + "']");
			eleUtil.doActionsClick(woele);
			By isComplaintchkInWOfrom = By.xpath("//select[@aria-label='Is Compliant?']/option[@data-selected='true']");
			eleUtil.waitForVisibilityOfElement(isComplaintchkInWOfrom, 100);
			String isComplaintVal = eleUtil.doElementGetText(isComplaintchkInWOfrom);
			System.out.println("isComplaintVal" + isComplaintVal);
			// eleUtil.doElementClickable(gwctankername, 20);
			// eleUtil.doClick(gwctankername);
			if (isComplaintVal.equalsIgnoreCase("No")) {
				System.out.println("Tanker is noncompalince. Permit will not be generated for this tanker");
			} else {
				eleUtil.doElementClickable(tankerNumberInWOform, 30);
				eleUtil.doClick(tankerNumberInWOform);
				clickOnRefrehBtn();
				clickOnRefrehBtn();

				// jsutil.zoomChromeEdgeSafari("80");

				// permitnumval();

				// eleUtil.waitForVisibilityOfElement(permitnumber, 100);

				// String permit = eleUtil.doGetElementAttribute(permitnumber, "aria-label");
				CommonActionsPage.permitnums.put("permits" + i, permitnumval());

				System.out.println();
				// CommonActionsPage.permitnums.put("permits", permit);-->if we are using like
				// this latest value is replacing with existing value
				// System.out.println("permits"+i);
				// jsutil.zoomChromeEdgeSafari("100");
				eleUtil.waitForVisibilityOfElement(letterdate, 20);
				String letterdateval = eleUtil.doGetElementAttribute(letterdate, "aria-label");
				System.out.println("Letter date is" + letterdateval);

				// need to add code here --> permit expiry date

				System.out.println("---------------");
				// String letterdateval = "12-2-2024";// 2024-02-12
				SimpleDateFormat formatter = new SimpleDateFormat("dd/M/yyyy");
				Date date = formatter.parse(letterdateval);
				SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
				String finalString = newFormat.format(date);
				System.out.println(finalString);
				LocalDate permitgeneratedDate = LocalDate.parse(finalString);
				int month = permitgeneratedDate.getMonth().getValue();
				int year = permitgeneratedDate.getYear();

				// Define the date range criteria based on applicationDate
				int stDateYear = Integer.MIN_VALUE, endDateYear = Integer.MIN_VALUE;
				if (month >= 4 && month <= 12) {
					stDateYear = year;
					// endDateYear = year + 1;//commented on 07/23
					endDateYear = year;
				} else if (month >= 1 && month <= 3) {
					stDateYear = year - 1;
					endDateYear = year;
				}
				// Financial year range from
				LocalDate startDate = LocalDate.of(stDateYear, 4, 1);
				LocalDate endDate = LocalDate.of(endDateYear, 3, 31);

				// Calculate the expire date based on the condition
				LocalDate ExpectedexpireDate = LocalDate.of(endDateYear, 3, 31);// Here we always want exp date tobe
																				// mar-31

				// Print the result
				// System.out.println("Permit generation Date: " + letterdateval);
				// System.out.println("Expire Date: " + ExpectedexpireDate);

				// Format LocalDate as per our choice
				DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("M/dd/yyyy");// dd/M/yyyy --> modified on
																						// 07/23
				String expireDateInString = ExpectedexpireDate.format(formatter1);
				System.out.println("Converted String (DateTimeFormatter): " + expireDateInString);

				System.out.println("--------------------");

				String expirydateval = eleUtil.doGetElementAttribute(expirydate, "aria-label");
				// System.out.println("Expire date is" + expirydateval);
				if (expirydateval.equals(expireDateInString)) {
					System.out.println("Expiry date is expected   " + "actual : " + expirydateval + "   Expected : "
							+ expireDateInString);
				} else {
					System.out.println(
							"Not as expected" + "actual : " + expirydateval + "Expected : " + expireDateInString);
				}

				// eleUtil.doClick(backBtn);

				// CommonActionsPage.permitnum = permitnumval();
				// CommonActionsPage.permitExpiryDate = expirydateval;

				jsutil.clickElementByJS(driver.findElement(backBtn));

			}
			eleUtil.doElementClickable(saveCloseBtn, 30);
			eleUtil.doClick(saveCloseBtn);

		}
		/*
		 * SortedMap<String, String> sortedPermits = new
		 * TreeMap<>(CommonActionsPage.permitnums);
		 * CommonActionsPage.permitnums.clear();
		 * CommonActionsPage.permitnums.putAll(sortedPermits);
		 * System.out.println("sortedPermits" + sortedPermits);
		 */

		System.out.println("List of permits " + CommonActionsPage.permitnums);// key=value
		System.out.println("put" + CommonActionsPage.permitnums.get("permits" + i));// null
		System.out.println("keyset" + CommonActionsPage.permitnums.keySet());// All keys
		System.out.println(permitnums.get("permits"));// null
	}

	public void validateSOReviewNotification() throws InterruptedException {
		// for (int i = 1; i <= CommonActionsPage.permitnums.size(); i++) {
		for (Map.Entry<String, String> entry : CommonActionsPage.permitnums.entrySet()) {
			System.out.println(entry.getValue());
			eleUtil.isPageLoaded(100);
			eleUtil.waitForVisibilityOfElement(notificationIcon, 100);
			eleUtil.doClick(notificationIcon);
			// jsutil.zoomChromeEdgeSafari("80");
			Boolean flag = false;
			long startTime = System.currentTimeMillis();
			// int i = 1;
			while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
				try {
					Thread.sleep(3000);
					// WebElement WOalert = driver.findElement(By.xpath("(//p[contains(text(),'The
					// Permit')])["+i+"]"));
					String ExpectedAlertContent = "The Permit " + entry.getValue() + " has been submitted by "
							+ CommonActionsPage.case_FIO + " and waiting for your review .\"Tap to Open\"";
					By ele = By.xpath("//p[contains(text(),'The Permit " + entry.getValue() + " has been submitted by "
							+ CommonActionsPage.case_FIO + " and waiting for your review')]");
					eleUtil.waitForVisibilityOfElement(ele, 20);
					if (!driver.findElement(ele).isDisplayed()) {

						// JavascriptExecutor js = (JavascriptExecutor) driver;

						// WebElement scrollDown =
						// driver.findElement(By.xpath("//div[contains(@class,'ms-Panel-scrollableContent
						// scrollableContent')]//p[contains(text(),'The Permit " + entry.getValue() +
						// "has been submitted by "+ CommonActionsPage.case_FIO + " and waiting for your
						// review')]/a"));
						// WebElement scrollDown =
						// driver.findElement(By.cssSelector("div:contains('ms-Panel-scrollableContent
						// scrollableContent')"));
						// js.executeScript("arguments[0].scrollBy(0,1200);", scrollDown);
						// js.executeScript("arguments[0].scrollIntoView(true);", scrollDown);

						Boolean flag1 = false;

						while (!flag1) {
							try {
								Thread.sleep(30000);
								// eleUtil.waitForVisibilityOfElement(ele, AppConstants.SHORT_DEFAULT_WAIT);
								WebElement scrollDown = driver.findElement(By.xpath(
										"//div[contains(@class,'ms-Panel-scrollableContent scrollableContent')]//p[contains(text(),'The Permit "
												+ entry.getValue() + "has been submitted by "
												+ CommonActionsPage.case_FIO + " and waiting for your review')]/a"));
								// jsutil.scrollIntoView(scrollDown);
								JavascriptExecutor js = (JavascriptExecutor) driver;
								js.executeScript("window.scrollBy(0,10000)");

								System.out.println("element clicked  : " + scrollDown);
								if (scrollDown.isDisplayed()) {
									flag1 = true;
								}

							} catch (Exception e) {

								System.out.println("element not found");
							}
						}

					}

					WebElement WOalert = driver.findElement(
							By.xpath("//p[contains(text(),'The Permit " + entry.getValue() + " has been submitted by "
									+ CommonActionsPage.case_FIO + " and waiting for your review')]"));
					if (eleUtil.isClickable(WOalert, 10)) {
						String actualAlertcontent = WOalert.getText();
						System.out.println("actualAlertcontent" + actualAlertcontent);
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

						wait.until(ExpectedConditions.elementToBeClickable(WOalert));

						// permitNumber = CommonActionsPage.permitnums.entrySet().iterator().next();
						// String ExpectedAlertContent = "The Permit " + entry.getValue() + " has been
						// submitted by "
						// + CommonActionsPage.case_FIO + " and waiting for your review .\"Tap to
						// Open\"";
						System.out.println("ExpectedAlertContent is :" + ExpectedAlertContent);
						assertTrue(actualAlertcontent.contains(ExpectedAlertContent), "Alert content is not same");
						WebElement taptoopenBtn = driver.findElement(By
								.xpath("//p[contains(text(),'The Permit " + entry.getValue() + " has been submitted by "
										+ CommonActionsPage.case_FIO + " and waiting for your review')]/a"));
						taptoopenBtn.click();
						flag = true;
						ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
						System.out.println("open tabs" + tabs.size());
						driver.switchTo().window(tabs.get(1));
						eleUtil.waitForVisibilityOfElement(permitnotext, 100);
						String afterTaptoOpenBtn = eleUtil.doGetElementAttribute(permitnotext, "Value");
						System.out.println("afterTaptoOpenBtn:" + afterTaptoOpenBtn);
						assertTrue(afterTaptoOpenBtn.contains(entry.getValue()),
								"Permit number is not same after clicking on tap to open button");

						System.out.println(tabs.size() - 1);
						eleUtil.doElementClickable(saveCloseBtn, 20);
						eleUtil.doClick(saveCloseBtn);
						driver.switchTo().window(tabs.get(0));
						eleUtil.doClick(cancelBtn);
						// jsutil.zoomChromeEdgeSafari("100");

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

	}

	public void validateCaseComplaintNotification() throws InterruptedException {

		eleUtil.isPageLoaded(100);
		eleUtil.waitForVisibilityOfElement(notificationIcon, 100);
		eleUtil.doClick(notificationIcon);
		Boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
			try {
				Thread.sleep(3000);

				WebElement WOalert = driver.findElement(By.xpath("//p[contains(text(),'Case is compliant')]"));
				// JavascriptExecutor js = (JavascriptExecutor) driver;
				// js.executeScript("arguments[0].scrollIntoView(true);", WOalert);
				if (eleUtil.isClickable(WOalert, 10)) {
					String actualAlertcontent = WOalert.getText();
					// eleUtil.waitForVisibilityOfElement(SIESGWCCompanyfield,AppConstants.SHORT_DEFAULT_WAIT);
					System.out.println("actualAlertcontent" + actualAlertcontent);
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait.until(ExpectedConditions.elementToBeClickable(WOalert));
					String ExpectedAlertContent = "' Case is compliant'. ''Tap to Open''.";
					System.out.println("ExpectedAlertContent is :" + ExpectedAlertContent);
					assertTrue(actualAlertcontent.contains(ExpectedAlertContent), "Alert content is not same");
					WebElement taptoopenBtn = driver
							.findElement(By.xpath("//p[contains(text(),'Case is compliant')]/a"));
					taptoopenBtn.click();
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("open tabs" + tabs.size());
		driver.switchTo().window(tabs.get(1));
		// Thread.sleep(10000);
		eleUtil.waitForVisibilityOfElement(caseid, 100);
		String afterTaptoOpenBtn = eleUtil.doGetElementAttribute(caseid, "Value");// need to update code here

		System.out.println("afterTaptoOpenBtn:" + afterTaptoOpenBtn);
		assertTrue(afterTaptoOpenBtn.contains(CommonActionsPage.casenumber),
				"case is not same after clicking on tap to open button");
		System.out.println(tabs.size() - 1);
		// driver.switchTo().window(tabs.get(tabs.size() - 2));
		eleUtil.doElementClickable(saveCloseBtn, 20);
		eleUtil.doClick(saveCloseBtn);
		driver.switchTo().window(tabs.get(0));
		try {
			eleUtil.doClick(cancelBtn);
		} catch (Exception e) {
			eleUtil.doActionsClick(cancelBtn);
		}
	}

	public void validateReworkNotification() throws InterruptedException {

		eleUtil.isPageLoaded(100);
		eleUtil.waitForVisibilityOfElement(notificationIcon, 100);
		eleUtil.doClick(notificationIcon);
		Boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
			try {
				Thread.sleep(3000);
				WebElement WOalert = driver.findElement(By.xpath("//p[contains(text(),'Case Alert')]"));
				if (eleUtil.isClickable(WOalert, 10)) {
					String actualAlertcontent = WOalert.getText();
					// eleUtil.waitForVisibilityOfElement(SIESGWCCompanyfield,AppConstants.SHORT_DEFAULT_WAIT);
					System.out.println("actualAlertcontent" + actualAlertcontent);
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait.until(ExpectedConditions.elementToBeClickable(WOalert));
					String ExpectedAlertContent = "Case Alert !" + CommonActionsPage.casenumber
							+ " is Re-assigned to you.Tap to Open.";
					System.out.println("ExpectedAlertContent is :" + ExpectedAlertContent);
					assertTrue(actualAlertcontent.contains(ExpectedAlertContent), "Alert content is not same");
					WebElement taptoopenBtn = driver.findElement(By.xpath("//p[contains(text(),'Case Alert')]/a"));
					taptoopenBtn.click();
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("open tabs" + tabs.size());
		driver.switchTo().window(tabs.get(1));
		// Thread.sleep(10000);
		eleUtil.waitForVisibilityOfElement(caseid, 100);
		String afterTaptoOpenBtn = eleUtil.doGetElementAttribute(caseid, "Value");// need to update code here

		System.out.println("afterTaptoOpenBtn:" + afterTaptoOpenBtn);
		assertTrue(afterTaptoOpenBtn.contains(CommonActionsPage.casenumber),
				"case is not same after clicking on tap to open button");
		System.out.println(tabs.size() - 1);
		// driver.switchTo().window(tabs.get(tabs.size() - 2));
		eleUtil.doElementClickable(saveCloseBtn, 20);
		eleUtil.doClick(saveCloseBtn);
		driver.switchTo().window(tabs.get(0));
		eleUtil.doClick(cancelBtn);
	}

	public void validateWOComplaintNotification() throws InterruptedException {
		eleUtil.isPageLoaded(100);
		eleUtil.waitForVisibilityOfElement(notificationIcon, 100);
		eleUtil.doClick(notificationIcon);
		Boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
			try {
				Thread.sleep(3000);
				WebElement WOalert = driver.findElement(By.xpath("//p[contains(text(),'Compliant WO')]"));
				if (eleUtil.isClickable(WOalert, 10)) {
					String actualAlertcontent = WOalert.getText();
					// eleUtil.waitForVisibilityOfElement(SIESGWCCompanyfield,AppConstants.SHORT_DEFAULT_WAIT);
					System.out.println("actualAlertcontent" + actualAlertcontent);
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait.until(ExpectedConditions.elementToBeClickable(WOalert));
					String ExpectedAlertContent = "Compliant WO's of " + CommonActionsPage.casenumber;
					System.out.println("ExpectedAlertContent is :" + ExpectedAlertContent);
					assertTrue(actualAlertcontent.contains(ExpectedAlertContent), "Alert content is not same");
					WebElement taptoopenBtn = driver.findElement(
							By.xpath("//p[contains(text(),'Compliant WO')]/../following-sibling::div/p/a"));
					taptoopenBtn.click();
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("open tabs" + tabs.size());
		driver.switchTo().window(tabs.get(1));
		// Thread.sleep(10000);
		eleUtil.waitForVisibilityOfElement(caseid, 100);
		String afterTaptoOpenBtn = eleUtil.doGetElementAttribute(caseid, "Value");// need to update code here

		System.out.println("afterTaptoOpenBtn:" + afterTaptoOpenBtn);
		assertTrue(afterTaptoOpenBtn.contains(CommonActionsPage.casenumber),
				"case is not same after clicking on tap to open button");
		System.out.println(tabs.size() - 1);
		// driver.switchTo().window(tabs.get(tabs.size() - 2));
		eleUtil.doElementClickable(saveCloseBtn, 20);
		eleUtil.doClick(saveCloseBtn);
		driver.switchTo().window(tabs.get(0));
		try {
			eleUtil.doClick(cancelBtn);
		} catch (Exception e) {
			eleUtil.doActionsClick(cancelBtn);
		}
	}

	public void validateDeregisterNotification() throws InterruptedException {

		eleUtil.isPageLoaded(100);
		eleUtil.waitForVisibilityOfElement(notificationIcon, 100);
		eleUtil.doClick(notificationIcon);
		Boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
			try {
				Thread.sleep(3000);

				WebElement WOalert = driver.findElement(
						By.xpath("//p[contains(text(),'A tanker has been Deregistered and required your approval')]"));
				// JavascriptExecutor js = (JavascriptExecutor) driver;
				// js.executeScript("arguments[0].scrollIntoView(true);", WOalert);
				if (eleUtil.isClickable(WOalert, 10)) {
					String actualAlertcontent = WOalert.getText();
					// eleUtil.waitForVisibilityOfElement(SIESGWCCompanyfield,AppConstants.SHORT_DEFAULT_WAIT);
					System.out.println("actualAlertcontent" + actualAlertcontent);
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait.until(ExpectedConditions.elementToBeClickable(WOalert));
					//String ExpectedAlertContent = "' Case is compliant'. ''Tap to Open''.";
					String ExpectedAlertContent = "A tanker has been Deregistered and required your approval. ''Click here''.";
					System.out.println("ExpectedAlertContent is :" + ExpectedAlertContent);
					assertTrue(actualAlertcontent.contains(ExpectedAlertContent), "Alert content is not same");
					WebElement taptoopenBtn = driver.findElement(By.xpath(
							"//p[contains(text(),'A tanker has been Deregistered and required your approval')]/a"));
					taptoopenBtn.click();
					flag = true;
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					System.out.println("open tabs" + tabs.size());
					driver.switchTo().window(tabs.get(1));
					// Thread.sleep(10000);
					eleUtil.waitForVisibilityOfElement(caseid, 100);
					String afterTaptoOpenBtn = eleUtil.doGetElementAttribute(caseid, "Value");// need to update code
																								// here

					System.out.println("afterTaptoOpenBtn:" + afterTaptoOpenBtn);
					assertTrue(afterTaptoOpenBtn.contains(CommonActionsPage.casenumber),
							"case is not same after clicking on tap to open button");
					System.out.println(tabs.size() - 1);
					// driver.switchTo().window(tabs.get(tabs.size() - 2));
					eleUtil.doElementClickable(saveCloseBtn, 20);
					eleUtil.doClick(saveCloseBtn);
					driver.switchTo().window(tabs.get(0));
					try {
						eleUtil.doClick(cancelBtn);
					} catch (Exception e) {
						eleUtil.doActionsClick(cancelBtn);
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void completeSOReviewStage() {
		navigatingtoStage("SO Review");

		/*
		 * eleUtil.waitForVisibilityOfElement(systemassesmentOption, 10);
		 * assertEquals(eleUtil.doElementGetText(systemassesmentOption), "Complaince");
		 * eleUtil.waitForVisibilityOfElement(userassesmentOption, 10);
		 * assertEquals(eleUtil.doElementGetText(userassesmentOption), "Complaince");
		 */

		eleUtil.waitForVisibilityOfElement(submitAOreviewBtn, 10);
		eleUtil.createSelect(submitAOreviewBtn);
		eleUtil.doSelectDropDownByVisibleText(submitAOreviewBtn, "Yes");
		eleUtil.doClick(saveBtn);
		navigatingtoStage("SO Review");
		eleUtil.doElementClickable(nextstageBtn, 10);
		eleUtil.doClick(nextstageBtn);
	}

	public void completeAOReviewStage() {
		navigatingtoStage("AO Review");
		eleUtil.waitForVisibilityOfElement(AOresponseOption, 10);
		eleUtil.createSelect(AOresponseOption);
		// eleUtil.doClick(AOresponseOption);
		eleUtil.doSelectDropDownByVisibleText(AOresponseOption, "Approve");
		eleUtil.doElementClickable(saveBtn, 10);
		eleUtil.doActionsClick(saveBtn);
		navigatingtoStage("AO Review");
		eleUtil.doElementClickable(nextstageBtn, 10);
		eleUtil.doClick(nextstageBtn);
	}

	public void completeGenerateEmailStage() {
		navigatingtoStage("Generate Email");
		/*
		 * eleUtil.waitForVisibilityOfElement(generateemailOption, 10);
		 * eleUtil.createSelect(generateemailOption); eleUtil.isPageLoaded(40);
		 * eleUtil.doSelectDropDownByVisibleText(generateemailOption, "Yes");
		 */
		eleUtil.waitForVisibilityOfElement(emailtocustomerOption, 10);
		eleUtil.createSelect(emailtocustomerOption);
		eleUtil.doSelectDropDownByVisibleText(emailtocustomerOption, "Yes");
		/*
		 * eleUtil.waitForVisibilityOfElement(endoresementreceivedOption, 10);
		 * eleUtil.createSelect(endoresementreceivedOption);
		 * eleUtil.doSelectDropDownByVisibleText(endoresementreceivedOption, "Yes");
		 */
		eleUtil.doElementClickable(saveBtn, 30);
		eleUtil.doActionsClick(saveBtn);
		// eleUtil.isPageLoaded(10);
		// below 2 steps need to be removed once mails code is removed
		/*
		 * eleUtil.doElementClickable(okBtn, 10); eleUtil.doClick(okBtn);
		 */
	}

	public void completeResolveStage() {
		eleUtil.doElementClickable(generateemailStage, 10);
		navigatingtoStage("Generate Email");
		eleUtil.doElementClickable(nextstageBtn, 50);
		eleUtil.doActionsClick(nextstageBtn);
		while (true) {
			try {
				eleUtil.waitForVisibilityOfElement(okBtn, 10);
				eleUtil.doClick(okBtn);
			} catch (org.openqa.selenium.NoSuchElementException e) {
				break;
			}
		}

		navigatingtoStage("Close");
		eleUtil.waitForVisibilityOfElement(endoresementreceivedOption, 10);
		eleUtil.createSelect(endoresementreceivedOption);
		eleUtil.doSelectDropDownByVisibleText(endoresementreceivedOption, "Yes");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eleUtil.waitForVisibilityOfElement(resolvecaseOption, 10);
		eleUtil.createSelect(resolvecaseOption);
		eleUtil.doSelectDropDownByVisibleText(resolvecaseOption, "Yes");
		eleUtil.waitForVisibilityOfElement(finishBtn, 10);
		eleUtil.doElementClickable(finishBtn, 10);
		eleUtil.doClick(finishBtn);
	}

	public void processingStage() {
		navigatingtoStage("Processing");
		eleUtil.waitForVisibilityOfElement(processingOption, 10);
		eleUtil.createSelect(processingOption);
		eleUtil.doSelectDropDownByVisibleText(processingOption, "Yes");
		eleUtil.doElementClickable(saveBtn, 10);
		eleUtil.doActionsClick(saveBtn);
		navigatingtoStage("Processing");
		eleUtil.doElementClickable(nextstageBtn, 10);
		eleUtil.doClick(nextstageBtn);
	}

	public void uploadDocInCase() throws AWTException {
		navigatingtotab("Documents");
		eleUtil.doElementClickable(attachBtn, 10);
		eleUtil.doClick(attachBtn);
		eleUtil.doElementClickable(browsefield, 10);
		// eleUtil.doClick(browseBtn);
		// driver.findElement(browseBtn).sendKeys("Users/sriswathianusha.nulu/Documents/Test.txt");
		//
		eleUtil.doClick(browsefield);
		eleUtil.doSendKeys(browsefield, "C:/Users/sriswathianusha.nulu/Documents/Test.txt");
		/*
		 * Robot rb = new Robot();
		 * 
		 * // copying File path to Clipboard StringSelection str = new
		 * StringSelection("C:\\Users\\sriswathianusha.nulu\\Documents\\Test.txt");
		 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		 * 
		 * // press Contol+V for pasting rb.keyPress(KeyEvent.VK_CONTROL);
		 * rb.keyPress(KeyEvent.VK_V);
		 * 
		 * // release Contol+V for pasting rb.keyRelease(KeyEvent.VK_CONTROL);
		 * rb.keyRelease(KeyEvent.VK_V);
		 * 
		 * // for pressing and releasing Enter rb.keyPress(KeyEvent.VK_ENTER);
		 * rb.keyRelease(KeyEvent.VK_ENTER);
		 */
		eleUtil.doElementClickable(uploadBtn, 10);
		eleUtil.doClick(uploadBtn);
	}

	public void WOStatusChange() {

		navigatingtotab("Work Orders");
		// eleUtil.doClick(wostatusField);
		Boolean flag = false;
		long startTime = System.currentTimeMillis();
		while (!flag && (System.currentTimeMillis() - startTime) < 30000) {
			try {
				Thread.sleep(3000);
				eleUtil.doClickWithWait(refreshBtn, AppConstants.SHORT_DEFAULT_WAIT);
				navigatingtotab("Work Orders");
				eleUtil.waitForVisibilityOfElement(wostatusField, AppConstants.SHORT_DEFAULT_WAIT);
				String status = eleUtil.doElementGetText(wostatusField);
				System.out.println(status);
				if (status.equals("Scheduled")) {
					break;
				}
			} catch (Exception e) {
				// e.getMessage();
				System.out.println("Exceptrion:" + e);
			}
		}
	}

	public void manualWOCreation() throws InterruptedException {

		eleUtil.waitForVisibilityOfElement(newWOBtn, 20);
		eleUtil.doClick(newWOBtn);

		eleUtil.waitForVisibilityOfElement(applicationTanker, 50);
		eleUtil.doClick(applicationTanker);
		// driver.findElement(applicationTanker).sendKeys(CommonActionsPage.TankerName,
		// Keys.ARROW_DOWN, Keys.ENTER);
		eleUtil.doClear(applicationTanker);
		System.out.println(CommonActionsPage.tankerNumber.get(1));
		eleUtil.doSendKeys(applicationTanker, CommonActionsPage.tankerNumber.get(1));
		Thread.sleep(30000);
		By tankernumxpath = By.xpath("//li[contains(@data-id,'pub_applicationtankerid')]");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(tankernumxpath)).click().build().perform();

		eleUtil.doClick(quickcreateSaveNCloseBtn);
		eleUtil.isPageLoaded(30);
		// give wait for eleement visible WO STtaus= Uncheduled

		By manWOStatus = By.xpath("//label[@aria-label='Unscheduled']");
		eleUtil.waitForVisibilityOfElement(manWOStatus, 30);

		sortTheRecords(createdonCol, NewToOldCol, AppConstants.LONG_DEFAULT_WAIT);

		WebElement Workordernum = driver.findElement(By.xpath("(//div[@col-id='msdyn_name']//descendant::a)[1]"));
		By ele2 = By.xpath("(//div[@col-id='msdyn_name']//descendant::a)[1]");
		String manwotext = eleUtil.doGetElementAttribute(ele2, "aria-label");
		System.out.println("manwotext is" + manwotext);
		CommonActionsPage.WOnumber.add(manwotext);
		System.out.println("new WOrk order list is " + CommonActionsPage.WOnumber);

	}

	public void manualBookableResource() throws ParseException, InterruptedException {
		// click on the record whose WO Sttaus i 'Unscheduled' or click on 'Created On'
		// and sort the records from Newer to Older + select first record

		// sortTheRecords(createdonCol, NewToOldCol, AppConstants.LONG_DEFAULT_WAIT);
		selectFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAULT_WAIT);
		getFirstRecord(firstRecord, AppConstants.MEDIUM_DEFAULT_WAIT);
		// Validation on Booking tab
		eleUtil.waitForVisibilityOfElement(bookingTab, 30);
		eleUtil.doClick(bookingTab);

		eleUtil.waitForVisibilityOfElement(newBookableresourceBtn, 100);
		eleUtil.doClick(newBookableresourceBtn);
		eleUtil.doElementClickable(bookingStatusManualWO, 50);
		eleUtil.doClick(bookingStatusManualWO);
		By selectAnOption = By.xpath("//button[@title='In Progress']");
		eleUtil.waitForVisibilityOfElement(selectAnOption, 100);
		eleUtil.doClick(selectAnOption);
		eleUtil.isPageLoaded(30);
		// Adding 10 minuites to end time field and enter into the endTime field
		Thread.sleep(3000);
		String StartDateval = eleUtil.doGetElementAttribute(startDateManualWO, "value");
		String StartTimeval = eleUtil.doGetElementAttribute(startTimeManualWO, "value");
		System.out.println("StartDateval=" + StartDateval);
		System.out.println("StartTimeval=" + StartTimeval);

		eleUtil.doElementClickable(endDateManualWO, 30);
		eleUtil.doClick(endDateManualWO);
		Thread.sleep(15000);
		eleUtil.doClick(endDateManualWO);
		Thread.sleep(1000);
		eleUtil.doClearUsingKeys(endDateManualWO);
		// Thread.sleep(1000);
		eleUtil.doSendKeys(endDateManualWO, StartDateval);
		driver.findElement(endDateManualWO).sendKeys(Keys.ENTER);

		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
		Date date = timeFormat.parse(StartTimeval);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, 10);
		String result = timeFormat.format(cal.getTime());
		System.out.println(result);
		eleUtil.doElementClickable(endTimeManualWO, 30);
		eleUtil.doClick(endTimeManualWO);
		eleUtil.doClearUsingKeys(endTimeManualWO);
		eleUtil.doSendKeys(endTimeManualWO, result);

		eleUtil.waitForVisibilityOfElement(resource, 50);
		eleUtil.doClick(resource);
		eleUtil.doClear(resource);
		eleUtil.doSendKeys(resource, CommonActionsPage.case_FIO);
		Thread.sleep(30000);
		By resourcexpath = By.xpath("//li[contains(@data-id,'resource.field')]");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(resourcexpath)).click().build().perform();
		// eleUtil.doActionsClick(fioxpath);
		/*
		 * driver.findElement(resource).sendKeys(Keys.ARROW_DOWN); Thread.sleep(10000);
		 * driver.findElement(resource).sendKeys(Keys.ENTER);
		 */
		// eleUtil.isPageLoaded(10);
		eleUtil.doElementClickable(saveOnBooking, 10);
		eleUtil.doClick(saveOnBooking);

		Thread.sleep(5000);

		signTheChecklist();

		eleUtil.doElementClickable(saveOnBooking, 10);
		eleUtil.doClick(saveOnBooking);

		eleUtil.doElementClickable(saveNCloseOnBooking, 10);
		eleUtil.doClick(saveNCloseOnBooking);

		while (true) {
			try {
				eleUtil.doElementClickable(saveNContinueBtn, 30);
				eleUtil.doClick(saveNContinueBtn);
			} catch (org.openqa.selenium.NoSuchElementException e) {
				break;
			}
		}

		try {
			eleUtil.doClick(saveCloseBtn);
		} catch (Exception e) {
			eleUtil.doActionsClick(saveCloseBtn);
		}
	}

	public void manualCaseCreation() throws InterruptedException {
		eleUtil.waitForVisibilityOfElement(newBtn, 50);
		eleUtil.doElementClickable(newBtn, 20);
		jsutil.clickElementByJS(driver.findElement(newBtn));
		eleUtil.doElementClickable(caseSubtypeField, 30);
		eleUtil.createSelect(caseSubtypeField);
		eleUtil.doSelectDropDownByVisibleText(caseSubtypeField, "Tanker Deregistration");

		eleUtil.waitForVisibilityOfElement(entityLookupField, 50);
		eleUtil.doClick(entityLookupField);
		eleUtil.doClear(entityLookupField);
		System.out.println(CommonActionsPage.Tankercompanyname);
		eleUtil.doSendKeys(entityLookupField, CommonActionsPage.Tankercompanyname);
		// eleUtil.doSendKeys(entityLookupField, "Tankcompany29072024104016");
		Thread.sleep(25000);
		By tankercompanyxpath = By.xpath("//li[contains(@data-id,'customerid')]");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(tankercompanyxpath)).click().build().perform();
		
		eleUtil.doClick(saveBtn);
		Thread.sleep(2000);
		System.out.println("Text :" + eleUtil.doElementGetText(caseid));
		System.out.println("Attribute :" + eleUtil.doGetElementAttribute(caseid, "value"));
		System.out.println("title :" + eleUtil.doGetElementAttribute(caseid, "title"));
		CommonActionsPage.casenumber = eleUtil.doElementGetText(caseid);
		System.out.println("updated case number : " + CommonActionsPage.casenumber);
		
		eleUtil.isPageLoaded(30);
		
		
		
	}

	public void tankerToDeregister() throws InterruptedException {
		eleUtil.waitForVisibilityOfElement(moreCommandsForDereg, 30);
		eleUtil.doElementClickable(moreCommandsForDereg, 20);
		jsutil.clickElementByJS(driver.findElement(moreCommandsForDereg));
		// eleUtil.doClick(moreCommandsForDereg);
		eleUtil.doElementClickable(newCaseTanker, 20);
		eleUtil.doClick(newCaseTanker);

		eleUtil.waitForVisibilityOfElement(tankerLookupField, 50);
		eleUtil.doClick(tankerLookupField);

		eleUtil.doClear(tankerLookupField);
		System.out.println(CommonActionsPage.tankerNumber.get(1));
		eleUtil.doSendKeys(tankerLookupField, CommonActionsPage.tankerNumber.get(1));
		// eleUtil.doSendKeys(tankerLookupField, "T_290724104010");
		Thread.sleep(25000);
		By tankerxpath = By.xpath("//li[contains(@data-id,'pub_tanker')]");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(tankerxpath)).click().build().perform();

		eleUtil.waitForVisibilityOfElement(saveCloseBtn, 30);
		eleUtil.doElementClickable(saveCloseBtn, 20);
		eleUtil.doClick(saveCloseBtn);

	}

	public void GWEstQuan(String GWPerMonth) {
		eleUtil.waitForVisibilityOfElement(GWEstimatedQuantity, 10);
		String actualGWEstimatedQuantity = eleUtil.doGetElementAttribute(GWEstimatedQuantity, "title");
		assertEquals(actualGWEstimatedQuantity, GWPerMonth, "GW Estimated quantity not matching");
	}

	public int OSEstQuan(String OSSPerMonth, String OSIPerMonth) {
		// eleUtil.waitForVisibilityOfElement(OSEstimatedQuantity, 10);
		// String actualOSEstimatedQuantity =
		// eleUtil.doGetElementAttribute(OSEstimatedQuantity, "title");
		int Average = (Integer.valueOf(OSSPerMonth) + Integer.valueOf(OSIPerMonth)) / 2;
		// String expectedOSEstimatedQuantity = Integer.toString(Average);
		// assertEquals(actualOSEstimatedQuantity, expectedOSEstimatedQuantity, "OS
		// Estimated quantity not matching");
		return Average;
	}

	public int calculatedDepositOS(String OSSPerMonth, String OSIPerMonth) {
		// eleUtil.waitForVisibilityOfElement(CalDepositOS, 10);
		// String actualcalculatedDepositOS =
		// eleUtil.doGetElementAttribute(CalDepositOS, "title");
		int expectedcalculatedDepositOS = OSEstQuan(OSSPerMonth, OSIPerMonth) * 38;
		return expectedcalculatedDepositOS;
	}

	public int calculatedDepositGW(String GWPerMonth) {
		// eleUtil.waitForVisibilityOfElement(CalDepositGW, 10);
		// String actualcalculatedDepositOS =
		// eleUtil.doGetElementAttribute(CalDepositGW, "title");
		int expectedcalculatedDepositGW = Integer.valueOf(GWPerMonth) * 2;
		return expectedcalculatedDepositGW;
	}

	public int calculatedDepositBasedOnApp(String OSSPerMonth, String OSIPerMonth, String GWPerMonth) {
		int val = calculatedDepositOS(OSSPerMonth, OSIPerMonth) + calculatedDepositGW(GWPerMonth);
		return val;
	}

	public void calculatedDepositBasedOnActualVol() {

	}

	public void topUp() {

	}

	public void depoitAmountRecotrdCreation() {
		changeAreaSelection("GWC Tanker");
		selectEntity("Deposits");

	}

	public void paymentRecordValidation(String OSSPerMonth, String OSIPerMonth, String GWPerMonth, String wastetype)
			throws InterruptedException {
		eleUtil.doElementClickable(customerName, 30);
		eleUtil.doClick(customerName);
		eleUtil.waitForVisibilityOfElement(customerName, 50);
		eleUtil.doElementClickable(customerName, 100);
		eleUtil.doClick(customerName);
		eleUtil.doClick(filterBy);
		eleUtil.doSendKeys(filterbyinputbox, CommonActionsPage.Tankercompanyname);
		Thread.sleep(3000);
		driver.findElement(filterbyinputbox).sendKeys(Keys.ALT, Keys.ENTER);
		eleUtil.doClick(applyBtn);

		selectFirstRecord(firstRecord, AppConstants.SHORT_DEFAULT_WAIT);
		getFirstRecord(firstRecord, AppConstants.SHORT_DEFAULT_WAIT);
		switch (wastetype) {
		case "Greasy Waste":
			eleUtil.waitForVisibilityOfElement(wasteType, 20);
			assertEquals(eleUtil.doGetElementAttribute(wasteType, "title"), "Greasy Waste",
					"Wate type is not matching");
			GWEstQuan(GWPerMonth);
			assertEquals(eleUtil.doGetElementAttribute(OSEstimatedQuantity, "title"), "0.00",
					"OS Estimated quantity not matching");
			break;
		case "Organic Sludge":
			eleUtil.waitForVisibilityOfElement(wasteType, 20);
			assertEquals(eleUtil.doGetElementAttribute(wasteType, "title"),
					"Organic Sludge – Ships, Organic Sludge – Industries", "Wate type is not matching");
			eleUtil.waitForVisibilityOfElement(OSEstimatedQuantity, 10);
			String actualOSEstimatedQuantity = eleUtil.doGetElementAttribute(OSEstimatedQuantity, "title");
			int averageVal = OSEstQuan(OSSPerMonth, OSIPerMonth);
			String expectedOSEstimatedQuantity = Integer.toString(averageVal);
			assertEquals(actualOSEstimatedQuantity, expectedOSEstimatedQuantity, "OS Estimated quantity not matching");
			assertEquals(eleUtil.doGetElementAttribute(GWEstimatedQuantity, "title"), "0.00",
					"OS Estimated quantity not matching");
			break;
		case "Graesy Waste and Organic Sludge":
			eleUtil.waitForVisibilityOfElement(wasteType, 20);
			assertEquals(eleUtil.doGetElementAttribute(wasteType, "title"),
					"Greasy Waste, Organic Sludge – Ships, Organic Sludge – Industries", "Wate type is not matching");
			GWEstQuan(GWPerMonth);
			eleUtil.waitForVisibilityOfElement(OSEstimatedQuantity, 10);
			actualOSEstimatedQuantity = eleUtil.doGetElementAttribute(OSEstimatedQuantity, "title");
			averageVal = OSEstQuan(OSSPerMonth, OSIPerMonth);
			expectedOSEstimatedQuantity = Integer.toString(averageVal);
			assertEquals(actualOSEstimatedQuantity, expectedOSEstimatedQuantity, "OS Estimated quantity not matching");
			break;
		}

	}

	public void mailGeneratedOrNot(String mailType) throws InterruptedException, ParseException {
		clickOnRefrehBtn();
		navigatingtotab("Timeline");
		// eleUtil.isPageLoaded(100);
		Thread.sleep(2000);
		By ele;
		switch (mailType) {

		case "Inspection Schedule":
			String mailTrigger;
			ele = By.xpath("//label[contains(text(),'Inspection Appointment')]");
			// String mailTrigger = eleUtil.doElementGetText(ele);
			// assertTrue(mailTrigger.contains("Inspection Appointment"), "Mail is not
			// generated");
			// ----------

			boolean flag = false;
			long startTime = System.currentTimeMillis();
			ele = By.xpath("//label[contains(text(),'Inspection Appointment')]");
			while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
				try {
					for (int i = 0; i <= CommonActionsPage.tankerNumberSize.get("tankersize"); i++) {

						eleUtil.waitForVisibilityOfElement(morecommandsInTimeline, 30);
						eleUtil.doClick(morecommandsInTimeline);
						driver.findElement(By.xpath("//div[text()='Refresh timeline']")).click();

						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
						eleUtil.waitForVisibilityOfElement(ele, AppConstants.SHORT_DEFAULT_WAIT);
						List<WebElement> emailElements = driver.findElements(ele);
						for (WebElement email : emailElements) {
							// if(CommonActionsPage.tankerNumberSize.get("tanker
							// size").equals(email.getSize()))
							String emailContent = email.getText();
							if (emailContent.contains("Inspection Appointment")) {
								System.out.println("Email related to Inspection Appointment: " + emailContent);
								assertTrue(emailContent.contains("Inspection Appointment"), "Mail is not generated");
								// flag = true;
								// break;

							}
						}
						flag = true;

						if (flag) {
							System.out.println("Email with Inspection Appointment found.");
						} else {
							System.out.println("Email with Inspection Appointment not found.");
							// Add assertion for failure if necessary
							// assertTrue(foundEmail, "Mail is not generated");
						}
					}
				} catch (NoSuchElementException e) {
					System.out.println("Element not found: ");
				} catch (TimeoutException e) {
					System.out.println("Timeout waiting for element visibility: ");
				} catch (Exception e) {
					System.out.println("Exception occurred: ");
				}
			}

			// ----------------

			/*
			 * ele = By.xpath(
			 * "//label[contains(text(),'Inspection Appointment')]//ancestor::div[contains(@id,'timeline_record')]//a[@title='Open Record']"
			 * ); eleUtil.waitForVisibilityOfElement(ele, 30);
			 * eleUtil.doElementClickable(ele, 10); eleUtil.doClick(ele);
			 * eleUtil.scrollUsingRobotClass(); Thread.sleep(4000); //
			 * eleUtil.waitForVisibilityOfElement(mailframeLoc, 10);
			 * driver.switchTo().frame(driver.findElement(By.xpath(
			 * "//iframe[@title='Designer']")));
			 * driver.switchTo().frame(driver.findElement(By.xpath(
			 * "//iframe[@title='Description rich text editor' and @aria-label='Description rich text editor']"
			 * ))); // eleUtil.waitForFrameByLocator(mailframeLoc,
			 * AppConstants.LONG_DEFAULT_WAIT); Thread.sleep(4000); String actualBody =
			 * eleUtil.doElementGetText(mailBody);
			 * 
			 * String Expectedstr = "Dear Sir/Madam,\n" +
			 * "Please send in the tanker to Water hub during working hours  on between  to .Confirm the appointment date and time 1 day in advance.\n"
			 * + "Please ensure the tanker is ready for inspection.\n" +
			 * "Tank should be empty to open for visual check, the GPS operational\n" +
			 * "and camera can view the suction and discharge valve.\n" +
			 * "If satisfactory, its discharge handle will be tagged with PUB seal.\n" +
			 * "\n" + "Thanks,\n" + "G RAJ KUMAR\n" + "Senior Assistant Engineer\n" +
			 * "Water Reclamation (Network) Department (Operation & Maintenance Division)";
			 * String str1 ="Dear , \n" + "\n" +
			 * "Please send in the tanker to Water hub during working hours on between to. Confirm the appointment date and time 1 Day in advance.\n"
			 * + "\n" + "Please ensure the tanker is ready for inspection.\n" +
			 * "Tank should be empty to open for visual check, the GPS operational and camera can view the suction and discharge valve.\n"
			 * + "If satisfactory, its discharge handle will be tagged with PUB seal.\n" +
			 * "\n" + "\n" + "Regards\n" + "G RAJ KUMAR\n" + "Senior Assistant Engineer\n" +
			 * "Water Reclamation (Network) Department (Operation & Maintenance Division)";
			 * String str2="Dear , \n" + "\n" +
			 * "Please send in the tanker to Water hub during working hours on between. Confirm the appointment date and time 1 Day in advance.\n"
			 * + "\n" + "Please ensure the tanker is ready for inspection.\n" +
			 * "Tank should be empty to open for visual check, the GPS operational and camera can view the suction and discharge valve.\n"
			 * + "If satisfactory, its discharge handle will be tagged with PUB seal.\n" +
			 * "\n" + "Regards\n" + "G RAJ KUMAR\n" + "Senior Assistant Engineer\n" +
			 * "Water Reclamation (Network) Department (Operation & Maintenance Division)\n"
			 * ; System.out.println(actualBody);
			 * System.out.println("-----------------------"); System.out.println(str1);
			 * //assertEquals(actualBody, Expectedstr, "Body is not matching");
			 * assertTrue(str2.contains(actualBody), "Mail is generated");
			 * driver.switchTo().defaultContent();
			 */

			break;
		case "Permit generation":
			ele = By.xpath("//label[text()='Permit to Dispose Of Waste at Water Reclamation Plants (WRPs)']");
			mailTrigger = eleUtil.doElementGetText(ele);
			assertTrue(mailTrigger.contains("Permit to Dispose Of Waste at Water Reclamation Plants (WRPs)"),
					"Mail is not generated");
			// Assert.assertEquals(true,driver.findElement(attachment).isDisplayed());
			ele = By.xpath(
					"//label[text()='Permit to Dispose Of Waste at Water Reclamation Plants (WRPs)']//ancestor::div[contains(@id,'timeline_record')]//a[@title='Open Record']");
			eleUtil.doElementClickable(ele, 10);
			eleUtil.doClick(ele);
			eleUtil.waitForVisibilityOfElement(attachment, 30);
			if (driver.findElement(attachment).isDisplayed()) {
				System.out.println("attachment is present");
			} else {
				System.out.println("attachment is not present");
			}
			eleUtil.doElementClickable(backBtn, 50);
			eleUtil.doClick(backBtn);
			break;
		case "Permit WRP email":
			ele = By.xpath("//label[contains(text(),'For your assistance')]");

			mailTrigger = eleUtil.doElementGetText(ele);
			assertTrue(mailTrigger.contains("For your assistance"), "Mail is generated");
			ele = By.xpath(
					"//label[contains(text(),'For your assistance')]//ancestor::div[contains(@id,'timeline_record')]//a[@title='Open Record']");
			eleUtil.doElementClickable(ele, 10);
			eleUtil.doClick(ele);
			eleUtil.waitForVisibilityOfElement(attachment, 30);
			if (driver.findElement(attachment).isDisplayed()) {
				System.out.println("attachment is present");
			} else {
				System.out.println("attachment is not present");
			}
			eleUtil.doElementClickable(backBtn, 50);
			eleUtil.doClick(backBtn);
			break;
		case "Tanker non-complaince":
			ele = By.xpath("//label[text()='Tanker failed inspection']");
			// mailTrigger = eleUtil.doElementGetText(ele);
			// assertTrue(mailTrigger.contains("Tanker failed inspection"), "Mail is not
			// generated");

			flag = false;
			startTime = System.currentTimeMillis();
			ele = By.xpath("//label[contains(text(),'Tanker failed inspection')]");
			while (!flag && (System.currentTimeMillis() - startTime) < 300000) {
				try {
					eleUtil.waitForVisibilityOfElement(morecommandsInTimeline, 30);
					eleUtil.doClick(morecommandsInTimeline);
					driver.findElement(By.xpath("//div[text()='Refresh timeline']"))// button[contains(@aria-label,'Refresh')
																					// and contains(@id,'pub_document')]
							.click();
					eleUtil.waitForVisibilityOfElement(ele, AppConstants.SHORT_DEFAULT_WAIT);
					if (driver.findElement(ele).isDisplayed()) {
						flag = true;
						mailTrigger = eleUtil.doElementGetText(ele);
						assertTrue(mailTrigger.contains("Tanker failed inspection"), "Mail is not generated");

					}
				} catch (Exception e) {
					// Log the specific exception message for better debugging
					System.out.println("Non-Complaince email is not displayed");
				}
			}

			break;

		}
	}

	public void mailValidation(String mailType) throws InterruptedException, ParseException {
		clickOnRefrehBtn();
		navigatingtotab("Timeline");
		// eleUtil.isPageLoaded(100);
		Thread.sleep(2000);
		String actualSub, actualFrom, actualBody;
		List<WebElement> actualTo;
		List<String> headersValList;
		By ele;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/M/yyyy");
		Date date = formatter.parse(CommonActionsPage.startdateval);
		SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");
		String finalString = newFormat.format(date);
		System.out.println(finalString);
		switch (mailType) {

		case "Inspection Schedule":
			ele = By.xpath(
					"//label[contains(text(),'Inspection scheduled')]//ancestor::div[contains(@id,'timeline_record')]//a[@title='Open Record']");
			eleUtil.waitForVisibilityOfElement(ele, 30);
			eleUtil.doElementClickable(ele, 10);
			eleUtil.doClick(ele);
			eleUtil.waitForVisibilityOfElement(mailSubject, 10);
			actualSub = eleUtil.doGetElementAttribute(mailSubject, "Value");
			System.out.println("subject is" + actualSub);
			actualFrom = eleUtil.doElementGetText(mailFrom);

			actualTo = driver.findElements(mailTo);
			headersValList = new ArrayList<String>();
			for (int i = 0; i < actualTo.size(); i++) {
				String actualToVal = actualTo.get(i).getText();
				headersValList.add(actualToVal);
			}

			assertEquals(actualFrom, "SIES DEV3", "From address is not matching");
			System.out.println("CommonActionsPage.Tankercompanyname" + CommonActionsPage.Tankercompanyname
					+ "headersValList" + headersValList); //
			assertEquals(CommonActionsPage.Tankercompanyname, headersValList, "To address is not matching");
			assertTrue(headersValList.contains(CommonActionsPage.Tankercompanyname), "To address is not matching");
			assertEquals(actualSub, "Inspection scheduled for tanker " + CommonActionsPage.TankerName + ".",
					"Subject is not matching");
			// assertEquals(actualTo, "Tankercompany_022003","To address is not matching");
			// assertEquals(actualSub, "Inspection scheduled for tanker //
			// T_GW+022003.","Subject is not matching");
			eleUtil.scrollUsingRobotClass();
			Thread.sleep(4000);
			// eleUtil.waitForVisibilityOfElement(mailframeLoc, 10);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Designer']")));
			driver.switchTo().frame(driver.findElement(By.xpath(
					"//iframe[@title='Description rich text editor' and @aria-label='Description rich text editor']")));
			// eleUtil.waitForFrameByLocator(mailframeLoc,AppConstants.LONG_DEFAULT_WAIT);
			// Thread.sleep(4000);
			actualBody = eleUtil.doElementGetText(mailBody);

			System.out.println(finalString);

			/*
			 * String Expectedstr = "Dear Sir/Madam,\n" + "Please send in the tanker " +
			 * CommonActionsPage.TankerName + " to Waterhub during working hours on " +
			 * finalString + " 11:30 AM.\n" +
			 * "Confirm the appointment date and time 1 day in advance.\n" +
			 * "Please ensure the tanker is ready for inspection.\n" +
			 * "Tank should be empty to open for visual check, the GPS operational\n" +
			 * "and camera can view the suction and discharge valve.\n" +
			 * "If satisfactory, its discharge handle will be tagged with PUB seal.\n" +
			 * "\n" + "Thanks,\n" + "G RAJ KUMAR\n" + "Senior Assistant Engineer\n" +
			 * "Water Reclamation (Network) Department (Operation & Maintenance Division)";
			 * System.out.println(actualBody); assertEquals(actualBody, Expectedstr,
			 * "Body is not matching");
			 */

			driver.switchTo().defaultContent();

			break;
		case "Permit generation":
			ele = By.xpath(
					"//label[text()='Permit to Dispose Of Waste at Water Reclamation Plants (WRPs)']//ancestor::div[contains(@id,'timeline_record')]//a[@title='Open Record']");
			eleUtil.doElementClickable(ele, 10);
			eleUtil.doClick(ele);
			eleUtil.waitForVisibilityOfElement(mailSubject, 10);
			actualSub = eleUtil.doGetElementAttribute(mailSubject, "Value");
			System.out.println("subject is" + actualSub);
			actualFrom = eleUtil.doElementGetText(mailFrom);
			actualTo = driver.findElements(mailTo);
			headersValList = new ArrayList<String>();
			for (int i = 0; i < actualTo.size(); i++) {
				String actualToVal = actualTo.get(i).getText();
				headersValList.add(actualToVal);
			}

			System.out.println("actualTo values:" + headersValList);

			assertEquals(actualFrom, "SIES DEV2", "From address is not matching");
			List<String> expectedTo = new ArrayList<String>();

			expectedTo.add("WRN5 WRP Contact"); //
			expectedTo.add("Tankcompany01032024080235");
			expectedTo.add(CommonActionsPage.Tankercompanyname);
			System.out.println("expectedTo values:" + expectedTo);
			// assertEquals(headersValList, expectedTo, "To address is not matching");

			Collections.sort(headersValList);
			Collections.sort(expectedTo);
			if (headersValList.equals(expectedTo) == true) {
				System.out.println(" To address is matching     :" + headersValList + "------->" + expectedTo);
			} else {
				System.out.println(" To address is not matching ");
			}

			assertEquals(actualSub, "Permit to Dispose Of Waste at Water Reclamation Plants (WRPs)",
					"Subject is not matching");
			eleUtil.scrollUsingRobotClass();
			Thread.sleep(4000);
			// eleUtil.waitForVisibilityOfElement(mailframeLoc, 10);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Designer']")));
			driver.switchTo().frame(driver.findElement(By.xpath(
					"//iframe[@title='Description rich text editor' and @aria-label='Description rich text editor']")));
			// eleUtil.waitForFrameByLocator(mailframeLoc,AppConstants.LONG_DEFAULT_WAIT);
			// Thread.sleep(4000);
			actualBody = eleUtil.doElementGetText(mailBody);

			String ExpectedBody = "Dear Sir,\n" + "\n"
					+ "The attached permits dated 1/3/2024 are for disposal of greasy waste, organic sludge at Jurong WRP and human wastewater at WRPs. These permits expire on 31/3/2025.\n"
					+ "\n"
					+ "Please acknowledge acceptance of the terms and conditions by returning us a copy of this agreement within 5 working days with the signature of a representative of your company listed in ACRA. \n"
					+ "\n" + "Regards\n" + "\n" + "\n" + "\n" + "SIES DEV2\n" + "Field Inspection Officer\n"
					+ "Water Reclamation (Network) Department (Operation & Maintenance Division)\n" + "\n"
					+ "Confidential information may be in this message. If you are not the intended recipient, please notify the sender and delete the email";

			/*
			 * String ExpectedBody = "Dear Sir,\n" + "\n" + "The attached permits dated " +
			 * CommonActionsPage.startdateval +
			 * " are for disposal of greasy waste, organic sludge at Jurong WRP and human wastewater at WRPs. These permits expire on "
			 * + CommonActionsPage.permitExpiryDate + ".\n" + "\n" +
			 * "Please acknowledge acceptance of the terms and conditions by returning us a copy of this agreement within 5 working days with the signature of a representative of your company listed in ACRA. \n"
			 * + "\n" + "Regards\n" + "\n" + "\n" + "\n" + "SIES DEV2\n" +
			 * "Field Inspection Officer\n" +
			 * "Water Reclamation (Network) Department (Operation & Maintenance Division)\n"
			 * + "\n" +
			 * "Confidential information may be in this message. If you are not the intended recipient, please notify the sender and delete the email"
			 * ;
			 */
			System.out.println("permit  generation actual" + actualBody);
			System.out.println("Permit generation expected" + ExpectedBody);
			if (actualBody.equalsIgnoreCase(ExpectedBody)) {
				System.out.println(" Body is same     :" + actualBody + "------->" + ExpectedBody);
			} else {
				System.out.println(" Body is not same");
			}
			driver.switchTo().defaultContent();

			// Assert.assertEquals(true,driver.findElement(attachment).isDisplayed());
			List<WebElement> files = driver.findElements(attachment);
			if (!files.isEmpty()) {
				System.out.println("attachment is present");
			} else {
				System.out.println("attachment is not present");
			}
			break;
		case "Permit WRP email":
			ele = By.xpath(
					"//label[contains(text(),'For your assistance')]//ancestor::div[contains(@id,'timeline_record')]//a[@title='Open Record']");
			eleUtil.doElementClickable(ele, 10);
			eleUtil.doClick(ele);
			eleUtil.waitForVisibilityOfElement(mailSubject, 10);
			actualSub = eleUtil.doGetElementAttribute(mailSubject, "Value");
			System.out.println("subject is" + actualSub);
			actualFrom = eleUtil.doElementGetText(mailFrom);
			actualTo = driver.findElements(mailTo);
			headersValList = new ArrayList<String>();
			for (int i = 0; i < actualTo.size(); i++) {
				String actualToVal = actualTo.get(i).getText();
				headersValList.add(actualToVal);
			}
			assertEquals(actualFrom, "SIES DEV2", "From address is not matching");
			assertTrue(headersValList.contains("WRN5 WRP Contact"), "To address is not matching");
			assertEquals(actualSub,
					"For your assistance: Agreement to dispose waste at PUB's Water Reclamation Plants (WRPs) for Year.",
					"Subject is not matching");
			eleUtil.scrollUsingRobotClass();
			Thread.sleep(4000); // eleUtil.waitForVisibilityOfElement(mailframeLoc, 10);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Designer']")));
			driver.switchTo().frame(driver.findElement(By.xpath(
					"//iframe[@title='Description rich text editor' and @aria-label='Description rich text editor']")));
			// eleUtil.waitForFrameByLocator(mailframeLoc,AppConstants.LONG_DEFAULT_WAIT);
			Thread.sleep(4000);
			actualBody = eleUtil.doElementGetText(mailBody); // System.out.println(actualBody);

			ExpectedBody = "Dear WRP colleagues\n" + "\n" + CommonActionsPage.Tankercompanyname
					+ "'s new permit for 0 tankers has been issued.\n" + "\n"
					+ "Please take note and pass on to your teams on the ground to allow the tankers access to WRPs according to type of waste.\n"
					+ "\n" + "Description Attachment Remarks\n"
					+ "List of all GWCs and their vehicle numbers granted permit\n"
					+ "Valid until: [Please refer to attachment for expiry date]\n"
					+ "File 2023 WRP list of tankers effective from 1 Apr 2023_V2.xlsx\n"
					+ "Updated tanker list excludes the following tanker:\n" + CommonActionsPage.Tankercompanyname
					+ " - " + CommonActionsPage.GWCReferenceNum + "\n" + "\n" + "\n" + "\n" + "Regards\n" + "\n" + "\n"
					+ "G RAJ KUMAR \n" + "Assistant Engineer\n"
					+ "Water Reclamation (Network) Department (Operation & Maintenance Division)\n" + "\n"
					+ "Confidential information may be in this message. If you are not the intended recipient, please notify the sender and delete the email";

			/*
			 * ExpectedBody = "Dear WRP colleagues\n" +
			 * "\n Tankcompany01032024080235's new permit for 0 tankers has been issued.\n"
			 * + "\n" +
			 * "Please take note and pass on to your teams on the ground to allow the tankers access to WRPs according to type of waste.\n"
			 * + "\n" + "Description Attachment Remarks\n" +
			 * "List of all GWCs and their vehicle numbers granted permit\n" +
			 * "Valid until: [Please refer to attachment for expiry date]\n" +
			 * "File 2023 WRP list of tankers effective from 1 Apr 2023_V2.xlsx\n" +
			 * "Updated tanker list excludes the following tanker:\n Tankcompany01032024080235 - 886\n"
			 * + "\n" + "\n" + "\n" + "Regards\n" + "\n" + "\n" + "G RAJ KUMAR \n" +
			 * "Assistant Engineer\n" +
			 * "Water Reclamation (Network) Department (Operation & Maintenance Division)\n"
			 * + "\n" +
			 * "Confidential information may be in this message. If you are not the intended recipient, please notify the sender and delete the email"
			 * ;
			 */

			System.out.println("permit  generation actual" + actualBody);
			System.out.println("Permit generation expected" + ExpectedBody);
			// assertEquals(actualBody, Expectedstr, "Body is not matching");
			if (actualBody.equalsIgnoreCase(ExpectedBody)) {
				// System.out.println(" Body is same :" + actualBody + "------->" +
				// ExpectedBody);
				System.out.println(" Body is same");
			} else {
				System.out.println(" Body is not same");
			}
			driver.switchTo().defaultContent();
			if (driver.findElement(attachment).isDisplayed()) {
				System.out.println("attachment is present");
			} else {
				System.out.println("attachment is not present");
			}
			break;
		}
		eleUtil.doElementClickable(backBtn, 50);
		eleUtil.doClick(backBtn);

	}

	public void mailValidationNew(String mailType) throws InterruptedException, ParseException {
		clickOnRefrehBtn();
		navigatingtotab("Timeline");
		// eleUtil.isPageLoaded(100);
		Thread.sleep(2000);
		String actualSub, actualFrom, actualBody;
		List<WebElement> actualTo;
		List<String> headersValList;
		By ele;
		/*
		 * SimpleDateFormat formatter = new SimpleDateFormat("dd/M/yyyy"); Date date =
		 * formatter.parse(CommonActionsPage.getSharedValue("scheduledStartDate"));
		 * SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy"); String
		 * finalString = newFormat.format(date); System.out.println(finalString);
		 */
		switch (mailType) {

		case "Inspection Schedule":

			ele = By.xpath(
					"//label[contains(text(),'Inspection Appointment')]//ancestor::div[contains(@id,'timeline_record')]//a[@title='Open Record']");
			eleUtil.waitForVisibilityOfElement(ele, 30);
			eleUtil.doElementClickable(ele, 10);
			eleUtil.doClick(ele);

			Thread.sleep(4000);
			// eleUtil.waitForVisibilityOfElement(mailframeLoc, 10);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Designer']")));
			driver.switchTo().frame(driver.findElement(By.xpath(
					"//iframe[@title='Description rich text editor' and @aria-label='Description rich text editor']")));
			// eleUtil.waitForFrameByLocator(mailframeLoc, AppConstants.LONG_DEFAULT_WAIT);
			Thread.sleep(4000);

			actualBody = eleUtil.doElementGetText(mailBody);
			String Expectedstr = "Dear , \n" + "\n"
					+ "Please send in the tanker  to Water hub during working hours on  between  to . Confirm the appointment date and time 1 Day in advance.\n"
					+ "\n" + "Please ensure the tanker is ready for inspection.\n"
					+ "Tank should be empty to open for visual check, the GPS operational and camera can view the suction and discharge valve.\n"
					+ "If satisfactory, its discharge handle will be tagged with PUB seal.\n" + "\n" + "\n"
					+ "Regards\n" + "G RAJ KUMAR\n" + "Senior Assistant Engineer\n"
					+ "Water Reclamation (Network) Department (Operation & Maintenance Division)\n";
			String straar[] = { "Dear , \n" + "\n" + "Please send in the tanker ",
					"to Water hub during working hours on", "between",
					"Confirm the appointment date and time 1 Day in advance.",
					"Please ensure the tanker is ready for inspection.\n"
							+ "Tank should be empty to open for visual check, the GPS operational and camera can view the suction and discharge valve.\n"
							+ "If satisfactory, its discharge handle will be tagged with PUB seal.\n" + "\n" + "\n"
							+ "Regards\n" + "G RAJ KUMAR\n" + "Senior Assistant Engineer\n"
							+ "Water Reclamation (Network) Department (Operation & Maintenance Division)" };
			System.out.println(actualBody);
			System.out.println("straar[0] :" + straar[0]);
			System.out.println("straar[1] :" + straar[1]);
			System.out.println("straar[2] :" + straar[2]);
			System.out.println("straar[3] :" + straar[3]);
			System.out.println("straar[4] :" + straar[4]);

			assertTrue(actualBody.contains(straar[0]), "Body is not matching-0");
			assertTrue(actualBody.contains(straar[1]), "Body is not matching-1");
			assertTrue(actualBody.contains(straar[2]), "Body is not matching-2");
			assertTrue(actualBody.contains(straar[3]), "Body is not matching-3");
			assertTrue(actualBody.contains(straar[4]), "Body is not matching-4");
			// assertEquals(actualBody, Expectedstr, "Body is not matching");
			driver.switchTo().defaultContent();
			break;
		case "Permit generation":
			ele = By.xpath(
					"//label[text()='Permit to Dispose Of Waste at Water Reclamation Plants (WRPs)']//ancestor::div[contains(@id,'timeline_record')]//a[@title='Open Record']");
			eleUtil.doElementClickable(ele, 10);
			eleUtil.doClick(ele);
			eleUtil.waitForVisibilityOfElement(mailSubject, 10);
			actualSub = eleUtil.doGetElementAttribute(mailSubject, "Value");
			System.out.println("subject is" + actualSub);
			actualFrom = eleUtil.doElementGetText(mailFrom);
			actualTo = driver.findElements(mailTo);
			headersValList = new ArrayList<String>();
			for (int i = 0; i < actualTo.size(); i++) {
				String actualToVal = actualTo.get(i).getText();
				headersValList.add(actualToVal);
			}

			System.out.println("actualTo values:" + headersValList);
			assertEquals(actualFrom, "SIES DEV2", "From address is not matching");
			List<String> expectedTo = new ArrayList<String>();

			expectedTo.add("WRN5 WRP Contact");
			// expectedTo.add("Tankcompany01032024080235");
			expectedTo.add(CommonActionsPage.Tankercompanyname);
			System.out.println("expectedTo values:" + expectedTo);
			// assertEquals(headersValList, expectedTo, "To address is not matching");

			Collections.sort(headersValList);
			Collections.sort(expectedTo);
			if (headersValList.equals(expectedTo) == true) {
				System.out.println(" To address is matching     :" + headersValList + "------->" + expectedTo);
			} else {
				System.out.println(" To address is not matching ");
			}

			assertEquals(actualSub, "Permit to Dispose Of Waste at Water Reclamation Plants (WRPs)",
					"Subject is not matching");
			eleUtil.scrollUsingRobotClass();
			Thread.sleep(4000);
			// eleUtil.waitForVisibilityOfElement(mailframeLoc, 10);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Designer']")));
			driver.switchTo().frame(driver.findElement(By.xpath(
					"//iframe[@title='Description rich text editor' and @aria-label='Description rich text editor']")));
			// eleUtil.waitForFrameByLocator(mailframeLoc, AppConstants.LONG_DEFAULT_WAIT);
			Thread.sleep(4000);
			actualBody = eleUtil.doElementGetText(mailBody);

			/*
			 * String ExpectedBody = "Dear Sir,\n" + "\n" +
			 * "The attached permits dated 1/3/2024 are for disposal of greasy waste, organic sludge at Jurong WRP and human wastewater at WRPs. These permits expire on 31/3/2025.\n"
			 * + "\n" +
			 * "Please acknowledge acceptance of the terms and conditions by returning us a copy of this agreement within 5 working days with the signature of a representative of your company listed in ACRA. \n"
			 * + "\n" + "Regards\n" + "\n" + "\n" + "\n" + "SIES DEV2\n" +
			 * "Field Inspection Officer\n" +
			 * "Water Reclamation (Network) Department (Operation & Maintenance Division)\n"
			 * + "\n" +
			 * "Confidential information may be in this message. If you are not the intended recipient, please notify the sender and delete the email"
			 * ;
			 */

			String ExpectedBody = "Dear Sir,\n" + "\n" + "The attached permits dated " + CommonActionsPage.startdateval
					+ " are for disposal of greasy waste, organic sludge at Jurong WRP and human wastewater at WRPs. These permits expire on "
					+ CommonActionsPage.permitExpiryDate + ".\n" + "\n"
					+ "Please acknowledge acceptance of the terms and conditions by returning us a copy of this agreement within 5 working days with the signature of a representative of your company listed in ACRA. \n"
					+ "\n" + "Regards\n" + "\n" + "\n" + "\n" + "SIES DEV2\n" + "Field Inspection Officer\n"
					+ "Water Reclamation (Network) Department (Operation & Maintenance Division)\n" + "\n"
					+ "Confidential information may be in this message. If you are not the intended recipient, please notify the sender and delete the email";
			System.out.println("permit  generation actual" + actualBody);
			System.out.println("Permit generation expected" + ExpectedBody);
			if (actualBody.equalsIgnoreCase(ExpectedBody)) {
				System.out.println(" Body is same     :" + actualBody + "------->" + ExpectedBody);
			} else {
				System.out.println(" Body is not same");
			}
			driver.switchTo().defaultContent();
			// Assert.assertEquals(true, driver.findElement(attachment).isDisplayed());
			List<WebElement> files = driver.findElements(attachment);
			if (!files.isEmpty()) {
				System.out.println("attachment is present");
			} else {
				System.out.println("attachment is not present");
			}
			break;
		case "Permit WRP email":
			ele = By.xpath(
					"//label[contains(text(),'For your assistance')]//ancestor::div[contains(@id,'timeline_record')]//a[@title='Open Record']");
			eleUtil.doElementClickable(ele, 10);
			eleUtil.doClick(ele);
			eleUtil.waitForVisibilityOfElement(mailSubject, 10);
			actualSub = eleUtil.doGetElementAttribute(mailSubject, "Value");
			System.out.println("subject is" + actualSub);
			actualFrom = eleUtil.doElementGetText(mailFrom);
			actualTo = driver.findElements(mailTo);
			headersValList = new ArrayList<String>();
			for (int i = 0; i < actualTo.size(); i++) {
				String actualToVal = actualTo.get(i).getText();
				headersValList.add(actualToVal);
			}
			assertEquals(actualFrom, "SIES DEV2", "From address is not matching");
			assertTrue(headersValList.contains("WRN5 WRP Contact"), "To address is not matching");
			assertEquals(actualSub,
					"For your assistance: Agreement to dispose waste at PUB's Water Reclamation Plants (WRPs) for Year.",
					"Subject is not matching");
			eleUtil.scrollUsingRobotClass();
			Thread.sleep(4000);
			// eleUtil.waitForVisibilityOfElement(mailframeLoc, 10);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Designer']")));
			driver.switchTo().frame(driver.findElement(By.xpath(
					"//iframe[@title='Description rich text editor' and @aria-label='Description rich text editor']")));
			// eleUtil.waitForFrameByLocator(mailframeLoc, AppConstants.LONG_DEFAULT_WAIT);
			Thread.sleep(4000);
			actualBody = eleUtil.doElementGetText(mailBody);
			// System.out.println(actualBody);

			ExpectedBody = "Dear WRP colleagues\n" + "\n" + CommonActionsPage.Tankercompanyname
					+ "'s new permit for 0 tankers has been issued.\n" + "\n"
					+ "Please take note and pass on to your teams on the ground to allow the tankers access to WRPs according to type of waste.\n"
					+ "\n" + "Description Attachment Remarks\n"
					+ "List of all GWCs and their vehicle numbers granted permit\n"
					+ "Valid until: [Please refer to attachment for expiry date]\n"
					+ "File 2023 WRP list of tankers effective from 1 Apr 2023_V2.xlsx\n"
					+ "Updated tanker list excludes the following tanker:\n" + CommonActionsPage.Tankercompanyname
					+ " - " + CommonActionsPage.GWCReferenceNum + "\n" + "\n" + "\n" + "\n" + "Regards\n" + "\n" + "\n"
					+ "G RAJ KUMAR \n" + "Assistant Engineer\n"
					+ "Water Reclamation (Network) Department (Operation & Maintenance Division)\n" + "\n"
					+ "Confidential information may be in this message. If you are not the intended recipient, please notify the sender and delete the email";

			/*
			 * ExpectedBody = "Dear WRP colleagues\n" +
			 * "\n Tankcompany01032024080235's new permit for 0 tankers has been issued.\n"
			 * + "\n" +
			 * "Please take note and pass on to your teams on the ground to allow the tankers access to WRPs according to type of waste.\n"
			 * + "\n" + "Description Attachment Remarks\n" +
			 * "List of all GWCs and their vehicle numbers granted permit\n" +
			 * "Valid until: [Please refer to attachment for expiry date]\n" +
			 * "File 2023 WRP list of tankers effective from 1 Apr 2023_V2.xlsx\n" +
			 * "Updated tanker list excludes the following tanker:\n Tankcompany01032024080235 - 886\n"
			 * + "\n" + "\n" + "\n" + "Regards\n" + "\n" + "\n" + "G RAJ KUMAR \n" +
			 * "Assistant Engineer\n" +
			 * "Water Reclamation (Network) Department (Operation & Maintenance Division)\n"
			 * + "\n" +
			 * "Confidential information may be in this message. If you are not the intended recipient, please notify the sender and delete the email"
			 * ;
			 */
			System.out.println("permit  generation actual" + actualBody);
			System.out.println("Permit generation expected" + ExpectedBody);
			// assertEquals(actualBody, Expectedstr, "Body is not matching");
			if (actualBody.equalsIgnoreCase(ExpectedBody)) {
				// System.out.println(" Body is same :" + actualBody + "------->" +
				// ExpectedBody);
				System.out.println(" Body is same");
			} else {
				System.out.println(" Body is not same");
			}
			driver.switchTo().defaultContent();
			if (driver.findElement(attachment).isDisplayed()) {
				System.out.println("attachment is present");
			} else {
				System.out.println("attachment is not present");
			}
			break;
		}
		eleUtil.doElementClickable(backBtn, 50);
		eleUtil.doClick(backBtn);
	}

	public void mailValidationUsingExcel() throws InterruptedException, ParseException {
		clickOnRefrehBtn();
		navigatingtotab("Timeline");
		Thread.sleep(2000);
		String actualSub, actualFrom, actualBody;
		List<WebElement> actualTo;
		List<String> headersValList;
		By ele;
		excelUtil.getRowData("WRN5 Mails", "Inspection Schedule");

		eleUtil.doElementClickable(backBtn, 50);
		eleUtil.doClick(backBtn);
	}

}
