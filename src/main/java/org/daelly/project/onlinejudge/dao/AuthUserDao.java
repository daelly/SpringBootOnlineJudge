package org.daelly.project.onlinejudge.dao;

import java.util.List;

import org.daelly.project.onlinejudge.domain.AuthUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserDao extends PagingAndSortingRepository<AuthUser, Integer> {

	public List<AuthUser> findByUsername(String username);
}
