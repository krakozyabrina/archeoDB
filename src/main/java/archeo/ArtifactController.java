package archeo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes(types = {ArtifactsBySquaresAndDepth.class,
        ArtifactsBySquaresOnDepth.class,
        ArtifactsByDays.class,
        EmployeeByArtifactId.class,
        MyFieldInventory.class,
        SizeOfArtifactsBySquareAndDepth.class,
        FieldInventoryByCharacteristic.class,
        FieldInventoryByObjectAndDepth.class,
        FieldInventoryByNumber.class})
public class ArtifactController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ArtifactDao artifactDao;

    @ExceptionHandler
    public ModelAndView handleException(Exception exception) {
        logger.info(exception.toString());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("error", "");
        return mv;
    }

    @GetMapping("/")
    public ModelAndView home() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        mv.addObject("title", "Домашняя страница");
        return mv;
    }

    @GetMapping("/about")
    public ModelAndView about() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("about");
        mv.addObject("title", "О программе");
        return mv;
    }

    @GetMapping("/help")
    public ModelAndView help() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("help");
        mv.addObject("title", "Помощь");
        return mv;
    }

    @GetMapping("/addArtifact")
    public ModelAndView artifactForm() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addArtifact");
        mv.addObject("artifact", new Artifact());
        mv.addObject("materials", artifactDao.findAllMaterials());
        mv.addObject("squares", artifactDao.findAllSquares());
        mv.addObject("epochs", artifactDao.findAllEpochs());
        mv.addObject("layers", artifactDao.findAllLayers());
        mv.addObject("regions", artifactDao.findAllRegions());
        mv.addObject("positions", artifactDao.findAllPositions());
        mv.addObject("employees", artifactDao.findAllEmployees());
        mv.addObject("sites", artifactDao.findAllSites());
        mv.addObject("siteobjects", artifactDao.findAllSiteobjects());
        mv.addObject("characteristics", artifactDao.findAllCharacteristics());
        mv.addObject("title", "Добавление находок");

        return mv;
    }

    @PostMapping("/addArtifact")
    public ModelAndView artifactSubmit(@ModelAttribute Artifact artifact,
                                       BindingResult result,
                                       SessionStatus status) {

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
        mv.addObject("siteobjects", artifactDao.findAllSiteobjects());
        mv.addObject("characteristics", artifactDao.findAllCharacteristics());
        mv.addObject("title", "Добавление находок");
        mv.addObject("error", result.hasErrors());

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
        mv.addObject("materials", artifactDao.findAllMaterials());
        mv.addObject("title", "Добавить материал");

        return mv;
    }

    @PostMapping("/addmaterial")
    public ModelAndView materialSubmit(@ModelAttribute Material material) {

        artifactDao.saveMaterial(material);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addmaterial");
        mv.addObject("material", material);
        mv.addObject("materials", artifactDao.findAllMaterials());
        mv.addObject("title", "Добавить материал");

        return mv;
    }

    @GetMapping("/addsquare")
    public ModelAndView addsquare() {

        ModelAndView mv = new ModelAndView();
        Square square = new Square();
        mv.setViewName("addsquare");
        mv.addObject("square", square);
        mv.addObject("squares", artifactDao.findAllSquares());
        mv.addObject("title", "Добавить квадрат");

        return mv;
    }

    @PostMapping("/addsquare")
    public ModelAndView squareSubmit(@ModelAttribute Square square) {

        artifactDao.saveSquare(square);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addsquare");
        mv.addObject("square", square);
        mv.addObject("squares", artifactDao.findAllSquares());
        mv.addObject("title", "Добавить квадрат");

        return mv;
    }

    @GetMapping("/addepoch")
    public ModelAndView addepoch(Principal principal) {

        ModelAndView mv = new ModelAndView();
        Epoch epoch = new Epoch();
        mv.setViewName("addepoch");
        mv.addObject("title", "Эпоха");
        mv.addObject("epoch", epoch);
        mv.addObject("epochs", artifactDao.findAllEpochs());

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
        mv.addObject("layers", artifactDao.findAllLayers());
        mv.addObject("title", "Добавить слой");

        return mv;
    }

    @PostMapping("/addlayer")
    public ModelAndView layerSubmit(@ModelAttribute Layer layer) {

        artifactDao.saveLayer(layer);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addlayer");
        mv.addObject("layer", layer);
        mv.addObject("layers", artifactDao.findAllLayers());
        mv.addObject("title", "Добавить слой");

        return mv;
    }

    @GetMapping("/addregion")
    public ModelAndView addregion() {

        ModelAndView mv = new ModelAndView();
        Region region = new Region();
        mv.setViewName("addregion");
        mv.addObject("region", region);
        mv.addObject("title", "Добавить регион");
        mv.addObject("regions", artifactDao.findAllRegions());

        return mv;
    }

    @PostMapping("/addregion")
    public ModelAndView regionSubmit(@ModelAttribute Region region) {

        artifactDao.saveRegion(region);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addregion");
        mv.addObject("region", region);
        mv.addObject("regions", artifactDao.findAllRegions());
        mv.addObject("title", "Добавить регион");

        return mv;
    }

    @GetMapping("/addposition")
    public ModelAndView addposition() {

        ModelAndView mv = new ModelAndView();
        Position position = new Position();
        mv.setViewName("addposition");
        mv.addObject("position", position);
        mv.addObject("positions", artifactDao.findAllPositions());
        mv.addObject("title", "Добавить должность");


        return mv;
    }

    @PostMapping("/addposition")
    public ModelAndView positionSubmit(@ModelAttribute Position position) {

        artifactDao.savePosition(position);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addposition");
        mv.addObject("position", position);
        mv.addObject("positions", artifactDao.findAllPositions());
        mv.addObject("title", "Добавить должность");

        return mv;
    }

    @GetMapping("/addemployee")
    public ModelAndView addemployee() {

        ModelAndView mv = new ModelAndView();
        Employee employee = new Employee();
        mv.setViewName("addemployee");
        mv.addObject("employee", employee);
        mv.addObject("employees", artifactDao.findAllEmployees());
        mv.addObject("title","Добавить сотрудника");

        return mv;
    }

    @PostMapping("/addemployee")
    public ModelAndView employeeSubmit(@ModelAttribute Employee employee) {

        artifactDao.saveEmployee(employee);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addemployee");
        mv.addObject("employee", employee);
        mv.addObject("employees", artifactDao.findAllEmployees());
        mv.addObject("title","Добавить сотрудника");

        return mv;
    }

    @GetMapping("/addsite")
    public ModelAndView addsite() {

        ModelAndView mv = new ModelAndView();
        Site site = new Site();
        mv.setViewName("addsite");
        mv.addObject("site", site);
        mv.addObject("sites", artifactDao.findAllSites());
        mv.addObject("epochs", artifactDao.findAllEpochs());
        mv.addObject("hydroobjects", artifactDao.findAllHydroobjects());
        mv.addObject("settlements", artifactDao.findAllSettlements());
        mv.addObject("regions", artifactDao.findAllRegions());
        mv.addObject("title","Добавить памятник");


        return mv;
    }

    @PostMapping("/addsite")
    public ModelAndView siteSubmit(@ModelAttribute Site site) {

        artifactDao.saveSite(site);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addsite");
        mv.addObject("site", site);
        mv.addObject("sites", artifactDao.findAllSites());
        mv.addObject("epochs", artifactDao.findAllEpochs());
        mv.addObject("hydroobjects", artifactDao.findAllHydroobjects());
        mv.addObject("settlements", artifactDao.findAllSettlements());
        mv.addObject("regions", artifactDao.findAllRegions());
        mv.addObject("title","Добавить памятник");

        return mv;
    }

    @GetMapping("/addhydroobject")
    public ModelAndView addhydroobject() {

        ModelAndView mv = new ModelAndView();
        Hydroobject hydroobject = new Hydroobject();
        mv.setViewName("addhydroobject");
        mv.addObject("hydroobject", hydroobject);
        mv.addObject("hydroobjects", artifactDao.findAllHydroobjects());
        mv.addObject("title","Добавить объект гидросети");


        return mv;
    }

    @PostMapping("/addhydroobject")
    public ModelAndView hydroobjectSubmit(@ModelAttribute Hydroobject hydroobject) {

        artifactDao.saveHydroobject(hydroobject);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addhydroobject");
        mv.addObject("hydroobject", hydroobject);
        mv.addObject("hydroobjects", artifactDao.findAllHydroobjects());
        mv.addObject("title","Добавить объект гидросети");

        return mv;
    }

    @GetMapping("/addsettlement")
    public ModelAndView addsettlement() {

        ModelAndView mv = new ModelAndView();
        Settlement settlement = new Settlement();
        mv.setViewName("addsettlement");
        mv.addObject("settlement", settlement);
        mv.addObject("settlements", artifactDao.findAllSettlements());
        mv.addObject("title","Добавить населённый пункт");


        return mv;
    }

    @PostMapping("/addsettlement")
    public ModelAndView settlementSubmit(@ModelAttribute Settlement settlement) {

        artifactDao.saveSettlement(settlement);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addsettlement");
        mv.addObject("settlement", settlement);
        mv.addObject("settlements", artifactDao.findAllSettlements());
        mv.addObject("title","Добавить населённый пункт");

        return mv;
    }

    @GetMapping("/addcharacteristic")
    public ModelAndView addcharacteristic() {

        ModelAndView mv = new ModelAndView();
        Characteristic characteristic = new Characteristic();
        mv.setViewName("addcharacteristic");
        mv.addObject("characteristic", characteristic);
        mv.addObject("characteristics", artifactDao.findAllCharacteristics());
        mv.addObject("title","Добавить характеристику");


        return mv;
    }

    @PostMapping("/addcharacteristic")
    public ModelAndView characteristicSubmit(@ModelAttribute Characteristic characteristic) {

        artifactDao.saveCharacteristic(characteristic);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addcharacteristic");
        mv.addObject("characteristic", characteristic);
        mv.addObject("characteristics", artifactDao.findAllCharacteristics());
        mv.addObject("title","Добавить характеристику");

        return mv;
    }

    @GetMapping("/addsiteobject")
    public ModelAndView addsiteobject() {

        ModelAndView mv = new ModelAndView();
        SiteObject siteobject = new SiteObject();
        mv.setViewName("addsiteobject");
        mv.addObject("siteobject", siteobject);
        mv.addObject("siteobjects", artifactDao.findAllSiteobjects());
        mv.addObject("title","Добавить объект");


        return mv;
    }

    @PostMapping("/addsiteobject")
    public ModelAndView siteobjectSubmit(@ModelAttribute SiteObject siteobject) {

        artifactDao.saveSiteobject(siteobject);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addsiteobject");
        mv.addObject("siteobject", siteobject);
        mv.addObject("siteobjects", artifactDao.findAllSiteobjects());
        mv.addObject("title","Добавить объект");

        return mv;
    }

    @GetMapping("/fieldinventory")
    public ModelAndView fieldinventory() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("fieldinventory");
        Fieldinventory fieldinventory = new Fieldinventory();
        mv.addObject("fieldinventories", artifactDao.fieldInventory());
        mv.addObject("title", "Полевая опись");

        return mv;
    }

    @GetMapping("/fieldinventory_export")
    public ModelAndView fieldinventory_export() {
        List<Fieldinventory> fieldinventories = artifactDao.fieldInventory();
        return new ModelAndView(new FieldInventoryAEV(fieldinventories));
    }

    @GetMapping("/count_artifacts_by_squares_on_depth")
    public ModelAndView query_artifacts_by_squares_on_depth() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("count_artifacts_by_squares_on_depth");
        mv.addObject("artifactsBySquaresOnDepth", new ArtifactsBySquaresOnDepth());
        mv.addObject("fieldinventories", Collections.emptyList());
        mv.addObject("title", "Количество находок по квадратам на заданной глубине");

        return mv;
    }

    @PostMapping("/count_artifacts_by_squares_on_depth")
    public ModelAndView count_artifacts_by_squares_on_depth(@ModelAttribute("artifactsBySquaresOnDepth") ArtifactsBySquaresOnDepth artifactsBySquaresOnDepth) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("count_artifacts_by_squares_on_depth");
        mv.addObject("artifactsBySquaresOnDepth", artifactsBySquaresOnDepth);
        mv.addObject("fieldinventories", artifactDao.countArtifactsBySquares(artifactsBySquaresOnDepth.getFrom(), artifactsBySquaresOnDepth.getTo()));
        mv.addObject("title", "Количество находок по квадратам на заданной глубине");

        return mv;
    }

    @GetMapping("/count_artifacts_by_squares_on_depth_export")
    public ModelAndView count_artifacts_by_squares_on_depth_export(@ModelAttribute("artifactsBySquaresOnDepth") ArtifactsBySquaresOnDepth artifactsBySquaresOnDepth) {
        List<Map<String, Object>> list = artifactDao.countArtifactsBySquares(artifactsBySquaresOnDepth.getFrom(),artifactsBySquaresOnDepth.getTo());
        return new ModelAndView(new CountArtifactsBySquaresOnDepthAEV(list));
    }

    @GetMapping("/field_inventory_by_number")
    public ModelAndView field_inventory_by_number() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("field_inventory_by_number");
        mv.addObject("fieldInventoryByNumber", new FieldInventoryByNumber());
        mv.addObject("fieldinventories", Collections.emptyList());
        mv.addObject("title", "Опись предметов по номеру в описи");

        return mv;
    }

    @PostMapping("/field_inventory_by_number")
    public ModelAndView field_inventory_by_number(@ModelAttribute("fieldInventoryByNumber") FieldInventoryByNumber fieldInventoryByNumber) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("field_inventory_by_number");
        mv.addObject("fieldInventoryByNumber", fieldInventoryByNumber);
        mv.addObject("fieldinventories", artifactDao.fieldInventoryByNumber(fieldInventoryByNumber.getInv_num()));
        mv.addObject("title", "Опись предметов по номеру в описи");

        return mv;
    }

    @GetMapping("/field_inventory_by_number_export")
    public ModelAndView field_inventory_by_number_export(@ModelAttribute("fieldInventoryByNumber") FieldInventoryByNumber fieldInventoryByNumber) {
        List<Map<String, Object>> list = artifactDao.fieldInventoryByNumber(fieldInventoryByNumber.getInv_num());
        return new ModelAndView(new FieldInventoryByNumberAEV(list));
    }

    @GetMapping("/field_inventory_by_number_remove")
    public ModelAndView deleteArtifact(@RequestParam("id") Long id) {
        artifactDao.deleteArtifact(id);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("field_inventory_by_number");
        mv.addObject("title", "Удаление записи завершено");
        return mv;
    }

    @GetMapping("/field_inventory_by_number_change")
    public ModelAndView editArtifact(@RequestParam("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("field_inventory_by_number_change");
        mv.addObject("artifact", artifactDao.findArtifactById(id));
        mv.addObject("materials", artifactDao.findAllMaterials());
        mv.addObject("squares", artifactDao.findAllSquares());
        mv.addObject("epochs", artifactDao.findAllEpochs());
        mv.addObject("layers", artifactDao.findAllLayers());
        mv.addObject("employees", artifactDao.findAllEmployees());
        mv.addObject("sites", artifactDao.findAllSites());
        mv.addObject("siteobjects", artifactDao.findAllSiteobjects());
        mv.addObject("characteristics", artifactDao.findAllCharacteristics());
        mv.addObject("title", "Редактирование предмета по номеру в описи");
        return mv;
    }

    @PostMapping("/field_inventory_by_number_change")
    public ModelAndView updateArtifact(@ModelAttribute Artifact artifact,
                                       BindingResult result,
                                       SessionStatus status) {

        artifactDao.changeArtifact(artifact);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("field_inventory_by_number");
        mv.addObject("fieldinventories", artifactDao.fieldInventoryByNumber(artifact.getInv_num()));
        mv.addObject("title", "Описание предмета скорректировано");
        return mv;
    }

    @GetMapping("/field_inventory_by_characteristic")
    public ModelAndView field_inventory_by_characteristic() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("field_inventory_by_characteristic");
        mv.addObject("fieldInventoryByCharacteristic", new FieldInventoryByCharacteristic());
        mv.addObject("fieldinventories", Collections.emptyList());
        mv.addObject("title", "Опись предметов по характеристике");
        mv.addObject("characteristics", artifactDao.findAllCharacteristics());

        return mv;
    }

    @PostMapping("/field_inventory_by_characteristic")
    public ModelAndView field_inventory_by_characteristic(@ModelAttribute("fieldInventoryByCharacteristic") FieldInventoryByCharacteristic fieldInventoryByCharacteristic) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("field_inventory_by_characteristic");
        mv.addObject("fieldInventoryByCharacteristic", fieldInventoryByCharacteristic);
        mv.addObject("fieldinventories", artifactDao.fieldInventoryByCharacteristic(fieldInventoryByCharacteristic.getCharacteristic_id()));
        mv.addObject("title", "Опись предметов по характеристике");
        mv.addObject("characteristics", artifactDao.findAllCharacteristics());

        return mv;
    }

    @GetMapping("/field_inventory_by_characteristic_export")
    public ModelAndView field_inventory_by_characteristic_export(@ModelAttribute("fieldInventoryByCharacteristic") FieldInventoryByCharacteristic fieldInventoryByCharacteristic) {
        List<Map<String, Object>> list = artifactDao.fieldInventoryByCharacteristic(fieldInventoryByCharacteristic.getCharacteristic_id());
        return new ModelAndView(new FieldInventoryByCharacteristicAEV(list));
    }

    @GetMapping("/field_inventory_by_object_and_depth")
    public ModelAndView field_inventory_by_object_and_depth() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("field_inventory_by_object_and_depth");
        mv.addObject("fieldInventoryByObjectAndDepth", new FieldInventoryByObjectAndDepth());
        mv.addObject("fieldinventories", Collections.emptyList());
        mv.addObject("title", "Опись предметов по объекту и глубине");
        mv.addObject("siteobjects", artifactDao.findAllSiteobjects());

        return mv;
    }

    @PostMapping("/field_inventory_by_object_and_depth")
    public ModelAndView field_inventory_by_object_and_depth(@ModelAttribute("fieldInventoryByObjectAndDepth") FieldInventoryByObjectAndDepth fieldInventoryByObjectAndDepth) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("field_inventory_by_object_and_depth");
        mv.addObject("fieldInventoryByObjectAndDepth", fieldInventoryByObjectAndDepth);
        mv.addObject("fieldinventories", artifactDao.fieldInventoryByObjectAndDepth(fieldInventoryByObjectAndDepth.getSiteobject_id(),fieldInventoryByObjectAndDepth.getFrom(),fieldInventoryByObjectAndDepth.getTo()));
        mv.addObject("title", "Опись предметов по объекту и глубине");
        mv.addObject("siteobjects", artifactDao.findAllSiteobjects());

        return mv;
    }

    @GetMapping("/field_inventory_by_object_and_depth_export")
    public ModelAndView field_inventory_by_object_and_depth_export (@ModelAttribute("fieldInventoryByObjectAndDepth") FieldInventoryByObjectAndDepth fieldInventoryByObjectAndDepth) {
        List<Map<String, Object>> list = artifactDao.fieldInventoryByObjectAndDepth(fieldInventoryByObjectAndDepth.getSiteobject_id(),fieldInventoryByObjectAndDepth.getFrom(),fieldInventoryByObjectAndDepth.getTo());
        return new ModelAndView(new FieldInventoryByObjectAndDepthAEV(list));
    }

    @GetMapping("/count_artifacts_by_material")
    public ModelAndView count_artifacts_by_material() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("count_artifacts_by_material");
        mv.addObject("fieldinventories", artifactDao.countArtifactsByMaterial());
        mv.addObject("title", "Количество находок по материалам");

        return mv;
    }

    @GetMapping("/count_artifacts_by_material_export")
    public ModelAndView count_artifacts_by_material_export() {
        List<Map<String,Object>> list = artifactDao.countArtifactsByMaterial();
        return new ModelAndView(new ArtifactsByMaterialAEV(list));
    }

    @GetMapping("/count_artifacts_by_employee")
    public ModelAndView count_artifacts_by_employee() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("count_artifacts_by_employee");
        mv.addObject("fieldinventories", artifactDao.countArtifactsByEmployee());
        mv.addObject("title", "Количество находок по сотрудникам");

        return mv;
    }

    @GetMapping("/count_artifacts_by_employee_export")
    public ModelAndView count_artifacts_by_employee_export() {
        List<Map<String,Object>> list = artifactDao.countArtifactsByEmployee();
        return new ModelAndView(new ArtifactsByEmployeeAEV(list));
    }

    @GetMapping("/find_employee_by_artifact_id")
    public ModelAndView find_employee_by_artifact_id() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("find_employee_by_artifact_id");
        mv.addObject("employeeByArtifactId", new EmployeeByArtifactId());
        mv.addObject("fieldinventories", Collections.emptyList());
        mv.addObject("title", "Найти сотрудника по номеру находки");

        return mv;
    }

    @PostMapping("/find_employee_by_artifact_id")
    public ModelAndView find_employee_by_artifact_id(
            @ModelAttribute EmployeeByArtifactId employeeByArtifactId,
            BindingResult result,
            SessionStatus status) {

        List<Map<String, Object>> list = artifactDao.findEmployeeByArtifactId(employeeByArtifactId.getArtifactId());

        ModelAndView mv = new ModelAndView();
        mv.setViewName("find_employee_by_artifact_id");
        mv.addObject("employeeByArtifactId", employeeByArtifactId);
        mv.addObject("error", result.hasErrors());
        mv.addObject("notfound", list.isEmpty() && !result.hasErrors());
        mv.addObject("fieldinventories", list);
        mv.addObject("title", "Найти сотрудника по номеру находки");

        return mv;
    }

    @GetMapping("/count_artifacts_by_squares")
    public ModelAndView query_artifacts_by_squares() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("count_artifacts_by_squares");
        mv.addObject("fieldinventories", artifactDao.countArtifactsBySquares());
        mv.addObject("title", "Общее количество находок по квадратам");

        return mv;
    }

    @GetMapping("/count_artifacts_by_squares_export")
    public ModelAndView count_artifacts_by_squares_export() {
        List<Map<String,Object>> list = artifactDao.countArtifactsBySquares();
        return new ModelAndView(new ArtifactsBySquaresAEV(list));
    }

    @GetMapping("/find_my_artifacts")
    public ModelAndView find_my_artifacts() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("find_my_artifacts");
        mv.addObject("myFieldInventory", new MyFieldInventory());
        mv.addObject("fieldinventories", Collections.emptyList());
        mv.addObject("title", "Мои находки");

        return mv;
    }

    @PostMapping("/find_my_artifacts")
    public ModelAndView find_my_artifacts(
            @ModelAttribute MyFieldInventory myFieldInventory,
            BindingResult result,
            SessionStatus status) {

        List<Map<String, Object>> list = artifactDao.findMyArtifacts(myFieldInventory.getName());

        ModelAndView mv = new ModelAndView();
        mv.setViewName("find_my_artifacts");
        mv.addObject("myFieldInventory", myFieldInventory);
        mv.addObject("error", result.hasErrors());
        mv.addObject("notfound", list.isEmpty() && !result.hasErrors());
        mv.addObject("fieldinventories", list);
        mv.addObject("title", "Мои находки");

        return mv;
    }

    @GetMapping("/find_artifacts_by_days")
    public ModelAndView find_artifacts_by_days() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("find_artifacts_by_days");
        mv.addObject("artifactsByDays", new ArtifactsByDays());
        mv.addObject("fieldinventories", Collections.emptyList());
        mv.addObject("title", "Опись находок по заданным дням");

        return mv;
    }

    @PostMapping("/find_artifacts_by_days")
    public ModelAndView find_artifacts_by_days(
            @ModelAttribute("artifactsByDays") ArtifactsByDays artifactsByDays,
            BindingResult result,
            SessionStatus status) {

        List<Map<String, Object>> list = artifactDao.fieldInventoryByPeriod(artifactsByDays.getFrom(),artifactsByDays.getTill());

        ModelAndView mv = new ModelAndView();
        mv.addObject("artifactsByDays", artifactsByDays);
        mv.addObject("error", result.hasErrors());
        mv.addObject("notfound", list.isEmpty() && !result.hasErrors());
        mv.addObject("fieldinventories", list);
        mv.addObject("title", "Опись находок по заданным дням");

        return mv;
    }

    @GetMapping("/find_artifacts_by_days_export")
    public ModelAndView find_artifacts_by_days_export(@ModelAttribute("artifactsByDays") ArtifactsByDays artifactsByDays) {
        List<Map<String, Object>> list = artifactDao.fieldInventoryByPeriod(artifactsByDays.getFrom(),artifactsByDays.getTill());
        return new ModelAndView(new ArtifactsByDaysAEV(list));
    }

    @GetMapping("/field_inventory_by_squares_and_depth")
    public ModelAndView field_inventory_by_squares_and_depth() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("field_inventory_by_squares_and_depth");
        mv.addObject("params", new ArtifactsBySquaresAndDepth());
        mv.addObject("fieldinventories", Collections.emptyList());
        mv.addObject("title", "Опись предметов по заданным квадратам и глубине");

        return mv;
    }

    @GetMapping("/field_inventory_by_squares_and_depth_export")
    public ModelAndView field_inventory_by_squares_and_depth_export(@ModelAttribute("params") ArtifactsBySquaresAndDepth params) {
        List<Map<String, Object>> list = artifactDao.fieldInventoryBySquaresAndDepth(params.getSquares(),params.getDepth_from(), params.getDepth_till());
        return new ModelAndView(new FieldInventoryAbstractExcelView(list));
    }

    @PostMapping("/field_inventory_by_squares_and_depth")
    public ModelAndView field_inventory_by_squares_and_depth(
            @ModelAttribute("params") ArtifactsBySquaresAndDepth params,
            BindingResult result,
            SessionStatus status) {

        List<Map<String, Object>> list = artifactDao.fieldInventoryBySquaresAndDepth(params.getSquares(),params.getDepth_from(), params.getDepth_till());

        ModelAndView mv = new ModelAndView();
        mv.addObject("params", params);
        mv.addObject("error", result.hasErrors());
        mv.addObject("notfound", list.isEmpty() && !result.hasErrors());
        mv.addObject("fieldinventories", list);
        mv.addObject("title", "Опись предметов по заданным квадратам и глубине");

        return mv;
    }

    @GetMapping("/all_sites_description")
    public ModelAndView all_sites_description() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("all_sites_description");
        mv.addObject("fieldinventories", artifactDao.allSitesDescription());
        mv.addObject("title", "Полное описание памятников");

        return mv;
    }

    @GetMapping("/all_sites_description_export")
    public ModelAndView all_sites_description_export() {
        List<Map<String,Object>> list = artifactDao.allSitesDescription();
        return new ModelAndView(new AllSitesAEV(list));
    }

    @GetMapping("/size_of_artifacts_by_square_and_depth")
    public ModelAndView size_of_artifacts_by_square_and_depth() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("size_of_artifacts_by_square_and_depth");
        mv.addObject("sizeOfArtifactsBySquareAndDepth", new SizeOfArtifactsBySquareAndDepth());
        mv.addObject("fieldinventories", Collections.emptyList());
        mv.addObject("title", "Размеры фрагментов по квадрату и глубине");

        return mv;
    }

    @PostMapping("/size_of_artifacts_by_square_and_depth")
    public ModelAndView size_of_artifacts_by_square_and_depth(
            @ModelAttribute SizeOfArtifactsBySquareAndDepth sizeOfArtifactsBySquareAndDepth,
            BindingResult result,
            SessionStatus status) {

        List<Map<String, Object>> list = artifactDao.sizeOfArtifactsBySquareAndDepth(sizeOfArtifactsBySquareAndDepth.getSquares(),sizeOfArtifactsBySquareAndDepth.getDepth_from(), sizeOfArtifactsBySquareAndDepth.getDepth_till());

        ModelAndView mv = new ModelAndView();
        mv.addObject("sizeOfArtifactsBySquareAndDepth", sizeOfArtifactsBySquareAndDepth);
        mv.addObject("error", result.hasErrors());
        mv.addObject("notfound", list.isEmpty() && !result.hasErrors());
        mv.addObject("fieldinventories", list);
        mv.addObject("title", "Размеры фрагментов по квадрату и глубине");

        return mv;
    }

    @GetMapping("/size_of_artifacts_by_square_and_depth_export")
    public ModelAndView size_of_artifacts_by_square_and_depth_export(@ModelAttribute("sizeOfArtifactsBySquareAndDepth") SizeOfArtifactsBySquareAndDepth sizeOfArtifactsBySquareAndDepth) {
        List<Map<String, Object>> list = artifactDao.sizeOfArtifactsBySquareAndDepth(sizeOfArtifactsBySquareAndDepth.getSquares(),sizeOfArtifactsBySquareAndDepth.getDepth_from(), sizeOfArtifactsBySquareAndDepth.getDepth_till());
        return new ModelAndView(new SizeOfArtifactsBySquareAndDepthAEV(list));
    }

}