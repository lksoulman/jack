package com.jack.service.api.file.model;

import java.io.Serializable;

/**
 * 
 * @ClassName: StorageInfo 
 * @Description:  
 * @author lksoulman 
 * @date 2018-06-14 18:12:21
 */
public class StorageInfo implements Serializable {

	/**
	 * @Fields serialVersionUID :
	 * @author lksoulman
	 */
	private static final long serialVersionUID = 3471380458022472090L;

	private String version;
	private String ipAddr;
	private String joinTime;// 存储加入时间
	private String upTime;// 存储更新时间
	private long totalGB;// 存储总容量
	private long freeGB;// 存储空闲容量
	private long totalUploadCount;// 文件总上传数量
	private byte status;// 状态
	private String lastSourceUpdate;// 最后上传时间
	private String lastSyncUpdate;// 最后同步时间

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}

	public String getUpTime() {
		return upTime;
	}

	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}

	public long getTotalGB() {
		return totalGB;
	}

	public void setTotalGB(long totalGB) {
		this.totalGB = totalGB;
	}

	public long getFreeGB() {
		return freeGB;
	}

	public void setFreeGB(long freeGB) {
		this.freeGB = freeGB;
	}

	public long getTotalUploadCount() {
		return totalUploadCount;
	}

	public void setTotalUploadCount(long totalUploadCount) {
		this.totalUploadCount = totalUploadCount;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getLastSourceUpdate() {
		return lastSourceUpdate;
	}

	public void setLastSourceUpdate(String lastSourceUpdate) {
		this.lastSourceUpdate = lastSourceUpdate;
	}

	public String getLastSyncUpdate() {
		return lastSyncUpdate;
	}

	public void setLastSyncUpdate(String lastSyncUpdate) {
		this.lastSyncUpdate = lastSyncUpdate;
	}
}
