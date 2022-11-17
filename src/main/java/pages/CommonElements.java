package pages;

import io.qameta.allure.Step;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class CommonElements {

    private static final SelenideElement constructorNavButton = $(byXpath("//p[text()='Конструктор']"));
    private static final SelenideElement orderFeedNavButton = $(byXpath("//p[text()='Лента Заказов']"));
    private static final SelenideElement siteLogoNav = $(By.className("AppHeader_header__logo__2D0X2"));
    private static final SelenideElement personalAccountNavButton = $(byXpath("//p[text() = 'Личный Кабинет']"));

    @Step("Клик по кнопке 'Конструктор' в навигационной панели")
    public static void clickConstructorNavButton(){
        constructorNavButton.click();
    }

    @Step("Клик по кнопке 'Лента Заказов' в навигационной панели")
    public static void clickOrderFeedNavButton(){
        orderFeedNavButton.click();
    }

    @Step("Клик по логотипу сайта в навигационной панели")
    public static void clickSiteLogoNav(){
        siteLogoNav.click();
    }

    @Step("Клик по кнопке 'Личный Кабинет' в навигационной панели")
    public static void clickPersonalAccountNavButton(){
        personalAccountNavButton.click();
    }
}
