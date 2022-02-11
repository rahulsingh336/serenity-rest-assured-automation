package com.example.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.is;

public class CountriesSearchSteps {
    private String ISO_CODE_SEARCH = "https://www.boredapi.com/api/activity";
    private Response response;

    @Step
    public void searchCountryByCode(String code){
        response = SerenityRest.when().get(ISO_CODE_SEARCH);
    }

    @Step
    public void searchIsExecutedSuccesfully(){
        //response.htmlPath().getString()
        //response.getCookies()
        response.then().statusCode(200);
    }

    @Step
    public void iShouldFindCountry(String country){
        //response.then().body("RestResponse.result.name", is(country));
    }
}
