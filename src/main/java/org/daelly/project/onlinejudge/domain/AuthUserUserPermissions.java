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
 * AuthUserUserPermissions entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "auth_user_user_permissions", uniqueConstraints = @UniqueConstraint(columnNames = {
		"user_id", "permission_id" }))
public class AuthUserUserPermissions implements java.io.Serializable {

	// Fields

	private Integer id;
	private AuthUser authUser;
	private AuthPermission authPermission;

	// Constructors

	/** default constructor */
	public AuthUserUserPermissions() {
	}

	/** full constructor */
	public AuthUserUserPermissions(AuthUser authUser,
			AuthPermission authPermission) {
		this.authUser = authUser;
		this.authPermission = authPermission;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "permission_id", nullable = false)
	public AuthPermission getAuthPermission() {
		return this.authPermission;
	}

	public void setAuthPermission(AuthPermission authPermission) {
		this.authPermission = authPermission;
	}

}