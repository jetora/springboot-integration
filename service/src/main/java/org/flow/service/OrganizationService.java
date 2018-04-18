package org.flow.service;

import org.flow.entity.Organization;

import java.util.List;

public interface OrganizationService {

    public int createOrganization(Organization organization);
    public int updateOrganization(Organization organization);
    public void deleteOrganization(Long organizationId);

    Organization findOne(Long organizationId);
    List<Organization> findAll();
}
