package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Period;

/**
 * Kontroler obsluhující registraci účastníků dětského tábora.
 */



  @Controller
  public class RegistraceController {

  @GetMapping("/")
  public ModelAndView formular() {
    ModelAndView modelAndView = new ModelAndView("/formular");
    modelAndView.addObject("form", new RegistraceForm());
    return modelAndView;
  }

    @PostMapping("")
    public Object form(@Valid @ModelAttribute("form") RegistraceForm form, BindingResult bindingResult) {


      /*Period period = datumNarozeni.until(LocalDate.now());
      int vek = period.getYears();

      if (vek < 9 && vek > 15){
        System.out.println("Dite nesmi byt mladsi 9 let a starsi 15 let.");
      }*/

      if (bindingResult.hasErrors()) {
        return "/formular";
      }

      return new ModelAndView("/rekapitulace");
    }
  }

