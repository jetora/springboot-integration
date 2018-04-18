package org.flow.service;

import org.flow.dao.mapper.OrganizationMapper;
import org.flow.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public int createOrganization(Organization organization) {
        return organizationMapper.insert(organization);
    }

    @Override
    public int updateOrganization(Organization organization) {
        return organizationMapper.updateByPrimaryKey(organization);
    }

    @Override
    public void deleteOrganization(Long organizationId) {
        organizationMapper.deleteByPrimaryKey(organizationId);
    }

    @Override
    public Organization findOne(Long organizationId) {
        return organizationMapper.selectByPrimaryKey(organizationId);
    }

    @Override
    public List<Organization> findAll() {
        return organizationMapper.selectAll();
    }

}
