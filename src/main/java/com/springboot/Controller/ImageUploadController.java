package com.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.Helper.FileUploadHelper;
import com.springboot.Helper.Response;

@RestController
@CrossOrigin("*")
public class ImageUploadController {
	
	
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@Autowired
	private Response response;
	
	@PostMapping("/Upload-Image")
	public ResponseEntity<String> UploadFile(@RequestParam("file") MultipartFile file){
		
//		System.out.println(file.getName());
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getContentType());
//		System.out.println(file.getSize());
//		System.out.println(file.isEmpty());
		
		try {
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain File");
			}
			if(!file.getContentType().equals("image/jpeg")) {
				
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File Must be of type JPEG");
			}
			
			boolean f=fileUploadHelper.UploaFile(file);
			if(f) {
				return ResponseEntity.status(HttpStatus.OK).body("Server--File Uploaded Successfully");
				//return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/Image/").path(file.getOriginalFilename()).toUriString());
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server--Something Went Wrong");
		
	}

}
