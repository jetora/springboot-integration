package org.flow.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.flow.entity.Organization;

import java.util.List;
@Mapper
public interface OrganizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Organization record);

    Organization selectByPrimaryKey(Long id);

    List<Organization> selectAll();

    int updateByPrimaryKey(Organization record);
}