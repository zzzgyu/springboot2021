package com.allweing.controller;

import com.aliyun.vod20170321.models.DeleteVideoRequest;
import com.aliyun.vod20170321.models.GetVideoPlayAuthRequest;
import com.aliyun.vod20170321.models.GetVideoPlayAuthResponse;
import com.aliyuncs.DefaultAcsClient;
import com.allweing.service.VideoService;
import com.allweing.utils.ConstantVodUtils;
import com.allweing.utils.InitVodCilent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @auther: zzzgyu
 */

@RestController
public class VideoController {

	@Autowired
    VideoService videoService;

	@PostMapping("/upload")
	public String saveVideo( MultipartFile file ) {

		String s = videoService.saveVideo(file);
		System.out.println(s);

		return "ok";
	}

	//根据视频id获取视频凭证
	@GetMapping("getPlayAuth/{id}")
	public String getPlayAuth(@PathVariable String id) {
		try {
			//创建初始化对象
			DefaultAcsClient client =
					InitVodCilent.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
			//创建获取凭证request和response对象
			GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
			//向request设置视频id
			request.setVideoId(id);
			//调用方法得到凭证
			GetVideoPlayAuthResponse response = client.getAcsResponse(request);
			String playAuth = response.getPlayAuth();
			return playAuth;
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	//根据视频id删除阿里云视频
	@DeleteMapping("removeAlyVideo/{id}")
	public String removeAlyVideo(@PathVariable String id) {
		try {
			//初始化对象
			DefaultAcsClient client = InitVodCilent.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
			//创建删除视频request对象
			DeleteVideoRequest request = new DeleteVideoRequest();
			//向request设置视频id
			request.setVideoIds(id);
			//调用初始化对象的方法实现删除
			client.getAcsResponse(request);
			return "ok";
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
