package baseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.theinternet.driver_manager.DriverManager;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setUpBrowser() {
        driver = DriverManager.getDriver();
    }

    public void openUrl(String expectedURL) {
        driver.get(expectedURL);
    }

    @AfterTest
    public void closeDriver() {
        DriverManager.quitDriver();
    }
}
