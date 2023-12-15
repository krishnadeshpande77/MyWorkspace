Feature: Validating Place APIs

  Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI
    Given Add Place Payload with "<name>" "<language>" "<address>" 
    When user calls "addPlaceAPI" with "Post" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And Verify place_Id created maps to "<name>" using "getPlaceAPI"
    
    Examples:
    | name              | language  | address                   | 
    | Krishna          | English    | World Cross Center| 
    | My House      | Hindi       | Nice Complex         |
    
