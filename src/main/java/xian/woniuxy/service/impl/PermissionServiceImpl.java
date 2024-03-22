package xian.woniuxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xian.woniuxy.entity.Permission;
import xian.woniuxy.entity.PermissionExample;
import xian.woniuxy.mapper.PermissionMapper;
import xian.woniuxy.service.PermissionService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public int save(Permission permission) {
        return permissionMapper.insertSelective(permission);
    }

    @Override
    public int delete(Integer permissionId) {
        List<Permission> children = getChildrenByPermissionId(permissionId);
        if(!children.isEmpty()){
            throw new RuntimeException("can't delete the target permission which is a parent");
        }
        return permissionMapper.deleteByPrimaryKey(permissionId);
    }

    private List<Permission> getChildrenByPermissionId(Integer permissionId) {
        PermissionExample pe = new PermissionExample();
        pe.or().andParentIdEqualTo(permissionId);
        List<Permission> children = permissionMapper.selectByExample(pe);
        return children;
    }

    @Override
    public int update(Permission permission) {
        return permissionMapper.updateByPrimaryKeySelective(permission);
    }

    @Override
    public List<Permission> findAll() {
        return permissionMapper.selectByExample(null);
    }

    @Override
    public Permission findOne(Integer permissionId) {
        Permission permission = permissionMapper.selectByPrimaryKey(permissionId);
        if(permission == null){
            throw  new RuntimeException("can't find Permission by:" + permissionId);
        }
        return permission;
    }

    @Override
    public Permission findRoot() {
        List<Permission> permissions = this.findAll();
        Permission root = null;
        for (Permission permission : permissions) {
            if(permission.getParentId() == -1){
                root = permission;
                break;
            }
        }
        fillChildren(permissions,root);

        return root;
    }
    private void fillChildren(List<Permission> permissions,Permission p){
        List<Permission> children = new ArrayList<>();
        for (Permission permission : permissions) {
            if(permission.getParentId().equals(p.getPermissionId())){
                children.add(permission);
            }
        }
        p.setChildren(children);
        if(p.getChildren().size()>0){
            for (Permission child : children) {
                fillChildren(permissions,child);
            }
        }

    }
}
