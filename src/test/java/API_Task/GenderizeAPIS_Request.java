package API_Task;

import io.restassured.RestAssured;
import io.restassured.internal.ResponseParserRegistrar;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class GenderizeAPIS_Request {

    @Test
    public void ValidateFemaleGender(){
        String Name = "Christina";
        String url = "https://api.genderize.io/?name="+ Name;

        Response response = RestAssured.given().get(url);
        response.then().assertThat().body("gender",equalTo("female"));
        System.out.println(response.getBody().asString());
    }

    @Test
    public void ValidateMaleGender(){
        String Name = "fawzy";
        String url = "https://api.genderize.io/?name="+ Name;

        Response response = RestAssured.given().get(url);
        response.then().assertThat().body("gender",equalTo("male"));
        System.out.println("Response code : "+ response.getBody().asString());
    }

}
