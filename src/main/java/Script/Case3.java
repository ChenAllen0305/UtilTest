package Script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;

public class Case3 {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");

        File file = new File("readme.txt");

        // 使用脚本变量来输出
        scriptEngine.put("key4file",file);

        // 直接输出文件路径
        System.out.println(file.getAbsolutePath());

        // 使用脚本输出文件路径
        scriptEngine.eval("print(key4file.getAbsolutePath())");
    }
}
