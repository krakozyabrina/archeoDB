package archeo;

import java.util.Date;

/**
 * Created by arybasova on 22.04.17.
 */
public class Fieldinventory {

    private Long id;

    private String title;

    private String description;

    private Date find_date;

    private Float sizex;

    private Float sizey;

    private Float sizez;

    private String cipher;

    private Float depth;

    private Float coord_north;

    private Float coord_west;

    private String square;

    private String material;

    private String layer;

    private String site_title;

    private String region;

    private Float area;

    private String siteobject;

    private String characteristic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFind_date() {
        return find_date;
    }

    public void setFind_date(Date find_date) {
        this.find_date = find_date;
    }

    public Float getSizex() {
        return sizex;
    }

    public void setSizex(Float sizex) {
        this.sizex = sizex;
    }

    public Float getSizey() {
        return sizey;
    }

    public void setSizey(Float sizey) {
        this.sizey = sizey;
    }

    public Float getSizez() {
        return sizez;
    }

    public void setSizez(Float sizez) {
        this.sizez = sizez;
    }

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public Float getDepth() {
        return depth;
    }

    public void setDepth(Float depth) {
        this.depth = depth;
    }

    public Float getCoord_north() {
        return coord_north;
    }

    public void setCoord_north(Float coord_north) {
        this.coord_north = coord_north;
    }

    public Float getCoord_west() {
        return coord_west;
    }

    public void setCoord_west(Float coord_west) {
        this.coord_west = coord_west;
    }

    public String getSquare() {
        return square;
    }

    public void setSquare(String square) {
        this.square = square;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getSite_title() {
        return site_title;
    }

    public void setSite_title(String site_title) {
        this.site_title = site_title;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public String getSiteobject() {
        return siteobject;
    }

    public void setSiteobject(String siteobject) {
        this.siteobject = siteobject;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }
}
