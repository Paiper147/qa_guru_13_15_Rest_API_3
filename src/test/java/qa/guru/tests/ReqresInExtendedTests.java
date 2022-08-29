package qa.guru.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import qa.guru.models.lombok.LoginBodyRequestLombokModel;
import qa.guru.models.pojo.LoginBodyRequestPojoModel;
import qa.guru.models.pojo.LoginBodyResponseLombokModel;

import static helpers.CustomApiListner.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReqresInExtendedTests {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://reqres.in";
    }

    /*
        1. make POST- request to https://reqres.in/api/login
            with body { "email": "eve.holt@reqres.in", "password": "cityslicka" }
        2. get response { "token": "QpwL5tke4Pnpja7X4" }
        3. check token is "QpwL5tke4Pnpja7X4"
     */

    @Test
    void loginTest() {
        String requestBody = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }"; // todo bad practice

        given()
                .filter(withCustomTemplates())
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    void loginWithPojoModelTest() {
        LoginBodyRequestPojoModel requestBodyPojo = new LoginBodyRequestPojoModel();
        requestBodyPojo.setEmail("eve.holt@reqres.in");
        requestBodyPojo.setPassword("cityslicka");

        LoginBodyResponseLombokModel response = given()
                .filter(withCustomTemplates())
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .body(requestBodyPojo)
                .when()
                .post("/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(LoginBodyResponseLombokModel.class);

        //jUnit
        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());
    }

    @Test
    void loginWithLombokModelTest() {
        LoginBodyRequestLombokModel requestBodyLombok = new LoginBodyRequestLombokModel();
        requestBodyLombok.setEmail("eve.holt@reqres.in");
        requestBodyLombok.setPassword("cityslicka");

        LoginBodyResponseLombokModel response = given()
                .filter(withCustomTemplates())
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .body(requestBodyLombok)
                .when()
                .post("/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(LoginBodyResponseLombokModel.class);

        //assertJ
        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }
}
