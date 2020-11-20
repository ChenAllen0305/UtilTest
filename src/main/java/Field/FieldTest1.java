package Field;

import Domain.Station;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class FieldTest1 {
    public static void main(String[] args) {
        FieldTest1 ft1 = new FieldTest1();
        ft1.testField();
        ft1.testFieldMethod();
    }

    /**
     * 获取变量类型、修饰符、注解
     */
    public void testField(){
        Class c = Station.class;
        Field[] fields = c.getDeclaredFields();

        for(Field f : fields){
            StringBuilder builder =  new StringBuilder();
            // 获取名字
            builder.append("filed name: ");
            builder.append(f.getName());
            // 获取类型
            builder.append(", type: ");
            builder.append(f.getType());
            // 获取修饰符
            builder.append(", modifiers: ");
            builder.append(Modifier.toString(f.getModifiers()));
            // 获取注解
            Annotation[] annotations = f.getAnnotations();
            if(annotations.length != 0){
                builder.append(", Annotations :");
                for(Annotation a : annotations){
                    builder.append(a.toString());
                    builder.append(" ");
                }
            } else {
                builder.append("-- No Annotations --");
            }
            System.out.println(builder.toString());
        }
    }

    /**
     * 获取变量属性中的方法
     */
    public void testFieldMethod(){
        Class c = Station.class;
        Method[] methods = c.getDeclaredMethods();

        for(Method m : methods){
            StringBuilder builder =  new StringBuilder();
            // 获取名字
            builder.append("method name: ");
            builder.append(m.getName());
            // 获取目标方法返回类型对应的Class对象
            builder.append(", Returntype: ");
            builder.append(m.getReturnType());
            // 获取目标方法返回类型对应的Type对象
            builder.append(", genericReturnType: ");
            builder.append(m.getGenericReturnType());
            // 获取注解
            Annotation[] annotations = m.getAnnotations();
            if(annotations.length != 0){
                builder.append(", Annotations :");
                for(Annotation a : annotations){
                    builder.append(a.toString());
                    builder.append(" ");
                }
            } else {
                builder.append("-- No Annotations --");
            }
            System.out.println(builder.toString());
        }
    }
}
