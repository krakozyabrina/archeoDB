package archeo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArtifactController {

    @Autowired
    private ArtifactRepository repository;

    @Autowired
    private ArtifactDao artifactDao;

    @GetMapping("/addArtifact")
    public ModelAndView greetingForm() {
//        model.addAttribute("greeting", new Artifact());

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addArtifact");
        mv.addObject("artifact", new Artifact());
        mv.addObject("artifacts", repository.findAll());

        return mv;
    }

    @PostMapping("/addArtifact")
    public ModelAndView greetingSubmit(@ModelAttribute Artifact artifact) {


        repository.save(artifact);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addArtifact");
        mv.addObject("artifact", artifact);
        mv.addObject("artifacts", repository.findAll());

        artifactDao.findAll();

        return mv;
    }

}