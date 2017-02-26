package com.daelly.project.onlinejudge.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TblSubject entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbl_subject")
public class TblSubject implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1046961815235994219L;

	// Fields
	private Integer id;
	private AuthUser authUser;
	private Integer subjectNo;
	private String title;
	private Integer timeLimit;
	private Integer memoryLimit;
	private String subjectDesc;
	private String inputDesc;
	private String outputDesc;
	private String origin;
	private Timestamp createTime;
	private Integer accepted;
	private Integer submissions;
	private Set<TblTestcase> tblTestcases = new HashSet<TblTestcase>(0);
	private Set<TblCommit> tblCommits = new HashSet<TblCommit>(0);

	// Constructors

	/** default constructor */
	public TblSubject() {
	}

	/** minimal constructor */
	public TblSubject(AuthUser authUser, Integer subjectNo, String title,
			Integer timeLimit, Integer memoryLimit, String subjectDesc,
			String inputDesc, String outputDesc, String origin,
			Timestamp createTime, Integer accepted, Integer submissions) {
		this.authUser = authUser;
		this.subjectNo = subjectNo;
		this.title = title;
		this.timeLimit = timeLimit;
		this.memoryLimit = memoryLimit;
		this.subjectDesc = subjectDesc;
		this.inputDesc = inputDesc;
		this.outputDesc = outputDesc;
		this.origin = origin;
		this.createTime = createTime;
		this.accepted = accepted;
		this.submissions = submissions;
	}

	/** full constructor */
	public TblSubject(AuthUser authUser, Integer subjectNo, String title,
			Integer timeLimit, Integer memoryLimit, String subjectDesc,
			String inputDesc, String outputDesc, String origin,
			Timestamp createTime, Integer accepted, Integer submissions,
			Set<TblTestcase> tblTestcases, Set<TblCommit> tblCommits) {
		this.authUser = authUser;
		this.subjectNo = subjectNo;
		this.title = title;
		this.timeLimit = timeLimit;
		this.memoryLimit = memoryLimit;
		this.subjectDesc = subjectDesc;
		this.inputDesc = inputDesc;
		this.outputDesc = outputDesc;
		this.origin = origin;
		this.createTime = createTime;
		this.accepted = accepted;
		this.submissions = submissions;
		this.tblTestcases = tblTestcases;
		this.tblCommits = tblCommits;
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
	@JoinColumn(name = "auther_id", nullable = false)
	public AuthUser getAuthUser() {
		return this.authUser;
	}

	public void setAuthUser(AuthUser authUser) {
		this.authUser = authUser;
	}

	@Column(name = "subject_no", nullable = false)
	public Integer getSubjectNo() {
		return this.subjectNo;
	}

	public void setSubjectNo(Integer subjectNo) {
		this.subjectNo = subjectNo;
	}

	@Column(name = "title", nullable = false, length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "time_limit", nullable = false)
	public Integer getTimeLimit() {
		return this.timeLimit;
	}

	public void setTimeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
	}

	@Column(name = "memory_limit", nullable = false)
	public Integer getMemoryLimit() {
		return this.memoryLimit;
	}

	public void setMemoryLimit(Integer memoryLimit) {
		this.memoryLimit = memoryLimit;
	}

	@Column(name = "subject_desc", nullable = false)
	public String getSubjectDesc() {
		return this.subjectDesc;
	}

	public void setSubjectDesc(String subjectDesc) {
		this.subjectDesc = subjectDesc;
	}

	@Column(name = "input_desc", nullable = false)
	public String getInputDesc() {
		return this.inputDesc;
	}

	public void setInputDesc(String inputDesc) {
		this.inputDesc = inputDesc;
	}

	@Column(name = "output_desc", nullable = false)
	public String getOutputDesc() {
		return this.outputDesc;
	}

	public void setOutputDesc(String outputDesc) {
		this.outputDesc = outputDesc;
	}

	@Column(name = "origin", nullable = false, length = 50)
	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "accepted", nullable = false)
	public Integer getAccepted() {
		return this.accepted;
	}

	public void setAccepted(Integer accepted) {
		this.accepted = accepted;
	}

	@Column(name = "submissions", nullable = false)
	public Integer getSubmissions() {
		return this.submissions;
	}

	public void setSubmissions(Integer submissions) {
		this.submissions = submissions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tblSubject")
	public Set<TblTestcase> getTblTestcases() {
		return this.tblTestcases;
	}

	public void setTblTestcases(Set<TblTestcase> tblTestcases) {
		this.tblTestcases = tblTestcases;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tblSubject")
	public Set<TblCommit> getTblCommits() {
		return this.tblCommits;
	}

	public void setTblCommits(Set<TblCommit> tblCommits) {
		this.tblCommits = tblCommits;
	}

}