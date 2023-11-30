Feature: Login feature
  Scenario: Login Success
    Given  User opens Login Page
    When User enters email "lolitamantsiuk@gmail.com"
    And User enters password "te$t$tudent"
    And User submits
    Then User should get logged in

  Scenario: Login Incorrect Password
    Given  User opens Login Page
    When User enters email "lolitamantsiuk@gmail.com"
    And User enters password "teststudent"
    And User submits
    Then User should not get logged in

  Scenario: Login Incorrect Email
    Given  User opens Login Page
    When User enters email "mantsiuk@gmail.com"
    And User enters password "te$t$tudent"
    And User submits
    Then User should not get logged in

  Scenario: Login empty Email
    Given  User opens Login Page
    When User enters email " "
    And User enters password "te$t$tudent"
    And User submits
    Then User should not get logged in

  Scenario: Login empty Password
    Given  User opens Login Page
    When User enters email "lolitamantsiuk@gmail.com"
    And User enters password " "
    And User submits
    Then User should not get logged in








