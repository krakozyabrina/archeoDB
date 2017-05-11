package archeo;

import java.util.Date;

/**
 * Created by arybasova on 01.05.17.
 */
public class FieldInventoryByNumber {
    private Long id;
    private Integer inv_num;
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

    public Integer getInv_num() {
        return inv_num;
    }

    public void setInv_num(Integer inv_num) {
        this.inv_num = inv_num;
    }


}
