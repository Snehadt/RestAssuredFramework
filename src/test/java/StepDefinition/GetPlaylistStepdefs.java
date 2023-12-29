package StepDefinition;

import com.spotify.oauth2.POJO.Playlist;
import com.spotify.oauth2.api.PlaylistApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import static Utils.JavaFaker.getDescription;
import static Utils.JavaFaker.getPName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetPlaylistStepdefs {
    Playlist playlist;
    Response response;

    @Given("user provides the get request to fetch the playlist value")
    public void userProvidesTheGetRequestToFetchThePlaylistValue() {
        playlist = new Playlist(getPName(),getDescription(),false);
         response = PlaylistApi.get();
    }

    @Then("user should be able to get the playlist")
    public void userShouldBeAbleToGetThePlaylist() {
        assertThat(response.statusCode(),equalTo(HttpStatus.SC_OK));
        Playlist resPlaylist = response.as(Playlist.class);
        assertThat(resPlaylist.getDescription(),equalTo(playlist.getDescription()));
        assertThat(resPlaylist.getName(),equalTo(playlist.getName()));
        assertThat(resPlaylist.get_public(),equalTo(playlist.get_public()));
    }
}