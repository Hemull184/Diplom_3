package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingInPage {

    private final By EMAIL_FIELD = By.xpath("//label[contains(text(),'Email')]/../input");
    private final By PASSWORD_FIELD = By.xpath("//input[@type='password']");
    private final By SING_IN_BUTTON = By.xpath("//*[text()='Войти']");
    private final By REGISTRATION_BUTTON = By.xpath("//*[text()='Зарегистрироваться']");
    private final By RECOVER_PASSWORD_BUTTON = By.xpath("//*[text()='Восстановить пароль']");
    private final By SING_IN_TEXT = By.xpath("//*[text()='Вход']");

    private final WebDriver driver;

    public SingInPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Запонить поле email")
    public void filledEmail(String email) {
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }

    @Step("Запонить поле password")
    public void filledPassword(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    @Step("Нажать на кнопку Вход")
    public void clickSignInButton() {
        driver.findElement(SING_IN_BUTTON).click();
    }

    @Step("Нажать на кнопку регистрация")
    public void clickRegistrationButton() {
        driver.findElement(REGISTRATION_BUTTON).click();
    }

    @Step("Получить текст 'Вход'")
    public String getSignInText() {
        return driver.findElement(SING_IN_TEXT).getText();
    }

    @Step("Нажать на кнопку Востановить пароль")
    public void clickRecoverPasswordButton() {
        driver.findElement(RECOVER_PASSWORD_BUTTON).click();
    }

    @Step("Подожать появления кнопки 'Вход'")
    public void waitSignInTextText() {
        WebElement until = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(SING_IN_TEXT));
    }

    @Step("авторизоваться")
    public void SignIn(String email, String password) {
        filledEmail(email);
        filledPassword(password);
        clickSignInButton();
    }
}
