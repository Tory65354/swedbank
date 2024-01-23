package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CalculatorPage {
    private final By SALARY_CALCULATOR = By.xpath(".//a[@rel = 'noreferrer noopener']");
    private final By BRUTO_SALARY = By.xpath(".//input[@class = 'wcalc-bruto']");
    private final By NETO_SALARY_2024 = By.id("neto-alga-2024");

    private BaseFunc baseFunc;

    public CalculatorPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectSalaryCalculator() {
        baseFunc.click(SALARY_CALCULATOR);
    }

    public void selectBrutoSalary() {
        baseFunc.selectByText(BRUTO_SALARY, "1500");
    }

    public double getNetoSalary () {
        WebElement netoSalaryElement = baseFunc.findElement(NETO_SALARY_2024);
        String netoSalaryText = netoSalaryElement.getText();
        double netoSalary = Double.parseDouble(netoSalaryText);

        System.out.println("Neto Salary in 2024:" + netoSalary);

        return netoSalary;
    }


}
