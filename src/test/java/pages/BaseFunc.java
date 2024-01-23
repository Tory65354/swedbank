package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseFunc {
    private WebDriver browser;
    private WebDriverWait wait;

    public BaseFunc() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        wait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }

    public void openUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        browser.get(url);
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void selectByValue(By locator, String value) {
        Select select = new Select(findElement(locator));
        select.selectByValue(value);
    }


    public void click(By locator) {
        WebElement element = findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void selectByText (By locator, String text) {
        WebElement element = findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        Select select = new Select(findElement(locator));
        select.selectByVisibleText(text);
    }

    public WebDriver getBrowser() {
        return browser;
    }

    public void type (By locator, String text) {
        WebElement inputField = findElement(locator);
        inputField.clear();
        inputField.sendKeys(text);
    }

    public void switchToTab() {
        ArrayList<String> tabs = new ArrayList<>(browser.getWindowHandles());
        browser.switchTo().window(tabs.get(1));
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://blog.swedbank.lv/riki-kalkulatori/darba-algas-kalkulators"));
    }

    public void switchToFrame (By frameLocator){
        WebElement frame = findElement(frameLocator);
        browser.switchTo().frame(frame);
    }








}
