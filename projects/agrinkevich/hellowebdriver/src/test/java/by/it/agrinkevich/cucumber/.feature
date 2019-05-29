Feature: Find aircraft ticket
  @success
  Scenario: Check Ticket Count
    Given Home Page Aviacompany Is Loaded
    When User set Flight Mode
    And Set One Way Ticket
    And Set Origin Minsk
    And Set Destination Moscow
    And Set Date 6/6/2019
    And Click Search
    And User seen List With Result
    Then Count If Result More 1