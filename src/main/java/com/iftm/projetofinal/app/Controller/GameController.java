package com.iftm.projetofinal.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        Jogador jogaNovo = dao.getJogador(jogador.getCod_jogador());
        
        if (jogaNovo == null) {
            dao.cadastrarJogador(jogador);
        } else {
            dao.atualizarJogador(jogador);
        }

        return listagem();
    }

    @RequestMapping("listagem")
    public ModelAndView listagem() {
        ModelAndView mv = new ModelAndView("listagem");
        mv.addObject("jogador", new Jogador());
        mv.addObject("joCadastrados", dao.getJogadores());
        return mv;
    }

    @RequestMapping("buscar")
    public ModelAndView listagem(@RequestParam(value = "apelido", required = true) String apelido) {
        ModelAndView mv = new ModelAndView("listagem");
        mv.addObject("joCadastrados", dao.getJogador(apelido));
        return mv;
    }

    @RequestMapping("remover")
    public ModelAndView remover(@RequestParam(value = "id", required = true) int id) {
        dao.apagarJogador(id);
        return listagem();
    }
    
    @RequestMapping("editar")
    public ModelAndView editar(@RequestParam(value = "id", required = true) int id) {
        Jogador jogador = dao.getJogador(id);

        ModelAndView mv = new ModelAndView("cadastro");
        mv.addObject("usuario", jogador);
        mv.addObject("cadastros", dao.getJogadores());

        return mv;
    }
}