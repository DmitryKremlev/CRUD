package springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springcourse.models.User;
import springcourse.service.UserServiceImpl;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final UserServiceImpl userServiceimpl;

    @Autowired
    public PeopleController(UserServiceImpl userServiceimpl) {
        this.userServiceimpl = userServiceimpl;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", userServiceimpl.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", userServiceimpl.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") User user) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/new";

        userServiceimpl.save(user);
        return "redirect:/people";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", userServiceimpl.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "people/edit";

        userServiceimpl.update(id, user);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userServiceimpl.delete(id);
        return "redirect:/people";
    }
}
