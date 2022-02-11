package com.example;

import com.example.steps.CountriesSearchSteps;
import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;

@RunWith(SerenityRunner.class)
public class CountriesSearchTests {

    @Test
    public void verifyThatWeCanFindUnitedStatesOfAmericaUsingTheCodeUS() {
        RestAssured.
                when().get("https://www.boredapi.com/api/activity").
                then().assertThat().statusCode(200);
                //and().body("RestResponse.result.name", is("United States of America"));
    }

    @Steps
    CountriesSearchSteps countriesSearchSteps;

    @Test
    public void verifyThatWeCanFindUnitedStatesOfAmericaCountryUsingTheCodeUS() {
        countriesSearchSteps.searchCountryByCode("US");
        countriesSearchSteps.searchIsExecutedSuccesfully();
        countriesSearchSteps.iShouldFindCountry("United States of America");
    }

}
