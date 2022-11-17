package pages;

import io.qameta.allure.Step;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage extends CommonElements{

    private static final SelenideElement emailField = $(byXpath("//input"));
    private static final SelenideElement restorePasswordButton = $(byXpath("//button[text()='Восстановить']"));
    private static final SelenideElement signInLink = $(byXpath("//a[text()='Войти']"));

    @Step("Заполнение поля 'Email'")
    public static void setEmailField(String email){
        emailField.setValue(email);
    }

    @Step("Нажатие на кнопку 'Восстановить пароль'")
    public static void clickRestorePasswordButton(){
        restorePasswordButton.click();
    }

    @Step("Нажатие на ссылку 'Войти'")
    public static void clickSignInLink(){
        signInLink.click();
    }
}
