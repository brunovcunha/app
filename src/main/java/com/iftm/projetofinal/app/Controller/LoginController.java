package com.iftm.projetofinal.app.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iftm.projetofinal.app.domain.Login;
import com.iftm.projetofinal.app.domain.Role;
import com.iftm.projetofinal.app.service.LoginService;


import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
    
    @Autowired
    private MenuController menuController;

    @Autowired
    private LoginService loginService;

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("login", new Login("", ""));
        return mv;
    }

    @PostMapping("/login/entrar")
    public String login(HttpSession session, Login loginDigitado, Model model) {

        Login loginBanco = loginService.verificaSenha(loginDigitado);

        if (loginBanco == null) {
            model.addAttribute("loginError", "Senha ou usuário inválidos, tente novamente.");
        return "login";
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        for (Role role : loginBanco.getRoles()) {
            logger.info("Registrando a role " + role.getNome() + " para o usuário logado " + loginBanco.getUsuario());
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getNome()));
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                loginBanco.getUsuario(),
                loginBanco.getSenha(),
                authorities);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext());

                return menuController.getMenus(model,loginBanco.getRoles());
    }
}
