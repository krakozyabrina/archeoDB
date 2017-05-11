package archeo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by arybasova on 16.04.17.
 */
public interface ArtifactDao {

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
    List<Fieldinventory> fieldInventory();
    List<Map<String, Object>> countArtifactsBySquares(Float from, Float to);
    List<Map<String, Object>> countArtifactsByMaterial();
    List<Map<String, Object>> countArtifactsByEmployee();
    List<Map<String, Object>> findEmployeeByArtifactId(Long artifactId);
    List<Map<String, Object>> countArtifactsBySquares();
    List<Map<String, Object>> findMyArtifacts(String name);
    List<Map<String, Object>> fieldInventoryByPeriod(Date from, Date till);
    List<Map<String, Object>> fieldInventoryBySquaresAndDepth(List<String> squares, Float depth_from, Float depth_till);
    List<Map<String, Object>> allSitesDescription();
    List<Map<String, Object>> sizeOfArtifactsBySquareAndDepth(List<String> squares, Float depth_from, Float depth_till);

    List<Hydroobject> findAllHydroobjects();

    void saveHydroobject(Hydroobject hydroobject);

    void saveSettlement(Settlement settlement);

    List<Settlement> findAllSettlements();

    List<Characteristic> findAllCharacteristics();

    void saveCharacteristic(Characteristic characteristic);

    List<SiteObject> findAllSiteobjects();

    void saveSiteobject(SiteObject siteobject);

    List<Map<String, Object>> fieldInventoryByNumber(Integer inv_num);

    Artifact findArtifactById(Integer inv_num);

    List<Map<String, Object>> fieldInventoryByCharacteristic(Integer characteristic_id);

    List<Map<String, Object>> fieldInventoryByObjectAndDepth(Integer siteobject_id, Float from, Float to);

    void changeArtifact(Artifact artifact);

    void deleteArtifact(Long id);
}
