package archeo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Artifact {

    private Long id;

    private Integer inv_num;

    private String title;

    private String description;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date find_date;

    private Float sizex;

    private Float sizey;

    private Float sizez;

    private String cipher;

    private Float depth;

    private Float coord_north;

    private Float coord_west;

    private Integer material_id;

    private Integer square_id;

    private Integer epoch_id;

    private Integer layer_id;

    private Integer region_id;

    private Integer position_id;

    private Integer employee_id;

    private Integer site_id;

    private Integer siteobject_id;

    private Integer characteristic_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInv_num() {
        return inv_num;
    }

    public void setInv_num(Integer inv_num) {
        this.inv_num = inv_num;
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
/*
    public Date getFind_date() {
        if (find_date != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            String str = format.format(find_date);
            try {
                return SimpleDateFormat.getDateInstance().parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return find_date;
    }

    public void setFind_date(String findDateStr) {
        if (findDateStr != null) {
            try {
                this.find_date = SimpleDateFormat.getDateInstance().parse(findDateStr);
                //String str = SimpleDateFormat.getDateInstance().format(findDateStr);
                //this.find_date = SimpleDateFormat.getDateInstance().parse(str);
            } catch (ParseException e) {
                // TODO
            }
        }
    }
*/
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

    public Integer getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(Integer material_id) {
        this.material_id = material_id;
    }

    public Integer getSquare_id() {
        return square_id;
    }

    public void setSquare_id(Integer square_id) {
        this.square_id = square_id;
    }

    public Integer getEpoch_id() {
        return epoch_id;
    }

    public void setEpoch_id(Integer epoch_id) {
        this.epoch_id = epoch_id;
    }

    public Integer getLayer_id() {
        return layer_id;
    }

    public void setLayer_id(Integer layer_id) {
        this.layer_id = layer_id;
    }

    public Integer getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Integer region_id) {
        this.region_id = region_id;
    }

    public Integer getPosition_id() {
        return position_id;
    }

    public void setPosition_id(Integer position_id) {
        this.position_id = position_id;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public Integer getSite_id() {
        return site_id;
    }

    public void setSite_id(Integer site_id) {
        this.site_id = site_id;
    }

    public Integer getSiteobject_id() {
        return siteobject_id;
    }

    public void setSiteobject_id(Integer siteobject_id) {
        this.siteobject_id = siteobject_id;
    }

    public Integer getCharacteristic_id() {
        return characteristic_id;
    }

    public void setCharacteristic_id(Integer characteristic_id) {
        this.characteristic_id = characteristic_id;
    }
/*
    public static Artifact generateRandom() {
        Artifact artifact = new Artifact();
        artifact.setId(1L);
        artifact.setFind_date(new Date());
        artifact.setTitle("dummy");
        artifact.setCipher(String.valueOf(new Random().nextInt()));
        return artifact;
    }
*/
    @Override
    public String toString() {
        return "Artifact{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", find_date=" + find_date +
                ", sizex=" + sizex +
                ", sizey=" + sizey +
                ", sizez=" + sizez +
                ", cipher='" + cipher + '\'' +
                ", depth=" + depth +
                ", coord_north=" + coord_north +
                ", coord_west=" + coord_west +
                ", material_id=" + material_id +
                ", square_id=" + square_id +
                ", epoch_id=" + epoch_id +
                ", layer_id=" + layer_id +
                ", region_id=" + region_id +
                ", position_id=" + position_id +
                ", employee_id=" + employee_id +
                ", site_id=" + site_id +
                '}';
    }
}