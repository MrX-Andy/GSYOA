<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->

			<div class="page-header">
				<h1>查看文章</h1>
			</div>

			<form method="post" id="form_data" name="form_data"  action="Messages_doReply" enctype="multipart/form-data" class="well form-horizontal">

				<div class="form-group">
					<div class="col-sm-10">
						<h2 align="center" style="color:<s:property 	value="#article.color" />; text-decoration:none;font-weight:bold;">${article.title }</h2>
		        
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-10">
					发布人： <label  id="name" name="name">${article.userId.name}</label>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-10">
					发布时间： <label  id="name" name="name">20${article.createTime }</label>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-10">
						最后修改时间：  <label  id="name" name="name">20${article.updateTime}</label>
		        
					</div>
				</div>
			<div class="operate panel panel-default">
				<div class="panel-body">
					<p>${article.content }</p>
				</div>
			</div>
			
			</form>
