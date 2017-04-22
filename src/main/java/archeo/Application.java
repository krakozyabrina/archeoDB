package archeo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        initDB();

    }

    private void initDB() {
/*
        jdbcTemplate.execute("DROP TABLE IF EXISTS Material CASCADE");
        jdbcTemplate.execute("DROP TABLE IF EXISTS Artifact CASCADE");
        jdbcTemplate.execute("DROP TABLE IF EXISTS Square CASCADE");
        jdbcTemplate.execute("DROP TABLE IF EXISTS Epoch CASCADE");
        jdbcTemplate.execute("DROP TABLE IF EXISTS Layer CASCADE");
        jdbcTemplate.execute("DROP TABLE IF EXISTS Region CASCADE");
        jdbcTemplate.execute("DROP TABLE IF EXISTS Position CASCADE");
        jdbcTemplate.execute("DROP TABLE IF EXISTS Employee CASCADE");
        jdbcTemplate.execute("DROP TABLE IF EXISTS Site CASCADE");

        jdbcTemplate.execute("CREATE TABLE Material(id SERIAL, material VARCHAR(50), CONSTRAINT material_pkey PRIMARY KEY (id))");
        jdbcTemplate.execute("CREATE TABLE Square(id SERIAL, square VARCHAR(50), CONSTRAINT square_pkey PRIMARY KEY (id))");
        jdbcTemplate.execute("CREATE TABLE Epoch(id SERIAL, epoch VARCHAR(50), CONSTRAINT epoch_pkey PRIMARY KEY (id))");
        jdbcTemplate.execute("CREATE TABLE Layer(id SERIAL, layer VARCHAR(255), CONSTRAINT layer_pkey PRIMARY KEY (id))");
        jdbcTemplate.execute("CREATE TABLE Region(id SERIAL, region VARCHAR(50), CONSTRAINT region_pkey PRIMARY KEY (id))");
        jdbcTemplate.execute("CREATE TABLE Position(id SERIAL, position VARCHAR(50), CONSTRAINT position_pkey PRIMARY KEY (id))");
        jdbcTemplate.execute("CREATE TABLE Employee(id SERIAL, fio VARCHAR(50), phone integer NOT NULL, position_id integer, FOREIGN KEY ( position_id ) REFERENCES position (id) ON DELETE RESTRICT ON UPDATE CASCADE, CONSTRAINT employee_pkey PRIMARY KEY (id))");
        jdbcTemplate.execute("CREATE TABLE Site(id SERIAL, site_title VARCHAR(50), site_comments VARCHAR(250), region_id integer, epoch_id integer, FOREIGN KEY ( region_id ) REFERENCES region (id) ON DELETE RESTRICT ON UPDATE CASCADE, FOREIGN KEY ( epoch_id ) REFERENCES epoch (id) ON DELETE RESTRICT ON UPDATE CASCADE, CONSTRAINT site_pkey PRIMARY KEY (id))");
        jdbcTemplate.execute("CREATE TABLE Artifact(id SERIAL NOT NULL, title VARCHAR(255), description VARCHAR(255), find_date timestamp without time zone, sizex real NOT NULL, sizey real NOT NULL, sizez real NOT NULL, cipher VARCHAR(25) UNIQUE, depth real NOT NULL, coord_north real NOT NULL, coord_west real NOT NULL, material_id integer, square_id integer, layer_id integer, employee_id integer, site_id integer, CONSTRAINT artifact_pkey PRIMARY KEY (id), FOREIGN KEY ( material_id ) REFERENCES material (id) ON DELETE RESTRICT ON UPDATE CASCADE, FOREIGN KEY ( square_id ) REFERENCES square (id) ON DELETE RESTRICT ON UPDATE CASCADE, FOREIGN KEY ( layer_id ) REFERENCES layer (id) ON DELETE RESTRICT ON UPDATE CASCADE, FOREIGN KEY ( employee_id ) REFERENCES employee (id) ON DELETE RESTRICT ON UPDATE CASCADE, FOREIGN KEY ( site_id ) REFERENCES site (id) ON DELETE RESTRICT ON UPDATE CASCADE)");

        jdbcTemplate.update("INSERT INTO material(material) VALUES(?)", "Керамика");
        jdbcTemplate.update("INSERT INTO material(material) VALUES(?)", "Камень");
        jdbcTemplate.update("INSERT INTO material(material) VALUES(?)", "Бронза");
        jdbcTemplate.update("INSERT INTO material(material) VALUES(?)", "Металл");
        jdbcTemplate.update("INSERT INTO material(material) VALUES(?)", "Дерево");
        jdbcTemplate.update("INSERT INTO material(material) VALUES(?)", "Кость");
        jdbcTemplate.update("INSERT INTO material(material) VALUES(?)", "Рог");
        jdbcTemplate.update("INSERT INTO material(material) VALUES(?)", "Не установлено");

        jdbcTemplate.update("INSERT INTO square(square) VALUES(?)", "И9");
        jdbcTemplate.update("INSERT INTO square(square) VALUES(?)", "И10");
        jdbcTemplate.update("INSERT INTO square(square) VALUES(?)", "И11");
        jdbcTemplate.update("INSERT INTO square(square) VALUES(?)", "И12");
        jdbcTemplate.update("INSERT INTO square(square) VALUES(?)", "Ж10");
        jdbcTemplate.update("INSERT INTO square(square) VALUES(?)", "Ж11");
        jdbcTemplate.update("INSERT INTO square(square) VALUES(?)", "К10");
        jdbcTemplate.update("INSERT INTO square(square) VALUES(?)", "К12");

        jdbcTemplate.update("INSERT INTO epoch(epoch) VALUES(?)", "Палеолит");
        jdbcTemplate.update("INSERT INTO epoch(epoch) VALUES(?)", "Мезолит");
        jdbcTemplate.update("INSERT INTO epoch(epoch) VALUES(?)", "Неолит");
        jdbcTemplate.update("INSERT INTO epoch(epoch) VALUES(?)", "Энеолит");
        jdbcTemplate.update("INSERT INTO epoch(epoch) VALUES(?)", "Бронзовый век");

        jdbcTemplate.update("INSERT INTO layer(layer) VALUES(?)", "переотложенный слой отвала с охрой");
        jdbcTemplate.update("INSERT INTO layer(layer) VALUES(?)", "желтовато-розовый охристый");
        jdbcTemplate.update("INSERT INTO layer(layer) VALUES(?)", "переотложенный слой отвала");
        jdbcTemplate.update("INSERT INTO layer(layer) VALUES(?)", "коричневый с ортзандом, корнями и прокалом (очажный)");
        jdbcTemplate.update("INSERT INTO layer(layer) VALUES(?)", "красно-желтый");
        jdbcTemplate.update("INSERT INTO layer(layer) VALUES(?)", "подъем");
        jdbcTemplate.update("INSERT INTO layer(layer) VALUES(?)", "желто-серый перемес");
        jdbcTemplate.update("INSERT INTO layer(layer) VALUES(?)", "перемешанный слой");

        jdbcTemplate.update("INSERT INTO region(region) VALUES(?)", "Ханты-Мансийский АО");
        jdbcTemplate.update("INSERT INTO region(region) VALUES(?)", "Тюменская область");
        jdbcTemplate.update("INSERT INTO region(region) VALUES(?)", "Свердловская область");
        jdbcTemplate.update("INSERT INTO region(region) VALUES(?)", "Ямало-ненецкий АО");

        jdbcTemplate.update("INSERT INTO position(position) VALUES(?)", "Руководитель");
        jdbcTemplate.update("INSERT INTO position(position) VALUES(?)", "Лаборант-исследователь");
        jdbcTemplate.update("INSERT INTO position(position) VALUES(?)", "Лаборант");
        jdbcTemplate.update("INSERT INTO position(position) VALUES(?)", "Научный сотрудник");

        jdbcTemplate.update("INSERT INTO employee(fio, phone, position_id) VALUES(?,?,?)", "Юдина Екатерина Александровна", 1234567, 2);
        jdbcTemplate.update("INSERT INTO employee(fio, phone, position_id) VALUES(?,?,?)", "Дубовцева Екатерина Николаевна", 1237987, 1);

        jdbcTemplate.update("INSERT INTO site(site_title, site_comments, region_id, epoch_id) VALUES(?,?,?,?)", "Барсова гора II/42", "памятник пострадал при бурении нефтяной скважины", 1, 3);

    **/
    }

}