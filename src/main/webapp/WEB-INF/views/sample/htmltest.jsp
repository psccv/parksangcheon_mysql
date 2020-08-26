<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<body>
	<h1 >HTML 이란?</h1>
	<h2>HTML 의 역사</h2>
	<h3>팀 버너스리에 대해</h3>
	<h4>HTML 의 태그</h4>
	<h5>HTML 의 태그</h5>
	<h6>안녕하세요`~</h6>
	<a href="http://conol.tistory.com">conol 티스토리로 가자!</a>
	<a>안녕하세요?</a>

	<img src="resources/images/ice.jp" alt="설명란 얼음 이미지">

	<p>
		<strong>이것은</strong> 문단입니다.<br> <b>이것은</b> 문단입니다.
	</p>
	<p>이것은&nbsp;&nbsp;&nbsp;&nbsp; &amp; &lt; &gt; &copy;
		&nbsp;&nbsp;&nbsp;&nbsp;문단입니다.</p>
	<hr>
	<p>이것은 문단입니다.</p>

	<ul>
		<li>리스트 1</li>
		<li>리스트 2</li>
	</ul>
	<ol>
		<li>리스트 1</li>
		<li>리스트 2</li>
	</ol>

	<div>
		<h2>회원가입폼 입니다.</h2>
		<form method="post" action="/htmltset" class="adminlogin_form">
			성별을 선택해 주세요 <select name="gender">
				<option value="M">남자</option>
				<option value="F">여자</option>
			</select> <br> <input type="text" name="userid" placeholder="user ID">
			<input type="password" name="password" placeholder="user Password">
			<br> <input type="file" name="upload_file"> <br>
			본인소개글 작성:
			<br>
			<textarea name="contents" cols="100" rows="5"
				placeholder="글을 입력해 주세요."></textarea>
			<input type="submit" name="submit" value="회원가입" class="login">
		</form>
	</div>

	<br>
	<br>
	<table summary="00학교 00반 성적표" style="border: 1px solid black">
		<!-- 인라인 스타일 주기 -->
		<caption>이 테이블은 학생들의 성적표 입니다.</caption>
		<tr>
			<th>이름</th>
			<th>성적</th>
		</tr>
		<tr>
			<td>김일국</td>
			<td>15</td>
		</tr>
		<tr>
			<td colspan="2">BBB</td>
		</tr>
		<tr>
			<td>CCC</td>
			<td>C</td>
		</tr>
	</table>





</body>
</html>