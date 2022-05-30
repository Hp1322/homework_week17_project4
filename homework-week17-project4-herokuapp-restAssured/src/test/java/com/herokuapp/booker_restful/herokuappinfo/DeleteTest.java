package com.herokuapp.booker_restful.herokuappinfo;

import com.herokuapp.booker_restful.model.HerokuappPojo;
import com.herokuapp.booker_restful.testbase.TestBase;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class DeleteTest extends TestBase {

    @Test
    public void deleteBookingById(){
        String credentials = "admin:password123";
        byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());
        String encoded = new String(encodedCredentials);

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization","Basic "+encoded)
                .pathParam("id",2874)
                .when()
                .delete("/booking/{id}");
        response.prettyPrint();
        response.then().statusCode(201);
    }


}
