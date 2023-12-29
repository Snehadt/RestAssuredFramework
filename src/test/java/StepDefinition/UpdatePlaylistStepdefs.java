package StepDefinition;

import com.spotify.oauth2.POJO.Playlist;
import com.spotify.oauth2.api.PlaylistApi;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import static Utils.JavaFaker.getDescription;
import static Utils.JavaFaker.getPName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UpdatePlaylistStepdefs {
    Playlist playlist;
    @Given("The user should be able to get the updated playlist")
    public void theUserShouldBeAbleToGetTheUpdatedPlaylist() {
        Response deserializedPlaylist = PlaylistApi.put(playlist);
        assertThat(deserializedPlaylist.statusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Given("The user should be update the playlist")
    public void theUserShouldBeUpdateThePlaylist() {
        playlist =new Playlist(getPName(),getDescription(),false);
        Response deserializedPlaylist = PlaylistApi.put(playlist);
    }
}
