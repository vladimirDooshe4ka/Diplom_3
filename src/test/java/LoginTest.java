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
import pages.RegistrationPage;
import pages.MainPage;
import pages.LoginPage;
import pages.ForgotPasswordPage;

public class LoginTest {
    private UserData userData = new UserData();

    @Before
    public void setUp(){
        BrowserProperties.setBrowser(BrowserProperties.chromeBrowser);
        Configuration.browserSize = "1920x1080";
    }

    @After
    public void tearDown(){
        closeWebDriver();
    }

    @Test
    @DisplayName("Тест логина по кнопке 'Войти в аккаунт' на главной странице")
    public void loginUserSignInMainPageButtonTest(){
        open(ConstantUi.HOME_PAGE_URL);
        MainPage.clickSignInButton();
        webdriver().shouldHave(url(ConstantUi.LOGIN_PAGE_URL));
        LoginPage.setAllFieldsLoginForm(userData.getEmail(), userData.getPassword());
        LoginPage.clickSignInButton();
        webdriver().shouldHave(url(ConstantUi.HOME_PAGE_URL));
        MainPage.makeOrderButtonVisibleCheck();

    }

    @Test
    @DisplayName("Тест логина по кнопке 'Личный кабинет' в хедере")
    public void loginUserSignInHeaderButtonTest(){
        open(ConstantUi.HOME_PAGE_URL);
        MainPage.clickPersonalAccountNavButton();
        webdriver().shouldHave(url(ConstantUi.LOGIN_PAGE_URL));
        LoginPage.setAllFieldsLoginForm(userData.getEmail(), userData.getPassword());
        LoginPage.clickSignInButton();
        webdriver().shouldHave(url(ConstantUi.HOME_PAGE_URL));
        MainPage.makeOrderButtonVisibleCheck();
    }

    @Test
    @DisplayName("Тест логина через кнопку в форме регистрации")
    public void loginUserSignInRegistrationPageButtonTest(){
        open(ConstantUi.REGISTRATION_PAGE_URL);
        RegistrationPage.clickSignInLink();
        webdriver().shouldHave(url(ConstantUi.LOGIN_PAGE_URL));
        LoginPage.setAllFieldsLoginForm(userData.getEmail(), userData.getPassword());
        LoginPage.clickSignInButton();
        webdriver().shouldHave(url(ConstantUi.HOME_PAGE_URL));
        MainPage.makeOrderButtonVisibleCheck();

    }

    @Test
    @DisplayName("Тест логина черещ кнопку в форме восстановления пароля")
    public void loginUserSignInForgotPasswordPageButtonTest(){
        open(ConstantUi.FORGOT_PASSWORD_PAGE_URL);
        ForgotPasswordPage.clickSignInLink();
        webdriver().shouldHave(url(ConstantUi.LOGIN_PAGE_URL));
        LoginPage.setAllFieldsLoginForm(userData.getEmail(), userData.getPassword());
        LoginPage.clickSignInButton();
        webdriver().shouldHave(url(ConstantUi.HOME_PAGE_URL));
        MainPage.makeOrderButtonVisibleCheck();
    }
}
