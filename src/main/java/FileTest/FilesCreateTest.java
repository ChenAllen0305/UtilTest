package FileTest;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static FileTest.CreateDir.getBaseJarPath;

/**
 * ClassName: FilesCreateTest
 * Author: ChenLun
 * date: 2021/8/17
 * Description:
 */
@Slf4j
public class FilesCreateTest {
    public static void main(String[] args) {
        String rootPath = getBaseJarPath().getAbsolutePath();
        log.info(rootPath);
        String filePath = rootPath + File.separator + "tempImage.txt";
        Path path = Paths.get(filePath);
        try {
//            Files.createFile(path);
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
