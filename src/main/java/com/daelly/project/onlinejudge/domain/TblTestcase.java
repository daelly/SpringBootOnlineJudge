package com.daelly.project.onlinejudge.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TblTestcase entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbl_testcase")
public class TblTestcase implements java.io.Serializable {

	// Fields

	private Integer id;
	private TblSubject tblSubject;
	private String inputData;
	private String outputData;

	// Constructors

	/** default constructor */
	public TblTestcase() {
	}

	/** full constructor */
	public TblTestcase(TblSubject tblSubject, String inputData,
			String outputData) {
		this.tblSubject = tblSubject;
		this.inputData = inputData;
		this.outputData = outputData;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id", nullable = false)
	public TblSubject getTblSubject() {
		return this.tblSubject;
	}

	public void setTblSubject(TblSubject tblSubject) {
		this.tblSubject = tblSubject;
	}

	@Column(name = "input_data", nullable = false, length = 1024)
	public String getInputData() {
		return this.inputData;
	}

	public void setInputData(String inputData) {
		this.inputData = inputData;
	}

	@Column(name = "output_data", nullable = false, length = 1024)
	public String getOutputData() {
		return this.outputData;
	}

	public void setOutputData(String outputData) {
		this.outputData = outputData;
	}

}