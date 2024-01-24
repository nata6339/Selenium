package org.theinternet.page_object;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.theinternet.enums.AlertButtons;

import java.time.Duration;

public class AlertsPage extends BasePage{

    public final static String ALERT_TEXT = "I am a JS Alert";
    public final static String CONFIRM_TEXT = "I am a JS Confirm";
    public final static String PROMPT_TEXT = "I am a JS prompt";

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    private By alertsBtn(String nameButton){
        return By.xpath("//button[contains(text(),'" + nameButton +"')]");
    }

    private By resultText(){
        return By.cssSelector("#result");
    }

    public void clickOnBtn(String nameButton){
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(alertsBtn(nameButton))));
        element.click();
    }

    public void clickBtnByJs(AlertButtons button){
        WebElement buttonToClick = driver.findElement(alertsBtn(button.getTEXT_ON_BUTTON()));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return arguments[0].click()", buttonToClick);
    }

    public void executeJSEvent(AlertButtons button){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return " + button.getON_CLICK_JS_FUNCTION());
    }

    public String switchToAlertGetText(boolean confirm, String... massage){
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        if (massage.length > 0){
            alert.sendKeys(massage[0]);
        }
        if (confirm){
            alert.accept();
        }else {
            alert.dismiss();
        }
        return alertText;
    }

    public String getResultText(){
        return driver.findElement(resultText()).getText();
    }

}
