package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class MainWikiScreen {

    private final SelenideElement mainWikiLogo = $(id("org.wikipedia.alpha:id/main_toolbar_wordmark"));
    private final SelenideElement mainWikiToolbar = $(id("org.wikipedia.alpha:id/main_toolbar"));
    private final SelenideElement searchContainer = $(id("org.wikipedia.alpha:id/search_container"));
    private final SelenideElement selectSearch = $(accessibilityId("Search Wikipedia"));
    private final SelenideElement searchData = $(id("org.wikipedia.alpha:id/search_src_text"));


    @Step("Verify Wiki logo on main screen is visible")
    public MainWikiScreen mainWikiLogoIsDisplayed() {
        mainWikiLogo.shouldBe(visible);
        return this;
    }

    @Step("Verify toolbar on main screen is visible")
    public MainWikiScreen mainToolBarIsDisplayed() {
        mainWikiToolbar.shouldBe(visible);
        return this;
    }

    @Step("Verify search bar on main screen is visible")
    public void searchContainerIsDisplayed() {

        searchContainer.shouldBe(visible);
    }

    @Step("Set '{value}' for search")
    public ResultScreen setSearchQuery(String value) {
        selectSearch.click();
        searchData.sendKeys(value);
        return page(ResultScreen.class);
    }

}
