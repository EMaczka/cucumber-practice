Feature: Ebay Advances Search

  Scenario: Ebay logo on Advanced Search page
    Given I am on Ebay Advanced Search page
    When I click on Ebay logo
    Then I am navigate to homepage

  Scenario: Advanced Search on item
    Given I am on Ebay Advanced Search page
    When I advanced search an item
      | keyword | exclude     | minPrice | maxPrice |
      | iPhone  | refurbished | 300      | 900      |
    Then I validate that the result titles do not contain 'refurbished'
