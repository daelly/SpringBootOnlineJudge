package com.daelly.project.onlinejudge.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.daelly.project.onlinejudge.domain.AuthPermission;

@Repository
public interface AuthPermissionDao extends PagingAndSortingRepository<AuthPermission, Integer> {

}
