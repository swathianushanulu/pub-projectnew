@HWComplaint
Feature: Testing Login Functionality

Background: Test CRM Login with valid credentials
 		Given User navigates to CRM login page
    When Login to app with "FIO_userid" and "FIO_pwd"
    And user selects App "DQB Case Management" 

 Scenario Outline: Test to create NEA list record
  When user change the changearea to "GWC Tanker"
  And user selects entity as "NEA List"
  And fill the details "Company_name","Vehicle_Number","<Vehicle_Type>","<Tankers_Capacity>","<Registration_Deregistration>" in the NEA list record form
 	And user selects entity as "Applications"
	And fill the details in application form for General details "<AddrOfTanker>","<PhoneNum>","<Email>"
  And fill the details in application form for Human waste type details "<HW>","<HWType>","<HWPerMonth>"
  And create a tanker by filling the details
    |CapacityOfTanker|WasteType|
    |1000|Human Wastewater|
  And approve the application
	Then verify whether case is created
  When Case is opened verify the fields
  And go to "Work Orders" tab
  And validate the schedule workorder notification
 	And fill the details in Bookings section
 	And navigate to Assignment stage and confirm the inspection schedule
 	And Validate "Inspection Schedule" mail with subject 
 	And go to "Work Orders" tab
 	And go to Service tasks tab and fill and complete the checklist as "Complaince"
#And verify the WO status field is "Completed" and verify tanker Iscomplaince? field value as "Yes"
	And navigate to Assignment stage and fill the respective details and navigate to next stage
	And navigate to Inspection stage and select the Inspection completed value as yes
#And verify "Agreement" letter is generated
#And verify "Permit" letter is generated
	And navigate to Inspection stage and fill the respective details and navigate to next stage
  When Login to app with "SO_userid" and "SO_pwd"
  And user selects App "DQB - Case Management" 
  And search for the case to open it
	And navigate to SO Review stage and fill the respective details and navigate to next stage
	When Login to app with "AO_userid" and "AO_pwd"
  And user selects App "DQB - Case Management" 
  And search for the case to open it
  And navigate to AO Review stage and fill the respective details and navigate to next stage
	When Login to app with "FIO_userid" and "FIO_pwd"
  And user selects App "DQB - Case Management"  
  And search for the case to open it
  And navigate to GenerateEmail stage and fill the respective details and navigate to next stage 
  And validate the system triggered email "Permit generation" to tankercompany once tanker is approved for disposing waste
  And validate the system triggered email "Permit WRP email" to WRP FD to update the status of Tankers
  And navigate to Close stage and fill the respective details and navigate to next stage 
    Examples:
   |Vehicle_Type|Tankers_Capacity|Registration_Deregistration|AddrOfTanker|PhoneNum|Email|HW|HWType|HWPerMonth|
  	|Tanker|1000|Registration|addr1|+6512345678|test@gmail.com|Yes|Domestic STPs|100|