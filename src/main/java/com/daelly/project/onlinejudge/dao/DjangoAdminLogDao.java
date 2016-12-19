package com.daelly.project.onlinejudge.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.daelly.project.onlinejudge.domain.DjangoAdminLog;

@Repository
public interface DjangoAdminLogDao extends PagingAndSortingRepository<DjangoAdminLog, Integer> {

}
