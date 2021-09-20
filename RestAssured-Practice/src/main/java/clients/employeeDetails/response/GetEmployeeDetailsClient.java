package clients.employeeDetails.response;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import properties.SampleApiProperties;

import static io.restassured.RestAssured.given;

public class GetEmployeeDetailsClient {

    GetEmployeeDetailsResponse getEmployeeDetailsResponse;
    String url = String.format("%s/apitest", SampleApiProperties.baseUrl);

    public GetEmployeeDetailsResponse getEmployeeDetails() {
        try {
            Response response = given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get(url);

            JsonPath js = new JsonPath(response.asString());

            getEmployeeDetailsResponse = response.as(GetEmployeeDetailsResponse.class);
            getEmployeeDetailsResponse.setHttpStatusCode(response.getStatusCode());
            getEmployeeDetailsResponse.setContentType(response.header("Content-Type"));
            getEmployeeDetailsResponse.getEmployeeData().get(0).setAge(js.getString("employeeData[0].age"));
            getEmployeeDetailsResponse.getEmployeeData().get(0).setRole(js.getString("employeeData[0].role"));
            getEmployeeDetailsResponse.getEmployeeData().get(0).setDob(js.getString("employeeData[0].dob"));

        } catch (Exception e) {
            System.out.println("Something went wrong " + e.getStackTrace());
        }
        return getEmployeeDetailsResponse;
    }
}
