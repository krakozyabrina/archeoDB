package archeo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by arybasova on 14.04.17.
 */
@Service
public class ArtifactDaoImpl implements ArtifactDao {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Artifact artifact) {

        jdbcTemplate.update("INSERT INTO " +
                "artifact(inv_num, title,description,find_date,sizex,sizey,sizez,cipher,depth,coord_north,coord_west, material_id, square_id, layer_id, employee_id, site_id, siteobject_id, characteristic_id)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                artifact.getInv_num(), artifact.getTitle(), artifact.getDescription(), artifact.getFind_date(),
                artifact.getSizex(), artifact.getSizey(), artifact.getSizez(), artifact.getCipher(),
                artifact.getDepth(), artifact.getCoord_north(), artifact.getCoord_west(),
                artifact.getMaterial_id(), artifact.getSquare_id(), artifact.getLayer_id(),
                artifact.getEmployee_id(), artifact.getSite_id(), artifact.getSiteobject_id(), artifact.getCharacteristic_id());
    }

    @Override
    public List<Material> findAllMaterials(){
        return jdbcTemplate.query("select * from material", (resultSet, rowNum) -> {
            Material m = new Material();
            m.setId(resultSet.getInt("id"));
            m.setMaterial(resultSet.getString("material"));
            return m;
        });
    }

    @Override
    public void saveMaterial(Material material) {
        jdbcTemplate.update("INSERT INTO material(material) VALUES (?)", material.getMaterial());
    }

    @Override
    public List<Square> findAllSquares(){
        return jdbcTemplate.query("select * from square", (resultSet, rowNum) -> {
            Square s = new Square();
            s.setId(resultSet.getInt("id"));
            s.setSquare(resultSet.getString("square"));
            return s;
        });
    }

    @Override
    public void saveSquare(Square square) {
        jdbcTemplate.update("INSERT INTO square(square) VALUES (?)", square.getSquare());
    }

    @Override
    public List<Epoch> findAllEpochs(){
        return jdbcTemplate.query("select * from epoch", (resultSet, rowNum) -> {
            Epoch e = new Epoch();
            e.setId(resultSet.getInt("id"));
            e.setEpoch(resultSet.getString("epoch"));
            return e;
        });
    }

    @Override
    public void saveEpoch(Epoch epoch) {
        jdbcTemplate.update("INSERT INTO epoch(epoch) VALUES (?)", epoch.getEpoch());
    }

    @Override
    public void saveLayer(Layer layer) {
        jdbcTemplate.update("INSERT INTO layer(layer) VALUES (?)", layer.getLayer());
    }

    @Override
    public List<Layer> findAllLayers(){
        return jdbcTemplate.query("select * from layer", (resultSet, rowNum) -> {
            Layer l = new Layer();
            l.setId(resultSet.getInt("id"));
            l.setLayer(resultSet.getString("layer"));
            return l;
        });
    }

    @Override
    public void saveRegion(Region region) {
        jdbcTemplate.update("INSERT INTO region(region) VALUES (?)", region.getRegion());
    }

    @Override
    public List<Region> findAllRegions(){
        return jdbcTemplate.query("select * from region", (resultSet, rowNum) -> {
            Region r = new Region();
            r.setId(resultSet.getInt("id"));
            r.setRegion(resultSet.getString("region"));
            return r;
        });
    }

    @Override
    public void savePosition(Position position) {
        jdbcTemplate.update("INSERT INTO position(position) VALUES (?)", position.getPosition());
    }

    @Override
    public List<Position> findAllPositions(){
        return jdbcTemplate.query("select * from position", (resultSet, rowNum) -> {
            Position p = new Position();
            p.setId(resultSet.getInt("id"));
            p.setPosition(resultSet.getString("position"));
            return p;
        });
    }

    @Override
    public void saveEmployee(Employee employee) {
        jdbcTemplate.update("INSERT INTO employee(fio, phone, position_id) VALUES (?,?,?)", employee.getFio(), employee.getPhone(), employee.getPosition_id());
    }

    @Override
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

    @Override
    public void saveSite(Site site) {
        jdbcTemplate.update("INSERT INTO site(site_title, site_comments, region_id, settlement_id, hydroobject_id, epoch_id) VALUES (?,?,?,?,?,?)", site.getSite_title(), site.getSite_comments(), site.getRegion_id(), site.getSettlement_id(), site.getHydroobject_id(), site.getEpoch_id());
    }

    @Override
    public List<Site> findAllSites(){
        return jdbcTemplate.query("select * from site", (resultSet, rowNum) -> {
            Site s = new Site();
            s.setId(resultSet.getInt("id"));
            s.setSite_title(resultSet.getString("site_title"));
            s.setSite_comments(resultSet.getString("site_comments"));
            s.setRegion_id(resultSet.getInt("region_id"));
            s.setSettlement_id(resultSet.getInt("settlement_id"));
            s.setHydroobject_id(resultSet.getInt("hydroobject_id"));
            s.setEpoch_id(resultSet.getInt("epoch_id"));
            return s;
        });
    }

    @Override
    public List<Fieldinventory> fieldInventory() {
        return jdbcTemplate.query("SELECT artifact.inv_num, " +
                "artifact.cipher, " +
                "material.material, " +
                "artifact.description, " +
                "siteobject.siteobject, " +
                "characteristic.characteristic, " +
                "artifact.title, " +
                "square.square, " +
                "artifact.depth, " +
                "artifact.coord_north, " +
                "artifact.coord_west, " +
                "layer.layer, " +
                "artifact.sizex, " +
                "artifact.sizey, " +
                "artifact.sizez, " +
                "artifact.sizex*artifact.sizey as area, "+
                "artifact.find_date, " +
                "site.site_title, " +
                "region.region " +
                "FROM artifact " +
                "left join layer on layer.id = artifact.layer_id left join site on site.id = artifact.site_id left join material on material.id = artifact.material_id left join square on square.id = artifact.square_id left join region on region.id = site.region_id left join siteobject on siteobject.id = artifact.siteobject_id left join characteristic on characteristic.id = artifact.characteristic_id "+
                "ORDER BY artifact.id", (resultSet, rowNum) -> {
            Fieldinventory fieldinventory = new Fieldinventory();
            fieldinventory.setInv_num(resultSet.getInt("inv_num"));
            fieldinventory.setCipher(resultSet.getString("cipher"));
            fieldinventory.setMaterial(resultSet.getString("material"));
            fieldinventory.setDescription(resultSet.getString("description"));
            fieldinventory.setSiteobject(resultSet.getString("siteobject"));
            fieldinventory.setCharacteristic(resultSet.getString("characteristic"));
            fieldinventory.setTitle(resultSet.getString("title"));
            fieldinventory.setSquare(resultSet.getString("square"));
            fieldinventory.setDepth(resultSet.getFloat("depth"));
            fieldinventory.setCoord_north(resultSet.getFloat("coord_north"));
            fieldinventory.setCoord_west(resultSet.getFloat("coord_west"));
            fieldinventory.setLayer(resultSet.getString("layer"));
            fieldinventory.setSizex(resultSet.getFloat("sizex"));
            fieldinventory.setSizey(resultSet.getFloat("sizey"));
            fieldinventory.setSizez(resultSet.getFloat("sizez"));
            fieldinventory.setArea(resultSet.getFloat("area"));
            fieldinventory.setFind_date(resultSet.getDate("find_date"));
            fieldinventory.setSite_title(resultSet.getString("site_title"));
            fieldinventory.setRegion(resultSet.getString("region"));
            return fieldinventory;
        });
    }

    @Override
    public List<Map<String, Object>> countArtifactsBySquares(Float from, Float to) {
        return jdbcTemplate.queryForList("SELECT square.square AS square, Count(artifact.id) AS summa, array_agg(artifact.inv_num) AS inv_num FROM square INNER JOIN artifact ON square.id = artifact.square_id WHERE ((artifact.depth) Between ? And ?) GROUP BY square.square", from, to);
    }

    @Override
    public List<Map<String, Object>> countArtifactsByMaterial() {
        return jdbcTemplate.queryForList("SELECT material.material AS material, COUNT(artifact.id) AS summa FROM material INNER JOIN artifact ON material.id = artifact.material_id GROUP BY material.material ORDER BY material.material");
    }

    @Override
    public List<Map<String, Object>> countArtifactsByEmployee() {
        return jdbcTemplate.queryForList("SELECT employee.fio AS fio, Count(artifact.id) AS summa FROM employee INNER JOIN artifact ON employee.id = artifact.employee_id GROUP BY employee.fio ORDER BY employee.fio");
    }

    @Override
    public List<Map<String, Object>> findEmployeeByArtifactId(Long artifactId) {
        return jdbcTemplate.queryForList("SELECT employee.fio, employee.phone, position.position FROM position INNER JOIN (employee INNER JOIN artifact ON employee.id = artifact.employee_id) ON position.id = employee.position_id WHERE artifact.inv_num = ?", artifactId);
    }

    @Override
    public List<Map<String, Object>> countArtifactsBySquares() {
        return jdbcTemplate.queryForList("SELECT square.square AS square, COUNT(artifact.id) AS summa FROM square INNER JOIN artifact ON square.id = artifact.square_id GROUP BY square.square");
    }

    @Override
    public List<Map<String, Object>> findMyArtifacts(String name) {
        return jdbcTemplate.queryForList("SELECT artifact.inv_num, artifact.title, artifact.description, artifact.find_date, " +
                "artifact.sizex, " +
                "artifact.sizey, " +
                "artifact.sizez, " +
                "layer.layer, " +
                "artifact.depth, " +
                "artifact.coord_north, " +
                "artifact.coord_west, " +
                "square.square, " +
                "material.material " +
                "FROM square INNER JOIN " +
                "(material INNER JOIN " +
                "(layer INNER JOIN " +
                "((position INNER JOIN employee " +
                "ON position.id = employee.position_id) " +
                "INNER JOIN artifact " +
                "ON employee.id = artifact.employee_id) " +
                "ON layer.id = artifact.layer_id) " +
                "ON material.id = artifact.material_id) " +
                "ON square.id = artifact.square_id " +
                "WHERE (employee.fio LIKE '"+"%"+name+"%' )");
    }

    @Override
    public List<Map<String, Object>> fieldInventoryByPeriod(Date from, Date till) {
        return jdbcTemplate.queryForList("SELECT " +
                "artifact.inv_num, " +
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
                "FROM layer INNER JOIN " +
                "(region INNER JOIN " +
                "(site INNER JOIN " +
                "(material INNER JOIN " +
                "(square INNER JOIN artifact " +
                "ON square.id = artifact.square_id) " +
                "ON material.id = artifact.material_id) " +
                "ON site.id = artifact.site_id) " +
                "ON region.id = site.region_id) " +
                "ON layer.id = artifact.layer_id " +
                "WHERE artifact.find_date between ? and ?" +
                "ORDER BY artifact.inv_num", from, till);
    }

    @Override
    public List<Map<String, Object>> fieldInventoryBySquaresAndDepth(List<String> squares, Float depth_from, Float depth_till) {

        String listParam = squares.stream()
                .map(str -> "'" + str + "'")
                .collect(Collectors.joining(", "));

        return jdbcTemplate.queryForList("SELECT  " +
                "artifact.inv_num, " +
                "artifact.cipher, " +
                "material.material, " +
                "artifact.description, " +
                "siteobject.siteobject, " +
                "characteristic.characteristic, " +
                "artifact.title, " +
                "square.square, " +
                "artifact.depth, " +
                "artifact.coord_north, " +
                "artifact.coord_west, " +
                "layer.layer, " +
                "artifact.sizex, " +
                "artifact.sizey, " +
                "artifact.sizez, " +
                "artifact.sizex*artifact.sizey as area, "+
                "artifact.find_date, " +
                "site.site_title, " +
                "region.region " +
                "FROM layer INNER JOIN " +
                "(region INNER JOIN " +
                "(site INNER JOIN " +
                "(material INNER JOIN " +
                "(square INNER JOIN artifact " +
                "ON square.id = artifact.square_id) " +
                "ON material.id = artifact.material_id) " +
                "ON site.id = artifact.site_id) " +
                "ON region.id = site.region_id) " +
                "ON layer.id = artifact.layer_id " +
                "LEFT JOIN siteobject ON siteobject.id = artifact.siteobject_id " +
                "LEFT JOIN characteristic ON characteristic.id = artifact.characteristic_id " +
                "WHERE (square.square in ( " + listParam + " )) " +
                "and (artifact.depth between ? and ?) " +
                "ORDER BY artifact.inv_num", depth_from, depth_till);
    }

    @Override
    public List<Map<String, Object>> allSitesDescription() {
        return jdbcTemplate.queryForList("SELECT site.site_title, " +
                "region.region, " +
                "epoch.epoch, " +
                "site.site_comments " +
                "FROM epoch INNER JOIN " +
                "(region INNER JOIN site " +
                "ON region.id = site.region_id) " +
                "ON epoch.id = site.epoch_id");
    }

    @Override
    public List<Map<String, Object>> sizeOfArtifactsBySquareAndDepth(List<String> squares, Float depth_from, Float depth_till) {
        String listParam = squares.stream()
                .map(str -> "'" + str + "'")
                .collect(Collectors.joining(", "));
        return jdbcTemplate.queryForList("SELECT artifact.inv_num, " +
                "artifact.sizex, " +
                "artifact.sizey, " +
                "artifact.sizez, " +
                "square.square, " +
                "artifact.depth " +
                "FROM square INNER JOIN artifact " +
                "ON square.id = artifact.square_id " +
                "WHERE square.square in ( " + listParam + " )" +
                "and artifact.depth between ? and ?", depth_from, depth_till);
    }

    @Override
    public List<Hydroobject> findAllHydroobjects() {
        return jdbcTemplate.query("select * from hydroobject", (resultSet, rowNum) -> {
            Hydroobject h = new Hydroobject();
            h.setId(resultSet.getInt("id"));
            h.setHydroobject(resultSet.getString("hydroobject"));
            return h;
        });
    }

    @Override
    public void saveHydroobject(Hydroobject hydroobject) {
        jdbcTemplate.update("INSERT INTO hydroobject(hydroobject) VALUES (?)", hydroobject.getHydroobject());
    }

    @Override
    public void saveSettlement(Settlement settlement) {
        jdbcTemplate.update("INSERT INTO settlement(settlement) VALUES (?)", settlement.getSettlement());
    }

    @Override
    public List<Settlement> findAllSettlements() {
        return jdbcTemplate.query("SELECT * FROM settlement", (resultSet, rowNum) -> {
            Settlement s = new Settlement();
            s.setId(resultSet.getInt("id"));
            s.setSettlement(resultSet.getString("settlement"));
            return s;
        });
    }

    @Override
    public List<Characteristic> findAllCharacteristics() {
        return jdbcTemplate.query("SELECT * FROM characteristic", (resultSet, rowNum) -> {
            Characteristic c = new Characteristic();
            c.setId(resultSet.getInt("id"));
            c.setCharacteristic(resultSet.getString("characteristic"));
            return c;
        });
    }

    @Override
    public void saveCharacteristic(Characteristic characteristic) {
        jdbcTemplate.update("INSERT INTO characteristic(characteristic) VALUES (?)", characteristic.getCharacteristic());
    }

    @Override
    public List<SiteObject> findAllSiteobjects() {
        return jdbcTemplate.query("SELECT * FROM siteobject", (resultSet, rowNum) -> {
            SiteObject s = new SiteObject();
            s.setId(resultSet.getInt("id"));
            s.setSiteobject(resultSet.getString("siteobject"));
            return s;
        });
    }

    @Override
    public void saveSiteobject(SiteObject siteobject) {
        jdbcTemplate.update("INSERT INTO siteobject(siteobject) VALUES (?)", siteobject.getSiteobject());
    }

    @Override
    public Artifact findArtifactById(Integer inv_num) {
        return jdbcTemplate.queryForObject("SELECT * FROM artifact WHERE artifact.inv_num = ? ORDER BY artifact.id",
                new BeanPropertyRowMapper<>(Artifact.class),
                inv_num);
    }

    @Override
    public List<Map<String, Object>> fieldInventoryByNumber(Integer inv_num) {
        return jdbcTemplate.queryForList("SELECT artifact.id, " +
                        "artifact.inv_num, " +
                        "artifact.cipher, " +
                        "material.material, " +
                        "artifact.description, " +
                        "siteobject.siteobject, " +
                        "characteristic.characteristic, " +
                        "artifact.title, " +
                        "square.square, " +
                        "artifact.depth, " +
                        "artifact.coord_north, " +
                        "artifact.coord_west, " +
                        "layer.layer, " +
                        "artifact.sizex, " +
                        "artifact.sizey, " +
                        "artifact.sizez, " +
                        "artifact.sizex*artifact.sizey as area, "+
                        "artifact.find_date, " +
                        "site.site_title " +
                        "FROM artifact " +
                        "left join layer on layer.id = artifact.layer_id left join site on site.id = artifact.site_id left join material on material.id = artifact.material_id left join square on square.id = artifact.square_id left join region on region.id = site.region_id left join siteobject on siteobject.id = artifact.siteobject_id left join characteristic on characteristic.id = artifact.characteristic_id "+
                        "WHERE artifact.inv_num = ?" +
                        "ORDER BY artifact.id", inv_num);
    }

    @Override
    public List<Map<String, Object>> fieldInventoryByCharacteristic(Integer characteristic_id) {
        return jdbcTemplate.queryForList("SELECT artifact.inv_num, " +
                "artifact.cipher, " +
                "material.material, " +
                "artifact.description, " +
                "siteobject.siteobject, " +
                "characteristic.characteristic, " +
                "artifact.title, " +
                "square.square, " +
                "artifact.depth, " +
                "artifact.coord_north, " +
                "artifact.coord_west, " +
                "layer.layer, " +
                "artifact.sizex, " +
                "artifact.sizey, " +
                "artifact.sizez, " +
                "artifact.sizex*artifact.sizey as area, "+
                "artifact.find_date, " +
                "site.site_title " +
                "FROM artifact " +
                "left join layer on layer.id = artifact.layer_id left join site on site.id = artifact.site_id left join material on material.id = artifact.material_id left join square on square.id = artifact.square_id left join region on region.id = site.region_id left join siteobject on siteobject.id = artifact.siteobject_id left join characteristic on characteristic.id = artifact.characteristic_id "+
                "WHERE artifact.characteristic_id = ?" +
                "ORDER BY artifact.id", characteristic_id);
    }

    @Override
    public List<Map<String, Object>> fieldInventoryByObjectAndDepth(Integer siteobject_id, Float from, Float to) {
        return jdbcTemplate.queryForList("SELECT artifact.inv_num, " +
                "artifact.cipher, " +
                "material.material, " +
                "artifact.description, " +
                "siteobject.siteobject, " +
                "characteristic.characteristic, " +
                "artifact.title, " +
                "square.square, " +
                "artifact.depth, " +
                "artifact.coord_north, " +
                "artifact.coord_west, " +
                "layer.layer, " +
                "artifact.sizex, " +
                "artifact.sizey, " +
                "artifact.sizez, " +
                "artifact.sizex*artifact.sizey as area, "+
                "artifact.find_date, " +
                "site.site_title " +
                "FROM artifact " +
                "left join layer on layer.id = artifact.layer_id left join site on site.id = artifact.site_id left join material on material.id = artifact.material_id left join square on square.id = artifact.square_id left join region on region.id = site.region_id left join siteobject on siteobject.id = artifact.siteobject_id left join characteristic on characteristic.id = artifact.characteristic_id "+
                "WHERE (artifact.siteobject_id = ?) and (artifact.depth BETWEEN ? AND ?) " +
                "ORDER BY artifact.id", siteobject_id, from, to);
    }

    @Override
    public void changeArtifact(Artifact artifact){
        jdbcTemplate.update("UPDATE artifact " +
                "SET inv_num = ? ," +
                " title = ? ," +
                " description = ? ," +
                " find_date = ? ," +
                " sizex = ? ," +
                " sizey = ? ," +
                " sizez = ? ," +
                " cipher = ? ," +
                " depth = ? ," +
                " coord_north = ? ," +
                " coord_west = ? ," +
                " material_id = ? ," +
                " square_id = ? ," +
                " layer_id = ? ," +
                " employee_id = ? ," +
                " site_id = ? ," +
                " siteobject_id = ? ," +
                " characteristic_id = ? " +
                "WHERE inv_num = ? ",
                artifact.getInv_num(),
                artifact.getTitle(),
                artifact.getDescription(),
                artifact.getFind_date(),
                artifact.getSizex(),
                artifact.getSizey(),
                artifact.getSizez(),
                artifact.getCipher(),
                artifact.getDepth(),
                artifact.getCoord_north(),
                artifact.getCoord_west(),
                artifact.getMaterial_id(),
                artifact.getSquare_id(),
                artifact.getLayer_id(),
                artifact.getEmployee_id(),
                artifact.getSite_id(),
                artifact.getSiteobject_id(),
                artifact.getCharacteristic_id(),
                artifact.getInv_num());
    }

    @Override
    public void deleteArtifact(Long id) {
        jdbcTemplate.update("DELETE FROM artifact WHERE id = ?", id);
    }


}
