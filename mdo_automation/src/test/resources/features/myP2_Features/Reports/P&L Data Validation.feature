#Author: sannorj@mydigitaloffice.ca
@myP2_Regression @myP2Sanity @new2
 
Feature:  P&L Reports - Data validation across the P&L pages

	Background: Navigate to P&L Monthly report
    Given I am login to the myp2 site
    And System navigate to the home page
   
  Scenario: Verify whether the P&L monthly values for all properties and all groups line up with other P&L reports
     And Select the organization as "Insignia Hospitality Group" 
     When I am expand the P&L Statement option under Reports section in Side Menu
     And go to the P&L Monthly page   
     And select the group "All groups" , property "All properties", specific date, View and Click on GO button
     And Store the first column values
    
     And I am expand the P&L Statement option under Reports section in Side Menu
     And go to the P&L Property Comparison
     And Store the Total column values
     Then Compare the P&L monthly and P&L Comparison Report figures
    
     And I am expand the P&L Statement option under Reports section in Side Menu
     Then I am navigate to P&L Yearly page
     And I select the group "All groups" , property "All properties" , year "2022" , view "Owner's View"
     And I am Loading the PnLYearly Report with GO button
     And Store the february column values
     Then Compare the P&L monthly and P&L Yearly Report figures
     
     
  Scenario: Verify whether the P&L monthly values for Single properties and Single groups line up with other P&L reports
     And Select the organization as "Insignia Hospitality Group" 
     When I am expand the P&L Statement option under Reports section in Side Menu
     And go to the P&L Monthly page   
     And select the group "1Insignia Hospitality Group" , property "CNMTS", specific date, View and Click on GO button
     And Store the first column values
    
     And I am expand the P&L Statement option under Reports section in Side Menu
     And go to the P&L Property Comparison
     And select the group "1Insignia Hospitality Group" , property "CNMTS", specific date, View and Click on GO button 
     And Store the Total column values
     Then Compare the P&L monthly and P&L Comparison Report figures
    
     And I am expand the P&L Statement option under Reports section in Side Menu
     Then I am navigate to P&L Yearly page
     And I select the group "1Insignia Hospitality Group" , property "CNMTS" , year "2022" , view "Owner's View"
     And I am Loading the PnLYearly Report with GO button
     And Store the february column values
     Then Compare the P&L monthly and P&L Yearly Report figures
     
  @myP2_Smoke
  Scenario Outline: Verify P&L Monthly report page Element visibility and filter functionality
    And Select the organization as "Beck Legacy Group" 
	  Given Selects filters as '<filter1>' and '<filter2>' in the initial page
	  And Click on the Menu bar
	  When Expand the '<Main_menu>' menu 
	  Then Expand the '<sub_menu>' menu option
	  And Select the '<target_Page>' option
	  Given Check the header of the navigated page '<target_Page_header>'
	  And Verify Group was selected as '<filter1>' and Property was selected as '<nullVal>'
	  When Click on the Go button
	  Then Verify name raws
  
   Examples: 
       |    filter1         |            filter2 								| Main_menu |  sub_menu |      target_Page 			  |		  target_Page_header			 |  nullVal | 
       |  Beck Legacy Group | Days Inn & Suites Page Lake Powell|  Reports	|P&L Reports| P&L Monthly Report (New)| Profit & Loss Monthly Report |   null 	|
       
       