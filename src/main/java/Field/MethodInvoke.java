package Field;

import Domain.Cat;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射访问构造器
 * 反射调用方法
 */
public class MethodInvoke {
    public static void main(String[] args) {
        MethodInvoke mi=  new MethodInvoke();
        mi.methodInvoke();
    }

    public void methodInvoke(){
        Class<?> c = Cat.class;

        try{
            // 创建cat实例
            Constructor constructor = c.getConstructor(String.class, int.class);
            Object cat = constructor.newInstance("Jack", 3);
            // 调用无参方法
            Method sleep = c.getDeclaredMethod("sleep");
            sleep.invoke(cat);
            // 调用定项参数方法
            Method eat = c.getDeclaredMethod("eat", String.class);
            eat.invoke(cat, "grass");
            // 调用不定项参数方法
            Class[] argTypes = new Class[] {String[].class};
            Method varargsEat = c.getDeclaredMethod("eat", argTypes);
            String[] foods = new String[]{"fish", "meat"};
            varargsEat.invoke(cat, (Object)foods);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
