package com.gf.guideforyou.common;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.gf.guideforyou.vo.UploadFileVo;

public class UploadFiles {
	
	
	public ArrayList<String> uploadFileLinkName(MultipartFile[] files){
		
		//파일 저장 로직 시작....
		ArrayList<UploadFileVo> fileList = new ArrayList<UploadFileVo>();
		ArrayList<String> linkList = new ArrayList<String>();
				
		//로컬
		String uploadFilePath = "C:\\tomcat\\apache-tomcat-8.5.43\\wtpwebapps\\GuideForYou\\uploadFiles\\";
		//aws mode
		//String uploadFilePath = "/var/lib/tomcat8/webapps/GuideForYou/uploadFiles/";
		
		System.out.println(files.length);
		for(MultipartFile file : files) {
					
			if(file.getSize() <= 0) {
				continue;
			}
					
			String originalFilename = file.getOriginalFilename();
					
			//파일명 바꾸기....(시간,랜덤 값)
			String randomName = UUID.randomUUID().toString();
			System.out.println(randomName);
				
			String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
					
			randomName += ext;
					
			File f = new File(uploadFilePath+randomName);
					
			try{
				file.transferTo(f);
			}catch(Exception e) {
				e.printStackTrace();
			}
					
			String link = "./uploadFiles/" + randomName;
					
			UploadFileVo fileVo =	new UploadFileVo(null,null,file.getOriginalFilename(),link);
					
			fileList.add(fileVo);
			linkList.add(link);
					
		}
		
		return linkList;

	}
	
}
