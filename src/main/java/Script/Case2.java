package Script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;

public class Case2 {
    public static void main(String[] args) throws FileNotFoundException, ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();

        ScriptEngine engine = scriptEngineManager.getEngineByName("JavaScript");

        String jsText = null;
        CharBuffer cbuf = null;
        String jsFilePath = "D://case.txt";
        File file = new File(jsFilePath);
        FileReader fileReader = null;

        try{
            fileReader = new FileReader(file);
            cbuf = CharBuffer.allocate((int) file.length());
            fileReader.read(cbuf);
            jsText = new String(cbuf.array());
            System.out.println(jsText);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
