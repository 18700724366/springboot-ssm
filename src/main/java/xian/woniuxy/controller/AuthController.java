package xian.woniuxy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xian.woniuxy.entity.User;
import xian.woniuxy.service.AuthService;
import xian.woniuxy.utli.ResultVo;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("auth/login")
    public ResultVo login(@RequestBody User user){
        User loginUser = authService.login(user.getUsername(), user.getPassword());
        return ResultVo.success(loginUser);
    }
}
