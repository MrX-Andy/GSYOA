<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang='en'>
	<head>
		<meta charset='utf-8' />
		<title><s:property value="#application.SystemInfo.name" /></title>
		<meta content='' name='description' />
		<meta content='' name='author' />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- Bootstrap -->
		<link href="public/css/bootstrap.min.css" rel="stylesheet" >
		<link href="public/css/jquery-ui-1.9.2.custom.css" rel="stylesheet" />
		<link href="public/css/checkbox/grey.css" rel="stylesheet" />
		<link href="public/css/font-awesome.min.css" rel="stylesheet" />
		<!--[if lt IE 9]>
		<link type="text/css" href="public/css/custom-theme/jquery.ui.1.9.2.ie.css"  rel="stylesheet" />
		<![endif]-->

		<link href="public/css/style.css" rel="stylesheet">
		<script src="public/js/jquery.js"></script>
		<script src="public/js/jquery.icheck.min.js"></script>

		<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
		<script src="public/js/html5shiv.js"></script>
		<script src="public/js/respond.min.js"></script>
		<![endif]-->
		<!-- 点击验证码刷新 -->
		<script type="text/javascript"> 
			 function changeimg()
			 {
			   var myimg = document.getElementById("code"); 
			   now = new Date(); 
			   myimg.src="makeCertPic.jsp?"+now.getTime();
			 } 
		</script> 
	
	</head>
	<body>
		<!-- Wrap all page content here -->
		
			
<div class="container">
	<!-- /container -->
	<div class="row">
		<div class="col-xs-12 hidden-xs" style="margin-top:80px;"></div>
	</div>
	<div class="row">
		<div class="col-sm-8 hidden-xs">
			<div class="img" style="height: 500px;background-image: url('public/img/back.jpg');	background-repeat: no-repeat;"></div>
		</div>
		<div class="col-sm-4 well">
			<div style="margin-bottom:44px">
				<h1 class="text-center">国商院OA系统 </h1>
			</div>
			<form action="login" method="post" id="form_data" class="form-horizontal" >
				<div class="form-group">
					<label class="col-sm-3  control-label" for="emp_no">编　号：</label>
					<div class="col-sm-9">
						<input class="form-control" id="emp_no"  name="user.id"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3  control-label" for="password">密　码：</label>
					<div class="col-sm-9">
						<input class="form-control" id="password" type="password" name="user.password"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3  control-label" for="password">身　份：</label>
					<div class="col-sm-9">
						<select name="position.id" class="form-control">
							<s:iterator value="#request.PositionList" id="position">
						    <option value="<s:property value="#position.id"/>"><s:property value="#position.name"/></option>
						    </s:iterator>
				        </select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3  control-label" for="emp_no">验证码：</label>
					<div class="col-sm-4">
						<input class="form-control" id="emp_no"  name="user.state"/>
					</div>
					<div class="col-sm-5">
		 					<a href="javascript:changeimg()"><img id="code" src="makeCertPic.jsp"></a>
						
						
					</div>
				</div>
				<p>
				&nbsp;
				
			</p>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-9">
						<input type="submit" value="　登录　"   class="btn btn-lg btn-primary login_button"  id="updateForm">　　
						<input type="button" value="　重置　" onclick="login();" class="btn btn-lg btn-primary">
					</div>	
				</div>
			</form>
			<p>&nbsp;
				
			</p>
			<p>&nbsp;
				
			</p>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-8">
			<span>©2014 <s:property value="#application.SystemInfo.address" /> 2011级软件技术班</span>
		</div>

		<div class="col-sm-4 text-right">
			<span> <a href="#">开发日记</a> </span>&nbsp;&nbsp;&nbsp;&nbsp; <span> <a title="点击这里给我发消息" href="http://wpa.qq.com/msgrd?v=3&uin=<s:property value="#application.SystemInfo.qq" />&site=qq&menu=yes" target="_blank"><img title="点击这里给我发消息" alt="点击这里给我发消息" src="http://wpa.qq.com/pa?p=2:<s:property value="#application.SystemInfo.qq" />:52" border="0" />&nbsp;在线咨询</a></span>
		</div>
	</div>
	
	
	
				</div>
		</div>
		<script src="public/js/bootstrap.min.js"></script>
		<script src="public/js/jquery-ui-1.9.2.custom.min.js"></script>
		<script src="public/js/common.js"></script>
		
		<!-- 提示框 -->
		<button id="winForm" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" style="display:none;">提示框</button>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title" id="myModalLabel"><s:property value="#application.SystemInfo.name" /> ->提示您</h4>
		      </div>
		      <div class="modal-body">内容</div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- 异步提交 -->
		<script type="text/javascript" src="public/js/jquery.form.js"></script>
		<script type="text/javascript">
			$('#updateForm').click(function() {
				$('#form_data').ajaxForm(function(date) {
					$(".modal-body").html(""); /* 清空内容 */
					$(".modal-body").append(date); /* 设置内容 */
					$("#winForm").click();		/*点击按钮打开提示框*/
				});
			});
		</script>
	</body>
</html>
