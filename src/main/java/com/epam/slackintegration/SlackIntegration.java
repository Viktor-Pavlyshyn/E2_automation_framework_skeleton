package com.epam.slackintegration;

import io.restassured.response.Response;

import static com.epam.utils.DataPropLoader.getSlackProperty;
import static io.restassured.RestAssured.given;

public class SlackIntegration {

    public static <T> Response postToSlack(T body) {
        return given().contentType("application/json").body("{\"text\": \"" + body + "\"}")
                .post(getSlackProperty("slack.url")
                        + getSlackProperty("slack.endpoint")
                        + getSlackProperty("slack.key"));
    }
}
