package xian.woniuxy.service.impl;

import xian.woniuxy.entity.Role;
import xian.woniuxy.entity.User;
import xian.woniuxy.mapper.UserMapper;
import xian.woniuxy.mapper.custom.CustomRoleMapper;
import xian.woniuxy.mapper.custom.CustomUserMapper;
import xian.woniuxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private CustomUserMapper userMapper;

    @Autowired
    private CustomRoleMapper roleMapper;

    @Override
    public int save(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int delete(Integer userId) {
        int rows = userMapper.revokeRoleFromUser(userId);
        rows += userMapper.deleteByPrimaryKey(userId);
        return rows;
    }


    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectByExample(null);
    }

    @Override
    public User findOne(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if(user == null){
            throw  new RuntimeException("can't find User by:" + userId);
        }
        List<Integer> roleIds = userMapper.findRoleIdsByUserId(userId);

        List<Role> roles = new ArrayList<>();
        for (Integer roleId : roleIds) {
            Role role = roleMapper.selectByPrimaryKey(roleId);
            roles.add(role);
        }
        user.setRoles(roles);
        return user;
    }

    @Override
    public int distRoleToUser(Integer userId, List<Integer> roleIds) {
        int rows = userMapper.revokeRoleFromUser(userId);
        if(roleIds.size()<1){
            return rows;
        }
        rows += userMapper.distRoleToUser(userId, roleIds);
        return rows;
    }

    @Override
    public int revokeRoleFromUser(Integer userId) {
        return userMapper.revokeRoleFromUser(userId);
    }

}
