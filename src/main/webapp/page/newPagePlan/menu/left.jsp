<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>菜单</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/menu/css/jquery.treeview.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/menu/css/screen.css" />
<script src="${pageContext.request.contextPath}/menu/js/jquery-1.4.2.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/menu/js/jquery.treeview.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("#tree").treeview({
			collapsed : true,
			animated : "medium",
			control : "#sidetreecontrol",
			persist : "location"
		});
	})
</script>

</head>
<body ondblclick="ToggleNav();">
	<div id="main">
		<div id="sidetree">
			<div class="treeheader">操作菜单</div>

			<div id="sidetreecontrol">
				<a href="?#">Collapse All</a> 
				|
				<a href="?#">Expand All</a>
			</div>
			<ul id="tree">
				<li>
					<img src="${pageContext.request.contextPath}/ui/images/menu/khgl.png"
						width="17" height="17"> 
					<strong>客户管理</strong>
					<ul>
						<li>
							<img src="${pageContext.request.contextPath}/ui/images/menu/khbf.png"
								width="17" height="17"> 
							<a href="${pageContext.request.contextPath}/company/selectCompanyByPage.do"
								target="rightFrame">
								客户拜访
							</a>
						</li>
						<%-- <li>
							<img src="${pageContext.request.contextPath}/ui/images/menu/lxrlb.png"
								width="17" height="17"> 
							<a href="${pageContext.request.contextPath}/page/newPagePlan/crm/customer/linkman/view.jsp"
								target="rightFrame">
								联系人列表
							</a>
						</li>
						<li>
							<im src="${pageContext.request.contextPath}/ui/images/menu/lxjllb.png"
								width="17" height="17"> 
							<a href="${pageContext.request.contextPath}/page/newPagePlan/crm/customer/linktouch/view.jsp"
								target="rightFrame">
								联系记录列表
							</a>
						</li>
						<li>
							<img src="${pageContext.request.contextPath}/ui/images/menu/khccsz.png"
								width="17" height="17"> 
							<a href="${pageContext.request.contextPath}/page/newPagePlan/crm/customer/rule/rule.jsp"
								target="rightFrame">
								客户查重设置 
							</a>
						</li> --%>
					</ul>
				</li>
				<li>
					<img src="${pageContext.request.contextPath}/ui/images/menu/xtsz.png"
						width="17" height="17"> 
					<strong>系统设置 </strong>
					<ul>
						
						<li>
							<img src="${pageContext.request.contextPath}/ui/images/menu/bmsz.png"
								width="17" height="17"> 
							<a href="${pageContext.request.contextPath}/group/selectAllGroupByPage.do"
							target="rightFrame">
								部门设置
							</a>
						</li>
						<li>
							<img src="${pageContext.request.contextPath}/ui/images/menu/czqxz.png"
							width="17" height="17"> 
							<a href="${pageContext.request.contextPath}/privilege/selectPrivilegeByPage.do"
							target="rightFrame">
								权限设置
							</a>
						</li>
						<li>
							<img src="${pageContext.request.contextPath}/ui/images/menu/rsgl.png"
							width="17" height="17"> 
							<a href="${pageContext.request.contextPath}/role/showRoleByPage.do"
							target="rightFrame">
								角色管理
							</a>
						</li>
						<li>
							<img src="${pageContext.request.contextPath}/ui/images/menu/bmsz.png"
								width="17" height="17"> 
							<a href="${pageContext.request.contextPath}/user/showUser.do"
							target="rightFrame">
								用户角色
							</a>
						</li>
						<li>
							<img src="${pageContext.request.contextPath}/ui/images/menu/bmsz.png"
								width="17" height="17"> 
							<a href="${pageContext.request.contextPath}/log/selectLogByPage.do"
							target="rightFrame">
								日志查看
							</a>
						</li>
						<li>
							<img src="${pageContext.request.contextPath}/ui/images/menu/sfzl.png"
								width="17" height="17"> 
							<a href="${pageContext.request.contextPath}/province/selectProvinceByPage.do"
								target="rightFrame">
								省份资料
							</a>
						</li>
						<li>
							<img src="${pageContext.request.contextPath}/ui/images/menu/cszl.png"
								width="17" height="17"> 
							<a href="${pageContext.request.contextPath}/city/selectCityByPage.do"
								target="rightFrame">
								城市资料
							</a>
						</li>
						<li>
							<img src="${pageContext.request.contextPath}/ui/images/menu/bmzj.png"
								width="17" height="17"> 
							<a href="${pageContext.request.contextPath}/codeRule/selectCodeRuleByPage.do"
								target="rightFrame">
								编码规则
							</a>
						</li>
					</ul>
				</li>

				<li>
					<img src="${pageContext.request.contextPath}/ui/images/menu/bbyfx.png"
						width="17" height="17"> 
					<strong>报表与分析</strong>
					<%-- <ul>
						<li>
							<img src="${pageContext.request.contextPath}/ui/images/menu/khflfx.png"
								width="17" height="17"> 
							<a href="${pageContext.request.contextPath}/page/newPagePlan/report/khflfxReport.jsp"
								target="rightFrame">
								客户分类分析 
							</a>
						</li>
						<li>
							<img src="${pageContext.request.contextPath}/ui/images/menu/khgjfx.png"
								width="17" height="17"> 
							<a href="${pageContext.request.contextPath}/page/newPagePlan/report/khflfxReport.jsp"
								target="rightFrame">
								客户分析
							</a>
						</li>
					</ul>
				</li>
			</ul>
 --%>
		</div>

	</div>
	<div id="divCollapsedNav" class="navTocColor"
		style="display: none; width: 100%; height: 100%;">
		<a href="javascript:ToggleNav();" title="展开导航框架" id="linkNavClosed">
			<img src="${pageContext.request.contextPath}/menu/images/toc2.gif"
				alt="展开导航框架" border="3"/>
		</a>
	</div>
	
	<script src="${pageContext.request.contextPath}/menu/js/left.js"></script>

</body>
</html>
