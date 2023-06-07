package config;

public class WebDriverConfig {

    public static String yandexBrowser = "src\\test\\resources\\WebDriver\\bin\\yandexdriver.exe";
    public static String chromeBrowser = "src\\test\\resources\\WebDriver\\bin\\chromedriver.exe";
    public static final String KEY_DRIVER = "webdriver.chrome.driver";

    public static String setBrowser() {
        if (System.getProperty("browser_type") != null && System.getProperty("browser_type").equals("yandex")) {
            return yandexBrowser;
        }
        return chromeBrowser;
    }
}