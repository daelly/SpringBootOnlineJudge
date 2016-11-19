package org.daelly.project.onlinejudge.dao;

import org.daelly.project.onlinejudge.domain.DjangoAdminLog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DjangoAdminLogDao extends PagingAndSortingRepository<DjangoAdminLog, Integer> {

}
