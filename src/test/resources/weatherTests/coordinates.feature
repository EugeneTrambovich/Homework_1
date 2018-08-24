Feature: Testing coordinates for weather
  Scenario: Coordinates test
    When we getting weather from server
    Then lon is -0.13
    And lat is 51.51

  Scenario: Visibility test
    When we getting weather from server
    Then visibility is 10000

  Scenario: Weather test
    When we getting weather from server
    Then weather id is 300
    And weather main is Drizzle
    And weather description is light intensity drizzle
    And weather icon is 09d


  Scenario: Wind test
    When we getting weather from server
    Then wind speed is 4.1
    And wind deg is 80

  Scenario: Base test
    When we getting weather from server
    Then base is stations

  Scenario: Main test
    When we getting weather from server
    Then temp is 280.32
    And pressure is 1012
    And humidity is 81
    And temp_min is 279.15
    And temp_max is 281.15

  Scenario: Dt test
    When we getting weather from server
    Then dt is 1485789600

  Scenario: Name test
    When we getting weather from server
    Then name is London

  Scenario: Id test
    When we getting weather from server
    Then id is 2643743

  Scenario: Cod test
    When we getting weather from server
    Then cod is 200

  Scenario: Clouds test
    When we getting weather from server
    Then all is 90

  Scenario: Sys test
    When we getting weather from server
    Then sys type is 1
    And sys id is 5091
    And sys message is 0.0103
    And sys country is GB
    And sys sunrise is 1485762037
    And sys sunset is 1485794875