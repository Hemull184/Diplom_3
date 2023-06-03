import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import user.RandomUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class HomePageTest {

    private WebDriver driver;
    private final String driverBin;
    public HomePageTest (String driverBin) {this.driverBin=driverBin;}

    HomePage objHomePage;

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return RandomUser.DATA;
    }

    @Before
    public void startUp() {
        System.setProperty(RandomUser.KEY_DRIVER,RandomUser.VALUE_PATH + driverBin);
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        objHomePage = new HomePage(driver);
    }

    @Test
    @DisplayName("Тест булок")
    public void bunsTest() {
        objHomePage.clickFillingButton();
        objHomePage.clickBunsButton();
        String newBreadText = objHomePage.getBunsText();
        assertThat(newBreadText, is("Булки"));
    }

    @Test
    @DisplayName("Тест соусов")
    public void sauseTest() {
        objHomePage.clickSauseButton();
        String newSauceText = objHomePage.getSauceText();
        assertThat(newSauceText, is("Соусы"));
    }

    @Test
    @DisplayName("Тест начинок")
    public void fillingTest() {
        objHomePage.clickSauseButton();
        String newFillingText = objHomePage.getFillingText();
        assertThat(newFillingText, is("Начинки"));
    }

    @After
    public void clean() {
        driver.quit();
    }
}
