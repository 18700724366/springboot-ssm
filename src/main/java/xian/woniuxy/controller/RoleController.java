package xian.woniuxy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xian.woniuxy.entity.Role;
import xian.woniuxy.service.RoleService;
import xian.woniuxy.utli.ResultVo;

import java.util.List;
import java.util.Map;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("role/save")
    public ResultVo save(@RequestBody Role role){
        int rows = roleService.save(role);
        return rows > 0 ? ResultVo.success() : ResultVo.failure();
    }

    @PostMapping("role/delete")
    public ResultVo delete(@RequestBody String roleId){
        if(!StringUtils.hasText(roleId)){
            throw new RuntimeException("roleId is required!");
        }
        int rows = roleService.delete(Integer.valueOf(roleId));
        return rows > 0 ? ResultVo.success() : ResultVo.failure();
    }

    @PostMapping("role/update")
    public ResultVo update(@RequestBody Role role){
        int rows = roleService.update(role);
        return rows > 0 ? ResultVo.success() : ResultVo.failure();
    }
    
    @PostMapping("role/findAll")
    public ResultVo findAll(){
        List<Role> list = roleService.findAll();
        return ResultVo.success(list);
    }
    
    @PostMapping("role/findOne")
    public ResultVo findOne(@RequestBody String roleId){
        if(!StringUtils.hasText(roleId)){
            throw new RuntimeException("roleId is required!");
        }
        Role role = roleService.findOne(Integer.valueOf(roleId));
        return ResultVo.success(role);
    }

    @PostMapping("role/distPermToRole")
    public ResultVo distPermToRole(@RequestBody Map<String, Object> map){
        Integer roleId = (Integer) map.remove("roleId");
        List<Integer> permissionIds = (List<Integer>) map.remove("permissionIds");
        int rows = roleService.distPermToRole(roleId, permissionIds);
        return rows > 0 ? ResultVo.success() : ResultVo.failure();
    }

}
