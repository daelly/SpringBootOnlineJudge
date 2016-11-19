package org.daelly.project.onlinejudge.dao;

import org.daelly.project.onlinejudge.domain.DjangoContentType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DjangoContentTypeDao extends PagingAndSortingRepository<DjangoContentType, Integer> {

}
