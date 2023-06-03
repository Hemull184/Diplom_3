package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {

    public final By ACCOUNT_BUTTON = By.xpath("//*[text()='Профиль']");
    public final By EXIT_BUTTON = By.xpath("//*[text()='Выход']");
    private final By CONSTRUCTOR_BUTTON = By.xpath("//*[text()='Конструктор']");
    private final By HOME_PAGE_BUTTON = By.className("AppHeader_header__logo__2D0X2");

    private static WebDriver driver;
    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на кнопку Выход")
    public void clickExitButton() {
        driver.findElement(EXIT_BUTTON).click();
    }
    @Step("Нажать на кнопку'Профиль'")
    public String getAccountext() {
        return driver.findElement(ACCOUNT_BUTTON).getText();
    }
    @Step("Нажать на кнопку конструктор")
    public void clickConstructorButton() {
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }
    @Step("Подожать появления кнопки 'Выход'")
    public void waitExitButton() {
        WebElement until = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(EXIT_BUTTON));
    }
    @Step("Подожать появления кнопки 'Конструктор'")
    public void waitConstructorButton() {
        WebElement until = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(CONSTRUCTOR_BUTTON));
    }
    @Step("Подожать появления кнопки 'Stellar Burgers'")
    public void waitHomePageButton() {
        WebElement until = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(HOME_PAGE_BUTTON));
    }
    @Step("Подожать появления кнопки 'Профиль'")
    public void waitAccountButton() {
        WebElement until = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(ACCOUNT_BUTTON));
    }
    @Step("Нажать на кнопку StellarBurger")
    public void clickStellarBurgersButton() {
        driver.findElement(HOME_PAGE_BUTTON).click();
    }
}
