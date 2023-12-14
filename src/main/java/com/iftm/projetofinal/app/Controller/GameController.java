package com.iftm.projetofinal.app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GameController {
    
    @GetMapping("/menu")
    public ModelAndView menuPrincipal() {
        ModelAndView mv = new ModelAndView("menu");
        mv.addObject("usuario", null);
        return mv;
    }
}