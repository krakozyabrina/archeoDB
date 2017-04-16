package archeo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ArtifactController {

    @Autowired
    private ArtifactDao artifactDao;

    @GetMapping("/addArtifact")
    public ModelAndView artifactForm() {
//        model.addAttribute("artifact", new Artifact());

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addArtifact");
        mv.addObject("artifact", Artifact.generateRandom());
        //mv.addObject("artifacts", repository.findAll());

        return mv;
    }

    @PostMapping("/addArtifact")
    public ModelAndView artifactSubmit(@ModelAttribute Artifact artifact) {

        artifactDao.save(artifact);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addArtifact");
        mv.addObject("artifact", artifact);

        artifactDao.findAll();

        return mv;
    }

    @GetMapping("/login")
    public ModelAndView loginForm() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");

        return mv;
    }

    @GetMapping("/homepage")
    public ModelAndView homepage() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("homepage");

        return mv;
    }


}