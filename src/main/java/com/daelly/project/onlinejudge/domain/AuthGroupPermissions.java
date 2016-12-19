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
import javax.persistence.UniqueConstraint;

/**
 * AuthGroupPermissions entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "auth_group_permissions", uniqueConstraints = @UniqueConstraint(columnNames = {
		"group_id", "permission_id" }))
public class AuthGroupPermissions implements java.io.Serializable {

	// Fields

	private Integer id;
	private AuthPermission authPermission;
	private AuthGroup authGroup;

	// Constructors

	/** default constructor */
	public AuthGroupPermissions() {
	}

	/** full constructor */
	public AuthGroupPermissions(AuthPermission authPermission,
			AuthGroup authGroup) {
		this.authPermission = authPermission;
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
	@JoinColumn(name = "permission_id", nullable = false)
	public AuthPermission getAuthPermission() {
		return this.authPermission;
	}

	public void setAuthPermission(AuthPermission authPermission) {
		this.authPermission = authPermission;
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