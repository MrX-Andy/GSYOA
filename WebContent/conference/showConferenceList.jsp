<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!-- 异步提交 -->
<script type="text/javascript" src="public/js/jquery.form.js"></script>
<script type="text/javascript">
	$('.button').click(function() {
		$('#form_data').ajaxForm(function(date) {
			/* alert(date);  */
			$(".col-xs-12").html(""); /* 清空内容 */
			$(".col-xs-12").append(date); /* 设置内容 */
		});
	});
</script>



	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->

			<div class="page-header">
				<h1>查看站内信</h1>
			</div>

			<form method="post" id="form_data" name="form_data"  action="Messages_doReply" enctype="multipart/form-data" class="well form-horizontal">
				

				<div class="form-group">
					<div class="col-sm-10">
						主    题：  <label  id="name" name="name"><s:property value="#request.showList.title"/></label>
		        
					</div>
				</div>


				<div class="form-group">
					<div class="col-sm-10">
					部门经理： <label  id="name" name="name"><s:property value="#request.showList.createUserId.name"/></label>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-10">
						会议时间：  <label  id="name" name="name">20<s:property value="#request.showList.createTime"/></label>
		        
					</div>
				</div>
                 
				<div class="form-group">
					<div class="col-xs-12">
						 会议内容：<p><s:property value="#request.showList.content"/></p>
				
					</div>
				</div>
			<div class="operate panel panel-default">
				
			</div>
			
			</form>