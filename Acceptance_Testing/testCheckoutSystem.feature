Feature: Checkout system
  I want to be able to checkout items with various pricing rules 
  so that I can take advantage of special offers 

 
  Scenario: Purchase items without special offers 
    Given the following pricing rules 
    | Item | Unit price | Special price |
    | A    |     50     | 3 for 130     |
    | B    |     30     | 2 for 45      |
    | C    |     20     |               |
    | D    |     15     |               |
    When I scan the following items
    | Item | 
    | A    |
    | B    |
    | C    |
    | D    |
    Then The total price should be 115
    
  Scenario: Purchase same items multiple times 
    Given the following pricing rules 
    | Item | Unit price | Special price |
    | A    |     50     | 3 for 130     |
    | B    |     30     | 2 for 45      |
    | C    |     20     |               |
    | D    |     15     |               |
    When I scan the following items
    | Item | 
    | A    |
    | A    |
    | A    |
    Then The total price should be 130
    
  Scenario: Purchase items with and without special price 
    Given the following pricing rules 
    | Item | Unit price | Special price |
    | A    |     50     | 3 for 130     |
    | B    |     30     | 2 for 45      |
    | C    |     20     |               |
    | D    |     15     |               |
    When I scan the following items
    | Item | 
    | B    |
    | B    |
    | C    |
    | D    |
    Then The total price should be 80
    
  Scenario: Purchase items in any order 
    Given the following pricing rules 
    | Item | Unit price | Special price |
    | A    |     50     | 3 for 130     |
    | B    |     30     | 2 for 45      |
    | C    |     20     |               |
    | D    |     15     |               |
    When I scan the following items
    | Item | 
    | A    |
    | B    |
    | A    |
    | D    |
    | A    |
    Then The total price should be 175 
    
  Scenario: Apply special price for item A multiple times
    Given the following pricing rules 
    | Item | Unit price | Special price |
    | A    |     50     | 3 for 130     |
    | B    |     30     | 2 for 45      |
    | C    |     20     |               |
    | D    |     15     |               |
    When I scan the following items
      | Item |
      | A    |
      | A    |
      | A    |
      | A    |
      | A    |
      | A    |
    Then the total price should be 260
  
  Scenario: Scan items without any special price
    Given the following pricing rules 
    | Item | Unit price | Special price |
    | A    |     50     | 3 for 130     |
    | B    |     30     | 2 for 45      |
    | C    |     20     |               |
    | D    |     15     |               |
    When I scan the following items
      | Item |
      | C    |
      | C    |
      | D    |
      | D    |
    Then the total price should be 70
  
  Scenario: Change pricing rules and scan items
    Given the following new pricing rules
    | Item | Unit Price | Special Price   |
    | A    | 60         | 4 for 200       |
    | B    | 40         | 3 for 100       |
    | C    | 25         |                 |
    | D    | 10         | 5 for 40        |
    When I scan the following items
      | Item |
      | A    |
      | A    |
      | A    |
      | A    |
      | B    |
      | B    |
      | B    |
      | D    |
      | D    |
      | D    |
      | D    |
      | D    |
      | C    |
      | C    |
    Then the total price should be 390
    
  Scenario: Verify pricing update after scanning items
    Given the following pricing rules 
      | Item | Unit price | Special price |
      | A    |     50     | 3 for 130     |
      | B    |     30     | 2 for 45      |
      | C    |     20     |               |
      | D    |     15     |               |
    And I scan the following items
      | Item |
      | A    |
      | B    |
      | C    |
    And the total price should be 100
    When the pricing rules are updated to
      | Item | Unit Price | Special Price   |
      | A    | 60         | 4 for 200       |
      | B    | 40         | 3 for 100       |
      | C    | 25         |                 |
      | D    | 10         | 5 for 40        |
    And I scan the following items
      | Item |
      | A    |
      | B    |
      | C    |
    Then the total price should be 225
    
  Scenario: Scan additional items after applying special price
    Given the following pricing rules 
      | Item | Unit price | Special price |
      | A    |     50     | 3 for 130     |
      | B    |     30     | 2 for 45      |
      | C    |     20     |               |
      | D    |     15     |               |    
    And I scan the following items
      | Item |
      | A    |
      | A    |
      | A    |
    And the total price should be 130
    When I scan the following items
      | Item |
      | A    |
    Then the total price should be 180

