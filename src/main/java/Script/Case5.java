package Script;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Case5 {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        String js = "function run(){print('hello, son')}";

        engine.eval(js);

        Invocable invocable = (Invocable) engine;

        Runnable runnable = invocable.getInterface(Runnable.class);

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
