package com.jack.service.api.file.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: FastGroup
 * @Description:
 * @author lksoulman
 * @date 2018-06-14 18:13:00
 */
public class FastGroup implements Serializable {

	/**
	 * @Fields serialVersionUID :
	 * @author lksoulman
	 */
	private static final long serialVersionUID = -9131594060914802476L;

	private String groupName;
	private List<StorageInfo> storageList = new ArrayList<>();

	public FastGroup(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<StorageInfo> getStorageList() {
		return storageList;
	}

	public void addStorageList(StorageInfo storageInfo) {
		this.storageList.add(storageInfo);
	}
}
