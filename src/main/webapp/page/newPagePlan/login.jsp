<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>CRM客户关系管理系统</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css"
	rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/opform.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/global.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/win.js"
	type="text/javascript"></script>
<style>
.font {
	color: #000000;
	font-size: 9pt;
	font-family: "宋体"
}

.td {
	font-size: 9pt;
	font-family: "宋体";
	height: 25px;
}

INPUT {
	background-color: #FFFFFF;
}

body {
	margin: 0px;
}
</style>
<script type="text/javascript">
	function changeCheckNum() {
		var checkNumImage_ = document.getElementById("checkNumImage");
		checkNumImage_.src = "${pageContext.request.contextPath}/image.jsp?timeStamp="
				+ new Date().getTime();
	}

	function checkSubmit() {
		document.forms[0].submit();
	}
</script>
</head>

<BODY topmargin="0" leftmargin="0"
	onLoad="if (window.location != window.top.location) window.top.location.href=window.location.href; document.all.userName.focus();setUserName();">
	<form name="form1" method="post" action="${pageContext.request.contextPath}/user/login.do">
	<!-- <form name="form1" method="post" action=""> -->
		<TABLE width="100%" cellpadding="0" cellspacing="0" id="header">
			<TR>
				<TD>
					<TABLE height="80" cellpadding="0" cellspacing="0" width="100%">
						<TR>
							<TD width="225">
								<img src="${pageContext.request.contextPath}/ui/images/ban_1.gif">
							</TD>
							<TD
								background="${pageContext.request.contextPath}/ui/images/ban_2.gif">
									&nbsp;
							</TD>
							<TD width="181"
								background="${pageContext.request.contextPath}/ui/images/ban_2.gif">
							</TD>
						</TR>
					</TABLE>
				</TD>
			</TR>
			<TR>
				<TD height="119"
					background="${pageContext.request.contextPath}/ui/images/bg.gif">
					&nbsp;
				</TD>
			</TR>
			<TR>
				<TD height="300">
					<TABLE width="100%" cellpadding="0" cellspacing="0">
						<TR>
							<TD valign="top" align="center">
								<img src="${pageContext.request.contextPath}/ui/images/6de23acd08b3d569c38beade29c3293e.jpg">
							</TD>
							<TD width="44" height="200"
								background="${pageContext.request.contextPath}/ui/images/line.png">
								&nbsp;
							</TD>
							<TD width="540" valign="top">
								<TABLE width="100%" cellpadding="0" cellspacing="0">
									<TR>
										<TD height="140" valign="top">
											<font class="font">请输入您的用户名及密码:</font>
											<br> 
											<font color="#FF0000"></font>
											<br>
											<TABLE cellpadding="0" cellspacing="0">
												<TR>
													<TD class="td">用户帐号：</TD>
													<TD class="td">
														<input name="name" type="text" value="${requestScope.name}"
															id="name" />
													</TD>
												</TR>
												<TR>
													<TD class="td">登录密码：</TD>
													<TD class="td">
														<input name="password" type="password"
															value="${requestScope.password}" id="password">
													</TD>
												</TR>
												<TR>
													<TD class="td">验&nbsp;证&nbsp;码：</TD>
													<TD class="td">
														<input name="checkNum" type="text"
															value="" id="checkNum" style="width: 80"> 
														<img id="checkNumImage"
															src="${pageContext.request.contextPath}/image.jsp"
															height="19" align="absmiddle" onClick="changeCheckNum()"
															title="点击换一张" style="cursor: hand">
														<span style="color:red">${requestScope.checkInfo}</span>
													</TD>
												</TR>
												<TR>
													<TD class="td">记&nbsp;住&nbsp;我：</TD>
													<TD class="td">
														<input name="rememberMe"
															type="checkbox" id="rememberMe" value="yes"
															class="checkbox" ${checked}>
													</TD>
												</TR>
											</TABLE>
										</TD>
									</TR>
									<TR>
										<TD>
											<img
												src="${pageContext.request.contextPath}/ui/images/login.png"
												id="login" onClick="checkSubmit();" style="cursor: pointer;">
											&nbsp;
											<%-- <a href="${pageContext.request.contextPath}/user/login.do">
												登录
											</a> --%>
											&nbsp;
											<img src="${pageContext.request.contextPath}/ui/images/reset.png"
												id="reset" onClick="" style="cursor: hand">
										</TD>
									</TR>
								</TABLE>
							</TD>
						</TR>
					</TABLE>
				</TD>
			</TR>
		</TABLE>
	</form>
</BODY>
</html>
