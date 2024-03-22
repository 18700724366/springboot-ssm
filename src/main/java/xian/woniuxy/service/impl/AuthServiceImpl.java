package xian.woniuxy.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xian.woniuxy.entity.User;
import xian.woniuxy.entity.UserExample;
import xian.woniuxy.mapper.custom.CustomUserMapper;
import xian.woniuxy.service.AuthService;

import java.util.List;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {
    @Autowired
    private CustomUserMapper userMapper;
    @Override
    public User login(String username, String password) {
        UserExample ue = new UserExample();
        ue.or().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> list = userMapper.selectByExample(ue);
        if(list.size()>0){
            return list.get(0);
        }
        throw new RuntimeException("认证失败");
    }
}
