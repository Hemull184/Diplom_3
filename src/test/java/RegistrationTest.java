import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import user.RandomUser;
import user.UserCreds;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SingInPage;

public class RegistrationTest {

    private WebDriver driver;
    HomePage homePage;
    RegistrationPage registrationPage;
    SingInPage singInPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        homePage = new HomePage(driver);
        homePage.clickPersonalAreaButton();
        singInPage = new SingInPage(driver);
        singInPage.clickRegistrationButton();
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    @DisplayName("Тест регистрации c некорректный паролем")
    public void registrationWithErrorPassTest() {
        registrationPage.registration("Pavlik48", "Pavlik48@yandex.ru", "98765");
        String newGetErrorText = registrationPage.getIncorrectPasswordText();
        assertThat(newGetErrorText, is("Некорректный пароль"));
    }

    @Test
    @DisplayName("Тест регистрации с корректным паролем")
    public void registrationWithCorrectPassTest() {
        UserCreds userCreds = RandomUser.random();
        registrationPage.registration(userCreds.getName(), userCreds.getEmail(), userCreds.getPassword());
        singInPage.waitSignInTextText();
        String newGetEnterText = singInPage.getSignInText();
        assertThat(newGetEnterText, is("Вход"));
    }

    @After
    public void clean() {
        driver.quit();
    }
}
