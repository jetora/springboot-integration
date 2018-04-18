package org.flow.service;

import org.flow.dao.mapper.ResourceMapper;
import org.flow.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-14
 * <p>Version: 1.0
 */
@Service

public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public int createResource(Resource resource) {
        return resourceMapper.insert(resource);
    }

    @Override
    public int updateResource(Resource resource) {
        return resourceMapper.updateByPrimaryKey(resource);
    }

    @Override
    public void deleteResource(Long resourceId) {
        resourceMapper.deleteByPrimaryKey(resourceId);
    }

    @Override
    public Resource findOne(Long resourceId) {
        return resourceMapper.selectByPrimaryKey(resourceId);
    }

    @Override
    public List<Resource> findAll() {
        return resourceMapper.selectAll();
    }

}
