package archeo;

/**
 * Created by arybasova on 20.04.17.
 */
public class Site {
    private Integer id;
    private String site_title;
    private String site_comments;
    private Integer region_id;
    private Integer epoch_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSite_title() {
        return site_title;
    }

    public void setSite_title(String site_title) {
        this.site_title = site_title;
    }

    public String getSite_comments() {
        return site_comments;
    }

    public void setSite_comments(String site_comments) {
        this.site_comments = site_comments;
    }

    public Integer getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Integer region_id) {
        this.region_id = region_id;
    }

    public Integer getEpoch_id() {
        return epoch_id;
    }

    public void setEpoch_id(Integer epoch_id) {
        this.epoch_id = epoch_id;
    }
}
