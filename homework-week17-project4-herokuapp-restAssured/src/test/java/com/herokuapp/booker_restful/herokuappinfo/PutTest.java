package com.herokuapp.booker_restful.herokuappinfo;

import com.herokuapp.booker_restful.model.HerokuappPojo;
import com.herokuapp.booker_restful.testbase.TestBase;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PutTest extends TestBase {

    @Test
    public void updateBookingById(){
        String credentials = "admin:password123";
        byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());
        String encoded = new String(encodedCredentials);

        HashMap<Object, Object> dates = new HashMap<>();
        dates.put("checkin", "2018-01-01");
        dates.put("checkout", "2019-01-01");

        HerokuappPojo herokuappPojo = new HerokuappPojo();
        herokuappPojo.setFirstname("James");
        herokuappPojo.setLastname("Brown");
        herokuappPojo.setTotalprice(111);
        herokuappPojo.setDepositpaid(false);
        herokuappPojo.setBookingdates(dates);
        herokuappPojo.setAdditionalneeds("Breakfast");

        Response response = given()
                .header("Content-Type", "application/json")
             //   .header("Authorization","Basic "+encoded)
                .auth().preemptive().basic("admin","password123")
                .body(herokuappPojo)
                .pathParam("id",2874)
                .when()
                .put("/booking/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }


}
