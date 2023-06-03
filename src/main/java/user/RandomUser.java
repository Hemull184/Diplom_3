package user;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUser {

    public static UserCreds random() {
        return new UserCreds(RandomStringUtils.randomAlphabetic(10) + "@yandex.ru", "123456789", RandomStringUtils.randomAlphabetic(10));
    }

    public static final String KEY_DRIVER = "webdriver.chrome.driver";
    public static final String VALUE_PATH = "src\\test\\resources\\WebDriver\\bin\\";

    public static final Object[][] DATA = new Object[][]{
            {"chromedriver.exe"},
            {"yandexdriver.exe"}
    };
}
