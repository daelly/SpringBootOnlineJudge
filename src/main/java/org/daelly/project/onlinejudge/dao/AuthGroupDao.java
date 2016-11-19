package org.daelly.project.onlinejudge.dao;

import org.daelly.project.onlinejudge.domain.AuthGroup;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthGroupDao extends PagingAndSortingRepository<AuthGroup, Integer> {

}
