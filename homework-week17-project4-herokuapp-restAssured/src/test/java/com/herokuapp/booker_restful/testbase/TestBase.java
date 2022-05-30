package com.herokuapp.booker_restful.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Created by Harsh Patel
 */
public class TestBase {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

    }
}
