package JsonAutoDetect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ClassName: EmployeeMain
 * Author: ChenLun
 * date: 2021/7/5
 * Description:
 */
public class EmployeeMain {
    public static void main(String[] args) throws JsonProcessingException {
        Employee employee = Employee.of("Trish", "Manager", "The Moon");
        ObjectMapper om = new ObjectMapper();

        String jsonStr = om.writeValueAsString(employee);
        System.out.println("jsonStr:" + jsonStr);

        Employee e = om.readValue(jsonStr, Employee.class);
        System.out.println(e);
    }
}
