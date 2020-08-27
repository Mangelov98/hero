package hero.heroexam.web;

import hero.heroexam.service.HeroService;
import hero.heroexam.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private final UserService userService;
    private final HeroService heroService;

    public HomeController(UserService userService, HeroService heroService) {
        this.userService = userService;
        this.heroService = heroService;
    }


    @GetMapping("/")
    public ModelAndView home(HttpSession httpSession, ModelAndView modelAndView) {
        if (httpSession.getAttribute("user") == null) {
            modelAndView.setViewName("index");
        } else {
            modelAndView.addObject("user", httpSession.getAttribute("user"));
            modelAndView.addObject("heroes", this.heroService.findAllHeroes());
            modelAndView.setViewName("home");
        }
        return modelAndView;
    }

}
