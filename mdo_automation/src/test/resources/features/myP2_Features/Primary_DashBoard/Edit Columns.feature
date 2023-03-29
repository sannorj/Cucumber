#Author: sannorj@mydigitaloffice.ca
@myP2_Regression @PrimaryDashBoard
Feature: Primary DashBoard - Edit Columns Feature

Background: Login to myP2 application 
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "Beck Legacy Group" 
  And select the Group ,Property and Date 
  
  Scenario: Verify whether a user is able to edit the column in the By Property table
  When User clicks Edit icon in By Property table
  Then The table goes into the editable mode
  And User click on the edit icon in the particular column
  And User changed the paramerters and clicks save button 
  Then The changes are reflected in the column
  
  Scenario: Verify whether a user is able to edit the column in the By Revenue table
  When User clicks edit icon in By Revenue table
  Then The table goes into the editable mode
  And User click on the edit icon in the particular column
  And User changed the paramerters and clicks save button 
  
  
  