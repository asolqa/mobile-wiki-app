package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;
import static io.appium.java_client.AppiumBy.id;

public class ResultScreen {
    private final ElementsCollection searchResults = $$(id("org.wikipedia.alpha:id/page_list_item_title"));
    private final SelenideElement resultDescription = $(id("org.wikipedia.alpha:id/page_list_item_description"));

    @Step("Verify results are available")
    public void searchResultsAreFound() {
        searchResults.shouldHave(sizeGreaterThan(0));
    }

    @Step("Verify article description is visible")
    public ResultScreen descriptionForArticleIsVisible() {
        resultDescription.shouldBe(visible);
        return this;
    }

    @Step("Click on article from results")
    public ArticleScreen clickOnArticle() {
        resultDescription.click();
        return page(ArticleScreen.class);
    }

}
