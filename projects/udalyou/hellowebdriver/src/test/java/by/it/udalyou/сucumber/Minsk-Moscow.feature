Feature: Find aicraft ticket Minsk-Moscow
@success
                             Scenario: Check Ticket Count
                              Given Home Page airline Is Loaded from "https://www.expedia.com.my/"
                              When User set Flight Mode
                              And User set One Way Ticket
                              And Set Origin "Minsk"
                              And Set Destination "Moscow"
                              And Set Date 6/6/2019
                              And Click Search
                              And User seen List with result
                              Then Count if results more 1