package Domain;

import java.io.Serializable;
import java.util.Date;


public class Station implements Comparable<Station>, Serializable {


    private Long id;
    private String name;
    private Long code;
    private String title;
    private Double storageCapacity;
    private Double photovoltaicCapacity;
    private Double windCapacity;
    private String longitude;
    private String latitude;
    private Boolean activity = true;
    private String sn;
    private Date productionTime;

    @Override
    public int compareTo(Station o) {
        if (this.sn == null) {
            return -1;
        } else if (o.getSn() == null) {
            return 1;
        }
        return this.sn.compareTo(o.getSn());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(Double storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public Double getPhotovoltaicCapacity() {
        return photovoltaicCapacity;
    }

    public void setPhotovoltaicCapacity(Double photovoltaicCapacity) {
        this.photovoltaicCapacity = photovoltaicCapacity;
    }

    public Double getWindCapacity() {
        return windCapacity;
    }

    public void setWindCapacity(Double windCapacity) {
        this.windCapacity = windCapacity;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Boolean getActivity() {
        return activity;
    }

    public void setActivity(Boolean activity) {
        this.activity = activity;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Date getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(Date productionTime) {
        this.productionTime = productionTime;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", title='" + title + '\'' +
                ", storageCapacity=" + storageCapacity +
                ", photovoltaicCapacity=" + photovoltaicCapacity +
                ", windCapacity=" + windCapacity +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", activity=" + activity +
                ", sn='" + sn + '\'' +
                ", productionTime=" + productionTime +
                '}';
    }
}
