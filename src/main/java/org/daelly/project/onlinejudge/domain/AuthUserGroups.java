package org.daelly.project.onlinejudge.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * AuthUserGroups entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "auth_user_groups", uniqueConstraints = @UniqueConstraint(columnNames = {
		"user_id", "group_id" }))
public class AuthUserGroups implements java.io.Serializable {

	// Fields

	private Integer id;
	private AuthUser authUser;
	private AuthGroup authGroup;

	// Constructors

	/** default constructor */
	public AuthUserGroups() {
	}

	/** full constructor */
	public AuthUserGroups(AuthUser authUser, AuthGroup authGroup) {
		this.authUser = authUser;
		this.authGroup = authGroup;
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
	@JoinColumn(name = "group_id", nullable = false)
	public AuthGroup getAuthGroup() {
		return this.authGroup;
	}

	public void setAuthGroup(AuthGroup authGroup) {
		this.authGroup = authGroup;
	}

}