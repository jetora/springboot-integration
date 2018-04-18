package org.flow.service;

import org.flow.dao.mapper.RoleMapper;
import org.flow.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Service

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ResourceService resourceService;

    public int createRole(Role role) {
        return roleMapper.insert(role);
    }

    public int updateRole(Role role) {
        return roleMapper.updateByPrimaryKey(role);
    }

    public void deleteRole(Long roleId) {
        roleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public Role findOne(Long roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public List<Role> findAll() {
        return roleMapper.selectAll();
    }
}
