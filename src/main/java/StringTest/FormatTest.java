package StringTest;

/**
 * ClassName: FormatTest
 * Author: ChenLun
 * date: 2021/4/27
 * Description:
 */
public class FormatTest {
    public static void main(String[] args) {

        String tempPath = "http://10.7.1.46:9000/minio/tbea/bd4b955f-06cb-4e19-b512-f5a5427c9960/product/222.jpg";
        String tenantCode = "newCompany";
        String seq = "123123";
        String expandName = "JPG";
//        String tempPath = String.format("%s/%s.%s", tenantCode, seq, expandName);
        String moduleName = "product";
        String fileName = tempPath.substring(tempPath.lastIndexOf("/") + 1);
        String objectKey = String.format("%s/%s/%s", tenantCode, moduleName, fileName);
        System.out.println(objectKey);
    }
}
