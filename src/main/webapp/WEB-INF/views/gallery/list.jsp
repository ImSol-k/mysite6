<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="${pageContext.request.contextPath }/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/css/gallery.css" rel="stylesheet" type="text/css">

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


                  <button id="btnImgUpload">이미지올리기</button>
                  <div class="clear"></div>


                  <ul id="viewArea">

                     <!-- 이미지반복영역 -->
					<c:forEach items="${galleryList }" var="galleryVo">
	                     <li>
	                        <div class="view">
	                           <img class="imgItem" src="${pageContext.request.contextPath }/upload/${galleryVo.saveName}">
	                           <div class="imgWriter">
	                              작성자: <strong>${galleryVo.name }</strong>
	                           </div>
	                        </div>
	                     </li>
					</c:forEach>
                     <!-- 이미지반복영역 -->


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
                  <label class="form-text">글작성</label> <input id="addModalContent" type="text" name="" value="">
               </div>
               <div class="form-group">
                  <label class="form-text">이미지선택</label> <input id="file" type="file" name="" value="">
               </div>
            </div>
            <div class="m-footer">
               <button type="submit">저장</button>
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
	   
	   //이미지 업로드 팝업열기
	   let btnImgUpload = document.querySelector("#btnImgUpload");
	   console.log(btnImgUpload);
	   btnImgUpload.addEventListener("click", modalOpen);
	   //팝업닫기
	   let closeBtn = document.querySelectorAll(".closeBtn");
	   for(let i = 0; i < closeBtn.length; i++){
		   closeBtn[i].addEventListener("click", modalClose);
	   }
	   
   });
   
   /***************************
    * 이미지 업로드 팝업창열긴
    */
   function modalOpen(event){
		//클릭된 요소가 버튼이면
  		if(event.target.tagName == "BUTTON"){
  			console.log("모달창 켜기");      			
  			let modal = document.querySelector(".modal");
  			modal.style.display = "block";
  		} 
	}//modalOpen()
   /***************************
    * 이미지 업로드 팝업창닫기
    */
   function modalClose(){
  	let modal = document.querySelector(".modal");
	modal.style.display = "none";
	}//modalClose()
</script>


</html>

