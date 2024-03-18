package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.AttachService;

/******************************************
 * GalleryController
 ******************************************/

@Controller
@RequestMapping("attach")
public class AttachController {

	@Autowired
	private AttachService attachService;

	/**********************************
	 * 사진 업로드 -uploadForm() -upload()
	 */
	@RequestMapping(value = "uploadform", method = RequestMethod.GET)
	public String uploadForm() {
		System.out.println("AttachContoller.uploadForm()");
		return "attach/form";
	}
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String upload(@RequestParam(value = "file") MultipartFile file, Model model) {
		System.out.println("AttachContoller.upload()");

		String saveName = attachService.exeUpload(file);
		model.addAttribute("saveName", saveName);
		
		return "attach/result";
	}

}
