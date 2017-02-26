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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * AuthGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "auth_group", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class AuthGroup implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2073146199423987648L;

	// Fields
	private Integer id;
	private String name;
	private Set<AuthGroupPermissions> authGroupPermissionses = new HashSet<AuthGroupPermissions>(
			0);
	private Set<AuthUserGroups> authUserGroupses = new HashSet<AuthUserGroups>(
			0);

	// Constructors

	/** default constructor */
	public AuthGroup() {
	}

	/** minimal constructor */
	public AuthGroup(String name) {
		this.name = name;
	}

	/** full constructor */
	public AuthGroup(String name,
			Set<AuthGroupPermissions> authGroupPermissionses,
			Set<AuthUserGroups> authUserGroupses) {
		this.name = name;
		this.authGroupPermissionses = authGroupPermissionses;
		this.authUserGroupses = authUserGroupses;
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

	@Column(name = "name", unique = true, nullable = false, length = 80)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "authGroup")
	public Set<AuthGroupPermissions> getAuthGroupPermissionses() {
		return this.authGroupPermissionses;
	}

	public void setAuthGroupPermissionses(
			Set<AuthGroupPermissions> authGroupPermissionses) {
		this.authGroupPermissionses = authGroupPermissionses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "authGroup")
	public Set<AuthUserGroups> getAuthUserGroupses() {
		return this.authUserGroupses;
	}

	public void setAuthUserGroupses(Set<AuthUserGroups> authUserGroupses) {
		this.authUserGroupses = authUserGroupses;
	}

}