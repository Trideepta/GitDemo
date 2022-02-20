#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login into Application

  @tag1
  Scenario Outline: Positive test validation
    Given Initialize the browser with chrome
    And Navigate to "http://www.qaclickacademy.com/" Site
    And Click on Login link in home page to land on secure sign in page
    When User enters <username> and <password> and clicks on login button
    Then Verify the user is successfully logged in
    
    Examples:
    |username	|password	|
    |test99@gmail.com	|123456	|
    |test90@gmail.com	|89076	|  
    