package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage {

    private final By EMAIL_FIELD = By.xpath("//label[contains(text(),'Email')]/../input");
    private final By RESTORE_BUTTON = By.xpath("//button[contains(text(),'Восстановить')]");
    private final By SING_IN_BUTTON = By.className("Auth_link__1fOlj");

    private final WebDriver driver;

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Запонить поле Email")
    public void filledEmail(String email) {
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }

    @Step("Нажать на кнопку Востановить")
    public void clickRestoreButton() {
        driver.findElement(RESTORE_BUTTON).click();
    }

    @Step("Нажать на кнопку Войти")
    public void clickSignINButton() {
        driver.findElement(SING_IN_BUTTON).click();
    }

    @Step("Востановить пароль")
    public void restore(String email) {
        filledEmail(email);
        clickRestoreButton();
    }
}
