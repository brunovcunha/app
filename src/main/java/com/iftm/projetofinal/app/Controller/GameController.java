package com.iftm.projetofinal.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iftm.projetofinal.app.dao.GameDao;
import com.iftm.projetofinal.app.domain.Jogador;

@Controller
public class GameController {

    @Autowired
    private GameDao dao;

    @RequestMapping("cadastro")
    public ModelAndView cadastro() {
        ModelAndView mv = new ModelAndView("cadastro");
        mv.addObject("jogador", new Jogador());
        mv.addObject("joCadastrados", dao.getJogadores());
        return mv;
    }

    @PostMapping("cadastro")
    public ModelAndView cadastro(Jogador jogador) {
        Jogador jog = 
        ModelAndView mv = new ModelAndView("menu");
        mv.addObject("usuario", null);
        return mv;
    }
}