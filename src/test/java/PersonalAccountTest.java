import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import config.WebDriverConfig;
import pages.SingInPage;
import pages.PersonalAccountPage;

public class PersonalAccountTest {

    private WebDriver driver;

    HomePage homePage;
    SingInPage singInPage;
    PersonalAccountPage personalAccountPage;

    @Before
    public void setUp() {
        System.setProperty(WebDriverConfig.KEY_DRIVER, WebDriverConfig.setBrowser());
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        homePage = new HomePage(driver);
        homePage.clickLogIntButton();
        singInPage = new SingInPage(driver);
        singInPage.SignIn("Pavlik56@yandex.ru", "987654");
        homePage.clickPersonalAreaButton();
        personalAccountPage = new PersonalAccountPage(driver);
    }

    @Test
    @DisplayName("Тест выхода из аккаунта")
    public void exitSignInTest() {
        personalAccountPage.waitExitButton();
        personalAccountPage.clickExitButton();
        singInPage.waitSignInTextText();
        String newGetEnterText = singInPage.getSignInText();
        assertThat(newGetEnterText, is("Вход"));
    }

    @Test
    @DisplayName("Тест перехода из ЛК в конструктор ")
    public void crossOverConstructorTest() {
        personalAccountPage.waitConstructorButton();
        personalAccountPage.clickConstructorButton();
        String newDesignerText = homePage.getConstructorText();
        assertThat(newDesignerText, is("Соберите бургер"));
    }

    @Test
    @DisplayName("Тест перехода из ЛК  по Stellar Burgers в конструктор ")
    public void crossOverStellarBurgersTest() {
        personalAccountPage.waitHomePageButton();
        personalAccountPage.clickStellarBurgersButton();
        String newDesignerText = homePage.getConstructorText();
        assertThat(newDesignerText, is("Соберите бургер"));
    }

    @After
    public void clean() {
        driver.quit();
    }
}
