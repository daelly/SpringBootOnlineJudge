package org.daelly.project.onlinejudge.dao;

import org.daelly.project.onlinejudge.domain.AuthGroupPermissions;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthGroupPermissionsDao extends PagingAndSortingRepository<AuthGroupPermissions, Integer> {

}
