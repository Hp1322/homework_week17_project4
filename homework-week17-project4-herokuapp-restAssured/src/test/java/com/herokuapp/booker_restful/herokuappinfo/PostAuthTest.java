package com.herokuapp.booker_restful.herokuappinfo;

import com.herokuapp.booker_restful.model.HerokuappPojo;
import com.herokuapp.booker_restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class PostAuthTest extends TestBase {

    @Test
    public void createAuth() {
        HerokuappPojo herokuappPojo = new HerokuappPojo();
        herokuappPojo.setUsername("admin");
        herokuappPojo.setPassword("password123");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(herokuappPojo)
                .when()
                .post("/auth");
        response.prettyPrint();
        response.then().statusCode(200);
    }

}
