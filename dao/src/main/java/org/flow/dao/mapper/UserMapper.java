package org.flow.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.flow.entity.User;

import java.util.List;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}