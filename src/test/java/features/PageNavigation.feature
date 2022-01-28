Feature: Manage pagination for different number of pages and items per page

  Scenario: User knows the number of pages which the set creates
    Given the user wants to know the number of pages which the set creates
    When the user enters the dataset
    And the user provides the items per page
    Then the user gets to know the number of pages which the set creates

  Scenario: User knows the number of items in a given dataset
    Given the user wants to know the number of items in a given dataset
    When the user enters the dataset
    Then the user gets to know the number of items in a given dataset

  Scenario: User knows the number of items in a given page
    Given the user wants to know the number of items in a given page
    When the user enters the page number
    Then the user gets to know the number of items in a given page

  Scenario: User can find the page number of a given item in the dataset
    Given the user wants to find the page number where the item is shown
    When the user enters the item
    Then the user can find the page number where the item is shown

  Scenario Outline: User cannot find a non existing page number: <pageIndex>
    Given the user wants to find a non existing page number
    When the user enters the page number <pageIndex>
    Then the user cannot find the page number <pageIndex>
    Examples:
      | pageIndex |
      |    20     |
      |   -10     |
