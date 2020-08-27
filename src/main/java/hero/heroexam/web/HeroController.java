package hero.heroexam.web;

import hero.heroexam.domain.binding.HeroAddBindingModel;
import hero.heroexam.domain.binding.HeroDeleteBindingModel;
import hero.heroexam.domain.service.HeroServiceModel;
import hero.heroexam.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/heroes")
public class HeroController {

    private final HeroService heroService;
    private final ModelMapper modelMapper;


    public HeroController(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/create")
    public String addHero(Model model) {
        if (!model.containsAttribute("heroAddBindingModel")) {
            model.addAttribute("heroAddBindingModel", new HeroAddBindingModel());
        }
        return "create-hero";
    }

    @PostMapping("/create")
    public String addConfirm(@Valid @ModelAttribute("heroAddBindingModel") HeroAddBindingModel heroAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("heroAddBindingModel", heroAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.heroAddBindingModel", bindingResult);

            return "redirect:create";
        } else {

            this.heroService.addHero(this.modelMapper.map(heroAddBindingModel, HeroServiceModel.class));

            return "redirect:/";
        }

    }

    @GetMapping("/details")
    public ModelAndView details(@RequestParam("id") String id, ModelAndView modelAndView) {
        modelAndView.addObject("hero", this.heroService.findById(id));
        modelAndView.setViewName("details-hero");
        return modelAndView;

    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id, ModelAndView modelAndView) {
        modelAndView.addObject("heros", this.heroService.findById(id));
        modelAndView.setViewName("delete-hero");
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public String deleteConfirm(@PathVariable("id") String id, @ModelAttribute("heroDeleteBindingModel") HeroDeleteBindingModel heroDeleteBindingModel,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("heroAddBindingModel", heroDeleteBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.heroDeleteBindingModel", bindingResult);

            return "redirect:delete";
        } else {

            this.heroService.delete(id);

            return "redirect:/";
        }
    }

}
