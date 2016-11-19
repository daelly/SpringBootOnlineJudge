package org.daelly.project.onlinejudge.domain;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * AuthUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "auth_user", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class AuthUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String password;
	private Timestamp lastLogin;
	private Boolean isSuperuser;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private Boolean isStaff;
	private Boolean isActive;
	private Timestamp dateJoined;
	private Set<AuthUserGroups> authUserGroupses = new HashSet<AuthUserGroups>(
			0);
	private Set<DjangoAdminLog> djangoAdminLogs = new HashSet<DjangoAdminLog>(0);
	private Set<TblSubject> tblSubjects = new HashSet<TblSubject>(0);
	private Set<AuthUserUserPermissions> authUserUserPermissionses = new HashSet<AuthUserUserPermissions>(
			0);
	private Set<TblCommit> tblCommits = new HashSet<TblCommit>(0);

	// Constructors

	/** default constructor */
	public AuthUser() {
	}

	/** minimal constructor */
	public AuthUser(String password, Boolean isSuperuser, String username,
			String firstName, String lastName, String email, Boolean isStaff,
			Boolean isActive, Timestamp dateJoined) {
		this.password = password;
		this.isSuperuser = isSuperuser;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.isStaff = isStaff;
		this.isActive = isActive;
		this.dateJoined = dateJoined;
	}

	/** full constructor */
	public AuthUser(String password, Timestamp lastLogin, Boolean isSuperuser,
			String username, String firstName, String lastName, String email,
			Boolean isStaff, Boolean isActive, Timestamp dateJoined,
			Set<AuthUserGroups> authUserGroupses,
			Set<DjangoAdminLog> djangoAdminLogs, Set<TblSubject> tblSubjects,
			Set<AuthUserUserPermissions> authUserUserPermissionses,
			Set<TblCommit> tblCommits) {
		this.password = password;
		this.lastLogin = lastLogin;
		this.isSuperuser = isSuperuser;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.isStaff = isStaff;
		this.isActive = isActive;
		this.dateJoined = dateJoined;
		this.authUserGroupses = authUserGroupses;
		this.djangoAdminLogs = djangoAdminLogs;
		this.tblSubjects = tblSubjects;
		this.authUserUserPermissionses = authUserUserPermissionses;
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

	@Column(name = "password", nullable = false, length = 256)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "last_login", length = 19)
	public Timestamp getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Column(name = "is_superuser", nullable = false)
	public Boolean getIsSuperuser() {
		return this.isSuperuser;
	}

	public void setIsSuperuser(Boolean isSuperuser) {
		this.isSuperuser = isSuperuser;
	}

	@Column(name = "username", unique = true, nullable = false, length = 30)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "first_name", nullable = false, length = 30)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false, length = 30)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email", nullable = false, length = 254)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "is_staff", nullable = false)
	public Boolean getIsStaff() {
		return this.isStaff;
	}

	public void setIsStaff(Boolean isStaff) {
		this.isStaff = isStaff;
	}

	@Column(name = "is_active", nullable = false)
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Column(name = "date_joined", nullable = false, length = 19)
	public Timestamp getDateJoined() {
		return this.dateJoined;
	}

	public void setDateJoined(Timestamp dateJoined) {
		this.dateJoined = dateJoined;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "authUser")
	public Set<AuthUserGroups> getAuthUserGroupses() {
		return this.authUserGroupses;
	}

	public void setAuthUserGroupses(Set<AuthUserGroups> authUserGroupses) {
		this.authUserGroupses = authUserGroupses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "authUser")
	public Set<DjangoAdminLog> getDjangoAdminLogs() {
		return this.djangoAdminLogs;
	}

	public void setDjangoAdminLogs(Set<DjangoAdminLog> djangoAdminLogs) {
		this.djangoAdminLogs = djangoAdminLogs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "authUser")
	public Set<TblSubject> getTblSubjects() {
		return this.tblSubjects;
	}

	public void setTblSubjects(Set<TblSubject> tblSubjects) {
		this.tblSubjects = tblSubjects;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "authUser")
	public Set<AuthUserUserPermissions> getAuthUserUserPermissionses() {
		return this.authUserUserPermissionses;
	}

	public void setAuthUserUserPermissionses(
			Set<AuthUserUserPermissions> authUserUserPermissionses) {
		this.authUserUserPermissionses = authUserUserPermissionses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "authUser")
	public Set<TblCommit> getTblCommits() {
		return this.tblCommits;
	}

	public void setTblCommits(Set<TblCommit> tblCommits) {
		this.tblCommits = tblCommits;
	}

}