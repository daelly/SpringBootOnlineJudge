package com.daelly.project.onlinejudge.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.daelly.project.onlinejudge.domain.AuthGroup;

@Repository
public interface AuthGroupDao extends PagingAndSortingRepository<AuthGroup, Integer> {

}
