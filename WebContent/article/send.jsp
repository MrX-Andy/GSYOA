<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
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

<!-- 加载编辑器 -->
<link rel="stylesheet" href="public/kindeditor/themes/default/default.css" />
<script charset="utf-8" src="public/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="public/kindeditor/lang/zh_CN.js"></script>
<script>
	$(function() {
		var editor = KindEditor.create('textarea[name="article.content"]');
	});

</script>

<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<div class="page-header">
			<h1>发送文章</h1>
		</div>

		<form method="post" id="form_data" name="form_data"	 action="Article_save"  	class="well form-horizontal">

			<div class="form-group">
				<label class="col-sm-2 control-label" for="name">标题*：</label>
				<div class="col-sm-10">
					<input class="form-control"  type="text" id="name" name="article.title" value="${article.title }">
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="name">标题颜色：</label>
				<div class="col-sm-10">	
					<input class="form-control" type="text"  id="color" name="article.color" value="${article.color }">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-12">
					<textarea id="myEditor"	style="margin-left: 0px; margin-right: 0px; width: 100%;" 	name="article.content" >${article.content}</textarea>
				</div>
			</div>

			<div class="operate panel panel-default">
				<div class="panel-body">
					<div class="pull-left">
						<a onclick="Main_main" class="btn btn-sm btn-primary">返回首页</a>
					</div>
					<div class="pull-right">
						<input type="hidden" name="article.id" value="${article.id }"/>
						<input type="hidden" name="article.userId.id" value="${article.userId.id }"/> 
						<input type="hidden" name="article.createTime" value="${article.createTime }"/>  
						<input	type="submit"   class="btn btn-sm btn-primary button" id="updateForm"  value="　　提交　　">
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