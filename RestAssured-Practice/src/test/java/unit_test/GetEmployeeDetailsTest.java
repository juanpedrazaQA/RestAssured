package unit_test;

import clients.employeeDetails.response.GetEmployeeDetailsClient;
import clients.employeeDetails.response.GetEmployeeDetailsResponse;
import org.testng.annotations.Test;
import utilities.Categories;
import utilities.Constant;

import static org.testng.Assert.assertEquals;

public class GetEmployeeDetailsTest {

    Constant employeeData;

    GetEmployeeDetailsResponse getEmployeeDetailsResponse = new GetEmployeeDetailsClient().getEmployeeDetails();

    @Test(groups = {Categories.SMOKE})
    public void shouldTestGetEmployeeDetailsStatusCode() {
        assertEquals(getEmployeeDetailsResponse.getHttpStatusCode(), 200);
    }
    @Test(groups = {Categories.SMOKE})
    public void verifyResponseHeadersIsJsonFormat() {
        String contentHeaderType = getEmployeeDetailsResponse.getContentType();
        assertEquals("application/json; charset=UTF-8", contentHeaderType);
    }
    @Test(groups = {Categories.SMOKE})
    public void verifyEmployeeDetailsResponseBody() {
        assertEquals(employeeData.STATUS_CODE_SUCCESS, getEmployeeDetailsResponse.getStatus());
        assertEquals(employeeData.EMPLOYEE_AGE, getEmployeeDetailsResponse.getEmployeeData().get(0).getAge());
        assertEquals(employeeData.EMPLOYEE_ROLE, getEmployeeDetailsResponse.getEmployeeData().get(0).getRole());
        assertEquals(employeeData.EMPLOYEE_DOB, getEmployeeDetailsResponse.getEmployeeData().get(0).getDob());
        assertEquals(employeeData.EMPLOYEE_MESSAGE, getEmployeeDetailsResponse.getMessage());
    }
    @Test(groups = {Categories.SMOKE})
    public void verifyResponseWithCompanyData() {
        assertEquals(employeeData.COMPANY_NAME, getEmployeeDetailsResponse.getEmployeeData().get(0).getCompany());
    }
}
