package helpers;

import config.ConfigsHolder;
import config.Credentials;

import static io.restassured.RestAssured.given;


public class BrowserstackHelper {

    private static final Credentials CREDENTIALS = ConfigsHolder.INSTANCE.credentials();

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(CREDENTIALS.username(), CREDENTIALS.userKey())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
