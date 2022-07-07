package ForTest;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * ClassName: testFile
 * Author: ChenLun
 * date: 2021/10/26
 * Description:
 */
public class testFile {
    public static void main(String[] args) {
        ArrayList<ParamEntity> paramEntities = new ArrayList<>();
        ParamEntity paramEntity0 = new ParamEntity();
        ParamEntity paramEntity1 = new ParamEntity();
        ParamEntity paramEntity2 = new ParamEntity();
        paramEntity0.setKey("0key");
        paramEntity0.setValue("0value");
        paramEntity1.setKey("1key");
        paramEntity1.setValue("1value");
        paramEntity2.setKey("2key");
        paramEntity2.setValue("2value");
        paramEntities.add(paramEntity0);
        paramEntities.add(paramEntity1);
        paramEntities.add(paramEntity2);
        Map<String, String> collect = paramEntities.stream().collect(Collectors.toMap(ParamEntity::getKey,
                p -> p.getValue() == null ? "" : p.getValue()
        ));
        paramEntities.forEach(k -> {
            k.getKey();
            k.setKey("11");
        });
        for (ParamEntity paramEntity : paramEntities) {

        }
        TreeSet<String> strings = new TreeSet<>();
        strings.add("p");
        strings.add("p");
        strings.add("z");
        strings.add("1");
        System.out.println(strings);
        System.out.println(paramEntities);
        System.out.println(collect);
    }
}
