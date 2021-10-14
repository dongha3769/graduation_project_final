package dev.yhp.db.controller;

import dev.yhp.db.enums.user.LoginResult;
import dev.yhp.db.enums.user.RegisterResult;
import dev.yhp.db.models.UserModel;
import dev.yhp.db.services.UserService;
import dev.yhp.db.vos.user.LoginVo;
import dev.yhp.db.vos.user.RegisterVo;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.sql.SQLException;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes({UserModel.Name})
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String registerGet() {
        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String registerPost(RegisterVo registerVo, Model model) throws SQLException {
        this.userService.register(registerVo);
        if(registerVo.getResult() == RegisterResult.SUCCESS){
            return  "user/register.done";
        }else{
            model.addAttribute("registerVo",registerVo);
            return "user/register";

        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String loginGet(
            @ModelAttribute(UserModel.Name) UserModel userModel) {
        if (userModel == null) {
            return "user/login";
        } else {
            return "user/ldh";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String loginPost(LoginVo loginVo, Model model) throws SQLException{
        this.userService.login(loginVo);
        if (loginVo.getResult() == LoginResult.SUCCESS) {
            model.addAttribute(UserModel.Name, loginVo.getUserModel());
            return "user/ldh";
        } else {
            return "user/login";
        }
    }

    @ModelAttribute(UserModel.Name)
    public UserModel userModel() {
        return null;
    }
}
