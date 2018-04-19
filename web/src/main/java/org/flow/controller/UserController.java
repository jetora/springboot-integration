package org.flow.controller;
import javax.annotation.Resource;

import org.flow.common.enums.Message;
import org.flow.common.exception.ResourceNotFoundException;
import org.flow.entity.User;
import org.springframework.http.ResponseEntity;
import org.flow.service.UserService;
import org.flow.utils.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import java.util.List;
import org.flow.common.enums.Message;

@RestController
@RequestMapping(value = "/user")
public class UserController{
    private static final Logger log = Logger.getLogger(UserController.class);

    @Resource
    private UserService userService ;
    /*
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object list() { // 通过model可以实现内容的传递
        return this.userService.findAll() ;
    }
    */
    @GetMapping(value = "/list", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<List<User>> getUsers(){
        ResponseResult<List<User>> result= new ResponseResult<>();
        try{
            List<User> userslist = userService.findAll();
            if (userslist.isEmpty()){
                log.error("空",new ResourceNotFoundException(String.valueOf(userslist.size())));
                //throw new ResourceNotFoundException(String.valueOf(userslist.size()));
                result.setCode(String.valueOf(HttpStatus.NOT_FOUND));
                result.setCode(Message.NOT_FOUND.toString());
            }else{
                result.setCode(String.valueOf(HttpStatus.OK));
                result.setData(userslist);
                result.setMsg(Message.SUCCESS.toString());
            }
        }catch (Exception e){
            //e.printStackTrace();
            log.error("查询失败。。。",e);
        }
        return result;
    }
    /**
     * 根据用户id查询用户数据
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<User> getUserById(@PathVariable Long id) {
        ResponseResult<User> result = new ResponseResult<>();
        try{
            User user = userService.findOne(id);
            if (user == null) {
                //throw new ResourceNotFoundException(String.valueOf(id));
                //log.error("",new ResourceNotFoundException(String.valueOf(id)));
                result.setCode(String.valueOf(HttpStatus.NOT_FOUND));
                result.setMsg(Message.NOT_FOUND.toString());
            }else {
                result.setCode(String.valueOf(HttpStatus.OK));
                result.setMsg(Message.SUCCESS.toString());
                result.setData(user);
            }
        }catch (Exception e){
            //e.printStackTrace();
            log.error("查询失败。。。",e);
        }
        return result;
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @PostMapping(value = "", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<User> insertSaveUser(@RequestBody User user){
        ResponseResult<User> result = new ResponseResult<>();
        try {
            userService.createUser(user);
            result.setCode(String.valueOf(HttpStatus.OK));
            result.setMsg(Message.SUCCESS.toString());
            result.setData(user);
        } catch (Exception e) {
            result.setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            result.setMsg(Message.FAIL.toString());
            result.setData(null);
            log.error("新增User失败！", e);
        }
        return result;
    }
    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @PutMapping(value = "", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<User> updateSaveUser(@RequestBody User user){
        ResponseResult<User> result = new ResponseResult<>();
        try {
            System.out.println(user);
            userService.updateUser(user);
            result.setCode(String.valueOf(HttpStatus.OK));
            result.setMsg(Message.SUCCESS.toString());
        } catch(Exception e) {
            result.setCode(String.valueOf(HttpStatus.NOT_FOUND));
            result.setMsg(Message.FAIL.toString());
        }
        return result;
    }
    /**
     * 删除用户
     *
     * @param user
     * @return
     */
    @DeleteMapping(value = "/{id}", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<User> deleteSaveUser(@PathVariable Long id){
        ResponseResult<User> result = new ResponseResult<>();
        try {
            userService.deleteUser(id);
            result.setCode(String.valueOf(HttpStatus.OK));
            result.setMsg(Message.SUCCESS.toString());
        } catch(Exception e){
            result.setCode(String.valueOf(HttpStatus.NOT_FOUND));
            result.setMsg(Message.FAIL.toString());
        }
        return result;
    }

}
