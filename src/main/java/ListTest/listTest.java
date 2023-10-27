package ListTest;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class listTest {
    public static void main(String[] args) {
//        List<Long> list = new ArrayList<>();
//        list.add(2L);
//        list.add(3L);
//        list.add(1L);
//        list.sort(Comparator.naturalOrder());
////        System.out.println(list.size());
////        System.out.println(list.get(list.size()));
//        System.out.println(list);
//        Long getLong = list.get(list.size() - 1);
//        System.out.println(getLong);


        List<Long> list = Collections.singletonList(1L);

        Map<Long, Long> modelMap = list.stream()
                .collect(Collectors.toMap(k -> k, o1 -> o1, (k1, k2) -> k1));
        log.info(modelMap.toString());

    }
}
