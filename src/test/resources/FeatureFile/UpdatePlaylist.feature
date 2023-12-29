Feature: To automate the update playlist feature of Spotify


  Background:Generation of auth code  and then access token for the spotify api
    Given user is on the chrome browser to generate the authorization code for the client application using scope,redirect_uri and client_id
    When user tries to login with google account
    Then user gets navigated to the client page with the generated auth code
    Given The user has auth code generated
    When The user provides the  form parameters
    Then the user should be able to get the access token
    Then user should be able to create a playlist

  Scenario: To update the playlist
    Given The user should be update the playlist
    Then The user should be able to get the updated playlist
