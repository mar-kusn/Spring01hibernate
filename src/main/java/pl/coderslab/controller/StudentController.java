package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Student;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/addformbind")
    public String addForm(Model model) {
        model.addAttribute("student", new Student());

        return "student/addform";
    }
    @PostMapping("/addformbind")
    public String addFormBindPost(Student student,
                                  Model m) {
        m.addAttribute("student", student);

        return "student/details";
    }

    @ModelAttribute("programmingSkillsList")
    public List<String> programmingSkills() {
        return Arrays.asList("Java", "C", "C++", "C#", "PHP", "Ruby", "Python");
    }
    @ModelAttribute("hobbiesList")
    public List<String> hobbies() {
        return Arrays.asList("music", "electronic", "trip", "cars", "computers");
    }
    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

}
