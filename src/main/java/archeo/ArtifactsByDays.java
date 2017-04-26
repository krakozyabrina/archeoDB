package archeo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by arybasova on 24.04.17.
 */
public class ArtifactsByDays {

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date from;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date till;

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTill() {
        return till;
    }

    public void setTill(Date till) {
        this.till = till;
    }
}
