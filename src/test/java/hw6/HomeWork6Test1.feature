@Run
Feature: Different Element Page test on Cucumber

  Scenario: Different Element Page Interface test
    Given I'm on Home Page
    Then The browser title of page is Home Page
    When I login as user PITER_CHAILOVSKII
    Then The user icon is displayed on the header
    And The number of images on Home Page equals 4 and they are displayed
    And The number of texts under images on the Home Page equals 4 and they are displayed
    And Texts on the Header of Home Page are displayed
    When I click the button "Service" on the Home Page to open the Service dropdown
    Then The number of Service dropdown buttons equals 8 and they are displayed
    And The number of Service elements on the left Section of Home Page equals 8 and they are displayed
    When I click the button "Different Elements" on the Service dropdown on Home Page to open DifferentElements Page
    Then I'm on Different Elements Page
    And The number of checkboxes equals 4 and they are displayed
    And The number of radio buttons on Different elements Page equals 4 and they are displayed
    And The dropdown with colors is displayed
    And Two buttons on the Different elements Page are displayed
    And The Right section on the Different elements Page is displayed
    And The Left section on the Different elements Page is displayed
    When I click on WATER checkbox on Different elements Page
    And I click on WIND checkbox on Different elements Page
    Then The 1 log row on the right panel of Different elements Page have text: "WIND: condition changed to true"
    And The 2 log row on the right panel of Different elements Page have text: "WATER: condition changed to true"
    When I click on SELEN radio button on Different elements Page
    Then The 1 log row on the right panel of Different elements Page have text: "metal: value changed to SELEN"
    When I click on colors dropdown with colors on Different elements page
    Then I Choose the YELLOW color on colors dropdown
    And The 1 log row on the right panel of Different elements Page have text: "Colors: value changed to YELLOW"
    When I click on WATER checkbox on Different elements Page
    And I click on WIND checkbox on Different elements Page
    Then The 1 log row on the right panel of Different elements Page have text: "WIND: condition changed to false"
    And The 2 log row on the right panel of Different elements Page have text: "WATER: condition changed to false"
