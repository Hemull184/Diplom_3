package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private final By NAME_FIELD = By.xpath("//label[contains(text(),'Имя')]/../input");
    private final By EMAIL_FIELD = By.xpath("//label[contains(text(),'Email')]/../input");
    private final By PASSWORD_FIELD = By.xpath("//input[@type='password']");
    private final By REGISTRATION_BUTTON = By.xpath("//*[text()='Зарегистрироваться']");
    private final By SIGN_IN_BUTTON = By.xpath("//*[text()='Войти']");
    private final By INCORRECT_PASSWORD_TEXT = By.xpath("//*[text()='Некорректный пароль']");

    private final WebDriver driver;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void filledName(String name) {
        driver.findElement(NAME_FIELD).sendKeys(name);
    }

    @Step("Запонить поле Email")
    public void filledEmail(String email) {

        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }
    @Step("Запонить поле password")
    public void filledPassword(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }
    @Step("Нажать на кнопку Регитсрация")
    public void clickRegistrationButton() {
        driver.findElement(REGISTRATION_BUTTON).click();
    }
    @Step("Нажать на кнопку Войти")
    public void clickSignINButton() {
        driver.findElement(SIGN_IN_BUTTON).click();
    }
    @Step("Получить текст ошибки")
    public String getIncorrectPasswordText() {
        return driver.findElement(INCORRECT_PASSWORD_TEXT).getText();
    }
    @Step("Запольнить поля регистрации")
    public void registration(String name, String email, String password) {
        filledName(name);
        filledEmail(email);
        filledPassword(password);
        clickRegistrationButton();
    }
}
