package xian.woniuxy.service;


import xian.woniuxy.entity.Permission;

import java.util.List;

public interface PermissionService {
    int save(Permission permission);
    int delete(Integer permissionId);
    int update(Permission permission);
    List<Permission> findAll();
    Permission findOne(Integer permissionId);
    Permission findRoot();
}
