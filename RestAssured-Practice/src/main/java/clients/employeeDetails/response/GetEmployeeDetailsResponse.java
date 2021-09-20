package clients.employeeDetails.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetEmployeeDetailsResponse extends BaseResponse{
    private List<EmployeeData> employeeData;

    private String message;

    private String status;

    private String contentType;

}
