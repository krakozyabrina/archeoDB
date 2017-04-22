package archeo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Map;

@Controller
public class ArtifactController {

    @Autowired
    private ArtifactDao artifactDao;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/addArtifact")
    public ModelAndView artifactForm() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addArtifact");
        mv.addObject("artifact", Artifact.generateRandom());
        mv.addObject("materials", artifactDao.findAllMaterials());
        mv.addObject("squares", artifactDao.findAllSquares());
        mv.addObject("epochs", artifactDao.findAllEpochs());
        mv.addObject("layers", artifactDao.findAllLayers());
        mv.addObject("regions", artifactDao.findAllRegions());
        mv.addObject("positions", artifactDao.findAllPositions());
        mv.addObject("employees", artifactDao.findAllEmployees());
        mv.addObject("sites", artifactDao.findAllSites());

        return mv;
    }

    @PostMapping("/addArtifact")
    public ModelAndView artifactSubmit(@ModelAttribute Artifact artifact) {

        artifactDao.save(artifact);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addArtifact");
        mv.addObject("artifact", artifact);
        mv.addObject("materials", artifactDao.findAllMaterials());
        mv.addObject("squares", artifactDao.findAllSquares());
        mv.addObject("epochs", artifactDao.findAllEpochs());
        mv.addObject("layers", artifactDao.findAllLayers());
        mv.addObject("regions", artifactDao.findAllRegions());
        mv.addObject("positions", artifactDao.findAllPositions());
        mv.addObject("employees", artifactDao.findAllEmployees());
        mv.addObject("sites", artifactDao.findAllSites());

        artifactDao.findAll();

        return mv;
    }

    @GetMapping("/login")
    public ModelAndView loginForm() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");

        return mv;
    }

    @PostMapping("/login")
    public ModelAndView logoutForm() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");

        return mv;
    }

    @GetMapping("/addmaterial")
    public ModelAndView addmaterial() {

        ModelAndView mv = new ModelAndView();
        Material material = new Material();
        mv.setViewName("addmaterial");
        mv.addObject("material", material);

        return mv;
    }

    @PostMapping("/addmaterial")
    public ModelAndView materialSubmit(@ModelAttribute Material material) {

        artifactDao.saveMaterial(material);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addmaterial");
        mv.addObject("material", material);
        mv.addObject("materials", artifactDao.findAllMaterials());

        return mv;
    }

    @GetMapping("/addsquare")
    public ModelAndView addsquare() {

        ModelAndView mv = new ModelAndView();
        Square square = new Square();
        mv.setViewName("addsquare");
        mv.addObject("square", square);

        return mv;
    }

    @PostMapping("/addsquare")
    public ModelAndView squareSubmit(@ModelAttribute Square square) {

        artifactDao.saveSquare(square);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addsquare");
        mv.addObject("square", square);
        mv.addObject("squares", artifactDao.findAllSquares());

        return mv;
    }

    @GetMapping("/addepoch")
    public ModelAndView addepoch() {

        ModelAndView mv = new ModelAndView();
        Epoch epoch = new Epoch();
        mv.setViewName("addepoch");
        mv.addObject("epoch", epoch);

        return mv;
    }

    @PostMapping("/addepoch")
    public ModelAndView epochSubmit(@ModelAttribute Epoch epoch) {

        artifactDao.saveEpoch(epoch);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addepoch");
        mv.addObject("epoch", epoch);
        mv.addObject("epochs", artifactDao.findAllEpochs());

        return mv;
    }

    @GetMapping("/addlayer")
    public ModelAndView addlayer() {

        ModelAndView mv = new ModelAndView();
        Layer layer = new Layer();
        mv.setViewName("addlayer");
        mv.addObject("layer", layer);

        return mv;
    }

    @PostMapping("/addlayer")
    public ModelAndView layerSubmit(@ModelAttribute Layer layer) {

        artifactDao.saveLayer(layer);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addlayer");
        mv.addObject("layer", layer);
        mv.addObject("layers", artifactDao.findAllLayers());

        return mv;
    }

    @GetMapping("/addregion")
    public ModelAndView addregion() {

        ModelAndView mv = new ModelAndView();
        Region region = new Region();
        mv.setViewName("addregion");
        mv.addObject("region", region);

        return mv;
    }

    @PostMapping("/addregion")
    public ModelAndView regionSubmit(@ModelAttribute Region region) {

        artifactDao.saveRegion(region);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addregion");
        mv.addObject("region", region);
        mv.addObject("regions", artifactDao.findAllRegions());

        return mv;
    }

    @GetMapping("/addposition")
    public ModelAndView addposition() {

        ModelAndView mv = new ModelAndView();
        Position position = new Position();
        mv.setViewName("addposition");
        mv.addObject("position", position);

        return mv;
    }

    @PostMapping("/addposition")
    public ModelAndView positionSubmit(@ModelAttribute Position position) {

        artifactDao.savePosition(position);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addposition");
        mv.addObject("position", position);
        mv.addObject("positions", artifactDao.findAllPositions());

        return mv;
    }

    @GetMapping("/addemployee")
    public ModelAndView addemployee() {

        ModelAndView mv = new ModelAndView();
        Employee employee = new Employee();
        mv.setViewName("addemployee");
        mv.addObject("employee", employee);

        return mv;
    }

    @PostMapping("/addemployee")
    public ModelAndView employeeSubmit(@ModelAttribute Employee employee) {

        artifactDao.saveEmployee(employee);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addemployee");
        mv.addObject("employee", employee);
        mv.addObject("employees", artifactDao.findAllEmployees());

        return mv;
    }

    @GetMapping("/addsite")
    public ModelAndView addsite() {

        ModelAndView mv = new ModelAndView();
        Site site = new Site();
        mv.setViewName("addsite");
        mv.addObject("site", site);

        return mv;
    }

    @PostMapping("/addsite")
    public ModelAndView siteSubmit(@ModelAttribute Site site) {

        artifactDao.saveSite(site);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addsite");
        mv.addObject("site", site);
        mv.addObject("sites", artifactDao.findAllSites());

        return mv;
    }

    @GetMapping("/fieldinventory")
    public ModelAndView fieldinventory() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("fieldinventory");
        Fieldinventory fieldinventory = new Fieldinventory();
        mv.addObject("fieldinventory", fieldinventory);
        mv.addObject("fieldinventories", artifactDao.fieldInventory());

        return mv;
    }

    @GetMapping("/count_artifacts_by_squares_on_depth")
    public ModelAndView query_artifacts_by_squares_on_depth() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("count_artifacts_by_squares_on_depth");
        mv.addObject("params", new ArtifactsBySquaresOnDepth());
        mv.addObject("fieldinventories", Collections.emptyList());

        return mv;
    }

    @PostMapping("/count_artifacts_by_squares_on_depth")
    public ModelAndView count_artifacts_by_squares_on_depth(@ModelAttribute ArtifactsBySquaresOnDepth params) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("count_artifacts_by_squares_on_depth");
        mv.addObject("params", params);
        mv.addObject("fieldinventories", artifactDao.countArtifactsBySquares(params.getFrom(), params.getTo()));

        return mv;
    }

    @GetMapping("/count_artifacts_by_material")
    public ModelAndView count_artifacts_by_material() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("count_artifacts_by_material");
        mv.addObject("fieldinventories", artifactDao.countArtifactsByMaterial());

        return mv;
    }

    @GetMapping("/count_artifacts_by_employee")
    public ModelAndView count_artifacts_by_employee() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("count_artifacts_by_employee");
        mv.addObject("fieldinventories", artifactDao.countArtifactsByEmployee());

        return mv;
    }

    @GetMapping("/find_employee_by_artifact_id")
    public ModelAndView find_employee_by_artifact_id() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("find_employee_by_artifact_id");
        mv.addObject("params", new EmployeeByArtifactId());
        mv.addObject("fieldinventories", Collections.emptyList());

        return mv;
    }

    @PostMapping("/find_employee_by_artifact_id")
    public ModelAndView find_employee_by_artifact_id(@ModelAttribute EmployeeByArtifactId params) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("find_employee_by_artifact_id");
        mv.addObject("params", params);
        mv.addObject("fieldinventories", artifactDao.findEmployeeByArtifactId(params.getArtifactId()));

        return mv;
    }

}