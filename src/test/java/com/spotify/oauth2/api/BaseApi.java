package com.spotify.oauth2.api;

import com.spotify.oauth2.POJO.Playlist;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static com.spotify.oauth2.Base.Base.reqSpecBuilder;
import static com.spotify.oauth2.Base.Base.resSpecBuilder;
import static io.restassured.RestAssured.given;

public class BaseApi {

    public BaseApi(String access_token, Playlist playlist, String s) {
    }

    public static Response post(Object playlist, String access_token, String userId){
        return given(reqSpecBuilder())
                .auth().oauth2(access_token)
                .body(playlist)
                .pathParam("userId",userId)
                .when().post("users/{userId}/playlists")
                .then().spec(resSpecBuilder())
                .extract()
                .response();
    }

    public static Response get(String userId, String access_token){
       return given(reqSpecBuilder())
               .auth().oauth2(access_token)
                .pathParam("userId",userId)
                .when().get("playlists/{userId}")
                .then().log().all().spec(resSpecBuilder())
                .extract()
                .response();
    }
    public static Response put(Object playlist,String userId,String access_token){
        return
                given(reqSpecBuilder()).auth().oauth2(access_token)
                .body(playlist)
                .pathParam("userId",userId)
                .when().put("users/{userId}/playlists")
                .then().spec(resSpecBuilder())
                .extract()
                .response();
    }
}