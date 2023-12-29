package com.spotify.oauth2.api;

import StepDefinition.AccessTokenStepdefs;
import Utils.Utility;
import com.spotify.oauth2.POJO.Playlist;
import io.restassured.response.Response;

import java.io.IOException;

public class PlaylistApi {
static String generated_access_token = AccessTokenStepdefs.access_token;
static String user_id;

    static {
        try {
            user_id = Utility.propertiesDecode("user_id");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Response post(Playlist playlist){
        return BaseApi.post(playlist,generated_access_token,user_id);
    }

    public static Response post(Playlist playlist, String expired_access_token){
        return BaseApi.post(playlist,expired_access_token,"users/31jmnagdak2eoalpod6grsg5gn5e/playlists");
    }

    public static Response get(){
       return BaseApi.get(user_id , generated_access_token);
    }

    public static Response put(Playlist playlist){
        return BaseApi.put(playlist,user_id,generated_access_token);
    }
}
