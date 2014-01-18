<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>GSYOA系统 -> 广西国际商务职业技术学院</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- basic styles -->
<link rel="stylesheet" href="public/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="public/assets/css/font-awesome.min.css" />
<!--[if IE 7]>
		<link rel="stylesheet" href="public/assets/css/font-awesome-ie7.min.css" />
	<![endif]-->
<!-- page specific plugin styles -->
<link rel="stylesheet"
	href="public/assets/css/jquery-ui-1.10.3.full.min.css" />
<link rel="stylesheet" href="public/assets/css/ace.min.css" />
<link rel="stylesheet" href="public/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="public/assets/css/ace-skins.min.css" />
<!--[if lte IE 8]>
		<link rel="stylesheet" href="public/assets/css/ace-ie.min.css" />
	<![endif]-->
<!-- inline styles related to this page -->
<link rel="stylesheet" href="public/assets/css/style.css" />
<!-- ace settings handler -->
<script src="public/assets/js/ace-extra.min.js"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
	<script src="public/assets/js/html5shiv.js"></script>
	<script src="public/assets/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	<div class="shade"></div>
	<div class="navbar navbar-default" id="navbar">
		<script type="text/javascript">
			try {
				ace.settings.check('navbar', 'fixed')
			} catch (e) {
			}
		</script>
		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="Main_main" class="navbar-brand"><small><i
						class="icon-leaf"></i> GSYOA系统 </small> </a>
				<!-- /.brand -->
			</div>
			<!-- /.navbar-header -->

			<div class="navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">
					<li class="green"><a href="#M#messages/Messages_list"
						onclick="del_current_node()"><i
							class="icon-envelope icon-animated-vertical"></i> <span
							class="badge badge-success">${messagesSum}</span> </a></li>

					<li class="light-blue"><a data-toggle="dropdown" href="#"
						class="dropdown-toggle"> <img class="nav-user-photo"
							src="public/assets/images/gallery/image-6.jpg"> <span
							class="user-info"> <s:property value="#session.User.name" />
						</span> <i class="icon-caret-down"></i>
					</a>
						<ul
							class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li><a href="#M#user/userInfo.jsp"> <i
									class="icon-user"></i> 用户资料
							</a></li>
							<li><a href="#M#user/updatePassword.jsp"><i
									class="icon-lock"></i> 修改密码</a></li>
							<li class="divider"></li>
							<li><a href="#W#User_loginOut"> <i class="icon-off"></i>
									退出
							</a></li>
						</ul></li>
				</ul>
				<!-- /.ace-nav -->
			</div>
			<!-- /.navbar-header -->
		</div>
		<!-- /.container -->
	</div>




	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<div class="main-container-inner">
			<a class="menu-toggler hidden-print" id="menu-toggler" href="#">
				<span class="menu-text"></span>
			</a>
			<div class="sidebar hidden-print" id="sidebar">
				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'fixed')
					} catch (e) {
					}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<a class="btn btn-success" href="#M#messages/send.jsp"
							onclick="del_current_node()"> <i class="icon-file-alt"></i>
						</a> <a class="btn btn-info" href="#M#messages/receiveList.jsp"
							onclick="del_current_node()"> <i class="icon-pencil"></i>
						</a> <a class="btn btn-warning" href="{:U('contact/index')}"
							onclick="del_current_node()"> <i class="icon-group"></i>
						</a> <a class="btn btn-danger" href="{:U('schedule/index')}"
							onclick="del_current_node()"> <i class="icon-calendar"></i>
						</a>
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span> <span class="btn btn-info"></span>

						<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
					</div>
				</div>
				<!-- #sidebar-shortcuts -->




				<ul class="nav nav-list">
				
						<li><a class="dropdown-toggle" node="83"
						href="/home/index#M#notice"><i class="icon-bell-alt"></i><span
							class="menu-text">公告</span><b class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<s:if test="#session.UserPosition.id!=1">
							<li><a node="181" href="#M#Article_send"> <i
									class="icon-angle-right"></i><span class="menu-text">公告发布</span></a>
							</li>
							</s:if>	
							<li><a node="138" href="#M#Article_list"> <i
									class="icon-angle-right"></i><span class="menu-text">公告列表</span></a>
							</li>
						</ul></li>
						
				
					<li class=""><a class="dropdown-toggle" node="85"
						href="/mail/folder/fid/inbox"><i class="icon-envelope-alt"></i><span
							class="menu-text">站内信</span><b class="arrow icon-angle-down"></b></a>
						<ul class="submenu" style="display: none;">
							<li><a node="123" href="#M#User_contact"> <i
									class="icon-angle-right"></i><span class="menu-text">查看通讯录</span></a>
							</li>
							<li><a node="100" href="#M#messages/send.jsp"> <i
									class="icon-angle-right"></i><span class="menu-text">发信息</span></a>
							</li>
							<li><a node="151" href="#M#messages/Messages_list"> <i
									class="icon-angle-right"></i><span class="menu-text">信息列表</span></a>
							</li>
							<li><a node="104" href="#M#messages/Messages_deletelist"> <i
									class="icon-angle-right"></i><span class="menu-text">垃圾箱</span></a>
							</li>
						</ul></li>
		


					<li><a class="dropdown-toggle" node="87" href="/flow/index"><i
							class="icon-pencil"></i><span class="menu-text">申请管理</span><b
							class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li><a class="dropdown-toggle" node="145" href="#"><i
									class="icon-angle-right"></i><span class="menu-text">申请</span><b
									class="arrow icon-angle-down"></b></a>
								<ul class="submenu">
									<li><a node="148" href="#M#voucher/voucherList.jsp"> <i
											class="icon-angle-right"></i><span class="menu-text">报销单申请</span></a>
									</li>
									<li><a node="147" href="#M#Apply_register"> <i
											class="icon-angle-right"></i><span class="menu-text">其它申请</span></a>
									</li>
								</ul>
							</li>
							<li><a node="144" href="#M#Apply_progress"> <i
									class="icon-angle-right"></i><span class="menu-text">申请进度</span></a>
							</li>	
							
							<s:if test="#session.UserPosition.id!=1">			
							<li><a class="dropdown-toggle" node="145" href="#"><i
									class="icon-angle-right"></i><span class="menu-text">审批</span><b
									class="arrow icon-angle-down"></b></a>
								<ul class="submenu">
									<li><a node="148" href="#M#Apply_dolist"> <i
											class="icon-angle-right"></i><span class="menu-text">已办理</span></a>
									</li>
									<li><a node="147" href="#M#Apply_list"> <i
											class="icon-angle-right"></i><span class="menu-text">待审批</span></a>
									</li>
								</ul>
							</li>
							</s:if>	
							
						</ul>
					</li>

					<li><a class="dropdown-toggle" node="84" href="/contact/index"><i
							class="icon-cogs"></i><span class="menu-text">会议管理</span><b
							class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
						<s:if test="#session.UserPosition.id!=1">
							<li><a node="169" href="#M#Conference_execute"> <i
									class="icon-angle-right"></i><span class="menu-text">会议记录</span></a>
							</li>
						</s:if>
							<li><a node="125" href="#M#Conference_list"> <i
									class="icon-angle-right"></i><span class="menu-text">会议列表</span></a>
							</li>


						</ul></li>

					<s:if test="#session.UserPosition.id!=1">
					<li><a class="dropdown-toggle" node="137"
						href="/home/index#M#forum"><i class="icon-group"></i><span
							class="menu-text">员工管理</span><b class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li><a node="139" href="#M#Employee_execute"> 
							
							<i
									class="icon-angle-right"></i><span class="menu-text">添加员工</span></a>
							</li>
							<li><a node="139" href="#M#Employee_list"> <i
									class="icon-angle-right"></i><span class="menu-text">员工列表</span></a>
							</li>
							

						</ul></li>
						</s:if>

					<s:if test="#session.UserPosition.id==3">
					<li><a class="dropdown-toggle" node="91"
						href="/schedule/index"><i class="icon-tasks"></i><span
							class="menu-text">部门管理</span><b class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li><a node="139" href="#M#Department_execute"> <i
									class="icon-angle-right"></i><span class="menu-text">增加部门</span></a>
							</li>
							<li><a node="139" href="#M#Department_list"> <i
									class="icon-angle-right"></i><span class="menu-text">部门列表</span></a>
							</li>
						</ul></li>



					<li><a class="dropdown-toggle" node="157"
						href="/contact/index"><i class="icon-comments-alt "></i><span
							class="menu-text">职位管理</span><b class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li><a node="139" href="#M#position/addPosition.jsp"> <i
									class="icon-angle-right"></i><span class="menu-text">增加职位</span></a>
							</li>
							<li><a node="125" href="#M#Position_list"> <i
									class="icon-angle-right"></i><span class="menu-text">职位列表</span></a>
							</li>
						</ul></li>

					</s:if>



				
					<li><a class="dropdown-toggle" node="84" href="/user/index"><i
							class="icon-cogs"></i><span class="menu-text">系统信息</span><b
							class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<s:if test="#session.UserPosition.id==3">
							<li><a node="169" href="#M#systemInfo.jsp"> <i
									class="icon-angle-right"></i><span class="menu-text">系统设定</span></a>
							</li>
							</s:if>
							<li><a node="125" href="#W#about.jsp"> <i
									class="icon-angle-right"></i><span class="menu-text">关于系统</span></a>
							</li>


						</ul></li>
				</ul>
















				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left"
						data-icon1="icon-double-angle-left"
						data-icon2="icon-double-angle-right"></i>
				</div>

				<script type="text/javascript">
					try {
						if (ace.settings.is("sidebar", "collapsed")) {
							ace.settings.sidebar_collapsed(true);
						} else {
							ace.settings.sidebar_collapsed(false);
						}
					} catch (e) {
					}
				</script>
			</div>

			<div class="main-content">
				<div class="breadcrumbs hidden-print" id="breadcrumbs">

					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a href="Main_main">首页</a></li>
					</ul>
					<!-- .breadcrumb -->
				</div>
				<div class="page-content  Flow Mail">
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->

							<div class="row">
								<div class="col-xs-12">
									<!-- PAGE CONTENT BEGINS -->
									<div class="row">
										<div class="col-xs-12 col-sm-6 widget-container-span" id="t1">
											<!-- 公告开始 -->
											<div class="widget-box" sort="11">
												<div class="widget-header">
													<h5 class="smaller">公告</h5>
												</div>
												<div class="widget-body">
													<div class="widget-main">
														<div class="tab-content">
															<div id="mail-new" class="tab-pane in active ul_table">
																<ul>
																	<s:iterator value="#request.articleList" id="article">
																		<li><span class="pull-right hidden-phone">20<s:property
																					value="#article.createTime" /></span> <span
																			class="auto autocut"><a
																				href="#M#Article_show" style="color:<s:property 	value="#article.color" />; text-decoration:none;font-weight:bold;" ><s:property
																						value="#article.title" /></a></span></li>
																	</s:iterator>
																</ul>
															</div>
														</div>
													</div>
												</div>
											</div>

										</div>
										<div class="col-xs-12 col-sm-6 widget-container-span" id="t2">
											<!-- 部门介绍开始 -->
											<div class="widget-box" sort="21">
												<div class="widget-header">
													<h5 class="smaller">${department.name }-部门职责</h5>
												</div>

												<div class="widget-body">
													<div class="widget-main">
														<div class="tab-content">
															<div id="flow-todo" class="tab-pane in active ul_table">
																${department.content }</div>
															<div id="flow-submit" class="tab-pane ul_table">
																<ul>
																	<volist name="submit_flow_list" id="vo">
																	<li><span class="pull-right hidden-phone">{$vo.create_time|toDate='m-d'}</span>
																		<span class="auto autocut"> <a
																			href="{:U('flow/read?id='.$vo['id'])}" node="87|150"
																			return_url="{:U('flow/folder?fid=submit')}">{$vo.name}</a>
																	</span></li>
																	</volist>
																</ul>
															</div>
														</div>
													</div>
												</div>
											</div>

										</div>


									</div>


									<!-- 网站信息开始 -->
									<div class="widget-box" sort="23">
										<div class="widget-header">
											<h5 class="smaller">网站信息</h5>
										</div>
										<div class="widget-body">
											<div class="widget-main ul_table">
												<ul>
													<li><span class="pull-left hidden-phone">网站名称：
															<s:property value="#application.SystemInfo.name" />
													</span></li>
													<li><span class="pull-left hidden-phone">网站地址：
															<s:property value="#application.SystemInfo.address" />
													</span></li>
													<li><span class="pull-left hidden-phone">网站邮箱：
															<s:property value="#application.SystemInfo.email" />
													</span></li>
													<li><span class="pull-left hidden-phone">联系电话：
															<s:property value="#application.SystemInfo.phone" />
													</span></li>
													<li><span class="pull-left hidden-phone">客服QQ：
															<s:property value="#application.SystemInfo.qq" />
													</span></li>
													<li><span class="pull-left hidden-phone">作 者：
															广西国际商务职业技术学院2011级软件技术班（韦海生、杨兵新、黄建伟、杨云云）</span></li>
													<li><span class="pull-left hidden-phone">    </span></li>
												</ul>
											</div>
										</div>
									</div>
									<!-- 网站信息结束 -->


								</div>
							</div>














							<!-- PAGE CONTENT ENDS -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
			<!-- /.main-content -->
			<div class="ace-settings-container hidden-print"
				id="ace-settings-container">
				<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
					id="ace-settings-btn">
					<i class="icon-cog bigger-150"></i>
				</div>

				<div class="ace-settings-box" id="ace-settings-box">
					<div>
						<div class="pull-left">
							<select id="skin-colorpicker" class="hide">
								<option data-skin="default" value="#438EB9">#438EB9</option>
								<option data-skin="skin-1" value="#222A2D">#222A2D</option>
								<option data-skin="skin-2" value="#C6487E">#C6487E</option>
								<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
							</select>
						</div>
						<span>&nbsp;主题颜色</span>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-rtl" /> <label class="lbl"
							for="ace-settings-rtl">菜单靠左</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-add-container" /> <label class="lbl"
							for="ace-settings-add-container"> 禁用响应式
						</label>
					</div>
				</div>
			</div>
			<!-- /#ace-settings-container -->
		</div>
		<!-- /.main-container-inner -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->
	<div id="push_msg"></div>
	<!-- basic scripts -->

	<!--[if !IE]>
	-->
	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='public/assets/js/jquery-2.0.3.min.js'>"
								+ "<" + "/script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
		window.jQuery || document.write("<script src='public/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");</script>
<![endif]-->
	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='public/assets/js/jquery.mobile.custom.min.js'>"
							+ "<" + "/script>");
	</script>
	<script src="public/assets/js/bootstrap.min.js"></script>
	<script src="public/assets/js/typeahead-bs2.min.js"></script>

	<!-- ace scripts -->
	<script src="public/assets/js/ace-elements.min.js"></script>
	<script src="public/assets/js/ace.min.js"></script>
	<script src="public/assets/js/common.js"></script>
	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		$(document).ready(function(){
			$("[href^='#M#']").click(function(){
				$(".page-content").load($(this).attr("href").replace("#M#","./")); 
			});	
			$("[href^='#W#']").click(function(){
				$(".modal-body").load($(this).attr("href").replace("#W#","./"));
				$("#winForm").click();		/*点击按钮打开提示框*/
			});		
		});
	</script>
	
	
			<!-- 提示框 -->
		<button id="winForm" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" style="display:none;">提示框</button>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title" id="myModalLabel"><s:property value="#session.SystemInfo.name" /> ->提示您</h4>
		      </div>
		      <div class="modal-body">内容</div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
		      </div>
		    </div>
		  </div>
		  
	
	
</body>
</html>