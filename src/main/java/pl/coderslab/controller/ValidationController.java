package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {

    private Validator validator;

    @Autowired
    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/book/validate-body")
    @ResponseBody
    public String validateBookBody() {
        Book b = new Book();
        Set<ConstraintViolation<Book>> violations = this.validator.validate(b);

        if (violations.isEmpty()) {
            return "Walidacja zakończona pomyślnie";
        }

        String violationResultStr = "";
        for (ConstraintViolation<Book> violation : violations) {
            violationResultStr += String.format("<div>%s : %s</div>\r\n",
                    violation.getPropertyPath(), violation.getMessage() );
        }

        return violationResultStr;
    }
}
