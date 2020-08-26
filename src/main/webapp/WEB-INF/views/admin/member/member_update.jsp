<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<div class="card card-warning">
			<div class="card-header">
				<h3 class="card-title">
					<strong>회원정보 수정</strong>
				</h3>
			</div>
			<!-- /.card-header -->
			<div class="card-body">
				<form role="form" action="/admin/member/update" method="POST">
					<dr>
					<div class="form-group">
						<label>아이디</label> <br>${memberVO.user_id}
						<input name="user_id" value="${memberVO.user_id}" type="hidden" class="form-control"
							placeholder="아이디">
					</div>
					<dr>
					<div class="form-group">
						<label>패스워드</label> 
						<input name="user_pw" value="" type="text" class="form-control"
							placeholder="${memberVO.user_pw}">
					</div>
					<dr>
					<div class="form-group">
						<label>이름</label> 
						<input name="user_name" value="${memberVO.user_name}" type="text" class="form-control"
							placeholder="이름">
					</div>
					<dr>
					<div class="form-group">
						<label>이메일</label> 
						<input name="email" value="${memberVO.email}" type="text" class="form-control"
							placeholder="이메일">
					</div>
					<dr>
					<div class="form-group">
						<label>포인트</label>
						<input name="point" value="${memberVO.point}" type="text" class="form-control"
							placeholder="포인트">
						<dr>
						<div class="form-group">
						<label>상태</label> 
							<select name="enabled" class="form-control" style="width:90px;">
								<option value="0" 
								<c:out value="${memberVO.enabled eq 'false'?'selected':''}"></c:out>
								>False</option>
								<option value="1" 
								<c:out value="${memberVO.enabled eq 'true'?'selected':''}"></c:out>
								>True</option>
							</select>
						</div>
						<dr>
						<div class="form-group">
							<label>등급</label> <select name="levels" class="form-control"
								style="width:140px;">
								<option value="ROLE_USER" 
								<c:out value="${memberVO.levels eq 'ROLE_USER'?'selected':''}"></c:out>
								>ROLE_USER</option>
								<option value="ROLE_ADMIN" 
								<c:out value="${memberVO.levels eq 'ROLE_ADMIN'?'selected':''}"></c:out>
								>ROLE_ADMIN</option>
							</select>
						</div>
						<dr>
						<button type="submit" class="btn btn-default" 
							style="background-color:yellow;">
							<strong>등록</strong>
						</button>
						<a href="/admin/member/list?page=${pageVO.page}" class="btn btn-default"
							style="background-color:skyblue;">
							<strong>돌아가기</strong>
						</a>
						<input name="page" type="hidden" value="${pageVO.page}">
				</form>
			</div>
			<!-- /.card-body -->
		</div>
		<!-- /.card -->
	</div>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@ include file="../include/footer.jsp"%>


