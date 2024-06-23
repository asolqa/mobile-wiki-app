package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;


@DisplayName("Search Tests")
@Disabled
public class WikiAppSearchTests_withoutPO extends TestBase {

    @Test
    @DisplayName("Search for article")
    void appiumSearchTest() {

        step("Skip onboarding", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());

        step("Type data for search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Open and verify article")
    void lombokSearchTest() {

        step("Skip onboarding", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());

        step("Type data for search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Lombok");
        });

        step("Verify list of found items contain needed data", () -> {
            $(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(text("Lombok"));
        });

        step("Verify first found item contains description", () -> {
            $(id("org.wikipedia.alpha:id/page_list_item_description"))
                    .shouldBe(visible);
        });

        step("Open an article", () ->
                $(id("org.wikipedia.alpha:id/page_list_item_title")).click());

        step("Verify opened article has а search bar", () -> {
            $(id("org.wikipedia.alpha:id/page_toolbar_button_search"))
                    .shouldBe(visible);
        });

        step("Verify opened article has a photo available", () -> {
            $(id("org.wikipedia.alpha:id/view_page_header_image"))
                    .shouldBe(visible);
        });

        step("Verify opened article has title and description", () -> {
            $(className("android.view.View"))
                    .shouldHave(text("Lombok"));
            $x("//android.view.View[@resource-id='pcs-edit-section-title-description']")
                    .shouldBe(visible);
        });

        step("Verify opened article contains tabs layout", () -> {
            $(id("org.wikipedia.alpha:id/page_actions_tab_layout"))
                    .shouldBe(visible);
        });

    }
}
