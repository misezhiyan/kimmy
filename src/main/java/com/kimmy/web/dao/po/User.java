package com.kimmy.web.dao.po;

import java.util.Date;

/**
 * @author Administrator
 *
 */
public class User {

	private int id;
	private String user_id;
	private String name;
	private String password;
	private Date registerTime;
	private Date lastLoadOnTime;
	private Date lastRequestTime;
	private int status;
	private String udpateBy;
	private Date updateDate;
	private String deleteBy;
	private Date deleteDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Date getLastLoadOnTime() {
		return lastLoadOnTime;
	}

	public void setLastLoadOnTime(Date lastLoadOnTime) {
		this.lastLoadOnTime = lastLoadOnTime;
	}

	public Date getLastRequestTime() {
		return lastRequestTime;
	}

	public void setLastRequestTime(Date lastRequestTime) {
		this.lastRequestTime = lastRequestTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUdpateBy() {
		return udpateBy;
	}

	public void setUdpateBy(String udpateBy) {
		this.udpateBy = udpateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDeleteBy() {
		return deleteBy;
	}

	public void setDeleteBy(String deleteBy) {
		this.deleteBy = deleteBy;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

}
