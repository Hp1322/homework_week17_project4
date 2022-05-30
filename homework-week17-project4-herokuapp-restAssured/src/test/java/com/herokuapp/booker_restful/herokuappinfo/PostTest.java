package com.herokuapp.booker_restful.herokuappinfo;

import com.herokuapp.booker_restful.model.HerokuappPojo;
import com.herokuapp.booker_restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;


import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class PostTest extends TestBase {

    @Test
    public void createNewBooking() {
        HashMap<Object, Object> dates = new HashMap<>();
        dates.put("checkin", "2018-01-01");
        dates.put("checkout", "2019-01-01");

        HerokuappPojo herokuappPojo = new HerokuappPojo();
        herokuappPojo.setFirstname("Jim");
        herokuappPojo.setLastname("Brown");
        herokuappPojo.setTotalprice(111);
        herokuappPojo.setDepositpaid(true);
        herokuappPojo.setBookingdates(dates);
        herokuappPojo.setAdditionalneeds("Breakfast");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(herokuappPojo)
                .when()
                .post("/booking");
        response.prettyPrint();
        response.then().statusCode(200);

    }

}
