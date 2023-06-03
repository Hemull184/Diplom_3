import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePageTest {

    private WebDriver driver;
    HomePage objHomePage;

    @Before
    public void setUp() {
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
