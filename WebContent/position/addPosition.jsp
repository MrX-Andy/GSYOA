<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!-- 异步提交 -->
<script type="text/javascript" src="public/js/jquery.form.js"></script>
<script type="text/javascript">
	$('.button').click(function() {
		$('#form_data').ajaxForm(function(date) {
			/* alert(date);  */
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
			<h1>职位管理</h1>
		</div>

		<form method="post" id="form_data" name="form_data"	 action="Position_add"  	class="well form-horizontal">
<div class="form-group">
				<label class="col-sm-2 control-label" for="name">职位名称：</label>
				<div class="col-sm-3">
					<input class="form-control"  type="text" id="content" name="position.name" value="${position.name}">	
				</div>
			</div>

			
			
			<div class="operate panel panel-default">
				<div class="panel-body">
					<div class="pull-left">
						<a onclick="go_return_url();" class="btn btn-sm btn-primary">返回</a>
						<a onclick="popup_confirm();" class="btn btn-sm btn-primary">选择审批流程</a>
					</div>
					<div class="pull-right">
						<a onclick="save(10);" class="btn btn-sm btn-primary">临时保存</a>
						<input type="hidden" name="position.id" value="${position.id}"/>  
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