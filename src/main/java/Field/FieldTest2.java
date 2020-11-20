package Field;

import Domain.Cat;

import java.lang.reflect.Field;

/**
 * 获取和设置变量值
 */
public class FieldTest2 {
    public static void main(String[] args) {
        Cat cat = new Cat("Tom", 2);
        FieldTest2 ft2 = new FieldTest2();
        ft2.testField(cat);
    }

    public void testField(Cat cat){
        Class c = cat.getClass();

        try{
            // 获取变量并设置可改动
            Field fieldName = c.getDeclaredField("name");
            Field fieldAge = c.getDeclaredField("age");
            fieldName.setAccessible(true);
            // 反射获取参数
            String name = (String) fieldName.get(cat);
            int age = fieldAge.getInt(cat);
            System.out.println("Before " + cat.toString());
            // 重新设置名字和年龄
            fieldName.set(cat, "Timmy");
            fieldAge.set(cat, 3);
            System.out.println("After " + cat.toString());
        } catch (NoSuchFieldException e){
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }
}
