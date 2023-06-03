import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import pages.HomePage;
import pages.RegistrationPage;
import pages.RestorePasswordPage;
import pages.SingInPage;
import pages.PersonalAccountPage;
import user.RandomUser;

@RunWith(Parameterized.class)
public class SingInTest {

    private WebDriver driver;
    private final String driverBin;
    public SingInTest (String driverBin) {this.driverBin=driverBin;}

    HomePage homePage;
    RegistrationPage registrationPage;
    SingInPage singInPage;
    RestorePasswordPage restorePassword;
    PersonalAccountPage personalAccountPage;

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return RandomUser.DATA;
    }

    @Before
    public void setUp() {
        System.setProperty(RandomUser.KEY_DRIVER,RandomUser.VALUE_PATH + driverBin);
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        homePage = new HomePage(driver);
        singInPage = new SingInPage(driver);
        registrationPage = new RegistrationPage(driver);
        restorePassword = new RestorePasswordPage(driver);
        personalAccountPage = new PersonalAccountPage(driver);
    }

    @Test
    @DisplayName("Тест входа по кнопке «Войти в аккаунт» на главной странице")
    public void singInHomePageTest() {
        homePage.clickLogIntButton();
        singInPage.SignIn("Pavlik56@yandex.ru", "987654");
        homePage.clickPersonalAreaButton();
        personalAccountPage.waitAccountButton();
        String newAccountLinkText = personalAccountPage.getAccountext();
        assertThat(newAccountLinkText, is("Профиль"));
    }

    @Test
    @DisplayName("Тест входа по кнопке в ЛК")
    public void singInPersonalAccountPageTest() {
        homePage.expectationPersonalAccount();
        homePage.clickLogIntButton();
        singInPage.SignIn("Pavlik56@yandex.ru", "987654");
        homePage.expectationPersonalAccount();
        homePage.clickPersonalAreaButton();
        personalAccountPage.waitAccountButton();
        String newAccountLinkText = personalAccountPage.getAccountext();
        assertThat(newAccountLinkText, is("Профиль"));
    }

    @Test
    @DisplayName("Тест входа по кнопке в форме регистрации")
    public void singInRegistrationPageTest() {
        homePage.expectationPersonalAccount();
        homePage.clickLogIntButton();
        singInPage.clickRegistrationButton();
        registrationPage.clickSignINButton();
        singInPage.SignIn("Pavlik56@yandex.ru", "987654");
        homePage.clickPersonalAreaButton();
        personalAccountPage.waitAccountButton();
        String newAccountLinkText = personalAccountPage.getAccountext();
        assertThat(newAccountLinkText, is("Профиль"));
    }

    @Test
    @DisplayName("Тест входа по кнопке в форме восстановления пароля")
    public void singInRestorePasswordTest() {
        homePage.expectationPersonalAccount();
        homePage.clickLogIntButton();
        singInPage.clickRecoverPasswordButton();
        restorePassword.clickSignINButton();
        singInPage.SignIn("Pavlik56@yandex.ru", "987654");
        homePage.expectationPersonalAccount();
        homePage.clickPersonalAreaButton();
        personalAccountPage.waitAccountButton();
        String newAccountLinkText = personalAccountPage.getAccountext();
        assertThat(newAccountLinkText, is("Профиль"));
    }

    @After
    public void clean() {
        driver.quit();
    }
}
