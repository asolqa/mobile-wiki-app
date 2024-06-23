package tests;

import data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screens.OnboardingScreen;


@DisplayName("Search on Wiki Tests")
public class WikiSearchTests extends TestBase {
    OnboardingScreen onboardingScreen = new OnboardingScreen();

    @Test
    @DisplayName("Search for data")
    public void appiumSearchTest() {
        onboardingScreen.clickSkipButton()
                .setSearchQuery(TestData.QUERY1)
                .searchResultsAreFound();
    }

    @Test
    @DisplayName("Search and open article")
    public void lombokSearchTest() {
        onboardingScreen.clickSkipButton()
                .setSearchQuery(TestData.QUERY2)
                .descriptionForArticleIsVisible()
                .clickOnArticle()
                .articlePageLayoutIsVisible()
                .articleScreenSearchBarIsVisible()
                .articleImageIsVisible()
                .articleTitleContainsSearchData()
                .articleTabLayoutIsVisible();

    }
}
