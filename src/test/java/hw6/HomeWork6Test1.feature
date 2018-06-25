Feature: Different Element Page test on Cucumber

  Scenario: Different Element Page Interface test
    Given I'm on Home Page
    Then Page title is Home Page
    When I login as user PITER_CHAILOVSKII
    Then User icon is displayed on header
    And Number of images on Home Page equals 4 and they are displayed
    And Number of texts under images on Home Page equals 4 and they are displayed
    And Texts on Header of Home Page are displayed
    When I click button "Service" on Home Page to open Service dropdown
    Then Number of Service dropdown buttons equals 8 and they are displayed
    And Number of Service elements on left Section of Home Page equals 8 and they are displayed
    When I click button "Different Elements" on Service dropdown on Home Page to open DifferentElements Page
    Then I'm on Different Elements Page
    And Number of checkboxes equals 4 and they are displayed
    And Number of radio buttons on Different elements Page equals 4 and they are displayed
    And Dropdown with colors is displayed
    And Two buttons on Different elements Page are displayed
    And Right section on Different elements Page is displayed
    And Left section on Different elements Page is displayed
    When I click on WATER checkbox on Different elements Page
    And I click on WIND checkbox on Different elements Page
    Then 1 log row on right panel of Different elements Page have text: "WIND: condition changed to true"
    And 2 log row on right panel of Different elements Page have text: "WATER: condition changed to true"
    When I click on SELEN radio button on Different elements Page
    Then 1 log row on right panel of Different elements Page have text: "metal: value changed to SELEN"
    When I click on colors dropdown with colors on Different elements page
    Then I Choose YELLOW color on colors dropdown
    And 1 log row on right panel of Different elements Page have text: "Colors: value changed to YELLOW"
    When I click on WATER checkbox on Different elements Page
    And I click on WIND checkbox on Different elements Page
    Then 1 log row on right panel of Different elements Page have text: "WIND: condition changed to false"
    And 2 log row on right panel of Different elements Page have text: "WATER: condition changed to false"