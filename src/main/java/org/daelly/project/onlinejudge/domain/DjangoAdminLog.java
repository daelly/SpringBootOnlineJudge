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
 * DjangoAdminLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "django_admin_log")
public class DjangoAdminLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private AuthUser authUser;
	private DjangoContentType djangoContentType;
	private Timestamp actionTime;
	private String objectId;
	private String objectRepr;
	private Short actionFlag;
	private String changeMessage;

	// Constructors

	/** default constructor */
	public DjangoAdminLog() {
	}

	/** minimal constructor */
	public DjangoAdminLog(AuthUser authUser, Timestamp actionTime,
			String objectRepr, Short actionFlag, String changeMessage) {
		this.authUser = authUser;
		this.actionTime = actionTime;
		this.objectRepr = objectRepr;
		this.actionFlag = actionFlag;
		this.changeMessage = changeMessage;
	}

	/** full constructor */
	public DjangoAdminLog(AuthUser authUser,
			DjangoContentType djangoContentType, Timestamp actionTime,
			String objectId, String objectRepr, Short actionFlag,
			String changeMessage) {
		this.authUser = authUser;
		this.djangoContentType = djangoContentType;
		this.actionTime = actionTime;
		this.objectId = objectId;
		this.objectRepr = objectRepr;
		this.actionFlag = actionFlag;
		this.changeMessage = changeMessage;
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
	@JoinColumn(name = "content_type_id")
	public DjangoContentType getDjangoContentType() {
		return this.djangoContentType;
	}

	public void setDjangoContentType(DjangoContentType djangoContentType) {
		this.djangoContentType = djangoContentType;
	}

	@Column(name = "action_time", nullable = false, length = 19)
	public Timestamp getActionTime() {
		return this.actionTime;
	}

	public void setActionTime(Timestamp actionTime) {
		this.actionTime = actionTime;
	}

	@Column(name = "object_id")
	public String getObjectId() {
		return this.objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	@Column(name = "object_repr", nullable = false, length = 200)
	public String getObjectRepr() {
		return this.objectRepr;
	}

	public void setObjectRepr(String objectRepr) {
		this.objectRepr = objectRepr;
	}

	@Column(name = "action_flag", nullable = false)
	public Short getActionFlag() {
		return this.actionFlag;
	}

	public void setActionFlag(Short actionFlag) {
		this.actionFlag = actionFlag;
	}

	@Column(name = "change_message", nullable = false)
	public String getChangeMessage() {
		return this.changeMessage;
	}

	public void setChangeMessage(String changeMessage) {
		this.changeMessage = changeMessage;
	}

}