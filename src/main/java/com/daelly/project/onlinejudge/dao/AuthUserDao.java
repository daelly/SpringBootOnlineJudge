package com.daelly.project.onlinejudge.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.daelly.project.onlinejudge.domain.AuthUser;

@Repository
public interface AuthUserDao extends PagingAndSortingRepository<AuthUser, Integer> {

	public List<AuthUser> findByUsername(String username);
}
