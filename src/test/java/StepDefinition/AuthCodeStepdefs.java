package StepDefinition;

import Locators.LocatorClass;
//import Page.ClientPage;
import Utils.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class AuthCodeStepdefs{

    WebDriver driver = null ;
 //   ClientPage page ;
    WebDriverWait wait ;
    LocatorClass lc = new LocatorClass();
    Utility utility = new Utility();
    public static String auth_code = "";

    @Given("user is on the chrome browser to generate the authorization code for the client application using scope,redirect_uri and client_id")
    public void chrome_setup() throws IOException {
        WebDriverManager.chromedriver().setup();
      //  page = new ClientPage(driver);
        driver = new ChromeDriver();
        String url = String.format("https://accounts.spotify.com/authorize?scope=%s&response_type=code&redirect_uri=%s&client_id=%s",Utility.propertiesDecode("scope"),Utility.propertiesDecode("redirect_uri"),Utility.propertiesDecode("client_id"));
        driver.get(url);
        driver.manage().window().maximize();    }

    @When("user tries to login with google account")
    public void userTriesToLoginWithGoogleAccount() throws IOException {
        utility.explicitWaitVisibilityOfElement(driver,lc.username);
       /* page.enterUserName(Utility.propertiesDecode("username"));
        page.enterPassword(Utility.propertiesDecode("password"));
        page.login();*/
        utility.sendkeys(lc.username,Utility.propertiesDecode("username"),driver);
        utility.sendkeys(lc.password,Utility.propertiesDecode("password"),driver);
        utility.click(driver,lc.login_btn);
    }


    @Then("user gets navigated to the client page with the generated auth code")
    public String generate_auth_token() {
        try{
            utility.explicitURLContains(driver,"?code=");
            String url =driver.getCurrentUrl();
            auth_code = url.split("=")[1].trim();
            System.out.println("auth code :"+auth_code);
            return auth_code;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(driver != null)
                driver.close();
        }
        return null;
    }
}