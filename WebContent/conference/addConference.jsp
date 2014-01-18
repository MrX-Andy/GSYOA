<%@ page language="java" contentType="text/html; charset=UTF-8"	import="java.util.Date" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!-- 异步提交 -->
		<script type="text/javascript" src="public/js/jquery.form.js"></script>
		<script type="text/javascript">
			$('#button').click(function() {
				$('#form_data').ajaxForm(function(date) {
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
		var editor = KindEditor.create('textarea[name="conference.content"]', {
			resizeType : 1,
			allowPreviewEmoticons : false,
			allowImageUpload : false,
			items : [ 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor',
					'bold', 'italic', 'underline', 'removeformat', '|',
					'justifyleft', 'justifycenter', 'justifyright',
					'insertorderedlist', 'insertunorderedlist', '|',
					'emoticons', 'image', 'link' ]
		});
	});
</script>
<!-- 加载编辑器 -->

<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<div class="page-header">
			<h1>会议管理</h1>
		</div>

		<form method="post" id="form_data" name="form_data"	 action="Conference_add"  	class="well form-horizontal">

			<div class="form-group">
				<label class="col-sm-2 control-label" for="name">会议主题：</label>
				<div class="col-sm-3">
					<input class="form-control"  type="text" id="name" name="conference.title" >	
				</div>
			</div>

			 <div class="form-group">
					<label class="col-sm-2  control-label" for="password">部门经 理 ：</label>
					<div class="col-sm-3">
				    
				        <select name="conference.createUserId.id" class="form-control">
							<s:iterator value="#request.userList" id="user">
						    <option value="<s:property value="#user.id"/>" <s:if test="#user.id==department.mangerId.id">selected</s:if>  ><s:property value="#user.name"/></option>
						    </s:iterator>
				        <select>
				        
				        
					</div>
				</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="name">会议时间：</label>
				<div class="col-sm-3">
					<input class="form-control"  type="text" id="times" name="conference.createTime"  value='2013-12-30 10:14:20'>	
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="name">会议地点：</label>
				<div class="col-sm-3">
					<input class="form-control"  type="text" id="name" name="conference.address" >	
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="name">会议内容：</label>
				<div class="col-sm-12">
					<textarea style="margin-left: 0px; margin-right: 0px; width: 100%;"  name="conference.content" >
					</textarea>	
				</div>
			</div>
			
			<div class="operate panel panel-default">
				<div class="panel-body">
					<div class="pull-left">
						<a onclick="go_return_url();" class="btn btn-sm btn-primary">返回</a>
					</div>
					<div class="pull-right">
						<a onclick="save(10);" class="btn btn-sm btn-primary">临时保存</a> 
						<input	type="submit"  id="button" class="btn btn-sm btn-primary button"  value="　　提交　　">
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
		
		
		