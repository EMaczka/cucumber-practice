Feature: Ebay Homepage

  Scenario: Advanced search link click
    Given I am on Ebay homepage
    When I click on Advanced link
    Then I navigate to Advanced Search page

  Scenario: Search item count
    Given I am on Ebay homepage
    When I search for 'iPhone 11'
    Then I validate at least 1000 search items present

  Scenario: Search toy car count
    Given I am on Ebay homepage
    When I search for 'Toy car'
    Then I validate at least 5000 search items present

  Scenario: Search in category count
    Given I am on Ebay homepage
    When I search for 'soap' in 'Baby' category
    Then I validate at least 500 search items present

  Scenario Outline:
    Given I am on Ebay homepage
    When I click on '<link>'
    Then I validate that the page navigates to '<url>' and title contains '<title>'
    Examples:
      | link        | url                                                            | title       |
      | Motors      | https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334 | Motors      |
      | Electronics | https://www.ebay.com/b/Electronics/bn_7000259124               | Electronics |
      | Toys        | https://www.ebay.com/b/Toys-Hobbies/220/bn_1865497             | Toys        |