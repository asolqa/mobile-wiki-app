package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static io.appium.java_client.AppiumBy.id;

public class OnboardingScreen {
    private final SelenideElement continueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));
    private final SelenideElement skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"));
    private final SelenideElement getStartedButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button"));
    private final SelenideElement primaryText = $(id("org.wikipedia.alpha:id/primaryTextView"));


    @Step("Verify Continue button is visible")
    public OnboardingScreen continueButtonIsDisplayed() {
        continueButton.shouldBe(visible);
        return this;
    }

    @Step("Verify Skip button is visible")
    public OnboardingScreen skipButtonIsDisplayed() {
        skipButton.shouldBe(visible);
        return this;
    }

    @Step("Verify Get Started button is visible")
    public OnboardingScreen getStartedButtonIsDisplayed() {
        getStartedButton.shouldBe(visible);
        return this;
    }

    @Step("Click on Continue button")
    public void clickContinueButton() {
        continueButton.click();
    }

    @Step("Click on Skip button")
    public MainWikiScreen clickSkipButton() {
        skipButton.click();
        return page(MainWikiScreen.class);
    }

    @Step("Click on Get Started button")
    public MainWikiScreen clickGetStartedButton() {
        getStartedButton.click();
        return page(MainWikiScreen.class);
    }

    @Step("Verify {expectedText} is visible")
    public OnboardingScreen checkHeaderText(String expectedText) {
        primaryText.shouldHave(text(expectedText));
        return this;
    }


}
