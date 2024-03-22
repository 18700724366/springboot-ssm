package xian.woniuxy.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xian.woniuxy.entity.Role;
import xian.woniuxy.mapper.custom.CustomRoleMapper;
import xian.woniuxy.service.RoleService;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private CustomRoleMapper roleMapper;
    @Override
    public int save(Role role) {
        return roleMapper.insertSelective(role);
    }

    @Override
    public int delete(Integer roleId) {
        return roleMapper.deleteByPrimaryKey(roleId);
    }


    @Override
    public int update(Role role) {
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public List<Role> findAll() {
        return roleMapper.selectByExample(null);
    }

    @Override
    public Role findOne(Integer roleId) {
        Role role = roleMapper.findRoleWithPermissionByRoleId(roleId);
        if(role == null){
            throw  new RuntimeException("can't find Role by:" + roleId);
        }
        return role;
    }

    @Override
    public int distPermToRole(Integer roleId, List<Integer> permissionIds) {
        int rows = roleMapper.revokePermFromRole(roleId);
        if(permissionIds.size() < 1){
            return rows;
        }
        rows += roleMapper.distPermToRole(roleId,permissionIds);
        return rows;
    }

}
