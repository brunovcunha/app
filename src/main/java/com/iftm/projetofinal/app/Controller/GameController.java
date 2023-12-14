package com.iftm.projetofinal.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.iftm.projetofinal.app.dao.GameDao;

@Controller
public class GameController {
    
    @Autowired

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("usuario", null);
        return mv;
    }
    
    @PostMapping

    @GetMapping("/menu")
    public ModelAndView menuPrincipal() {
        ModelAndView mv = new ModelAndView("menu");
        mv.addObject("usuario", null);
        return mv;
    }
    
    
}