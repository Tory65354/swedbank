package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final By BTN_CALCULATOR = By.xpath(".//a[@data-wt-label = 'Calculators']");
    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@data-wt-label='Accept']");

    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void clickAcceptCookie() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(baseFunc.getBrowser(), Duration.ofSeconds(40));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.invisibilityOfElementLocated(ACCEPT_COOKIE_BTN),
                ExpectedConditions.elementToBeClickable(ACCEPT_COOKIE_BTN)));
        baseFunc.click(ACCEPT_COOKIE_BTN);
        Thread.sleep(2000);
    }


    public void clickBTNCalculator() {
        baseFunc.click(BTN_CALCULATOR);
    }


}

