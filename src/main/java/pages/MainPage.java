package pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class MainPage extends CommonElements{

    private static final SelenideElement signInButton = $(byXpath("//button[text()='Войти в аккаунт']"));
    private static final SelenideElement makeOrderButton = $(By.xpath("//button[text()='Оформить заказ']"));
    private static final SelenideElement bunSectionButtonActive = $(byXpath("//span[text()='Булки']"));
    private static final SelenideElement saucesSectionButtonActive = $(byXpath("//span[text()='Соусы']"));
    private static final SelenideElement fillingSectionButtonActive = $(byXpath("//span[text()='Начинки']"));
    private static final SelenideElement bunSectionSelected = $(byXpath("//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span[text()='Булки']"));
    private static final SelenideElement saucesSectionSelected = $(byXpath("//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span[text()='Соусы']"));
    private static final SelenideElement fillingSectionSelected = $(byXpath("//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span[text()='Начинки']"));


    @Step("Клик по кнопке 'Войти в аккаунт' на главной странице")
    public static void clickSignInButton(){
        signInButton.click();
    }

    @Step("Проверка что кнопка 'Оформить заказ' видна")
    public static void makeOrderButtonVisibleCheck(){
        makeOrderButton.shouldBe(Condition.visible);
    }

    @Step("Клик по разделу 'Булки' в конструкторе")
    public static void clickBunSectionButtonActive(){
        bunSectionButtonActive.click();
    }

    @Step("Клик по разделу 'Соусы' в конструкторе")
    public static void clickSaucesSectionButtonActive(){
        saucesSectionButtonActive.click();
    }

    @Step("Клик по разделу 'Начинка ' в конструкторе")
    public static void clickFillingSectionButtonActive(){
        fillingSectionButtonActive.click();
    }

    @Step("Проверка выбранного раздела 'Булки'")
    public static boolean bunSectionSelectedIsDisplayed(){
        return bunSectionSelected.isDisplayed();
    }

    @Step("Проверка выбранного раздела 'Соусы'")
    public static boolean saucesSectionSelectedIsDisplayed(){
        return saucesSectionSelected.isDisplayed();
    }

    @Step("Проверка выбранного раздела 'Начинка'")
    public static boolean fillingSectionSelectedIsDisplayed(){
        return fillingSectionSelected.isDisplayed();
    }

}
