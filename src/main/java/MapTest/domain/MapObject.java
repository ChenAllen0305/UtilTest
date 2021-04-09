package MapTest.domain;

/**
 * @title: MaoObject
 * @Author
 * @Date: 2021/4/9
 */
public class MapObject implements Comparable {
    public Long id;
    public String title;

    public MapObject(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
