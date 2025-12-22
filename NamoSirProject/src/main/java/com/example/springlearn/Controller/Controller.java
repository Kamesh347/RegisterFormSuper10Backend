package com.example.springlearn.Controller;

import com.example.springlearn.Entity.RegisterForm;
import com.example.springlearn.Service.RegisterFormService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Nonnull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Form APIs", description = "Operations related to Register Form")
@RestController
@RequestMapping("/form")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {


    private final RegisterFormService service;

    public Controller(RegisterFormService service) {
        this.service = service;
    }

    @GetMapping("/all")
    @Operation(summary = "Get all form info")
    public ResponseEntity<List<RegisterForm>> getAll() {
        return ResponseEntity.ok(service.getAllForms());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get form info by ID")
    public ResponseEntity<RegisterForm> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getFormById(id));
    }

    @GetMapping("/byemail")
    @Operation(summary = "Get form by sender name")
    public ResponseEntity<?> getBySenderName(@Nonnull @RequestParam String name) {

        if (name.length() < 3) {
            return ResponseEntity.badRequest().body("Name length should be at least 3 characters");
        }

        return ResponseEntity.ok(service.getFormBySenderName(name));
    }

    @PostMapping("/add")
    @Operation(summary = "Add new form")
    public ResponseEntity<RegisterForm> addForm(@RequestBody RegisterForm form) {
        int len = form.getBodyParagraph().length();
        System.out.println(" body getBodyParagraph len :"+len);
        int len1 = form.getOpeningParagraph().length();
        System.out.println(" body getOpeningParagraph len :"+len1);

        int len2 = form.getClosingParagraph().length();
        System.out.println(" body getClosingParagraph len :"+len2);


        String opPar = form.getOpeningParagraph();
        System.out.println("1- Paragraph :"+opPar);

        String orgAdd = form.getOrganizationAddress();
        System.out.println("2- Paragraph :"+orgAdd);

        String orgName = form.getOrganizationName();
        System.out.println("3- Paragraph :"+orgName);


        return ResponseEntity.ok(service.saveForm(form));
    }

    @DeleteMapping("/del/{id}")
    @Operation(summary = "Delete form by ID")
    public ResponseEntity<String> deleteForm(@PathVariable int id) {
        service.deleteFormById(id);
        return ResponseEntity.ok("Form deleted successfully");
    }
}
