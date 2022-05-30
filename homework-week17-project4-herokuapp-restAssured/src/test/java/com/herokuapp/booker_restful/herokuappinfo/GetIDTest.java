package com.herokuapp.booker_restful.herokuappinfo;

import com.herokuapp.booker_restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetIDTest extends TestBase {

    @Test
    public void getBookingIds(){
        Response response = given()
                .pathParam("id",2003)
                .when()
                .get("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
