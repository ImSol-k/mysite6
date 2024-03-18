package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.vo.AttachVo;
import com.javaex.vo.GalleryVo;

/**********************
 * GalleryController
 **********************/
@Controller
@RequestMapping("/gallery")
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;
	
	/***********************
	 * GalleryMain
	 *  -list()
	 */
	@RequestMapping(value="main", method= {RequestMethod.GET, RequestMethod.POST})
	public String main() {
		System.out.println("GalleryController.main()");
		
		return "gallery/list";
	}
	
	/*********************************
	 * list
	 */
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public List<GalleryVo> list() {
		System.out.println("GalleryController.list()");
		List<GalleryVo> galleryList = galleryService.exeList();
		System.out.println(galleryList);
		return galleryList;
	}
	/*********************************
	 * upload
	 */
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public String upload(@RequestParam("no") int no,
						 @RequestParam("content") String content,
						 @RequestParam("file") MultipartFile file) {
		System.out.println("GalleryController.upload()");
		System.out.println("/ no: " + no);
		galleryService.exeUpload(no, content, file);
		return "";
	}
	
}
