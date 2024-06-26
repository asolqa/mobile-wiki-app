package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screens.OnboardingScreen;

import static io.qameta.allure.Allure.step;

@DisplayName("Wiki Onboarding Walkthrough Test")
public class WikiOnboardingWalkThroughTest extends TestBase {
    OnboardingScreen onboardingScreen = new OnboardingScreen();

    @SuppressWarnings("CodeBlock2Expr")
    @Test
    @DisplayName("Verify onboarding flow and screens")
    public void onboardingScreensTest() {

        step("Verify 1st onboarding screen and continue", () -> {
            onboardingScreen.checkHeaderText("The Free Encyclopedia")
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
                    .mainWikiLogoIsDisplayed()
                    .mainToolBarIsDisplayed()
                    .searchContainerIsDisplayed();
        });

    }
}
