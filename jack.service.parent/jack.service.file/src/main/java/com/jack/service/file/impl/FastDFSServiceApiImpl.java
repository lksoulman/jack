package com.jack.service.file.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.jack.service.api.exception.FastFileException;
import com.jack.service.api.file.FastDFSServiceApi;
import com.jack.service.api.file.model.FastFile;
import com.jack.service.api.file.model.FastGroup;
import com.jack.service.api.file.model.StorageInfo;
import com.luhuiguo.fastdfs.domain.GroupState;
import com.luhuiguo.fastdfs.domain.StorageState;
import com.luhuiguo.fastdfs.domain.StorePath;
import com.luhuiguo.fastdfs.exception.FdfsException;
import com.luhuiguo.fastdfs.service.DefaultTrackerClient;
import com.luhuiguo.fastdfs.service.FastFileStorageClient;

/**
 * 
 * @ClassName: FastDFSServiceApiImpl
 * @Description:
 * @author lksoulman
 * @date 2018-06-14 18:16:08
 */
@Service
public class FastDFSServiceApiImpl implements FastDFSServiceApi {

	@Autowired
	private DefaultTrackerClient tarckerClient;

	@Autowired
	private FastFileStorageClient fastFileStorageClient;

	@Override
	public List<FastGroup> listGroups() {
		List<GroupState> groupStateList = tarckerClient.listGroups();
		List<FastGroup> fastGroupList = new ArrayList<>(groupStateList.size());
		for (GroupState groupState : groupStateList) {
			String groupName = groupState.getGroupName();
			FastGroup fastGroup = new FastGroup(groupName);
			List<StorageState> storageStateList = tarckerClient.listStorages(groupState.getGroupName());
			for (StorageState storageState : storageStateList) {
				StorageInfo storageInfo = new StorageInfo();
				storageInfo.setIpAddr(storageState.getIpAddr());
				storageInfo.setFreeGB(storageState.getFreeMB() / 1024);
				storageInfo.setTotalGB(storageState.getTotalMB() / 1024);
				storageInfo.setJoinTime(DATE_FORMAT.get().format(storageState.getJoinTime()));
				storageInfo.setUpTime(DATE_FORMAT.get().format(storageState.getUpTime()));
				storageInfo.setLastSourceUpdate(DATE_FORMAT.get().format(storageState.getLastSourceUpdate()));
				storageInfo.setLastSyncUpdate(DATE_FORMAT.get().format(storageState.getLastSyncUpdate()));
				storageInfo.setStatus(storageState.getStatus());
				storageInfo.setTotalUploadCount(storageState.getTotalUploadCount());
				storageInfo.setVersion(storageState.getVersion());
				fastGroup.addStorageList(storageInfo);
			}
			fastGroupList.add(fastGroup);
		}
		return fastGroupList;
	}

	private static final ThreadLocal<DateFormat> DATE_FORMAT = new ThreadLocal<DateFormat>() {
		@Override
		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};

	public FastFile upload(FastFile fastFile) throws Exception {
		try {
			StorePath storePath = fastFileStorageClient.uploadFile(fastFile.getFileContent(),
					fastFile.getFile_ext_name());
			return new FastFile(storePath.getGroup(), storePath.getPath());
		} catch (Exception e) {
			throw new FastFileException("文件上传失败", e);
		}
	}

	@Override
	@Retryable(value = { FdfsException.class }, maxAttempts = 2)
	public byte[] download(String groupName, String filepath) throws Exception {
		byte[] b = fastFileStorageClient.downloadFile(groupName, filepath);
		return b;
	}

	@Override
	public String testApi(String test) {
		return test;
	}
}
