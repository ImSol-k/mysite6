<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="${pageContext.request.contextPath}/assets/css/mysite.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css"
	rel="stylesheet" type="text/css">

<!-- axios 라이브러리 포함 -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<style>
	.modal {
		width: 100%; 	/*  */
		height: 100%;	/*  */
		display: none;	/* 처음엔 숨김처리 */
		position: fixed;/* 위치고정 */
		left: 0;		/* 왼쪽 0부터 시작 */
		top: 0;			/* 위 0부터 시작 */
		z-index: 999;	/* 제일위 */
		overflow: auto;	/* 내용많으면 스크롤 */
		background-color: rgba(0,0,0,0.4);/*  */
	}
	
	.modal .modal-content {
		width: 400px;
		border: 1px solid #888888;
		background-color: #ffffff;
		padding: 0px 20px 20px 20px;
		margin: 100px auto;
	}
	
	.modal .modal-content .closeBtn{
		text-align: right;
		color: "#aaaaaa";
		font-size:28px;
		font-weight: bold;
		cursor: pointer;
	}
	.input-pass{
		margin: 50px;
	}

</style>

</head>

<body>
	<div id="wrap">

		<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
		

		<div id="container" class="clearfix">
			<div id="aside">
				<h2>방명록</h2>
				<ul>
					<li>일반방명록</li>
					<li>ajax방명록</li>
				</ul>
			</div>
			<!-- //aside -->

			<div id="content">

				<div id="content-head" class="clearfix">
					<h3>일반방명록</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>방명록</li>
							<li class="last">일반방명록</li>
						</ul>
					</div>
				</div>
				<!-- //content-head -->

				<div id="guestbook">
					<form id="guestForm"
						action="${pageContext.request.contextPath}/guest/addlist"
						method="get">
						<table id="guestAdd">
							<colgroup>
								<col style="width: 70px;">
								<col>
								<col style="width: 70px;">
								<col>
							</colgroup>
							<tbody>
								<tr>
									<th><label class="form-text" for="input-uname">이름</label>
									</td>
									<td><input id="input-uname" type="text" name="name"></td>
									<th><label class="form-text" for="input-pass">패스워드</label>
									</td>
									<td><input id="input-pass" type="password" name="pass"></td>
								</tr>
								<tr>
									<td colspan="4"><textarea name="content" cols="72"
											rows="5"></textarea></td>
								</tr>
								<tr class="button-area">
									<td colspan="4" class="text-center"><button type="submit">등록</button></td>
								</tr>
							</tbody>

						</table>
						<!-- //guestWrite -->
						<input type="hidden" name="action" value="add">

					</form>

					<!-- 모달 창 컨텐츠 -->
					<div id="myModal" class="modal">
						<div id="guestbook" class="modal-content">
							<div class="closeBtn">×</div>
							<div class="m-header">패스워드를 입력하세요</div>
							<div class="m-body">
								<input type="password" name="password" value=""><br>
								<input type="hidden" name="no" value="">
							</div>
							<div class="m-footer">
								<button class="btnDelete" type="button">삭제</button>
							</div>
						</div>
					</div>
					<!-- 모달창 -->
					<div id="guestbookList"></div>
					<!-- list -->
				</div>
				<!-- //guestbook -->
			</div>
			<!-- //content  -->
		</div>
		<!-- //container  -->

		<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>

	</div>
	<!-- //wrap -->

</body>

<script>
	document.addEventListener("DOMContentLoaded", function() {
		
		//데이터 리스트 요청	
		addListAndRender();
		
		//등록버튼 클릭
	    let btnAdd = document.querySelector("#guestForm");
	    btnAdd.addEventListener("submit", addAndList);//btnAdd.addEventListener()
	      
	    //모달창호출버튼 클릭
	    let guestbookList = document.querySelector("#guestbookList");
	    guestbookList.addEventListener("click", mCall);//guestbookList.addEventListener()
	    
	    //모달창 삭제버튼 클릭
	    let btnDelete = document.querySelector(".btnDelete");
	    btnDelete.addEventListener("click", deleteAndRemove);
	    
	    //모달창 닫기
	    let modalClose = document.querySelector(".closeBtn");
	    modalClose.addEventListener("click", mClose);
	      
	});//document.addEventListener()
	   
	   
	
	
	/******************************
	 * 리스트 불러오기
	 * -addList()
	 ******************************/
	function addListAndRender() {
		axios({
			method: 'get', //method type : put, post, delete
			url: '/mysite6/api/guestbooks',
			headers: {"Content-Type" : "application/json; charset=utf-8"}, //전송타입
			//params: guestbookVo, 	//get방식 파라미터로 값이 전달
			//data: guestbookVo, 		//put, post, delete 방식 자동으로 JSON으로 변환 전달
			responseType: 'json' 	//수신타입
		}).then(function (response) {
			//console.log(response); 	//수신데이터
			//console.log(response.data); 	//수신데이터
			
			//respon.data의 길이만큼 render호출
			for(let i = 0; i < response.data.length; i++){
				let guestVo = response.data[i];
				render(guestVo, "down");
			}
			
		}).catch(function (error) {
			console.log(error);
		});
	}
	
	/**************************
	 * 글쓰기
	 * -addAndList
	 **************************/
	function addAndList(event){
		console.log("글쓰기 클릭");
        event.preventDefault();
         
         //폼 데이터 수집
        let name = document.querySelector('[name = "name"]').value;
        let pw = document.querySelector('[name = "pass"]').value;
        let content = document.querySelector('[name = "content"]').value;
        //console.log(name, pw, content);
         
        let guestbookVo = {
        	name : name,
        	pw : pw,
        	content : content
        };
        
    	//새로 추가된 방명록
        axios({
			method: 'post', // put, post, delete
        	url: '/mysite6/api/guestbooks',
        	headers: {"Content-Type" : "application/json; charset=utf-8"}, //전송타입
        	params: guestbookVo, //파라미터로 값이 전달
        	//data: guestbookVo, //JSON으로 변환 전달
        	responseType: 'json' //수신타입
        }).then(function (response) {
        	console.log(response); //수신데이터
        	console.log("axios",response.data);
        	
        	let guestbookVo = response.data;
        	render(guestbookVo, "up");
        	
        	
        }).catch(function (error) {
        	console.log(error);
        });
	}
	
	/***************************
	 * 방명록 그리기 function
	 * -render()
	 ***************************/
	function render(guestbookVo, dir){
		//console.log("render()");
		//console.log(guestbookVo);
		//str에 html저장
		let str = '';
		str += ' <table id="t-'+guestbookVo.no+'" class="guestRead">';
		str += ' 	<colgroup>';
		str += ' 		<col style="width: 10%;">';
		str += ' 		<col style="width: 40%;">';
		str += ' 		<col style="width: 40%;">';
		str += ' 		<col style="width: 10%;">';
		str += ' 	</colgroup>';
		str += ' 	<tr>';
		str += ' 		<td>'+ guestbookVo.no +'</td>';
		str += ' 		<td>'+ guestbookVo.name +'</td>';
		str += ' 		<td>'+ guestbookVo.date +'</td>';
		str += ' 		<td><button class="btnModal" type="button" data-no='+guestbookVo.no+'>삭제</button></td>';
		str += ' 	</tr>';
		str += ' 	<tr>';
		str += ' 		<td colspan=4 class="text-left">'+ guestbookVo.content +'</td>';
		str += ' 	</tr>';
		str += ' </table>';
		
		//guestbookList인 id를 찾아서 beforeend에 추가
		let guestbookList = document.querySelector("#guestbookList");
		//방명록 추가 포지션 지정
		
		if(dir == "down"){
			guestbookList.insertAdjacentHTML("beforeend", str);
		} else if (dir == "up"){
			guestbookList.insertAdjacentHTML("afterbegin", str);
		} else{
			console.log("방향확인");
		}
		
			
	}//render()
	
	/*****************************
	 * 모달창 삭제버튼 클릭
	 *****************************/
	function deleteAndRemove(){
	  	
	  	//데이터 모으기
		let password = document.querySelector('[name="password"]').value;
		let no = document.querySelector('[name="no"]').value;
		let guestbookVo = {
			pw : password,
			no : no
		}
		
		//화면에서 삭제
	 	//tableRemove(no);
	  	console.log(guestbookVo);
		axios({
			method: 'delete', //method type : put, post, delete
			url: '${pageContext.request.contextPath}/api/guestbooks/'+no,
			headers: {"Content-Type" : "application/json; charset=utf-8"}, //전송타입
			params: guestbookVo, 	//get방식 파라미터로 값이 전달
			//data: guestbookVo, 	//put, post, delete 방식 자동으로 JSON으로 변환 전달
			responseType: 'json' 	//수신타입
		}).then(function (response) {	
			
            //화면에서 삭제
            //리턴값이 1이면(db에서 삭제가 되면)
			if(response.data == 1){
                 let id = "#t-"+no;
                 let removeTable = document.querySelector(id);
                 //테이블삭제
                 removeTable.remove();
                 //모달창 닫기
                 mClose();
             } else {
            	 window.alert("비밀번호를 다시 확인해주세요");
             }
			
		}).catch(function (error) {
			console.log(error);
		});
	 	//삭제후 모달창 닫기
		
	}//mDelete()
	
	/*****************************
	 * modal창 호출
	 * -mCall
	 *****************************/
	function mCall(event){
		//클릭된 요소가 버튼이면
   		if(event.target.tagName == "BUTTON"){
   			console.log("모달창 켜기");
				//모달 가져오기(화면에 나타내기)	      			
   			let modal = document.querySelector(".modal");
   			modal.style.display = "block";
   			//넘길 번호값 받아아갈 요소 찾기
   			let no = document.querySelector('[name="no"]');
   			//번호 받아가기
   			no.value = event.target.dataset.no;
   		} 
	}
	
	/************************
	 * modal창 닫기
	 * -mClose
	 ************************/
	function mClose(){
   			//내용 초기화
		let password = document.querySelector('[name="password"]');
	   	password.value= ""; 
	   	let modal = document.querySelector(".modal");
		modal.style.display = "none";
	}//modalClose
	
	
	//////////////////////// 안씀 ////////////////////////
	//화면에서 삭제
	function tableRemove(no){
		let tableTag = document.querySelectorAll(".guestRead tr:first-child>td:first-child");
	 	for(let i = 0; i< tableTag.length; i++){
	 			if(tableTag[i].textContent == no){
	 				//console.log("t:",tableTag[i].parentElement.parentElement.parentElement);
	 				tableTag[i].parentElement.parentElement.parentElement.remove();
	 			}
	 		
	 	}
	}
	
	
</script>

</html>