package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage extends CommonElements{

    private static final SelenideElement nameField =  $(byXpath("//fieldset[1]//input"));
    private static final SelenideElement emailField = $(byXpath("//fieldset[2]//input"));
    private static final SelenideElement passwordField = $(byXpath("//fieldset[3]//input"));
    private static final SelenideElement signUpButton = $(byXpath("//button[text()='Зарегистрироваться']"));
    private static final SelenideElement signInLink = $(byXpath("//a[text()='Войти']"));
    private static final SelenideElement incorrectPasswordMassage = $(byXpath("//p[text()='Некорректный пароль']"));

    @Step("Проверка появления сообщение о некорректном пароле")
    public static void incorrectPasswordMassageVisibleCheck(){
        incorrectPasswordMassage.shouldBe(Condition.visible);
    }

    @Step("Заполнение поля 'Имя' на странице регистрации")
    public static void setNameFieldRegistration(String name){
        nameField.setValue(name);
    }

    @Step("Заполнение поля 'Email' на странице регистрации")
    public static void setEmailFieldRegistration(String email){
        emailField.setValue(email);
    }

    @Step("Заполнение поля 'Пароль' на странице регистрации")
    public static void setPasswordFieldRegistration(String password){
        passwordField.setValue(password);
    }

    @Step("Клик по кнопке 'Зарегестрироваться' на странице регистрации")
    public static void clickSignUpButtonRegistration(){
        signUpButton.click();
    }

    @Step("Клик по кнопке 'Войти' на странице регистрации")
    public static void clickSignInLink(){
        signInLink.click();
    }

    @Step("Заполнения всех полей для регистрации")
    public static void setAllFieldsRegistrationForm(String name, String email, String password){
        setNameFieldRegistration(name);
        setEmailFieldRegistration(email);
        setPasswordFieldRegistration(password);
    }


}
