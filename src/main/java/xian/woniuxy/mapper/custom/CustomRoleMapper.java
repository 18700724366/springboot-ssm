package xian.woniuxy.mapper.custom;

import xian.woniuxy.entity.Role;
import xian.woniuxy.mapper.RoleMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomRoleMapper extends RoleMapper {
    Role findRoleWithPermissionByRoleId(Integer roleId);
    int distPermToRole(@Param("roleId") Integer roleId, List<Integer> permissionIds);

    int revokePermFromRole(Integer roleId);
}
