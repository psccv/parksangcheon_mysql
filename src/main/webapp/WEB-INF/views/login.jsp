<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="include/header.jsp"%>

<script>
	if('${param.msg}' == "fail"){
		alert("로그인에 실패 했습니다.! \n\n" + 
				"상세 메세지 : ${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}"); 
	}
</script>

<!-- container -->
<div id="container">
	<!-- location_area -->
	<div class="location_area member">
		<div class="box_inner">
			<h2 class="tit_page">
				스프링 <span class="in">in</span> 자바
			</h2>
			<p class="location">
				회원 <span class="path">/</span> 로그인
			</p>
			<ul class="page_menu clear">
				<li><a href="javascript:;" class="on">회원가입</a></li>
			</ul>
		</div>
	</div>
	<!-- //location_area -->
	<!-- bodytext_area -->
	<div class="bodytext_area box_inner">
		<!-- appForm -->
		<form action="/login" method="POST" class="appForm">
			<fieldset>
				<legend>입력 양식</legend>
				<p class="info_pilsoo pilsoo_item">필수입력</p>
				<ul class="app_list">
					<li class="clear"><label for="title"
						class="tit_lbl pilsoo_item">아이디</label>
						<div class="app_content">
							<input type="text" class="w100p" id="user_id" name="user_id"
								placeholder="아이디를 입력해주세요">
						</div></li>
					<li class="clear"><label for="writer"
						class="tit_lbl pilsoo_item">암호</label>
						<div class="app_content">
							<input type="password" class="w100p" id="user_pw" name="user_pw"
								placeholder="암호를 입력해주세요">
						</div></li>
				</ul>
				<p class="btn_line">
					<button type="submit" class="btn_baseColor">로그인</button>
				</p>
			</fieldset>
		</form>
		<!-- //appForm -->
	</div>
	<!-- //bodytext_area -->
</div>
<!-- //container -->
<%@ include file="include/footer.jsp"%>
