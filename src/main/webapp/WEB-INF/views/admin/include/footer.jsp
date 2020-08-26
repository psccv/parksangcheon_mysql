<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Control Sidebar -->
<aside class="control-sidebar control-sidebar-dark">
	<!-- Control sidebar content goes here -->
	<div class="p-3">
		<h5>Title</h5>
		<p>Sidebar content</p>
		<a href="/logout" class="btn btn-primary btn-lg btn-block">로그아웃</a>
	</div>
</aside>
<!-- /.control-sidebar -->

<!-- Main Footer -->
<footer class="main-footer">
	<!-- To the right -->
	<div class="float-right d-none d-sm-inline">Anything you want</div>
	<!-- Default to the left -->
	<strong>Copyright &copy; 2014-2020 <a
		href="https://adminlte.io">AdminLTE.io</a>.
	</strong> All rights reserved.
</footer>
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->


<!-- Bootstrap 4 -->
<script src="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="/resources/dist/js/adminlte.min.js"></script>
<script>
$(document).ready(function() {
    var current = location.pathname;
    //alert(current.split("/",3)[2]); //디버그값
    var current_split = current.split("/",3)[2]; //member OR board
    $('.nav-treeview li a').each(function(){// 반복문
        var $this = $(this);
        if(current=="/admin" || current=="/admin/"){
        }else{
        	//if($this.attr('href').includes(current) == true){ //includes 크롬에서만 작동
        	if($this.attr('href').indexOf(current_split) != -1){ //indexOf 익스플로러에서도 작동 명시적이지 않음
           		$this.addClass('active');
        	}else{
        		$this.removeClass('active');
        	}
        }
    })
 });
</script>

</body>
</html>
