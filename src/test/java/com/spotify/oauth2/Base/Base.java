package com.spotify.oauth2.Base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Base {


    public static RequestSpecification reqSpecBuilder() {
        return new RequestSpecBuilder()
                .setBaseUri("https://api.spotify.com/")
                .setBasePath("v1/")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();
    }

    public static ResponseSpecification resSpecBuilder(){
    return new ResponseSpecBuilder()
            //    .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();

    }

}
