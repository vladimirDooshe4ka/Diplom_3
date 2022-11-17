import Data.UserData;
import Data.UserDataGenerate;
import com.codeborne.selenide.Configuration;
import configuration.BrowserProperties;
import constants.ConstantUi;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.RegistrationPage;
import client.UserClient;

import static com.codeborne.selenide.WebDriverConditions.*;
import static com.codeborne.selenide.Selenide.*;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.hamcrest.Matchers.equalTo;

public class RegistrationTest {
    private UserClient userClient;
    private UserData userData;
    private String token;
    private String emailTest;
    private String passwordTest;



    @Before
    public void  setUp() {
        userData = new UserData();
        userClient = new UserClient();
        BrowserProperties.setBrowser(BrowserProperties.chromeBrowser);
        Configuration.browserSize = "1920x1080";
        open(ConstantUi.REGISTRATION_PAGE_URL);
    }

    @After
    public void tearDown(){
        userData.setEmail(emailTest);
        userData.setPassword(passwordTest);
        token = userClient.loginUser(userData)
                .extract()
                .path("accessToken");
        if (token != null) {
            userClient.deleteUser(token)
                    .assertThat()
                    .statusCode(SC_ACCEPTED)
                    .body("success", equalTo(true));
        }
        closeWebDriver();
    }


    @Test
    @DisplayName("Тест успешной регистрации пользователя")
    public void signUpUserWithValidDataTest(){
        emailTest = UserDataGenerate.getRandomEmail(10);
        passwordTest = UserDataGenerate.getRandomPassword(10);
        RegistrationPage.setAllFieldsRegistrationForm(UserDataGenerate.getRandomName(10), emailTest, passwordTest);
        RegistrationPage.clickSignUpButtonRegistration();
        webdriver().shouldHave(url(ConstantUi.LOGIN_PAGE_URL));
    }

    @Test
    @DisplayName("Тест ошибки заполнения поля 'Пароль' при регистрации пользователя")
    public void signUpUserWithIncorrectPasswordTest(){

        emailTest = UserDataGenerate.getRandomEmail(10);
        passwordTest = UserDataGenerate.getRandomPassword(4);
        RegistrationPage.setAllFieldsRegistrationForm(UserDataGenerate.getRandomName(10), emailTest, passwordTest);
        RegistrationPage.clickSignUpButtonRegistration();
        RegistrationPage.incorrectPasswordMassageVisibleCheck();
    }

}
