//package homeOld.tests;
//
//import homeOld.lombokModels.CreateRequestBody;
//import homeOld.lombokModels.CreateResponseBody;
//import homeOld.lombokModels.UserData;
//import io.restassured.http.ContentType;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static io.restassured.RestAssured.given;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class HomeReqresTestsPOJO {
//    private final static String URL = "https://reqres.in/";
//
//    @Test
//    void checkMichaelUserEmail() {
//        List<UserData> users = given()
//                .log().uri()
//                .when()
//                .contentType(ContentType.JSON)
//                .get(URL + "api/users?page=2")
//                .then()
//                .log().status()
//                .log().body()
////                .statusCode(200)
//                .extract().body().jsonPath().getList("data", UserData.class);
//        System.out.println("user");
//    }
//
//    @Test
//    void checkSuccessfulCreate(){
//        String name = "morpheus";
//        String job = "leader";
//        String id = "323";
//        String createdAt = "2022-07-28T13:07:55.460Z";
//
//        CreateRequestBody createRequestBody = new CreateRequestBody("morpheus", "leader");
//        CreateResponseBody responseBody = given()
//                .log().uri()
//                .log().body()
//                .when()
//                .contentType(ContentType.JSON)
//                .body(createRequestBody)
//                .post(URL + "api/users")
//                .then()
//                .log().all()
//                .extract().as(CreateResponseBody.class);
//        assertEquals(name, responseBody.getName());
//        assertEquals(job, responseBody.getJob());
//        assertEquals(id, responseBody.getId());
//        assertEquals(createdAt, responseBody.getCreatedAt());
//
//    }
//}
