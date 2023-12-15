package com.iftm.projetofinal.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameController {

    @Autowired

    @GetMapping("/cadastro")
    public ModelAndView cadastro() {
        ModelAndView mv = new ModelAndView("cadastro");
        mv.addObject("usuario", null);
        return mv;
    }

    @GetMapping("/menu")
    public ModelAndView menuPrincipal() {
        ModelAndView mv = new ModelAndView("menu");
        mv.addObject("usuario", null);
        return mv;
    }

}