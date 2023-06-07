package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final By PERSONAL_AREA_BUTTON = By.xpath("//p[contains(text(),'Личный Кабинет')]");
    private final By LOG_IN_BUTTON = By.xpath("//button[contains(text(),'Войти в аккаунт')]");
    private final By BUNS_BUTTON = By.xpath("//span[contains(text(),'Булки')]");
    private final By SAUSE_BUTTON = By.xpath("//span[contains(text(),'Соус')]");
    private final By FILLING_BUTTON = By.xpath(".//h2[text() = 'Начинки']");
    private final By CONSTRUCTOR_TEXT = By.xpath("//*[text()='Соберите бургер']");
    private final By BUNS_TEXT = By.xpath("//h2[contains(text(),'Булки')]");
    private final By SAUSE_TEXT = By.xpath("//h2[contains(text(),'Соусы')]");
    private final By FILLING_TEXT = By.xpath("//h2[contains(text(),'Начинки')]");

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на кнопку ЛК")
    public void clickPersonalAreaButton() {
        driver.findElement(PERSONAL_AREA_BUTTON).click();
    }

    @Step("Нажать на кнопку Войти в ЛК")
    public void clickLogIntButton() {
        driver.findElement(LOG_IN_BUTTON).click();
    }

    @Step("Нажать на кнопку 'Булка'")
    public void clickBunsButton() {
        driver.findElement(BUNS_BUTTON).click();
    }

    @Step("Нажать на кнопку 'Соус'")
    public void clickSauseButton() {
        driver.findElement(SAUSE_BUTTON).click();
    }

    @Step("Нажать на кнопку 'Начинка'")
    public void clickFillingButton() {
        driver.findElement(FILLING_BUTTON).click();
    }

    @Step("Найти текст 'Соберите бургер'")
    public String getConstructorText() {
        return driver.findElement(CONSTRUCTOR_TEXT).getText();
    }

    @Step("Найти текст 'Булки'")
    public String getBunsText() {
        return driver.findElement(BUNS_TEXT).getText();
    }

    @Step("Найти текст 'Соусы'")
    public String getSauceText() {
        return driver.findElement(SAUSE_TEXT).getText();
    }

    @Step("Найти текст 'Начинки'")
    public String getFillingText() {
        return driver.findElement(FILLING_TEXT).getText();
    }

    @Step("Подожать появления кнопки 'ЛК'")
    public void expectationPersonalAccount() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(PERSONAL_AREA_BUTTON));
    }
}
