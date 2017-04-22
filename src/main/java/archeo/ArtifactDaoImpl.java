package archeo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by arybasova on 14.04.17.
 */
@Service
public class ArtifactDaoImpl implements ArtifactDao {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void findAll() {

        jdbcTemplate.query("select * from artifact", (resultSet, rowNum) -> {
            Artifact a = new Artifact();
            a.setId(resultSet.getLong("id"));
            a.setTitle(resultSet.getString("title"));
            return a;
        }).forEach(artifact -> log.info(artifact.toString()));
    }

    public void save(Artifact artifact) {

        jdbcTemplate.update("INSERT INTO " +
                "artifact(id, title,description,find_date,sizex,sizey,sizez,cipher,depth,coord_north,coord_west, material_id, square_id, layer_id, employee_id, site_id)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                artifact.getId(), artifact.getTitle(), artifact.getDescription(), artifact.getFind_date(),
                artifact.getSizex(), artifact.getSizey(), artifact.getSizez(), artifact.getCipher(),
                artifact.getDepth(), artifact.getCoord_north(), artifact.getCoord_west(),
                artifact.getMaterial_id(), artifact.getSquare_id(), artifact.getLayer_id(),
                artifact.getEmployee_id(), artifact.getSite_id());
    }

    public List<Material> findAllMaterials(){
        return jdbcTemplate.query("select * from material", (resultSet, rowNum) -> {
            Material m = new Material();
            m.setId(resultSet.getInt("id"));
            m.setMaterial(resultSet.getString("material"));
            return m;
        });
    }

    public void saveMaterial(Material material) {
        jdbcTemplate.update("INSERT INTO material(material) VALUES (?)", material.getMaterial());
    }

    public List<Square> findAllSquares(){
        return jdbcTemplate.query("select * from square", (resultSet, rowNum) -> {
            Square s = new Square();
            s.setId(resultSet.getInt("id"));
            s.setSquare(resultSet.getString("square"));
            return s;
        });
    }

    public void saveSquare(Square square) {
        jdbcTemplate.update("INSERT INTO square(square) VALUES (?)", square.getSquare());
    }

    public List<Epoch> findAllEpochs(){
        return jdbcTemplate.query("select * from epoch", (resultSet, rowNum) -> {
            Epoch e = new Epoch();
            e.setId(resultSet.getInt("id"));
            e.setEpoch(resultSet.getString("epoch"));
            return e;
        });
    }

    public void saveEpoch(Epoch epoch) {
        jdbcTemplate.update("INSERT INTO epoch(epoch) VALUES (?)", epoch.getEpoch());
    }

    public void saveLayer(Layer layer) {
        jdbcTemplate.update("INSERT INTO layer(layer) VALUES (?)", layer.getLayer());
    }

    public List<Layer> findAllLayers(){
        return jdbcTemplate.query("select * from layer", (resultSet, rowNum) -> {
            Layer l = new Layer();
            l.setId(resultSet.getInt("id"));
            l.setLayer(resultSet.getString("layer"));
            return l;
        });
    }

    public void saveRegion(Region region) {
        jdbcTemplate.update("INSERT INTO region(region) VALUES (?)", region.getRegion());
    }

    public List<Region> findAllRegions(){
        return jdbcTemplate.query("select * from region", (resultSet, rowNum) -> {
            Region r = new Region();
            r.setId(resultSet.getInt("id"));
            r.setRegion(resultSet.getString("region"));
            return r;
        });
    }

    public void savePosition(Position position) {
        jdbcTemplate.update("INSERT INTO position(position) VALUES (?)", position.getPosition());
    }

    public List<Position> findAllPositions(){
        return jdbcTemplate.query("select * from position", (resultSet, rowNum) -> {
            Position p = new Position();
            p.setId(resultSet.getInt("id"));
            p.setPosition(resultSet.getString("position"));
            return p;
        });
    }

    public void saveEmployee(Employee employee) {
        jdbcTemplate.update("INSERT INTO employee(fio, phone, position_id) VALUES (?,?,?)", employee.getFio(), employee.getPhone(), employee.getPosition_id());
    }

    public List<Employee> findAllEmployees(){
        return jdbcTemplate.query("select * from employee", (resultSet, rowNum) -> {
            Employee e = new Employee();
            e.setId(resultSet.getInt("id"));
            e.setFio(resultSet.getString("fio"));
            e.setPhone(resultSet.getInt("phone"));
            e.setPosition_id(resultSet.getInt("position_id"));
            return e;
        });
    }
    public void saveSite(Site site) {
        jdbcTemplate.update("INSERT INTO site(site_title, site_comments, region_id, epoch_id) VALUES (?,?,?,?)", site.getSite_title(), site.getSite_comments(), site.getRegion_id(), site.getEpoch_id());
    }

    public List<Site> findAllSites(){
        return jdbcTemplate.query("select * from site", (resultSet, rowNum) -> {
            Site s = new Site();
            s.setId(resultSet.getInt("id"));
            s.setSite_title(resultSet.getString("site_title"));
            s.setSite_comments(resultSet.getString("site_comments"));
            s.setRegion_id(resultSet.getInt("region_id"));
            s.setEpoch_id(resultSet.getInt("epoch_id"));
            return s;
        });
    }

    public List fieldInventory() {
        return jdbcTemplate.query("SELECT artifact.id, " +
                "artifact.title, " +
                "artifact.description, " +
                "artifact.find_date, " +
                "artifact.sizex, " +
                "artifact.sizey, " +
                "artifact.sizez, " +
                "artifact.cipher, " +
                "artifact.depth, " +
                "artifact.coord_north, " +
                "artifact.coord_west, " +
                "square.square, " +
                "material.material, " +
                "layer.layer, " +
                "site.site_title, " +
                "region.region " +
                "FROM artifact " +
                "left join layer on layer.id = artifact.layer_id left join site on site.id = artifact.site_id left join material on material.id = artifact.material_id left join square on square.id = artifact.square_id left join region on region.id = site.region_id "+
                "ORDER BY artifact.id", (resultSet, rowNum) -> {
            Fieldinventory fieldinventory = new Fieldinventory();
            fieldinventory.setId(resultSet.getLong("id"));
            fieldinventory.setTitle(resultSet.getString("title"));
            fieldinventory.setDescription(resultSet.getString("description"));
            fieldinventory.setSizex(resultSet.getFloat("sizex"));
            fieldinventory.setSizey(resultSet.getFloat("sizey"));
            fieldinventory.setSizez(resultSet.getFloat("sizez"));
            fieldinventory.setCipher(resultSet.getString("cipher"));
            fieldinventory.setDepth(resultSet.getFloat("depth"));
            fieldinventory.setCoord_north(resultSet.getFloat("coord_north"));
            fieldinventory.setCoord_west(resultSet.getFloat("coord_west"));
            fieldinventory.setSquare(resultSet.getString("square"));
            fieldinventory.setMaterial(resultSet.getString("material"));
            fieldinventory.setLayer(resultSet.getString("layer"));
            fieldinventory.setSite_title(resultSet.getString("site_title"));
            fieldinventory.setRegion(resultSet.getString("region"));
            return fieldinventory;
        });
    }

    @Override
    public List countArtifactsBySquares(Float from, Float to) {
        return jdbcTemplate.queryForList("SELECT square.square AS square, Count(artifact.id) AS summa FROM square INNER JOIN artifact ON square.id = artifact.square_id WHERE ((artifact.depth) Between ? And ?) GROUP BY square.square", from, to);
    }

    @Override
    public List countArtifactsByMaterial() {
        return jdbcTemplate.queryForList("SELECT material.material AS material, COUNT(artifact.id) AS summa FROM material INNER JOIN artifact ON material.id = artifact.material_id GROUP BY material.material ORDER BY material.material");
    }

    @Override
    public List countArtifactsByEmployee() {
        return jdbcTemplate.queryForList("SELECT employee.fio AS fio, Count(artifact.id) AS summa FROM employee INNER JOIN artifact ON employee.id = artifact.employee_id GROUP BY employee.fio ORDER BY employee.fio");
    }

    @Override
    public List findEmployeeByArtifactId(Long artifactId) {
        return jdbcTemplate.queryForList("SELECT employee.fio, employee.phone, position.position FROM position INNER JOIN (employee INNER JOIN artifact ON employee.id = artifact.employee_id) ON position.id = employee.position_id WHERE artifact.id = ?", artifactId);
    }

}
