package com.treasure.dao.po;

import java.util.Date;

/**
 * @author Administrator
 *
 */
public class UserPoker {

	private int id;
	private String poker_id;
	private String user_id;
	private String name;
	private String password;
	private Date bind_time;
	private int status;
	private int is_default;
	private Date connect_time;
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
	public String getPoker_id() {
		return poker_id;
	}
	public void setPoker_id(String poker_id) {
		this.poker_id = poker_id;
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
	public Date getBind_time() {
		return bind_time;
	}
	public void setBind_time(Date bind_time) {
		this.bind_time = bind_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIs_default() {
		return is_default;
	}
	public void setIs_default(int is_default) {
		this.is_default = is_default;
	}
	public Date getConnect_time() {
		return connect_time;
	}
	public void setConnect_time(Date connect_time) {
		this.connect_time = connect_time;
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
