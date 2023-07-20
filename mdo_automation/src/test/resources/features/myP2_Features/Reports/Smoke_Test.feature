#Author: udarsha@mydigitaloffice.ca
@smoke_myp2

	Feature: Smoke Test validation for myP2

    Background: Comment smoke test by login into the application
       Given I am login to the myp2 site
       And System navigate to the home page
       And Select the organization as "HighGate Hotels"
    
  	Scenario: Smoke test for AR Dashboard
  	   And I am expand the Account Recievable option under Reports section in Side Menu
  	   Then I am navigate to AR Dashboard page
 		   And select Group and date from the relevant dropdowns
       And click the GO button
   	   Then report should be generated without errors
   
   Scenario: Smoke test for AR Report
       And I am expand the Account Recievable option under Reports section in Side Menu
       Then I am navigate to AR Property page
       When I select the property and Date
       And I select the date from picker
       Then I am loading ar property report with Go button
       Then AR report should be generated without errors
   
   Scenario: Smoke test for STR Report
        And 	click on the sidebar menu and expand Report and afterwards expand Revenue and STR
        Then click on STR Report
        And 	select Report and date from the relevant dropdown
         And click the GO button
        Then STR report should be generated without errors
   
   Scenario: Smoke test for Rolling Month Report
         And Expand the Rolling Month Report option under Reports section in Side Menu
        And Navigate to Rolling Month Report page
        When User selects the Group and date
        Then Default Rolling Month Headers should be loaded on the page.
   
   Scenario: Smoke test for Calendar Month Report calendar
         And Expand the Calendar Month Report option under Reports section in Side Menu
         And Navigate to Calendar Month Report page
         When User selects the Group and date
         Then Calendar Month Headers should be loaded on the page.
   
   Scenario: Smoke test for Revenue Breakdown report
           And I am expand the Revenue Breakdwon option under Reports section in Side Menu
           Then I am navigate to Revenue Breakdown page
           And 	select Report and date from the relevant dropdown
           And click the GO button
          Then Revenue Breakdown report should be generated without errors
    
     Scenario: Smoke test for AR mapping report
          Then I am expand the Accounts Mapping option under Configuration section in Side Menu
          And I am navigate to AR Mapping page
          When I select the Group and Property then loading AR Mapping report with Go button
         Then AR mapping report should be generated without errors
  
   Scenario: Smoke test for Sales Mapping report
          Then I am expand the Accounts Mapping option under Configuration section in Side Menu
          And I am navigate to Sales Mapping page through the AR Mapping page
          When I select the Group and Property then loading Sales Mapping report with Go button
         Then Sales mapping report should be generated without errors
      
      Scenario: Smoke test for GL  Mapping report
         Then I am expand the configuration options in Side Menu
         Then I am navigate to GL Mapping page
         Then GL mapping report should be generated without errors
         And navigate to Add GL Code page
         Then GL code page should be generated without errors
         And click Cancel button
         Then GL mapping report should be generated without errors
         And navigate to Copy page
         Then Copy page should be generated without errors
         And click Cancel button
         Then GL mapping report should be generated without errors
         And navigate to Import page
         Then Import page should be generated without errors
         
      Scenario: Smoke test for GL  Hierarchy report
         And I am expand the configuration options in Side Menu
         And I am navigate to GL Hierarchy page
         Then GL Hierarchy report should be generated without errors
      
       Scenario: Smoke test for IJ report
         And In the Side Menu, expand the IJ section.
         And Navigate to the Income Journal Summary
         And 	select Report and date from the relevant dropdown
         And click the GO button
         Then IJ report should be generated without errors
         And Navigate to the Income Journal Mapping page
         And select Report and date from the relevant dropdown
         And click the GO button
         Then IJ mapping report should be generated without errors
         
       Scenario: Smoke test for Account Management report
         Then I am expand the Accounts Mapping option under Configuration section in Side Menu
         And I navigate to Account Management page
         Then Account Management report should be generated without errors
         
       Scenario: Smoke test for Account Sales Managers report
				 And I am expand the configuration option
    		 Then I am navigate to Sales Managers page
         Then Account Sales Managers should be generated without errors
         
       Scenario: Smoke test for all P&L report pages
				 And I am expand the P&L Statement option under Reports section in Side Menu
    		 And go to the P&L Monthly page 
    		 And select a Group and a date from the relevant dropdown fields
    		 And click the GO button
    		 Then PnL pages should be generated without errors
    		 And I am expand the P&L Statement option under Reports section in Side Menu
    		 Then I am navigate to P&L Yearly page
    		 And click the GO button
    		 Then PnL pages should be generated without errors
    		 And I am expand the P&L Statement option under Reports section in Side Menu
    		 And go to the P&L Property Comparison
    		 And click the GO button
    		 Then PnL comp should be generated without errors
    And Select the organization as "Insignia Hospitality Group"
    		 When User clicks on Profit & Loss Unmapped option button
    		 And User navigates to Profit & Loss Unmapped page
    		 And click the GO button
				 And confirm if data is generated for the selected parameters without any errors being prompted

			Scenario: Smoke test for Pickup report
          Then I am expand the pickUp report option under Reports section in Side Menu
    			And I am navigate to pickUp report page
    			And click the GO button
    			Then pickup report should be generated without errors
    			
    	Scenario: Smoke test for Guest Ledger report
          And go to the Guest Ledger
    			And Select the organization as "Marriott"
    			And Select the Group
    			Then Guest Ledger should be generated without errors