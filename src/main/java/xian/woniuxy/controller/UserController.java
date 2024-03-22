package xian.woniuxy.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import xian.woniuxy.config.exception.UploadProperties;
import xian.woniuxy.entity.User;
import xian.woniuxy.service.FileService;
import xian.woniuxy.service.UserService;
import xian.woniuxy.utli.ResultVo;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableConfigurationProperties(UploadProperties.class)
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;
    @Autowired
    private UploadProperties uploadProperties;

    @PostMapping("user/save")
    public ResultVo save(@RequestBody User user){
        int rows = userService.save(user);
        return rows > 0 ? ResultVo.success() : ResultVo.failure();
    }

    @PostMapping("user/delete")
    public ResultVo delete(@RequestBody String userId,HttpServletRequest request){
        if(!StringUtils.hasText(userId)){
            throw new RuntimeException("userId is required!");
        }
        deleteUserPhooByUserId(Integer.valueOf(userId), request);


        int rows = userService.delete(Integer.valueOf(userId));

        return rows > 0 ? ResultVo.success() : ResultVo.failure();
    }

    private void deleteUserPhooByUserId(Integer userId, HttpServletRequest request) {
        User target = userService.findOne(Integer.valueOf(userId));
        String realPath = request.getServletContext().getRealPath("/images");
        fileService.delete(realPath + "/" + target.getPhoto());
    }

    @PostMapping("user/update")
    public ResultVo update(@RequestBody User user,HttpServletRequest request){
        deleteUserPhooByUserId(user.getUserId(),request);
        int rows = userService.update(user);
        return rows > 0 ? ResultVo.success() : ResultVo.failure();
    }
    
    @PostMapping("user/findAll")
    public ResultVo findAll(){
        List<User> list = userService.findAll();
        return ResultVo.success(list);
    }
    
    @PostMapping("user/findOne")
    public ResultVo findOne(@RequestBody String userId){
        if(!StringUtils.hasText(userId)){
            throw new RuntimeException("userId is required!");
        }
        User user = userService.findOne(Integer.valueOf(userId));
        return ResultVo.success(user);
    }


    @PostMapping("user/upload")
    public ResultVo upload(MultipartFile file, HttpServletRequest request) throws IOException {

        String dir = request.getServletContext().getRealPath("/" + uploadProperties.getDir());
        log.debug("文件上传路径：{}",dir);
        String newFileName = fileService.upload(file, dir);
        Map<String,String> map = new HashMap<>();
        String url = uploadProperties.getUrl()+ "/" + newFileName;
        map.put("url",url);
        map.put("newFileName",newFileName);

        return ResultVo.success(map);
    }

    @PostMapping("user/distRoleToUser")
    public ResultVo distRoleToUser(@RequestBody Map map){
        Integer userId = (Integer) map.remove("userId");
        List<Integer> roleIds = (List<Integer>) map.remove("roleIds");
        int rows = userService.distRoleToUser(userId, roleIds);
        return rows>0 ? ResultVo.success() :ResultVo.failure();
    }
}
