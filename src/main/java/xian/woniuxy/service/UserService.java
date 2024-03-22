package xian.woniuxy.service;



import xian.woniuxy.entity.User;

import java.util.List;

public interface UserService {
    int save(User user);
    int delete(Integer userId);
    int update(User user);
    List<User> findAll();
    User findOne(Integer userId);
    int distRoleToUser(Integer userId,List<Integer> roleIds);
    int revokeRoleFromUser(Integer userId);
}
