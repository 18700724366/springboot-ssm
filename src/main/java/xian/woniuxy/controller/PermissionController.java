package xian.woniuxy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xian.woniuxy.entity.Permission;
import xian.woniuxy.service.PermissionService;
import xian.woniuxy.utli.ResultVo;

import java.util.Arrays;
import java.util.List;

@RestController
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @PostMapping("permission/save")
    public ResultVo save(@RequestBody Permission permission){
        int rows = permissionService.save(permission);
        return rows > 0 ? ResultVo.success() : ResultVo.failure();
    }

    @PostMapping("permission/delete")
    public ResultVo delete(@RequestBody String permissionId){
        if(!StringUtils.hasText(permissionId)){
            throw new RuntimeException("permissionId is required!");
        }
        int rows = permissionService.delete(Integer.valueOf(permissionId));
        return rows > 0 ? ResultVo.success() : ResultVo.failure();
    }

    @PostMapping("permission/update")
    public ResultVo update(@RequestBody Permission permission){
        int rows = permissionService.update(permission);
        return rows > 0 ? ResultVo.success() : ResultVo.failure();
    }
    
    @PostMapping("permission/findAll")
    public ResultVo findAll(){
        List<Permission> list = permissionService.findAll();
        return ResultVo.success(list);
    }
    
    @PostMapping("permission/findOne")
    public ResultVo findOne(@RequestBody String permissionId){
        if(!StringUtils.hasText(permissionId)){
            throw new RuntimeException("permissionId is required!");
        }
        Permission permission = permissionService.findOne(Integer.valueOf(permissionId));
        return ResultVo.success(permission);
    }

    @PostMapping("permission/findAllAsTree")
    public ResultVo findAllAsTree(){
        Permission root = permissionService.findRoot();
        return ResultVo.success(Arrays.asList(root));
    }
}
