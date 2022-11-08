Feature: Login to Orange HRM

  @ValidCredentials
  Scenario: Login with valid credentials
    Given user is on home page
    When user enter username
    And user enter password
    Then user logged in successfully and redirect to home page

    #---------------------------------------------------------------------------

   #@InvalidCredentials
   #Scenario Outline: Login with invalid credentials
   #  Given user is on home page
   #  When user enter username as '<username>'
   #  And user enter password as '<password>'
   #  Then user prompt with error message '<errorMessage>'
   #  Examples:
   #    | username | password | errorMessage             |  |
   #   | admin | admin    | invalid credentials      |  |
   #   |       | admin123 | username cannot be empty |  |
   #   | Admin |  | password cannot be empty |  |

    #---------------------------------------------------------------------------

    # @ForgotCredentials
    # Scenario: Verify forgot password functionality
    #   Given user is on home page
    #   When user click on forgot password link
    #   Then user see reset password page



