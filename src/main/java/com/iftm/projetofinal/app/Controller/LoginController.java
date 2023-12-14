package com.iftm.projetofinal.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iftm.projetofinal.app.domain.Login;
import com.iftm.projetofinal.app.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("login", new Login());
        return mv;
    }

    @PostMapping("login")
    public String login(Login login, Model model) {
        if (loginService.verificaSenha(login) != null) {
            return "redirect:/menu";
        } else {
            model.addAttribute("loginError", "Senha ou usuário inválidos, tente novamente.");
            return "login";
        }
    }
}
