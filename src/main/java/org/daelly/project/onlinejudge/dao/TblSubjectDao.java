package org.daelly.project.onlinejudge.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.daelly.project.onlinejudge.domain.TblSubject;

@Repository
public interface TblSubjectDao extends PagingAndSortingRepository<TblSubject, Integer> {

}
