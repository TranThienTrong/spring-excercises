package com.example.demo.Control;

import com.example.demo.Model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: Tran Thien Trong
 * @Date: 2/9/2021
 * @Desc: This class is model hold person information
 * */

@Controller
@RequestMapping("/")
public class RegisterController {

    private final RegisterDAO registerDAO;

    @Autowired
    public RegisterController(RegisterDAO registerDAO){
        this.registerDAO = registerDAO;
    }

    /**
        @URL: http://localhost:8080/registers
     */
    @GetMapping(value = "/registers")
    public String showAllRegister(Model model){
        List<Register> registerList = registerDAO.findAll();
        model.addAttribute("registersList",registerList);
        return "registers/register-list";
    }

    /**
        @URL: http://localhost:8080/addForm
     */
    @RequestMapping("/addForm")
    public String showAddForm(Model model) {
        model.addAttribute("register", new Register());
        return "registers/register-form";
    }

    /**
        @URL: http://localhost:8080/save
     */
    @PostMapping(value = "/save")
    public String processForm(@Valid @ModelAttribute("register") Register register, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "registers/register-form";
        }
        else {
            registerDAO.addRegister(register);
            return "redirect:/registers";
        }
    }

    /**
        @URL: http://localhost:8080/update
     */
    @GetMapping(value = "/update")
    public String updateRegister(@RequestParam("registerId") int id, Model model){
            Register register = registerDAO.getById(id);
            model.addAttribute("register", register);
            return "registers/register-form";
    }

    /**
        @URL: http://localhost:8080/delete
     */
    @GetMapping("/delete")
    public String deleteRegister(@RequestParam("registerId") int id){
        registerDAO.deleteById(id);
        return "redirect:/registers";
    }


    /* This method use for trim every input to controller */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

}
