package org.flow.service;


import org.flow.entity.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface UserService {

    /**
     * 创建用户
     * @param user
     */
    //@Transactional((readOnly = true)
    @Transactional(propagation=Propagation.REQUIRED)
    public int createUser(User user);

    public int updateUser(User user);

    public void deleteUser(Long userId);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword);


    User findOne(Long userId);
    @Transactional(readOnly = true)
    List<User> findAll();

}
