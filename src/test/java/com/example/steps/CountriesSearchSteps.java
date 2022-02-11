package com.example.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.is;

public class CountriesSearchSteps {
    private String ISO_CODE_SEARCH = "http://localhost:8080/cookie";
    private Response response;

    @Step
    public void searchCountryByCode(String code){
        response = SerenityRest.when().get(ISO_CODE_SEARCH + code);
    }

    @Step
    public void searchIsExecutedSuccesfully(){
        //response.htmlPath().getString()
        //response.getCookies()
        response.then().statusCode(200);
    }

    @Step
    public void iShouldFindCountry(String country){
        response.then().body("RestResponse.result.name", is(country));
    }
}