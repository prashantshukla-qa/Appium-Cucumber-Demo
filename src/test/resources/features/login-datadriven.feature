Feature: User Authentication

  As a user
  I want to be able to sign in
  So that I can access my account


  Scenario: Facebook Throws error on using incorrect login
    Given I have launched the facebook app
    When I try to login using "test.qualitest.demo@gmail.com" and "Qait@123"
    Then I should see the error "Invalid username or password"

  Scenario: Test login feature correct login
    Given I have launched the facebook app
    When I try to login using "test.qualitest.demo@gmail.com" and "Qait@123"
    Then I should see Profile Icon

