package stepdefs;

import org.junit.Test;

import pages.BaseFunc;
import pages.CalculatorPage;
import pages.HomePage;

public class SwedbankTests {
    private final String URL = "www.swedbank.lv";


    private BaseFunc baseFunc;

    @Test
    public void calculatorCheck() throws InterruptedException {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl(URL);

        HomePage homePage = new HomePage(baseFunc);

        homePage.clickAcceptCookie();
        homePage.clickBTNCalculator();

        CalculatorPage calculatorPage = new CalculatorPage(baseFunc);
        calculatorPage.selectSalaryCalculator();
        calculatorPage.fillInBrutoSalary("1500");
        calculatorPage.getNetoSalary();

    }
}
