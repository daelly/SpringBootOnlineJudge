package org.daelly.project.onlinejudge.dao;

import org.daelly.project.onlinejudge.domain.TblSubject;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblSubjectDao extends PagingAndSortingRepository<TblSubject, Integer> {

}
