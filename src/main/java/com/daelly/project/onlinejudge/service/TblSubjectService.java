package com.daelly.project.onlinejudge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daelly.project.onlinejudge.dao.TblSubjectDao;
import com.daelly.project.onlinejudge.domain.TblSubject;

@Service
@Transactional
public class TblSubjectService {

	@Autowired
	TblSubjectDao dao;
	
	@Cacheable("ONE_DAY")
	@Transactional(readOnly=true)
	public TblSubject findOne(Integer id) {
		return dao.findOne(id);
	}
	
	@Cacheable("ONE_MONTH")
	@Transactional(readOnly=true)
	public Iterable<TblSubject> findAll() {
		return dao.findAll();
	}
}
