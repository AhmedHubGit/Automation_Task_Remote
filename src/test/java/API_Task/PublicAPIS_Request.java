package API_Task;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.ArrayList;


public class PublicAPIS_Request {

    @Test
    public void CheckResponseCode() {
        RestAssured.baseURI = "https://api.publicapis.org";
        RestAssured.basePath = "/entries";
        RestAssured.given().get().then().assertThat().statusCode(200);
        System.out.println("request being processed successfully at the server");
    }

    @Test
    public void CountAllRecords() {
        RestAssured.baseURI = "https://api.publicapis.org";
        RestAssured.basePath = "/entries";

        Response response = RestAssured.given().contentType(ContentType.JSON).log().all().get("");
        JsonPath extractor = response.jsonPath();
        int count = extractor.get("count");
        System.out.println("\n" + "Total number of Records in request : " + count);
    }

    @Test
    public void GetALlvaluesInRequest() {
        RestAssured.baseURI = "https://api.publicapis.org";
        RestAssured.basePath = "/entries";

        Response response = RestAssured.given().contentType(ContentType.JSON).log().all().get("");
        response.prettyPrint();
    }

    @Test
    public void GetCertainValueFromRequest() {
        RestAssured.baseURI = "https://api.publicapis.org";
        RestAssured.basePath = "/entries";

        Response response = RestAssured.given().contentType(ContentType.JSON).log().all().get("");
        JsonPath extractor = response.jsonPath();
        ArrayList<String> Category = extractor.get("entries.Category");
        System.out.println("\n" + "Total number of Category parameter used : " + Category.size());
        String formattedString = Category.toString()
                .replace(",", "\n")
                .trim();
        System.out.println("\n" + "API Values are : " + formattedString);
    }

    @Test
    public void getParamterValueNumber() {
        String url = "https://api.publicapis.org/entries";
        String categoryValue="Animals";
        Response response = RestAssured.given().get(url);
        JsonPath js = new JsonPath(response.asString());
        for (Integer i = 0; i < 1500; i++)
        {
            String x = js.get("entries[" + Integer.toString(i) + "].Category");

            if (!(x.contains(categoryValue)))
            {
                System.out.println("Total value = " + i);
                break;
            }
        }

    }
}


