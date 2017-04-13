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
public class ArtifactDao {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void findAll() {

        jdbcTemplate.query("select * from artifact", (resultSet, rowNum) -> {
            Artifact a = new Artifact();
            a.setId(resultSet.getLong("id"));
            a.setTitle(resultSet.getString("title"));
            return a;
        }).forEach(artifact -> log.info(artifact.toString()));
    }
}
