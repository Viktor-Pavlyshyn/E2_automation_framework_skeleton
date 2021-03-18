package com.epam.slackintegration;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SlackIntegration {

    public static <T> Response postToSlack(T body) {
        return given().contentType("application/json").body("{\"text\": \"" + body + "\"}")
                .post("https://hooks.slack.com/services/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");
    }
}
