package com.allweing.service.impl;

import com.allweing.service.VideoService;
import com.allweing.utils.ConstantVodUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @auther: zzzgyu
 */
@Service
public class VideoServiceImpl implements VideoService {


	@Override
	public String saveVideo( MultipartFile file ) {
		/*String originalFilename = file.getOriginalFilename();

		System.out.println(originalFilename);*/

		try {
			//accessKeyId, accessKeySecret
			//fileName：上传文件原始名称
			// 01.03.09.mp4
			String fileName = file.getOriginalFilename();
			//title：上传之后显示名称
			String title = fileName.substring(0, fileName.lastIndexOf("."));
			//inputStream：上传文件输入流
			InputStream inputStream = file.getInputStream();
			UploadStreamRequest request = new UploadStreamRequest(ConstantVodUtils.ACCESS_KEY_ID,ConstantVodUtils.ACCESS_KEY_SECRET, title, fileName, inputStream);

			UploadVideoImpl uploader = new UploadVideoImpl();
			UploadStreamResponse response = uploader.uploadStream(request);

			String videoId = null;
			if (response.isSuccess()) {
				videoId = response.getVideoId();
			} else { //如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因
				videoId = response.getVideoId();
			}
			return videoId;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
