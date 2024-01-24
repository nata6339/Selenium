package org.theinternet.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{
    public static final String MAIN_URL = "https://the-internet.herokuapp.com/";

    public MainPage(WebDriver driver) {
        super(driver);
    }
//----------------------------------------------------------------------------------------------------------------------


    public By btnForLink(String nameButton) {
        return By.xpath("//a[@href='/" + nameButton + "']");
    }

    private By footer(){
        return By.xpath("//div[@id='page-footer']");
    }


//----------------------------------------------------------------------------------------------------------------------


    public String getAttributeHref(String nameButton) {
        return driver.findElement(btnForLink(nameButton)).getAttribute("href");
    }

    public void clickOnLink(String nameButton) {
        driver.findElement(btnForLink(nameButton)).click();
    }

    public void scrollToFooter(By element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
    }
}
