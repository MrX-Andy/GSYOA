<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!-- 异步提交 -->
<script type="text/javascript" src="public/js/jquery.form.js"></script>
<script type="text/javascript">
	$('#updateForm').click(function() {
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
			<h1>申请</h1>
		</div>

		<form method="post" id="form_data" name="form_data"	 action="Apply_add"  	class="well form-horizontal">
			<input type="hidden" id="ajax" name="ajax" value="0"> 
			<input	type="hidden" id="add_file" name="add_file"> 
			<input	type="hidden" id="type" name="type" value="11"> 
			<input	type="hidden" id="opmode" name="opmode" value="add"> 
			<input	type="hidden" id="confirm" name="confirm" value=""> 
			<input	type="hidden" id="confirm_name" name="confirm_name" value="">
			<input type="hidden" id="consult" name="consult" value=""> 
			<input	type="hidden" id="consult_name" name="consult_name" value="">
			<input type="hidden" id="refer" name="refer" value=""> 
			<input	type="hidden" id="refer_name" name="refer_name" value=""> 
			<input	type="hidden" id="step" name="step" value="">

			<div class="form-group">
					<label class="col-sm-3  control-label" for="password">申请类型：</label>
					<div class="col-sm-9">
						<select name="apply.typeId.id" class="form-control">
							<s:iterator value="#request.typeList" id="type">
						    <option value="<s:property value="#type.id"/>"><s:property value="#type.title"/></option>
						    </s:iterator>
				        </select>
					</div>
			</div>

			<div class="form-group">
				<div class="col-sm-12">
					<textarea id="myEditor"	style="margin-left: 0px; margin-right: 0px; width: 100%;" 	name="apply.content"></textarea>
				</div>
			</div>

			<div class="operate panel panel-default">
				<div class="panel-body">
					<div class="pull-left">
						<a onclick="Main_main" class="btn btn-sm btn-primary">返回首页</a>
					</div>
					<div class="pull-right">
						<input	type="submit"   class="btn btn-sm btn-primary button"  id="updateForm" value="　　提交　　">
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