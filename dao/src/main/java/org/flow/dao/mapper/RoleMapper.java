package org.flow.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.flow.entity.Role;

import java.util.List;
@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);
}