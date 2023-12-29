package Utils;

import Locators.LocatorClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

public class Utility {

    static WebDriverWait wait;
    LocatorClass lc = new LocatorClass();

    public static String decoder(String encodedMsg){
        byte[] decoded_byte = Base64.getDecoder().decode(encodedMsg);
        String decodedString = new String(decoded_byte);
        return decodedString;
    }

    public static String propertiesDecode(String key) throws IOException {
        Properties props=new Properties();
        FileReader reader=new FileReader("src\\main\\java\\Properties\\Config.properties");
        props.load(reader);
        return props.getProperty(key);
    }

    public void explicitWaitVisibilityOfElement(WebDriver driver,By keys){
        wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(keys));
    }

    public void explicitURLContains(WebDriver driver,String keys){
        wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.urlContains(keys));
    }

    public void click(WebDriver driver,By keys){
        driver.findElement(keys).click();
    }
    public void sendkeys(By element, String encoded,WebDriver driver){
        driver.findElement(element).sendKeys(Utility.decoder(encoded));
    }
}
