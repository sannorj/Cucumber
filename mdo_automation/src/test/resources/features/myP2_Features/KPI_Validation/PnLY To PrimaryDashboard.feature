#Author: madushika@mydigitaloffice.ca
@myP2_Regression @myP2_Smoke

Feature: Compare KPI values between Primary Dashboard and PnL Yearly Report according to selected property 

   Scenario Outline: Compare KIP Values of Primary Dashboard and PnL Yearly Report
    Given I am login to the myp2 site
    And System navigate to the home page
    And Select the organization as "HighGate Hotels" 
	  Given Selects filters as '<nullVal>' and '<Property>' in the landing page
  	And Select date as '<Date>'
  	When Verify KPI list available in Primary Dashboard page
    Then Store all the KPI values of months for '<Property>' property in '<Date>'
    
	  And Click on the Menu bar
	  When Expand the '<Main_menu>' menu
	  Then Expand the '<sub_menu>' menu option
	  And Select the '<target_Page>' option
	  Given Check the header of the navigated page '<target_Page_header>'
	  Given Selects filters as '<nullVal>' and '<Property>' in the landing page
	  And Select Year as '<Year>'
  	When Click on the Go button
  	And Verify all KPIs available in PnLY report
  	Then Compare dashboard KPI with PnL KPI and return the result of each month
  
    Examples: 
    	|    Date    | Year |    Group   |             Property           | Main_menu |   sub_menu   |       target_Page       |     target_Page_header      | nullVal|
    	| 01/31/2022 | 2022 | All groups | Alohilani Resort Waikiki Beach |  Reports  |  P&L Reports | P&L Yearly Report (New) | Profit & Loss Yearly Report |  null  |
      