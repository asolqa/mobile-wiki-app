package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screens.OnboardingScreen;

import static io.qameta.allure.Allure.step;

public class WikiOnboardingWalkThroughTest extends TestBase {
    OnboardingScreen onboardingScreen = new OnboardingScreen();

    @Test
    @DisplayName("Verify onboarding flow and screens")
    public void onboardingScreensTest() {

        step("Verify 1st onboarding screen and continue", () -> {
            onboardingScreen.checkHeaderText("The Free Encyclopedia …in over 300 languages")
                    .skipButtonIsDisplayed()
                    .continueButtonIsDisplayed()
                    .clickContinueButton();
        });

        step("Verify 2nd onboarding screen and continue", () -> {
            onboardingScreen.checkHeaderText("New ways to explore")
                    .skipButtonIsDisplayed()
                    .continueButtonIsDisplayed()
                    .clickContinueButton();
        });

        step("Verify 3rd onboarding screen and continue", () -> {
            onboardingScreen.checkHeaderText("Reading lists with sync")
                    .skipButtonIsDisplayed()
                    .continueButtonIsDisplayed()
                    .clickContinueButton();
        });

        step("Verify 4th onboarding screen and move to main Wiki screen", () -> {
            onboardingScreen.checkHeaderText("Data & Privacy")
                    .getStartedButtonIsDisplayed()
                    .clickGetStartedButton()
                    .mainToolBarIsDisplayed()
                    .searchContainerIsDisplayed()
                    .searchBarIsDisplayed();
        });

    }
}
