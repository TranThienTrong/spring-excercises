package com.example.demo.Control;

import com.example.demo.Model.Person;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * @Author: Thien Trong
 * @Date: 19/8/2021
 * @Desc: This class control all request
 * */
@Controller
public class RegisterFormController {
    @RequestMapping("/")
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return "form/register-form";
    }

    @RequestMapping(value = "/validatingForm", method = RequestMethod.POST)
    public String processForm( @Valid @ModelAttribute("person") Person person, BindingResult bindingResult) throws ParseException {
        if (bindingResult.hasErrors()) {
            return "form/register-form";
        } else {
            return "form/register-confirmation";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @InitBinder
    public void initBinder2(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(LocalDate.class, new CustomDateEditor(sdf, true));
    }
}
