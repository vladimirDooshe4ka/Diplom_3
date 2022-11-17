import Data.UserData;
import com.codeborne.selenide.Configuration;
import configuration.BrowserProperties;
import constants.ConstantUi;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.WebDriverConditions.*;
import static com.codeborne.selenide.Selenide.*;
import pages.*;

public class ProfileTest {
    private UserData userData = new UserData();

    @Before
    public void setUp(){
        BrowserProperties.setBrowser(BrowserProperties.chromeBrowser);
        Configuration.browserSize = "1920x1080";
        open(ConstantUi.LOGIN_PAGE_URL);
        LoginPage.setAllFieldsLoginForm(userData.getEmail(), userData.getPassword());
        LoginPage.clickSignInButton();
        webdriver().shouldHave(url(ConstantUi.HOME_PAGE_URL));
    }

    @After
    public void tearDown(){
        closeWebDriver();
    }

    @Test
    @DisplayName("Тест перехода в личный кабинет через кнопку в хедере")
    public void goProfilePageTest(){
        MainPage.clickPersonalAccountNavButton();
        webdriver().shouldHave(url(ConstantUi.PROFILE_PAGE_URL));
    }

    @Test
    @DisplayName("Тест перехода в конструктор по кнопке 'Конструктор' из личного кабинета")
    public void goConstructorButtonFromProfilePageTest(){
        MainPage.clickPersonalAccountNavButton();
        webdriver().shouldHave(url(ConstantUi.PROFILE_PAGE_URL));
        ProfilePage.clickConstructorNavButton();
        webdriver().shouldHave(url(ConstantUi.HOME_PAGE_URL));
        MainPage.makeOrderButtonVisibleCheck();
    }

    @Test
    @DisplayName("Тест перехода в конструктор по клику на логотип из личного кабинета")
    public void goConstructorLogoFromProfilePageTest(){
        MainPage.clickPersonalAccountNavButton();
        webdriver().shouldHave(url(ConstantUi.PROFILE_PAGE_URL));
        ProfilePage.clickSiteLogoNav();
        webdriver().shouldHave(url(ConstantUi.HOME_PAGE_URL));
        MainPage.makeOrderButtonVisibleCheck();
    }

    @Test
    @DisplayName("Тест выхода из аккаунта")
    public void logoutFromProfilePageTest(){
        MainPage.clickPersonalAccountNavButton();
        webdriver().shouldHave(url(ConstantUi.PROFILE_PAGE_URL));
        ProfilePage.clickLogoutButton();
        webdriver().shouldHave(url(ConstantUi.LOGIN_PAGE_URL));
    }
}
