@AllegroSearch
Feature: allegroSearch

  Background:
    When  User navigates to Allegro Home Page
    Then  User is on Allegro Home Page
    And   User closes Pop Up if it is displayed

@AllegroFilter
  Scenario: validate result for custom search with filters for 'Dyski zewnetrzne i przenosne'
    Given User is on Allegro Home Page
    And   I navigate to 'Dyski zewnetrzne i przenosne' page
    When  I apply search filters from 500 gb to 1000 gb
    Then  I should see correctly filtered results from 500 gb to 1000 gb
