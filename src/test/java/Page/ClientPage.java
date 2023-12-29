/*
package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientPage {

    @FindBy(id="login-username")
    WebElement username;

    @FindBy(id="login-password")
    WebElement password;

    @FindBy(id="login-button")
    WebElement login_btn;

    WebDriver driver;

    public ClientPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void enterUserName(String userName){
        username.sendKeys(userName);
    }

    public void enterPassword(String pwd){
        password.sendKeys(pwd);
    }

    public void login(){
        login_btn.click();
    }

}
*/
