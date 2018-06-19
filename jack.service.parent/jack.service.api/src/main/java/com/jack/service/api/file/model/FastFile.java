package com.jack.service.api.file.model;

import java.io.Serializable;

import org.apache.commons.io.FilenameUtils;

/**
 * 
 * @ClassName: FastFile
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 14:16:56
 */
public class FastFile implements Serializable {

	/**
	 * @Fields serialVersionUID :
	 * @author lksoulman
	 */
	private static final long serialVersionUID = -3192269994053795757L;

	private String fileName;
	private byte[] fileContent;
	private String file_ext_name;
	private String hashCode;// 文件MD5码
	private String groupName;
	private String filePath;

	public FastFile(String fileName, byte[] fileContent) {
		this.fileName = fileName;
		this.file_ext_name = FilenameUtils.getExtension(fileName);
		this.fileContent = fileContent;
	}

	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

	public FastFile(String groupName, String filePath) {
		this.groupName = groupName;
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
		this.file_ext_name = FilenameUtils.getExtension(fileName);
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

	public String getFile_ext_name() {
		return file_ext_name;
	}

	public void setFile_ext_name(String file_ext_name) {
		this.file_ext_name = file_ext_name;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "FastFile [groupName=" + groupName + ", filePath=" + filePath + "]";
	}
}
