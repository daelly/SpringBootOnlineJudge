package org.daelly.project.onlinejudge.domain;

import java.sql.Timestamp;
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
 * TblCommit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbl_commit")
public class TblCommit implements java.io.Serializable {

	// Fields

	private Integer id;
	private AuthUser authUser;
	private TblSubject tblSubject;
	private String language;
	private String code;
	private String ip;
	private Timestamp commitTime;
	private String status;

	// Constructors

	/** default constructor */
	public TblCommit() {
	}

	/** full constructor */
	public TblCommit(AuthUser authUser, TblSubject tblSubject, String language,
			String code, String ip, Timestamp commitTime, String status) {
		this.authUser = authUser;
		this.tblSubject = tblSubject;
		this.language = language;
		this.code = code;
		this.ip = ip;
		this.commitTime = commitTime;
		this.status = status;
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
	@JoinColumn(name = "user_id", nullable = false)
	public AuthUser getAuthUser() {
		return this.authUser;
	}

	public void setAuthUser(AuthUser authUser) {
		this.authUser = authUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id", nullable = false)
	public TblSubject getTblSubject() {
		return this.tblSubject;
	}

	public void setTblSubject(TblSubject tblSubject) {
		this.tblSubject = tblSubject;
	}

	@Column(name = "language", nullable = false, length = 10)
	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "code", nullable = false)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "ip", nullable = false, length = 39)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "commit_time", nullable = false, length = 19)
	public Timestamp getCommitTime() {
		return this.commitTime;
	}

	public void setCommitTime(Timestamp commitTime) {
		this.commitTime = commitTime;
	}

	@Column(name = "status", nullable = false, length = 30)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}