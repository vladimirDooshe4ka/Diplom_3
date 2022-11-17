package configuration;

public class BrowserProperties {
    public static final String yandexBrowser = "D:\\selenium\\yandexdriver\\bin\\yandexdriver.exe";
    public static final String chromeBrowser = "D:\\selenium\\chromedriver_win32\\bin\\chromedriver.exe";

    public static void setBrowser(String browser){
        System.setProperty("webdriver.chrome.driver", browser);
    }

}
