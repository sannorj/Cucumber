#Author: madushika@mydigitaloffice.ca
@myP1_Regression
Feature: Scorecard Dashboard Edit Functionality

  Background: Verify Scorecard Dashboard Main Functionality
    Given I am login to the myp1 site
    And System navigate to the dashboard
    When Navigate to Scorecard page
    Then Verify Scorecard data loaded
    
    Scenario: Verify card close
    Given Click on edit button
    And Close card
    When Click confirm close button
    Then Verify card closed
    
    Scenario: Verify card close from settings
    Given Click on edit button
    And Disable selected card
    When Verify card disabled
    
    Scenario: Verify card added from settings
    Given Click on edit button
    And Enable closed cards
    When Verify cards available