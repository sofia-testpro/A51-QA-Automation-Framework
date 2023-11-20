Feature: Login feature

  Scenario: Login Success
    //Given I open browser
    Given I open login page
    When I enter email "demo@class.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I should get logged in

    Scenario Outline: Login incorrect password
      Given I open login page
      When I enter email "<email>
      And I enter password "<password>"
      And I submit
      Then I should not get logged in
      Examples:
        | email              |  password
        | demo@class.com     |  te$t$tudent
        | demo@classs.com    |  te$t$tudent
        | demoo@class.com    |  te$t$tudent

