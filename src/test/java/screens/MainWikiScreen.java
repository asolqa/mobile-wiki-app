package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class MainWikiScreen {

    private final SelenideElement mainWikiToolbar = $(id("org.wikipedia.alpha:id/main_toolbar"));
    private final SelenideElement searchContainer = $(id("org.wikipedia.alpha:id/search_container"));
    private final SelenideElement selectSearch = $(accessibilityId("Search Wikipedia"));
    private final SelenideElement searchData = $(id("org.wikipedia.alpha:id/search_src_text"));


    public MainWikiScreen mainToolBarIsDisplayed() {
        mainWikiToolbar.shouldBe(visible);
        return this;
    }

    public MainWikiScreen searchContainerIsDisplayed() {
        searchContainer.shouldBe(visible);
        return this;
    }

    public void searchBarIsDisplayed() {
        searchData.shouldBe(visible);
    }

    @Step("Set {value} for search")
    public ResultScreen setSearchQuery(String value) {
        selectSearch.click();
        searchData.sendKeys(value);
        return page(ResultScreen.class);
    }

}
