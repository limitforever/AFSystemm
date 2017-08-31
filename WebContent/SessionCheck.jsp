<%@page import="cauc.edu.cn.model.AFUserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("CURRENTLOGINUSER") == null) {
%>
		<script type="text/javascript">
			alert("您还没有登录，请登录...");
			window.document.location.href="Login.jsp";
		</script>	
<%
	}
%>