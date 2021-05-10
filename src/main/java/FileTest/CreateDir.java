package FileTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.system.ApplicationHome;

import java.io.File;

/**
 * ClassName: CreateDir
 * Author: ChenLun
 * date: 2021/4/30
 * Description:
 */
@Slf4j
public class CreateDir {
    public static void main(String[] args) {
        String rootPath = getBaseJarPath().getAbsolutePath();
//        File tempFile = new File(rootPath + File.separator + "image");
        File tempFile = new File(rootPath + File.separator + "tempImage");
        if (!tempFile.exists()) {
            if (!tempFile.mkdir()) {
//                log.error();
                System.out.println("创建临时目录失败");
            }
        }
        System.out.println(tempFile.getAbsolutePath());
    }

    private static File getBaseJarPath() {
        ApplicationHome home = new ApplicationHome(CreateDir.class);
        File jarFile = home.getSource();
        return jarFile.getParentFile();
    }
}
