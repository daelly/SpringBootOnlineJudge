package org.daelly.project.onlinejudge.dao;

import org.daelly.project.onlinejudge.domain.AuthPermission;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthPermissionDao extends PagingAndSortingRepository<AuthPermission, Integer> {

}
