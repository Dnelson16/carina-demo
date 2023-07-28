package com.zebrunner.carina.demo.HomeworkTestCases;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JsonPlaceholderAPITests {

    @Test
    public void verifyStatusCodeOfGetAllPostsAPI() {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code is not 200");
    }
    @Test
    public void verifyTitleOfSpecificPost() {
        int postId = 1;
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/" + postId);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code is not 200");

        String expectedTitle = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
        String actualTitle = response.jsonPath().getString("title");
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match the expected value");
    }
    @Test
    public void verifyCreationOfNewPost() {

        String requestBody = "{ \"title\": \"Test Post\", \"body\": \"This is a test post.\", \"userId\": 1 }";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("https://jsonplaceholder.typicode.com/posts");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201, "Status code is not 201 (Created)");

        String expectedTitle = "Test Post";
        String actualTitle = response.jsonPath().getString("title");
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match the expected value");
    }
    @Test
    public void verifyStatusCodeOfGetSinglePostAPI() {
        int postId = 30;
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/" + postId);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code is not 200");
    }
    @Test
    public void verifyNumberOfCommentsForPost() {
        int postId = 20;
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/" + postId + "/comments");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code is not 200");

        int expectedCommentCount = 5;
        int actualCommentCount = response.jsonPath().getList("$").size();
        Assert.assertEquals(actualCommentCount, expectedCommentCount, "Number of comments does not match the expected value");
    }
}






