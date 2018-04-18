package org.flow.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.flow.entity.Resource;

import java.util.List;
@Mapper
public interface ResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    Resource selectByPrimaryKey(Long id);

    List<Resource> selectAll();

    int updateByPrimaryKey(Resource record);
}