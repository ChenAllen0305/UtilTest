package Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class foreachTest {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>(){{
            add("holli");
            add("Holli");
            add("hoi");
            add("Hoi");
            add("hoLLi");
        }};

        Iterator iterator = names.iterator();
        do{
            if(!iterator.hasNext()){
                break;
            } else {
                // 因为iterator中对于remove操作会导致内部参数不同，所以会出现错误
                String name = (String)iterator.next();
                if(name.equals("Holli")){
                    // 可直接换成for循环，或者使用iterator提供的remove方法
                    iterator.remove();
                    // 如果想要删除的对象只有一个的话，如set集，可设置break语句停止强循环
//                    names.remove(name);
//                    break;
                }
            }
        } while(true);
        System.out.println(names);
    }
}
