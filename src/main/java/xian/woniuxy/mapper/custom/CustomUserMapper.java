package xian.woniuxy.mapper.custom;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import xian.woniuxy.mapper.UserMapper;

import java.util.List;

@Repository
public interface CustomUserMapper extends UserMapper {
    List<Integer> findRoleIdsByUserId(Integer userId);
    int distRoleToUser(@Param("userId") Integer userId, List<Integer> roleIds);

    int revokeRoleFromUser(Integer userId);

}
