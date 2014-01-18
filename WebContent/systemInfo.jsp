<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!-- 异步提交 -->
<script type="text/javascript" src="public/js/jquery.form.js"></script>
<script type="text/javascript">
	$('.button').click(function() {
		$('#form_data').ajaxForm(function(date) {
/* 			alert("---");  */
			$(".modal-body").html(""); /* 清空内容 */
			$(".modal-body").append(date); /* 设置内容 */
			$("#winForm").click();		/*点击按钮打开提示框*/
		});
	});
</script>

<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<div class="page-header">
			<h1>系统信息</h1>
		</div>

		<form method="post" id="form_data" name="form_data"	 action="SystemInfo_update"  	class="well form-horizontal">

			<div class="form-group">
				<label class="col-sm-2 control-label" for="name">网站名称：</label>
				<div class="col-sm-5">
					<input class="form-control"  type="text" id="email" name="systemInfo.name" value="<s:property value="#application.SystemInfo.name" /> ">	
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="name">E-mail：</label>
				<div class="col-sm-5">
					<input class="form-control" type="text" id="name" name="systemInfo.email" value="<s:property value="#application.SystemInfo.email" /> ">	
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" for="name">服务电话：</label>
				<div class="col-sm-5">
					<input class="form-control" type="text" id="name" name="systemInfo.phone" value="<s:property value="#application.SystemInfo.phone" /> ">	
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" for="name">客服QQ：</label>
				<div class="col-sm-5">
					<input class="form-control" type="text" id="name" name="systemInfo.qq" value="<s:property value="#application.SystemInfo.qq" /> ">	
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" for="name">公司地址：</label>
				<div class="col-sm-5">
					<input class="form-control" type="text" id="name" name="systemInfo.address" value="<s:property value="#application.SystemInfo.address" /> ">	
				</div>
			</div>


			<div class="operate panel panel-default">
				<div class="panel-body">
					<div class="pull-left">
						<a onclick="Main_main" class="btn btn-sm btn-primary">返回首页</a>
					</div>
					<div class="pull-right">
						<a onclick="save(10);" class="btn btn-sm btn-primary">临时保存</a> 
						<input	type="submit"   class="btn btn-sm btn-primary button"  value="　　提交　　">
					</div>
				</div>
			</div>
		</form>
		
		
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
		</div>