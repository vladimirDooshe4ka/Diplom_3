import Data.UserData;
import com.codeborne.selenide.Configuration;
import configuration.BrowserProperties;
import constants.ConstantUi;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import static org.junit.Assert.*;

import static com.codeborne.selenide.WebDriverConditions.*;
import static com.codeborne.selenide.Selenide.*;

public class ConstructorPageTest {
    private UserData userData;

    @Before
    public void setUp(){
        BrowserProperties.setBrowser(BrowserProperties.chromeBrowser);
        Configuration.browserSize = "1920x1080";
        open(ConstantUi.HOME_PAGE_URL);
    }

    @After
    public void tearDown(){
        closeWebDriver();
    }

    @Test
    @DisplayName("Тест перехода к разделу 'Булки'")
    public void bunSectionSelectedTest(){
        if(MainPage.bunSectionSelectedIsDisplayed()){
            MainPage.clickSaucesSectionButtonActive();
            assertFalse(MainPage.bunSectionSelectedIsDisplayed());
        }
        MainPage.clickBunSectionButtonActive();
        assertTrue(MainPage.bunSectionSelectedIsDisplayed());
    }

    @Test
    @DisplayName("Тест перехода к разделу 'Соусы'")
    public void sauceSelectionSelectedTest(){
        if(MainPage.saucesSectionSelectedIsDisplayed()){
            MainPage.clickBunSectionButtonActive();
            assertFalse(MainPage.saucesSectionSelectedIsDisplayed());
        }
        MainPage.clickSaucesSectionButtonActive();
        assertTrue(MainPage.saucesSectionSelectedIsDisplayed());
    }

    @Test
    @DisplayName("Тест перехода к разделу 'Начинка'")
    public void fillingSelectionSelectedTest(){
        if (MainPage.fillingSectionSelectedIsDisplayed()){
            MainPage.clickSaucesSectionButtonActive();
            assertFalse(MainPage.fillingSectionSelectedIsDisplayed());
        }
        MainPage.clickFillingSectionButtonActive();
        assertTrue(MainPage.fillingSectionSelectedIsDisplayed());
    }
}
