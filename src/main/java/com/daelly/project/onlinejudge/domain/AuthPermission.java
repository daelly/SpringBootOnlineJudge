package com.daelly.project.onlinejudge.domain;

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
import javax.persistence.UniqueConstraint;

/**
 * AuthPermission entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "auth_permission", uniqueConstraints = @UniqueConstraint(columnNames = {
		"content_type_id", "codename" }))
public class AuthPermission implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8915033748214857553L;

	// Fields
	private Integer id;
	private DjangoContentType djangoContentType;
	private String name;
	private String codename;
	private Set<AuthUserUserPermissions> authUserUserPermissionses = new HashSet<AuthUserUserPermissions>(
			0);
	private Set<AuthGroupPermissions> authGroupPermissionses = new HashSet<AuthGroupPermissions>(
			0);

	// Constructors

	/** default constructor */
	public AuthPermission() {
	}

	/** minimal constructor */
	public AuthPermission(DjangoContentType djangoContentType, String name,
			String codename) {
		this.djangoContentType = djangoContentType;
		this.name = name;
		this.codename = codename;
	}

	/** full constructor */
	public AuthPermission(DjangoContentType djangoContentType, String name,
			String codename,
			Set<AuthUserUserPermissions> authUserUserPermissionses,
			Set<AuthGroupPermissions> authGroupPermissionses) {
		this.djangoContentType = djangoContentType;
		this.name = name;
		this.codename = codename;
		this.authUserUserPermissionses = authUserUserPermissionses;
		this.authGroupPermissionses = authGroupPermissionses;
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
	@JoinColumn(name = "content_type_id", nullable = false)
	public DjangoContentType getDjangoContentType() {
		return this.djangoContentType;
	}

	public void setDjangoContentType(DjangoContentType djangoContentType) {
		this.djangoContentType = djangoContentType;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "codename", nullable = false, length = 100)
	public String getCodename() {
		return this.codename;
	}

	public void setCodename(String codename) {
		this.codename = codename;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "authPermission")
	public Set<AuthUserUserPermissions> getAuthUserUserPermissionses() {
		return this.authUserUserPermissionses;
	}

	public void setAuthUserUserPermissionses(
			Set<AuthUserUserPermissions> authUserUserPermissionses) {
		this.authUserUserPermissionses = authUserUserPermissionses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "authPermission")
	public Set<AuthGroupPermissions> getAuthGroupPermissionses() {
		return this.authGroupPermissionses;
	}

	public void setAuthGroupPermissionses(
			Set<AuthGroupPermissions> authGroupPermissionses) {
		this.authGroupPermissionses = authGroupPermissionses;
	}

}