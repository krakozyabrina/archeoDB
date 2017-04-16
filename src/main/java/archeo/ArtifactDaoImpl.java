package archeo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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
                "artifact(id, title,description,find_date,sizex,sizey,sizez,cipher,depth,coord_north,coord_west, material_id, square_id, epoch_id, layer_id, region_id, position_id, employee_id, site_id)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                artifact.getId(), artifact.getTitle(), artifact.getDescription(), artifact.getFind_date(),
                artifact.getSizex(), artifact.getSizey(), artifact.getSizez(), artifact.getCipher(),
                artifact.getDepth(), artifact.getCoord_north(), artifact.getCoord_west(),
                artifact.getMaterial_id(), artifact.getSquare_id(), artifact.getEpoch_id(),
                artifact.getLayer_id(), artifact.getRegion_id(), artifact.getPosition_id(),
                artifact.getEmployee_id(), artifact.getSite_id());
    }
}
