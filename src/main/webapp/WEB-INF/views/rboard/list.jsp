<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
					<div id="list">
						<form action="" method="get">
							<div class="form-group text-right">
								<input type="text" name="find">
								<button type="submit" id="btn_search">검색</button>
							</div>
						</form>
						<table>
							<thead>
								<tr>
									<th width="60px">번호</th>
									<th>제목</th>
									<th>글쓴이</th>
									<th width="60px">조회수</th>
									<th width="120px">작성일</th>
									<th width="60px"></th>
									<th>g/o</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${cList }" var="rboardVo">
									<tr>
										<td>${rboardVo.no }</td>
										<td class="text-left"><a
											href="${pageContext.request.contextPath}/rboard/read?no=${rboardVo.no }">
												${rboardVo.title }[${rboardVo.depth }] </a></td>
										<td>${rboardVo.name }</td>
										<td>${rboardVo.hit }</td>
										<td>${rboardVo.regDate }</td>
										<c:if test="${!(empty authUser)}">
											<td><a href="${pageContext.request.contextPath}/rboard/writeform">[댓글달기]</td>
										</c:if>
										<td>${rboardVo.groupNo }/${rboardVo.orderNo }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

						<div id="paging">
							<ul>
								<li><a href="">◀</a></li>
								<li class="active"><a href="">1</a></li>
								<li><a href="">2</a></li>
								<li><a href="">3</a></li>
								<li><a href="">4</a></li>
								<li><a href="">5</a></li>
								<li><a href="">6</a></li>
								<li><a href="">7</a></li>
								<li><a href="">8</a></li>
								<li><a href="">9</a></li>
								<li><a href="">10</a></li>
								<li><a href="">▶</a></li>
							</ul>


							<div class="clear"></div>
						</div>
						<c:if test="${!(empty authUser)}">
							<a id="btn_write" href="${pageContext.request.contextPath}/board/writeform">글쓰기</a>
						</c:if>
					</div>
					<!-- //list -->
				</div>
				<!-- //board -->
			</div>
			<!-- //content  -->

		</div>
		<!-- //container  -->

		<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
	</div>
	<!-- //wrap -->

</body>

</html>
