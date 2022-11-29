package com.allweing.service;

import org.springframework.web.multipart.MultipartFile;

public interface VideoService {
	String saveVideo( MultipartFile file );
}
