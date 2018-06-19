package com.jack.service.api.file;

import java.util.List;

import com.jack.service.api.file.model.FastFile;
import com.jack.service.api.file.model.FastGroup;

/**
 * 
 * @ClassName: FastDFSServiceApi
 * @Description:
 * @author lksoulman
 * @date 2018-06-14 16:26:06
 */
public interface FastDFSServiceApi {

	/**
	 * 
	 * @Description:
	 * @return
	 * @return List<FastGroup>
	 * @author lksoulman
	 * @date 2018-06-14 18:13:57
	 */
	List<FastGroup> listGroups();

	/**
	 * 
	 * @Description:
	 * @param fastFile
	 * @throws Exception
	 * @return FastFile
	 * @author lksoulman
	 * @date 2018-06-14 17:45:00
	 */
	FastFile upload(FastFile fastFile) throws Exception;

	/**
	 * 
	 * @Description:
	 * @param groupName
	 * @param filepath
	 * @throws Exception
	 * @return byte[]
	 * @author lksoulman
	 * @date 2018-06-14 17:45:04
	 */
	byte[] download(String groupName, String filepath) throws Exception;

	/**
	 * 
	 * @Description:
	 * @param test
	 * @return
	 * @return String
	 * @author lksoulman
	 * @date 2018-06-14 18:39:03
	 */
	String testApi(String test);
}
