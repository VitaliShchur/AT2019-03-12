Feature: Find aircraft ticket
@success
    Scenario: Check Ticket Count
    Given Home Page aviacompany is Loaded
    When User Click Sign In
    And User set TicketMode
    And User set Origin Place
    And User set Destination Place
    And User set Date
    And User seen List with result
    Then Count if results more 1