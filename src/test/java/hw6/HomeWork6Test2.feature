Feature: User Table Page test on Cucumber

  Scenario: User Table Page test

    Given I'm on Home Page
    And I login as user PITER_CHAILOVSKII
    And I open User Table Page through header menu Service -> User Table
    And I am on Users Table Page
    And User Table Page's interface contains correct elements
    When I check Number and User columns of Users table
    Then User table contain correct values for numbers and users
      | Number | User             |
      | 1      | Roman            |
      | 2      | SergeyIvan       |
      | 3      | Vladzimir        |
      | 4      | Helen Benett     |
      | 5      | Yoshi Tannamuri  |
      | 6      | Giovanni Rovelli |
    When I check Description column of Users table
    Then All cells of 'Description' column contains text
      | Number | Description                  |
      | 1      | Lorem ipsum                  |
      | 2      | Lorem ipsum                  |
      | 3      | Lorem ipsum                  |
      | 4      | Lorem ipsum some description |
      | 5      | Lorem ipsum some description |
      | 6      | Lorem ipsum some description |
    When I set 'vip' status to Sergey Ivan
    Then 'Log' section shows a log row in format: Vip: condition changed to true
    When I click on dropdown in column Type for user Roman
    Then Droplist contains values
      | Dropdown Values |
      | Admin           |
      | User            |
      | Manager         |
