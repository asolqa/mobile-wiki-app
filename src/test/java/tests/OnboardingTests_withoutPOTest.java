package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@DisplayName("Onboarding Tests")
@Disabled
public class OnboardingTests_withoutPOTest extends TestBase {
    @Test
    @DisplayName("Wiki Onboarding screens walkthrough")
    void wikiScreensWalkthroughTest() {

        step("Verify 1st screen and continue", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("Verify 2nd screen and continue", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("Verify 3rd screen and continue", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("Verify 4th screen and get started", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Data & Privacy"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
        });

        step("Verify Wiki main page is opened", () -> {
            $(id("org.wikipedia.alpha:id/main_toolbar"))
                    .shouldBe(visible);
            $(id("org.wikipedia.alpha:id/search_container")).shouldBe(visible);
        });


    }
}
