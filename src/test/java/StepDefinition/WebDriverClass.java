package StepDefinition;

import org.openqa.selenium.WebDriver;

public class WebDriverClass {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        WebDriverClass.driver = driver;
    }
}
