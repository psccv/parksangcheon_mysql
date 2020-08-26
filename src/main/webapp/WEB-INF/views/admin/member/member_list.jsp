<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../include/header.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0 text-dark">DashBoard Management</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Starter Page</li>
					</ol>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content-header -->

	<!-- Main content -->
	<div class="content">

		<div class="card">
			<div class="card-header" style="background-color:#A2E9FF;">
				<h3 class="card-title">
					<strong>회원 검색</strong>
				</h3>
				<br>
				<div class="card-tools">
					<form action="/admin/member/list">
						<div class="input-group"
							style="width: 500px; positon: relative; padding: 5px; right: 98%;">
							<select class="form-control" name="searchType"
								style="text-align-last: center; direction:inherit;">
								<option selected>전체</option>
								<option>아이디</option>
								<option>이름</option>
								<option>이메일</option>
							</select><input type="text" name="searchKeyword"
								class="form-control float-right" placeholder="Search">
							<div class="input-group-append">
								<button type="submit" class="btn btn-default">검색</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- /.card-header -->
			<div class="card-body table-responsive p-0"
				style="text-align:center;">
				<table class="table table-hover text-nowrap">
					<thead>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>이메일</th>
							<th>포인트</th>
							<th>상태</th>
							<th>등록일</th>
							<th>등급</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${memberList}" var="memberVO" varStatus="status">
							<tr>
								<td><a href="/admin/member/view?user_id=${memberVO.user_id}&page=${pageVO.page}">${memberVO.user_id}</a></td>
								<td><a href="/admin/member/view?user_id=${memberVO.user_id}&page=${pageVO.page}">${memberVO.user_name}</a></td>
								<td>${memberVO.email}</td>
								<td>${memberVO.point}</td>
								<td>${memberVO.enabled}</td>
								<td><fmt:formatDate pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" value="${memberVO.reg_date}"/></td>
								<td>${memberVO.levels}</td>
							</tr>
						</c:forEach>
						
					</tbody>
				</table>
			</div>
			<!-- /.card-body -->
		</div>
		<!-- /.card -->

		<a href="/admin/member/write" class="btn btn-default" 
			style="background-color:#148CFF;">
			<strong>등록</strong>
		</a>
		<nav>
			<ul class="pagination" style="position: relative; left: 30%;">
					<c:if test="${pageVO.prev}">
						<li class="page-item"><a class="page-link"
							href="/admin/member/list?page=${pageVO.startPage-1}&searchType=${pageVO.searchType}&searchKeyword=${pageVO.searchKeyword}">이전</a></li>
					</c:if>
					<c:forEach begin="${pageVO.startPage}" end="${pageVO.endPage}"
						var="idx">
						<li
							class='page-item <c:out value="${idx==pageVO.page?'active':''}"/>'>
							<a href="/admin/member/list?page=${idx}&searchType=${pageVO.searchType}&searchKeyword=${pageVO.searchKeyword}"
							class="page-link">${idx} </a>
						</li>
					</c:forEach>
					<c:if test="${pageVO.next}">
						<li class="page-item"><a class="page-link"
							href="/admin/member/list?page=${pageVO.endPage+1}&searchType=${pageVO.searchType}&searchKeyword=${pageVO.searchKeyword}">다음</a></li>
					</c:if>
				</ul>
			</nav>
			<br>
	</div>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@ include file="../include/footer.jsp"%>


