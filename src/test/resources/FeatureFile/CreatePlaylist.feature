Feature: To automate the playlist feature of Spotify

  Background:Generation of auth code  and then access token for the spotify api
    Given user is on the chrome browser to generate the authorization code for the client application using scope,redirect_uri and client_id
    When user tries to login with google account
    Then user gets navigated to the client page with the generated auth code
    Given The user has auth code generated
    When The user provides the  form parameters
    Then the user should be able to get the access token

   Scenario: To create the Spotify playlist
    Given The user tries to hit the POST call to create playlist
    Then user should be able to get create the playlist
    And user should be able to compare the values provided with the generated response

  Scenario Outline: Negative test case for create playlist
    Given The user is logged in to the spotify site and user creates playlist using "expired_access_token"
    Examples:
      | expired_access_token |
    | "AQCRoPE2KgAOxUAd6eEI_7hS0g0x6mg1QlwtQgaIr9xxVrCNDPqtSD3WkR00_TsjBSUrPdNiAOcxZf0FroEbqz60yiLoe4qWbNDRTxrZSN4keGZxQc6uXQhLQCpGbVjrRJEkBWvGSNLfVit7_6B90LU4a2tZQ0D7leqRIdwSLM8xKEDWZVkDhhDoNAygyWDbKJ650moemPTm93k9O7Ej32p1AeR4pUVtnqgpooncZheS"                    |