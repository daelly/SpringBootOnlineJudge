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
 * DjangoContentType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "django_content_type", uniqueConstraints = @UniqueConstraint(columnNames = {
		"app_label", "model" }))
public class DjangoContentType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String appLabel;
	private String model;
	private Set<AuthPermission> authPermissions = new HashSet<AuthPermission>(0);
	private Set<DjangoAdminLog> djangoAdminLogs = new HashSet<DjangoAdminLog>(0);

	// Constructors

	/** default constructor */
	public DjangoContentType() {
	}

	/** minimal constructor */
	public DjangoContentType(String appLabel, String model) {
		this.appLabel = appLabel;
		this.model = model;
	}

	/** full constructor */
	public DjangoContentType(String appLabel, String model,
			Set<AuthPermission> authPermissions,
			Set<DjangoAdminLog> djangoAdminLogs) {
		this.appLabel = appLabel;
		this.model = model;
		this.authPermissions = authPermissions;
		this.djangoAdminLogs = djangoAdminLogs;
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

	@Column(name = "app_label", nullable = false, length = 100)
	public String getAppLabel() {
		return this.appLabel;
	}

	public void setAppLabel(String appLabel) {
		this.appLabel = appLabel;
	}

	@Column(name = "model", nullable = false, length = 100)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "djangoContentType")
	public Set<AuthPermission> getAuthPermissions() {
		return this.authPermissions;
	}

	public void setAuthPermissions(Set<AuthPermission> authPermissions) {
		this.authPermissions = authPermissions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "djangoContentType")
	public Set<DjangoAdminLog> getDjangoAdminLogs() {
		return this.djangoAdminLogs;
	}

	public void setDjangoAdminLogs(Set<DjangoAdminLog> djangoAdminLogs) {
		this.djangoAdminLogs = djangoAdminLogs;
	}

}