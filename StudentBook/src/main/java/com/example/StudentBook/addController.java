package com.example.StudentBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class addController {
    private PersonRepo personRepo;
    @Autowired
    public addController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @RequestMapping("/")
    public String index() {
        return "addData";
    }

    @RequestMapping("/add")
    public String addData(
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("indeks") String indeks,
            @RequestParam("email") String email,
            @RequestParam("description") String description, Model model) throws Exception {

        Person person = new Person(firstname, lastname, indeks, email, description, true);
        personRepo.save(person);
        model.addAttribute("person", person);
        return "View";
    }

    @RequestMapping("/show")
    public String show(Model model) {
        model.addAttribute("people", personRepo.findAll());
        return "show";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model) {
        personRepo.deleteById(id);
        model.addAttribute("person", personRepo.findAll());
        return "show";
    }

    @RequestMapping("/search")
    public String search(@RequestParam("last") String last, Model model){
        model.addAttribute("people", personRepo.findAllBylastname(last));
        return "show";
    }

    @RequestMapping("/redirect")
    public String redirect(@RequestParam("id") Long id, Model model) throws Exception {
        model.addAttribute("person", personRepo.findById(id));
        return "update";
    }

    @RequestMapping("/update")
    public String update(
            @RequestParam("id") Long id,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("indeks") String indeks,
            @RequestParam("email") String email,
            @RequestParam("description") String description, Model model) throws Exception {
        Person person = new Person(id, firstname, lastname, indeks, email, description, false);
        personRepo.save(person);
        model.addAttribute("person", person);
        return "View";
    }
}