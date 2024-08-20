Feature: Login Functionality

  Scenario Outline: Login with valid and invalid credentials
    Given User is on the login page
    When User enters "<username>" and "<password>"
    And User clicks on login button
    Then User should see "<result>"

    Examples: 
      | username       | password     | result              |
      | Admin          | admin123     | Dashboard           |
      | Administartion | admin123     | Invalid credentials |
      | Admin          | admin2340909 | Invalid credentials |
      |                | admin123     | Required            |
