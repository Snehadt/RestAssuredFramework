package StepDefinition;

import com.spotify.oauth2.POJO.Error;
import com.spotify.oauth2.POJO.Playlist;
import com.spotify.oauth2.api.PlaylistApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import com.spotify.oauth2.Base.Base;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import static Utils.JavaFaker.getDescription;
import static Utils.JavaFaker.getPName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpotifyPlaylistStepdefs extends Base{
    Playlist playlist ;
    Playlist deserializedPlaylist ;
    Response res ;

    @Given("The user tries to hit the POST call to create playlist")
    public void user_hits_post_call() {
        playlist = new Playlist(getPName(),getDescription(),false);
        res = PlaylistApi.post(playlist);
      }


    @Then("user should be able to get create the playlist")
    public void user_creates_playlist() {
        assertThat(res.statusCode(),equalTo(HttpStatus.SC_CREATED));
        deserializedPlaylist = res.as(Playlist.class);
    }


    @And("user should be able to compare the values provided with the generated response")
    public void userShouldBeAbleToCompareTheValuesProvidedWithTheGeneratedResponse() {
        assertThat(deserializedPlaylist.getDescription(),equalTo(playlist.getDescription()));
        assertThat(deserializedPlaylist.getName(),equalTo(playlist.getName()));
        assertThat(deserializedPlaylist.get_public(),equalTo(playlist.get_public()));
    }


    @Given("The user is logged in to the spotify site and user creates playlist using {string}")
    public void theUserIsLoggedInToTheSpotifySiteAndUserCreatesPlaylistUsing(String expired_access_token) {
        playlist = new Playlist(getPName(),getDescription(),false);
        Response responseError = PlaylistApi.post(playlist,expired_access_token);
        assertThat(responseError.statusCode(),equalTo(HttpStatus.SC_UNAUTHORIZED));
        com.spotify.oauth2.POJO.Error deserializedPlaylist = responseError.as(Error.class);
        assertThat(deserializedPlaylist.getError().getMessage() ,equalTo("Invalid access token"));

    }
    @Then("user should be able to create a playlist")
    public void userShouldBeAbleToCreateAPlaylist() {
        user_hits_post_call();
        user_creates_playlist();
    }
}
