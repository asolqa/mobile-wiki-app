package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class ArticleScreen {
    public static final String SEARCHED_DATA = "Lombok";
    private final SelenideElement articleSearchBar = $(id("org.wikipedia.alpha:id/page_toolbar_button_search"));
    private final SelenideElement articleImage = $(id("org.wikipedia.alpha:id/view_page_header_image"));
    private final SelenideElement articleTitle = $(className("android.widget.TextView"));
    //private final SelenideElement articleDescription = $x("//android.view.View[@resource-id='pcs-edit-section-title-description']");
    private final SelenideElement articleTabLayout = $(id("org.wikipedia.alpha:id/page_actions_tab_layout"));
    private final SelenideElement articlePageLayout = $(id("org.wikipedia.alpha:id/page_contents_container"));


    @Step("Verify page layout is loaded")
    public ArticleScreen articlePageLayoutIsVisible() {
        articlePageLayout.shouldBe(visible);
        return this;
    }

    @Step("Verify search bar is visible on article screen")
    public ArticleScreen articleScreenSearchBarIsVisible() {
        articleSearchBar.shouldBe(visible);
        return this;
    }

    @Step("Verify image for article is visible on screen")
    public ArticleScreen articleImageIsVisible() {
        articleImage.shouldBe(visible);
        return this;
    }

    @Step("Verify article title contains searched data")
    public ArticleScreen articleTitleContainsSearchData() {
        articleTitle.shouldHave(text(SEARCHED_DATA));
        return this;
    }

    /*@Step("Verify article contains description on the screen")
    public ArticleScreen articleDescriptionIsVisible() {
        articleDescription.shouldBe(visible);
        return this;
    }*/
    
    @Step("Verify tabs are available on article screen")
    @SuppressWarnings("UnusedReturnValue")
    public ArticleScreen articleTabLayoutIsVisible() {
        articleTabLayout.shouldBe(visible);
        return this;
    }


}
