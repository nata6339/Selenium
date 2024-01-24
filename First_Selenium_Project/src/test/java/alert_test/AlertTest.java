package alert_test;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.theinternet.enums.AlertButtons;
import org.theinternet.page_object.AlertsPage;
import org.theinternet.page_object.MainPage;

import static org.theinternet.page_object.AlertsPage.*;
import static org.theinternet.page_object.MainPage.MAIN_URL;

public class AlertTest extends BaseTest {
    MainPage mainPage;
    AlertsPage alertsPage;

    @BeforeClass
    public void setUp() {
        openUrl(MAIN_URL);
        mainPage = new MainPage(driver);
        alertsPage = new AlertsPage(driver);
    }

    @Test
    public void alertTest() {
        mainPage.scrollToFooter(mainPage.btnForLink("javascript_alerts"));
        mainPage.clickOnLink("javascript_alerts");
        alertsPage.clickOnBtn(AlertButtons.ALERT.getTEXT_ON_BUTTON());
        Assert.assertEquals(alertsPage.switchToAlertGetText(true), ALERT_TEXT);
        Assert.assertEquals(alertsPage.getResultText(), "You successfully clicked an alert");
    }

    @Test
    public void confirmDismissTest() {
        mainPage.scrollToFooter(mainPage.btnForLink("javascript_alerts"));
        mainPage.clickOnLink("javascript_alerts");
        alertsPage.clickOnBtn(AlertButtons.CONFIRM.getTEXT_ON_BUTTON());
        Assert.assertEquals(alertsPage.switchToAlertGetText(false), CONFIRM_TEXT);
        Assert.assertEquals(alertsPage.getResultText(), "You clicked: Cancel");
    }

    @Test
    public void confirmAcceptTest() {
        mainPage.scrollToFooter(mainPage.btnForLink("javascript_alerts"));
        mainPage.clickOnLink("javascript_alerts");
        alertsPage.clickOnBtn(AlertButtons.CONFIRM.getTEXT_ON_BUTTON());
        Assert.assertEquals(alertsPage.switchToAlertGetText(true), CONFIRM_TEXT);
        Assert.assertEquals(alertsPage.getResultText(), "You clicked: Ok");
    }

    @DataProvider(name = "TestParameters")
    Object[][] dataParameters() {
        return new Object[][]{
                {true, "Some text", "You entered: Some text"},
                {false, "Some text", "You entered: null"},
                {true, "", "You entered:"},
                {false, "", "You entered: null"}
        };
    }

    @Test(dataProvider = "TestParameters")
    public void promptTest(boolean confirm, String enteredText, String expectedText) {
        mainPage.scrollToFooter(mainPage.btnForLink("javascript_alerts"));
        mainPage.clickOnLink("javascript_alerts");
        alertsPage.clickOnBtn(AlertButtons.PROMPT.getTEXT_ON_BUTTON());
        Assert.assertEquals(alertsPage.switchToAlertGetText(confirm, enteredText), PROMPT_TEXT);
        Assert.assertEquals(alertsPage.getResultText(), expectedText);
    }

    @AfterMethod
    public void backDriver() {
        driver.navigate().back();
    }
}
