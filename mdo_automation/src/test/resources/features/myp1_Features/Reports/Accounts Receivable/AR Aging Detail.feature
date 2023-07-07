#Author: madushika@mydigitaloffice.ca
@myP1_Regression @ARAgingDetailPg
Feature: AR Aging Detail Page functionality

 		Background: Verify AR Aging Detail Page Navigation main Functionality
 		Given I am login to the myp1 site
    And System navigate to the dashboard
    Then Click on Link Reports "Reports" navigation Link
    Given Click on Link Accounts Receivable "Accounts Receivable" navigation Link
    When Click on Link AR Aging Summary "AR Aging Summary (Classic)" navigation Link
    And I navigate to AR Aging Detail page
    
  	Scenario: Verify calculated total of all raws Functionality
    Then Select Hotel filter option
    Given Select SelectBy filter option
    And Select Current Date option
    When Click on Update button 
    Then Calculate each column total and verify each total values
    #And Calculate each raw total and verify each total values
    #
    #Scenario: Verify Add Comment Functionality
    #Then Select Hotel filter option
    #Given Select SelectBy filter option
    #And Select Current Date option
    #When Click on Update button 
    #Then Verify Add Comment button and select option
    #And Verify Close button
    #When Verify View Past comments link and navigate to page
    
    #Scenario: Verify Search Functionality