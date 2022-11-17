package pages;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;

public class ProfilePage extends CommonElements{

    private static final SelenideElement logoutButton = $(byXpath("//button[text()='Выход']"));

    @Step("Нажатие на кнопку 'Выход'")
    public static void clickLogoutButton(){
        logoutButton.click();
    }
}
