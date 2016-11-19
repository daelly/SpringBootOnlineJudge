package org.daelly.project.onlinejudge.dao;

import org.daelly.project.onlinejudge.domain.AuthUserUserPermissions;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserUserPermissionsDao extends PagingAndSortingRepository<AuthUserUserPermissions, Integer> {

}
