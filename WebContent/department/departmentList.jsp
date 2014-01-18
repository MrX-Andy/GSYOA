<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->

		<div class="page-header clearfix">
			<h1 class="col-sm-8">部门管理</h1>
			<div class="col-sm-4 pull-right search_box">
				<form name="form_search" id="form_search" method="post">
					<div class="input-group">
						<input class="form-control" type="text" name="keyword"	 id="keyword">
						<div class="input-group-btn">
							<a class="btn btn-sm btn-info" onclick="submit_search();"><i
								class="icon-search"></i></a> <a class="btn btn-sm btn-success"
								onclick="toggle_adv_search();"><i
								id="toggle_adv_search_icon" class="icon-chevron-down bigger-125"></i></a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<form method="post" name="form_adv_search" id="form_adv_search">
			<div class="adv_search panel panel-default  display-none"
				id="adv_search">
				<div class="panel-heading">
					<div class="row">
						<h4 class="col-xs-6">高级搜索</h4>
						<div class="col-xs-6 text-right">
							<a class="btn btn-sm btn-info" onclick="submit_adv_search();">搜索</a>
							<a class="btn btn-sm " onclick="close_adv_search();">关闭</a>
						</div>
					</div>
				</div>
				<div class="panel-body">
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label" for="li_name">标题：</label>
						<div class="col-sm-8">
							<input class="form-control" type="text" id="li_name"
								name="li_name">
						</div>
					</div>

					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label" for="li_content">内容：</label>
						<div class="col-sm-8">
							<input class="form-control" type="text" id="li_content"
								name="li_content">
						</div>
					</div>

					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label" for="li_from">发件人：</label>
						<div class="col-sm-8">
							<input class="form-control" type="text" id="li_from"
								name="li_from">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label" for="bt_create_time">时间：</label>
						<div class="col-sm-8">
							<input data-date-format="yyyy-mm-dd"
								class="form-control input-date-range" type="text"
								name="bt_create_time" id="bt_create_time" readonly="readonly">
						</div>
					</div>
				</div>
			</div>
		</form>

		<div class="ul_table">
			<ul>
				<li class="thead">
					<span class="col-15"> 部门名称</span>
					<span class="col-35"> 部门经理</span> 
					<span class="col-15 pull-right text-center">	操作</span>   
					
				</li>
				
				<s:iterator value="#request.dpList" id="dpList">
				<form method="post" action="###Department_delete" name="form_data" id="form_data">
					<li class="tbody normal">
						<span class="col-15"> 
							<s:property value="#dpList.name"/>
						</span> 
						<span class="col-35"> 
							<a email="<s:property value="#dpList.mangerId"/>" email="<s:property value="#dpList.mangerId.name"/>"><s:property value="#dpList.mangerId.name"/></a>
						</span> 
						
						<span class="col-15 pull-right text-center">
							<a href="#W#Department_delete?department.id=<s:property value="#dpList.id"/>" class="btn btn-primary btn-xs ">删除</a>　
							<a href="###Department_execute?department.id=<s:property value="#dpList.id"/>" class="btn btn-primary btn-xs ">修改</a>
						</span>
						

						<span	class="autocut auto"> 
							<i class="icon-paper-clip"	style="text-indent: -9999px;"></i> 
							
						</span>
						
					</li>
				</form>
				</s:iterator>
				
				
				
				
				<div class="pagination">
					<form id="page_search" method="post">
						<input type="hidden" name="p"><input type="hidden"
							name="list_rows" value=""> 12 条记录 1/2 页 <input
							type="button" value="下一页"
							onclick="this.form.p.value=2;this.form.submit();"> <input
							class="current" type="button" value="1"><input
							type="button" value="2"
							onclick="this.form.p.value=2;this.form.submit();"> <input
							type="button" value="全部"
							onclick="this.form.p.value=1;this.form.list_rows.value=12;this.form.submit();">
					</form>
				</div>
			</ul>
		</div>
		
		
		
		
	<script type="text/javascript">
		$(document).ready(function(){
			$("[href^='###']").click(function(){
				$(".page-content").load($(this).attr("href").replace("###","./"));
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
		
		
		