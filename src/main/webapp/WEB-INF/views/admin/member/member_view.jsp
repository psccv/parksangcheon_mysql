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
					<strong>회원정보</strong>
				</h3>
			</div>
			<!-- /.card-header -->
			<div class="card-body">
				<form role="form" action="/admin/member/delete" method="POST">
					<dr>
					<div class="form-group">
						<label>아이디</label><br> ${memberVO.user_id}
					</div>
					<dr>
					<div class="form-group">
						<label>패스워드</label><br> ${memberVO.user_pw}
					</div>
					<dr>
					<div class="form-group">
						<label>이름</label><br> ${memberVO.user_name}
					</div>
					<dr>
					<div class="form-group">
						<label>이메일</label><br> ${memberVO.email}
					</div>
					<dr>
					<div class="form-group">
						<label>포인트</label><br> ${memberVO.point}
					</div>
					<dr>
					<div class="form-group">
						<label>상태</label><br> ${memberVO.enabled}
					</div>
					<dr>
					<div class="form-group">
						<label>등급</label><br> ${memberVO.levels}
					</div>
					<dr> 
						<a href="/admin/member/update?user_id=${memberVO.user_id}&page=${pageVO.page}" class="btn btn-default"
							style="background-color:yellow;position:relative;left:78%;">
							<strong>수정</strong>
						</a> <button type="submit" class="btn btn-default"
							style="background-color:red;position:relative;left:78%;">
							<strong>삭제</strong>
						</button> <a href="/admin/member/list?page=${pageVO.page}" class="btn btn-default"
							style="background-color:skyblue;position:relative;left:78%;">
							<strong>돌아가기</strong>
						</a>
						<input name="user_id" type="hidden" value="${memberVO.user_id}">
				</form>
				<!-- /.card-body -->
			</div>
			<!-- /.card -->
		</div>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->

	<%@ include file="../include/footer.jsp"%>
	
	
