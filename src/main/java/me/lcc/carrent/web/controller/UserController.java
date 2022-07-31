package me.lcc.carrent.web.controller;

import me.lcc.carrent.domain.bo.BusinessBo;
import me.lcc.carrent.service.UserService;
import me.lcc.carrent.web.CarRentAuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author lcc
 * @version 2022/7/30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ModelAndView register(String userId, String password, RedirectAttributes redirectAttributes) {
        BusinessBo businessBo = userService.register(userId, password);

        redirectAttributes.addFlashAttribute("msg", businessBo.getMessage());
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", businessBo.getMessage());
        if (!businessBo.isSuccess()) {
            mv.setViewName("register.html");
        } else {
            mv.setViewName("login.html");
        }
        return mv;
    }

    @RequestMapping("/logInFail")
    public ModelAndView logInFailPage(@RequestAttribute("SPRING_SECURITY_LAST_EXCEPTION") CarRentAuthenticationException exception) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register.html");
        mv.addObject("message", exception.getMessage());
        return mv;
    }
}
