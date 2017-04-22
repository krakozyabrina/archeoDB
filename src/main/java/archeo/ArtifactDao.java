package archeo;

import java.util.List;

/**
 * Created by arybasova on 16.04.17.
 */
public interface ArtifactDao {

    void findAll();
    void save(Artifact artifact);
    List<Material> findAllMaterials();
    void saveMaterial(Material material);
    void saveSquare(Square square);
    List<Square> findAllSquares();
    List<Epoch> findAllEpochs();
    void saveEpoch(Epoch epoch);
    void saveLayer(Layer layer);
    List<Layer> findAllLayers();
    List<Region> findAllRegions();
    void saveRegion(Region region);
    void savePosition(Position position);
    List<Position> findAllPositions();
    void saveEmployee(Employee employee);
    List<Employee> findAllEmployees();
    void saveSite(Site site);
    List<Site> findAllSites();
    List fieldInventory();
    List countArtifactsBySquares(Float from, Float to);
    List countArtifactsByMaterial();
    List countArtifactsByEmployee();
    List findEmployeeByArtifactId(Long artifactId);
}
