<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="${pageContext.request.contextPath }/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/css/gallery.css" rel="stylesheet" type="text/css">
<!-- axios 라이브러리 포함 -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<style>
	.modal {
		width: 100%;
		height: 100%;
		display: none;
		position: fixed;
		left: 0;
		top: 0;
		z-index: 999;
		overflow: auto;
		background-color: rgba(0,0,0,0.4);
	}
	.modal .modal-content {
		width: 600px;
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
</style>

</head>


<body>
   <div id="wrap">

      <c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
      <!-- //header -->
      <!-- //nav -->

      <div id="container" class="clearfix">
         <div id="aside">
            <h2>갤러리</h2>
            <ul>
               <li><a href="">일반갤러리</a></li>
               <li><a href="">파일첨부연습</a></li>
            </ul>
         </div>
         <!-- //aside -->
         <div id="content">

            <div id="content-head">
               <h3>갤러리</h3>
               <div id="location">
                  <ul>
                     <li>홈</li>
                     <li>갤러리</li>
                     <li class="last">갤러리</li>
                  </ul>
               </div>
               <div class="clear"></div>
            </div>
            <!-- //content-head -->


            <div id="gallery">
					<div id="list">

						<c:if test="${!(empty authUser)}">
							<button id="btnImgUpload">이미지올리기</button>
						</c:if>
						<div class="clear"></div>
						<ul id="viewArea">
						</ul>
					</div>
					<!-- //list -->
            </div>
            <!-- //board -->
         </div>
         <!-- //content  -->
      </div>
      <!-- //container  -->


      <c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
      <!-- //footer -->

   </div>
   <!-- //wrap -->

   <!-- 이미지등록 팝업(모달)창 -->
   <div id="addModal" class="modal">
      <div class="modal-content">
         <form action="" method="">
            <div class="closeBtn">×</div>
            <div class="m-header">간단한 타이틀</div>
            <div class="m-body">
            
               <div>
                  <label class="form-text">글작성</label><input id="addModalContent" type="text" name="content" value="">
               </div>
               <div class="form-group">
                  <label class="form-text">이미지선택</label><input id="file" type="file" name="file" value="">
               </div>
            </div>
            <div class="m-footer">
            	<input type="text" name="no" value="${authUser.no }">
               <button type="submit" id="saveBtn">저장</button>
            </div>
         </form>
      </div>
   </div>


   <!-- 이미지보기 팝업(모달)창 -->
   <div id="viewModal" class="modal">
      <div class="modal-content">
         <div class="closeBtn">×</div>
         <div class="m-header">간단한 타이틀</div>
         <div class="m-body">
            <div>
               <img id="viewModelImg" src="">
               <!-- ajax로 처리 : 이미지출력 위치-->
            </div>
            <div>
               <p id="viewModelContent"></p>
            </div>
         </div>
         <div class="m-footer">
            <button>삭제</button>
         </div>
      </div>
   </div>
</body>

<script type="text/javascript">
   
   document.addEventListener("DOMContentLoaded", function(){
	   
	   //리스트불러오기
	   ListRender();
	   
	   //이미지 업로드 팝업열기
	   let btnImgUpload = document.querySelector("#btnImgUpload");
	   console.log(btnImgUpload);
	   btnImgUpload.addEventListener("click", modalOpen);
	   
	   //파일선택
	   let file = document.querySelector("#file");
	   //console.log(file);
	   
	   //이미지 업로드
	   let saveBtn = document.querySelector("#saveBtn");
	   saveBtn.addEventListener("click", imgUpload);
	   
	   //팝업닫기
	   let closeBtn = document.querySelectorAll(".closeBtn");
	   for(let i = 0; i < closeBtn.length; i++){
		   closeBtn[i].addEventListener("click", modalClose);
	   }
	   
   });
   /***************************
	 * 이미지 리스트 요청
	 */
	function ListRender(){
	   console.log("리스트요청");
		axios({
			method: 'get',
			url: '${pageContext.request.contextPath}/gallery',
			headers: {"Content-Type" : "application/json; charset=utf-8"},
			responseType: 'json' 	//수신타입
		}).then(function (response) {
			//respon.data의 길이만큼 반복
			for(let i = 0; i < response.data.length; i++){
				let galleryVo = response.data[i];
				galleryList(galleryVo);
			}
			
		}).catch(function (error) {
			console.log(error);
		});
   }
   /***************************
	 * 이미지 리스트 그리기
	 */
	function galleryList(galleryVo){
	   console.log("리스트그리기");
	   let str = "";
	   str += ' <li>';
	   str += '  <div class="view">';
	   str += '   <img class="imgItem" src="${pageContext.request.contextPath }/assets/galleryImg/'+galleryVo.saveName+'">';
	   str += '   <div class="imgWriter"> 작성자: <strong>'+galleryVo.name+'</strong></div>';
	   str += '  </div>';
	   str += ' </li>';
	   
	   let viewArea = document.querySelector("#viewArea");
	   viewArea.insertAdjacentHTML("beforeend", str);
	   
	   
    }//galleryList()
	 
	/***************************
	 * 이미지 업로드 팝업창열기
	 */
	function modalOpen(event){
		//클릭된 요소가 버튼이면
  		if(event.target.tagName == "BUTTON"){
  			console.log("이미지업로드");      			
  			let modal = document.querySelector(".modal");
  			modal.style.display = "block";
  		} 
	}//modalOpen()
	
	/***************************
	 * 이미지 업로드
	 */
	 function imgUpload(){
		let no = Number(document.querySelector('[name = "no"]').value);
		let content = document.querySelector('[name = "content"]').value;
        let file = document.querySelector('[name = "file"]').files[0];
        console.log(content, file);
        let formData = new FormData();
        formData.append('no', no);
        formData.append('content', content);
        formData.append('file', file);
        axios({
			method: 'post', // put, post, delete
	       	url: '${pageContext.request.contextPath }/gallery',
	       	headers: {"Content-Type" : "multipart/form-data; charset=utf-8"}, //전송타입
	       	data: formData, //파라미터로 값이 전달
	       	responseType: 'json' //수신타입
	       }).then(function (response) {
	       }).catch(function (error) {
	       	console.log(error);
	       });
	}
	
	/***************************
	 * 이미지 업로드 팝업창닫기
	 */
	function modalClose(){
		console.log("이미지업로드 취소");
		let modal = document.querySelector(".modal");
		modal.style.display = "none";
	}//modalClose()
	
	
</script>


</html>

