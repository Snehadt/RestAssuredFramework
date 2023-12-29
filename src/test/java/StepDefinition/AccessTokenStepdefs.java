package StepDefinition;

import static io.restassured.RestAssured.given;
import Utils.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AccessTokenStepdefs {

    String auth_code = AuthCodeStepdefs.auth_code;
    public static String access_token = "";
    @Given("The user has auth code generated")
    public void theUserHasAuthCodeGenerated() throws Exception {
        if(!auth_code.isEmpty())
            System.out.println(" Valid auth code");
        else{
            throw new Exception(" Auth code is not valid");
        }
    }


    @When("The user provides the {string}, {string}, {string}  and {string} form parameters")
    public String generate_access_token(String grant_type, String redirect_uri, String client_id, String client_secret) {
       Map<String,String> formParam = new HashMap<>();
       formParam.put("redirect_uri",redirect_uri);
       formParam.put("grant_type",grant_type);
       formParam.put("code",auth_code);
       formParam.put("client_id",client_id);
       formParam.put("client_secret", Utility.decoder(client_secret));

        RestAssured.baseURI = "https://accounts.spotify.com";

        access_token = given()
                .basePath("/api")
                .formParams(formParam)
                .contentType(ContentType.URLENC)
        .when().post("/token")
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .jsonPath()
                .get("access_token");

        return access_token;
    }

    @Then("the user should be able to get the access token")
    public void theUserShouldBeAbleToGetTheAccessToken() throws Exception {
        System.out.println("access token is :"+ access_token);
        if(!access_token.isEmpty())
            System.out.println( " Access token generated !!");
        else{
            throw new Exception(" Access token not generated");
        }
    }

    @When("The user provides the  form parameters")
    public String theUserProvidesTheFormParameters() throws IOException {
        Map<String,String> formParam = new HashMap<>();
        formParam.put("redirect_uri",Utility.propertiesDecode("redirect_uri"));
        formParam.put("grant_type",Utility.propertiesDecode("grant_type"));
        formParam.put("code",auth_code);
        formParam.put("client_id",Utility.propertiesDecode("client_id"));
        formParam.put("client_secret", Utility.decoder(Utility.propertiesDecode("client_secret")));

        RestAssured.baseURI = "https://accounts.spotify.com";

        access_token = given()
                .basePath("/api")
                .formParams(formParam)
                .contentType(ContentType.URLENC)
                .when().post("/token")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .jsonPath()
                .get("access_token");

        return access_token;
    }
}