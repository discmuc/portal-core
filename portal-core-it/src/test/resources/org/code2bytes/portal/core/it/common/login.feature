Feature: Portal Login

    As a user
    I want to enter login credentials
    so that I can enter the application

    Scenario: Successful login as administrator
        Given I browse to URL of the portal application
        And I will be redirected to the login screen
        When I enter the credentials of the administrator
        Then I should see the start page

    Scenario: Successful login as user
        Given I browse to URL of the portal application
        And I will be redirected to the login screen
        When I enter the credentials of a user
        Then I should see the start page

 