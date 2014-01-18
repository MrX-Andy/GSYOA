<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!-- 异步提交 -->
<script type="text/javascript" src="public/js/jquery.form.js"></script>

<script type="text/javascript">
	$('#updateApply').click(function() {
		$('#form_data').ajaxForm(function(date) {
			/* alert(date);  */
			$(".modal-body").html(""); /* 清空内容 */
			$(".modal-body").append(date); /* 设置内容 */
			$("#winForm").click();		/*点击按钮打开提示框*/
		});
	});
</script>


<!-- 加载编辑器 -->
<link rel="stylesheet" href="public/kindeditor/themes/default/default.css" />
<script charset="utf-8" src="public/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="public/kindeditor/lang/zh_CN.js"></script>
<script>
	$(function() {
		var editor = KindEditor.create('textarea[name="apply.content"]');
	});
</script>
<!-- 加载编辑器 -->





<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<div class="page-header">
			<h1>申请报销</h1>
		</div>

		<form method="post" id="form_data" name="form_data"	 action="Apply_update"  	class="well form-horizontal">


			<div class="form-group">
					<label class="col-sm-3  control-label" for="password">申请类型：</label>
					<div class="col-sm-9">
						<select name="apply.typeId.id" class="form-control" readonly="true">			
						    <option  value="<s:property value="#request.apply.typeId.id"/>"><s:property value="#request.apply.typeId.title"/></option>					   
				        </select>
						
						
					</div>
			</div>

			<div class="form-group">
				<div class="col-sm-12">
				     <input type="hidden" id="id1" name="apply.id" value="<s:property value="#request.apply.id"/>"> 
					<textarea id="myEditor"	style="margin-left: 0px; margin-right: 0px; width: 100%;" 	name="apply.content"><s:property value="#request.apply.content"/></textarea>
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
						<input	type="submit"   class="btn btn-sm btn-primary button"  id="updateApply" value="　　提交修改　　">
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