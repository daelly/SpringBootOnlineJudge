package com.daelly.project.onlinejudge.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.daelly.project.onlinejudge.domain.AuthUserUserPermissions;

@Repository
public interface AuthUserUserPermissionsDao extends PagingAndSortingRepository<AuthUserUserPermissions, Integer> {

}
