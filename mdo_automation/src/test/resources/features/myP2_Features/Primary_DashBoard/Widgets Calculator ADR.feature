#Author: pasindu@mydigitaloffice.ca
@myP2_Regression @PrimaryDashBoard

Feature: Primary DashBoard - widgets calculation (ADR)

Background: Login to MYP2 application
  Given I am login to the myp2 site
  And System navigate to the home page
  And Select the organization as "Insignia Hospitality Group"
  When I Am navigate to toggle widget page by clicking ToggleWidget Icon
  Then I turn on all the widgets
  And Check and Verify the widgets order
  
  Scenario: The user add ADR column and compares the recorded graph value array with the recorded portfolio total value array to see if they are equivalent.
  When User select Insignia Hospitality Group from the group dropdown
  Then User select All properties in property dropdown section
  And User setup a specific date ADR
  And User set up By Property Period dropdown value
  And User add a new ADR column 
  And User change the Amount type in ADR editing column and get the Portfolio Total values and store in to an array
  And User change date to the last year ADR
  And User capture the ADR Records By the Year
  And User change date to the spcific past year
  And User capture the ADR Records By the Year
  And User setup the first specific date ADR
  And User select MTD value from the ADR widget period dropdown
  And User capture the ADR Records from graph and save it in an array
  And User comparing the two arrays ADR
  And User delete the ADR column