package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.TboardDao;
import com.javaex.vo.TboardVo;

@Service
public class TboardService {

	@Autowired
	private TboardDao tboardDao;

	// 리스트(검색O, 페이징O)
	public Map<String, Object> exeList3(int crtPage, String keyword) {
		System.out.println("TboardService.exeList3()");
		System.out.println(crtPage);

		/**********************************
		 * 리스트 가져오기
		 */
		// 한페이지당 출력 글갯수
		int listCnt = 10;
		// crtPage
		crtPage = (crtPage > 0) ? crtPage : (crtPage = 1);
		int startRowNo = (crtPage - 1) * listCnt;
		// startRowNo, listCnt Map으로 묶는다
		Map<String, Object> limitMap = new HashMap<String, Object>();
		limitMap.put("startRowNo", startRowNo);
		limitMap.put("listCnt", listCnt);
		limitMap.put("keyword", keyword);

		// dao에 전달해서 현재페이지의 리스트 10개를 받는다
		List<TboardVo> boardList = tboardDao.boardSelectList3(limitMap);
		
		/********************************
		 * 페이징 계산
		 */
		// 페이지당 버튼 갯수
		int pgaeBtncount = 5;
		// 전체 글갯수
		int totalCnt = tboardDao.selectTotalCnt3(keyword);
		// 마지막 버튼 번호
		int endPageBtnNo = (int) Math.ceil(crtPage / (double) pgaeBtncount) * pgaeBtncount;
		// 시작 버튼 번호
		int startPgaeBtnNo = (endPageBtnNo - pgaeBtncount) + 1;
		// 다음 화살표 유무
		boolean next = false;
		if (listCnt * endPageBtnNo < totalCnt) { // 한페이지당글갯수(10) * 마지막버튼번호(5) < 전체글갯수 102개
			next = true;
		} else { // 다음화살표가 false일때 마지막 버튼 번호 정확히 계산
			endPageBtnNo = (int) Math.ceil(totalCnt / (double) listCnt);

		}
		// 이전 화살표 유무
		boolean prev = false;
		if (startPgaeBtnNo != 1) {
			prev = true;
		}
		// Map으로 붂어서 Controller에 return
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("boardList", boardList);
		pMap.put("startPgaeBtnNo", startPgaeBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);
		pMap.put("prev", prev);
		pMap.put("next", next);

		return pMap;
	}

	
	
	
	// 리스트(검색X, 페이징O)
	public Map<String, Object> exeList2(int crtPage) {
		System.out.println("TboardService.exeList2()");
		System.out.println(crtPage);

		//////////////////////////////////////////////////
		// 리스트가져오기
		//////////////////////////////////////////////////
		// 한페이지당 출력 글갯수
		int listCnt = 10;

		// crtPage
		crtPage = (crtPage > 0) ? crtPage : (crtPage = 1);
		/*
		 * if(crtPage > 0) { crtPage = crtPage; }else { crtPage = 1; }
		 */

		int startRowNo = (crtPage - 1) * listCnt;

		// startRowNo, listCnt Map으로 묶는다
		Map<String, Integer> limitMap = new HashMap<String, Integer>();
		limitMap.put("startRowNo", startRowNo);
		limitMap.put("listCnt", listCnt);

		// dao에 전달해서 현재페이지의 리스트 10개를 받는다
		List<TboardVo> boardList = tboardDao.boardSelectList2(limitMap);

		//////////////////////////////////////////////////
		// 페이징 계산
		//////////////////////////////////////////////////

		// 페이지당 버튼 갯수
		int pgaeBtncount = 5;

		// 전체 글갯수
		int totalCnt = tboardDao.selectTotalCnt();
		int endPageBtnNo = (int) Math.ceil(crtPage / (double) pgaeBtncount) * pgaeBtncount;

		// 시작 버튼 번호
		int startPgaeBtnNo = (endPageBtnNo - pgaeBtncount) + 1;

		// 다음 화살표 유무
		boolean next = false;
		if (listCnt * endPageBtnNo < totalCnt) { // 한페이지당글갯수(10) * 마지막버튼번호(5) < 전체글갯수 102개
			next = true;
		} else {
			endPageBtnNo = (int) Math.ceil(totalCnt / (double) listCnt);
		}

		// 이전 화살표 유무
		boolean prev = false;
		if (startPgaeBtnNo != 1) {
			prev = true;
		}

		// 5개 map으로 묶어서 controller한테 보낸다 리턴해준다
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("boardList", boardList);
		pMap.put("startPgaeBtnNo", startPgaeBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);
		pMap.put("prev", prev);
		pMap.put("next", next);

		System.out.println(pMap);

		return pMap;
	}

	// 리스트(검색X,페이징 X)
	public List<TboardVo> exeList() {
		System.out.println("TboardService.exeList()");

		List<TboardVo> boardList = tboardDao.boardSelectList();

		return boardList;

	}

}