package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage {
    private final By SALARY_CALCULATOR = By.xpath(".//a[@rel = 'noreferrer noopener']");
    private final By BRUTO_SALARY = By.xpath(".//input[@class = 'wcalc-bruto']");
    private final By NETO_SALARY_2024 = By.id("neto-alga-2024");
    private final By IFRAME_CALCULATOR = By.id("calc");

    private BaseFunc baseFunc;

    public CalculatorPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectSalaryCalculator() {
        baseFunc.click(SALARY_CALCULATOR);
    }

    public void switchToCalculatorFrame() {
        baseFunc.switchToFrame(IFRAME_CALCULATOR);
    }

   public void fillInBrutoSalary(String salary) {
        WebDriverWait wait = new WebDriverWait(baseFunc.getBrowser(), Duration.ofSeconds(20));
       wait.until(ExpectedConditions.elementToBeClickable(BRUTO_SALARY));
        baseFunc.type(BRUTO_SALARY,salary);}

    public double getNetoSalary () {
        WebElement netoSalaryElement = baseFunc.findElement(NETO_SALARY_2024);
        String netoSalaryText = netoSalaryElement.getText();
        netoSalaryText = netoSalaryText.replace(" ", "");
        double netoSalary = Double.parseDouble(netoSalaryText);

        System.out.println("Bruto Salary:1500.Neto Salary in 2024:" + netoSalary);

        return netoSalary;
    }


}
