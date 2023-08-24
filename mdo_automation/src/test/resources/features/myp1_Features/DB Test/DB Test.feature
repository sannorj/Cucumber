#Author: madushika@mydigitaloffice.ca
@myp1dbTest

Feature: Compare the value between Files and base tables for write it in excel result sheet

   Scenario Outline:: Compare db and csv report values and write it in excel sheet
   	Given I have a databse connection
   #	Given I have a myp1 databse connection
   	When I retrieve the actual data list from the database and csv reports then compare it and add the values to an Excel sheet
   	When I retrieve the actual data list from the database and csv reports then compare it and add the values to an Excel sheet row wise
   	
   Scenario Outline:: Compare db and excel report values and write it in excel sheet
   	Given I have a databse connection
   	When I retrieve the actual data list from the database and excel reports then compare it and add the values to an Excel sheet
   	When I retrieve the actual data list from the database and excel reports then compare it and add the values to an Excel sheet row wise
   	
   Scenario Outline:: Compare db and xml report values and write it in excel sheet
   	Given I have a databse connection
   	When I retrieve the actual data list from the database and xml reports then compare it and add the values to an Excel sheet
   	When I retrieve the actual data list from the database and xml reports then compare it and add the values to an Excel sheet row wise