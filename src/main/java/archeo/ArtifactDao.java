package archeo;

/**
 * Created by arybasova on 16.04.17.
 */
public interface ArtifactDao {

    void findAll();
    void  save(Artifact artifact);
}
