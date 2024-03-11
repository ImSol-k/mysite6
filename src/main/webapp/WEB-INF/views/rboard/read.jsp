<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">

</head>


<body>
	<div id="wrap">

		<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>

		<div id="container" class="clearfix">
			<jsp:include page="/WEB-INF/views/includes/board.jsp"></jsp:include>

			<div id="content">

				<div id="content-head">
					<h3>댓글게시판</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>게시판</li>
							<li class="last">댓글게시판</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->
	
				<div id="board">
					<div id="read">
						<form action="${pageContext.request.contextPath}/rboard/write"
							method="get">
							<!-- 작성자 -->
							<div class="form-group">
								<span class="form-text">작성자</span> <span class="form-value">${rbVo.name }</span>
							</div>

							<!-- 조회수 -->
							<div class="form-group">
								<span class="form-text">조회수</span> <span class="form-value">${rbVo.hit }</span>
							</div>

							<!-- 작성일 -->
							<div class="form-group">
								<span class="form-text">작성일</span> <span class="form-value">${rbVo.regDate }</span>
							</div>

							<!-- 제목 -->
							<div class="form-group">
								<span class="form-text">제 목</span> <span class="form-value">${rbVo.title }</span>
							</div>

							<!-- 내용 -->
							<div id="txt-content">
								<span class="form-value"> ${rbVo.content } </span>
							</div>
							<div>
								<div>
									<a id="btn_modify"
										href="${pageContext.request.contextPath}/board/modifyform?no=${rbVo.no}">수정</a>
									<a id="btn_modify"
										href="${pageContext.request.contextPath}/board/list">목록</a>
								</div>
							</div>

						</form>
						<!-- //form -->
					</div><!-- //read -->
				</div><!-- //board -->
			</div><!-- //content  -->
		</div><!-- //container  -->

		<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
		
	</div><!-- //wrap -->

</body>

</html>
