package xian.woniuxy.service;


import xian.woniuxy.entity.User;

public interface AuthService {
    User login(String username, String password);
}
