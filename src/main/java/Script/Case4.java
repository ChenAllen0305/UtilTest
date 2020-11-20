package Script;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Case4 {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();

        ScriptEngine engine = scriptEngineManager.getEngineByName("JavaScript");

        String script = "function hello(name){print('Hello, ' + name);}";

        String js = "var object = new Object(); object.hello = function(name) {print( name );}";

        engine.eval(js);
//        engine.eval(script);

        Invocable inv = (Invocable) engine;

        Object obj = engine.get("object");

//        inv.invokeFunction("hello", "son");

        inv.invokeMethod(obj, "hello", "son2");
    }
}
