package com.daelly.project.onlinejudge.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.daelly.project.onlinejudge.domain.AuthGroupPermissions;

@Repository
public interface AuthGroupPermissionsDao extends PagingAndSortingRepository<AuthGroupPermissions, Integer> {

}
