package archeo;

import java.util.List;

/**
 * Created by arybasova on 28.04.17.
 */
public class SizeOfArtifactsBySquareAndDepth {
    private List<String> squares;
    private Float depth_from;
    private Float depth_till;

    public List<String> getSquares() {
        return squares;
    }

    public Float getDepth_from() {
        return depth_from;
    }

    public void setDepth_from(Float depth_from) {
        this.depth_from = depth_from;
    }

    public Float getDepth_till() {
        return depth_till;
    }

    public void setSquares(List<String> squares) {
        this.squares = squares;
    }

    public void setDepth_till(Float depth_till) {
        this.depth_till = depth_till;
    }
}
