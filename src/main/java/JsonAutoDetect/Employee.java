package JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * ClassName: Employee
 * Author: ChenLun
 * date: 2021/7/5
 * Description:
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Employee {
    private String name;
    private String dept;
    private String address;

    public static Employee of(String name, String dept, String address) {
        Employee e = new Employee();
        e.name = name;
        e.dept = dept;
        e.address = address;
        return e;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}