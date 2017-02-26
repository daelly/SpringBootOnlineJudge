package com.daelly.project.onlinejudge.dao;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.daelly.project.onlinejudge.domain.AuthUser;

@Repository
public interface AuthUserDao extends PagingAndSortingRepository<AuthUser, Integer> {

	@Cacheable("com.daelly.project.onlinejudge.dao.findByUsername")
	public List<AuthUser> findByUsername(String username);
}
