package xian.woniuxy.service;


import xian.woniuxy.entity.Role;

import java.util.List;

public interface RoleService {
    int save(Role role);
    int delete(Integer roleId);
    int update(Role role);
    List<Role> findAll();
    Role findOne(Integer roleId);
    int distPermToRole(Integer roleId,List<Integer> permissionIds);
}
