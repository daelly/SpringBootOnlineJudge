package org.daelly.project.onlinejudge.dao;

import org.daelly.project.onlinejudge.domain.AuthUserGroups;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserGroupsDao extends PagingAndSortingRepository<AuthUserGroups, Integer> {

}
