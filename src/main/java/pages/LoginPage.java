package pages;

import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;

public class LoginPage extends CommonElements{

    private static final SelenideElement emailField = $(byXpath("//input[@type='text']"));
    private static final SelenideElement passwordField = $(byXpath("//input[@type='password']"));
    private static final SelenideElement signInButton = $(byXpath("//button[text()='Войти']"));
    private static final SelenideElement signUpLink = $(byXpath("//a[text()='Зарегистрироваться']"));
    private static final SelenideElement restorePasswordLink = $(byXpath("//a[text()='Восстановить пароль']"));

    @Step("Заполнение поля email на странице логина")
    public static void setEmailField(String email){
        emailField.setValue(email);
    }

    @Step("Заполнения поля 'Пароль' на странице логиа")
    public static void setPasswordField(String password){
        passwordField.setValue(password);
    }

    @Step("Клик по кнопке 'Войти' на странице логина")
    public static void clickSignInButton(){
        signInButton.click();
    }

    @Step("Клик по кнопке 'Зарегестрироваться' на странице логина")
    public static void clickSignUpButton(){
        signUpLink.click();
    }

    @Step("Клик по кнопке 'Восстановить пароль'")
    public static void clickRestorePasswordButton(){
        restorePasswordLink.click();
    }

    @Step("Заполнение всех полей для входа")
    public static void setAllFieldsLoginForm(String email, String password){
        setEmailField(email);
        setPasswordField(password);
    }



}
