<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->

		<div class="page-header clearfix">
			<h1 class="col-sm-8">审批</h1>
			<div class="col-sm-4 pull-right search_box">
				<form name="form_search" id="form_search" method="post">
					<div class="input-group">
						<input class="form-control" type="text" name="keyword"	 id="keyword">
						<div class="input-group-btn">
							<a class="btn btn-sm btn-info" ><i
								class="icon-search"></i></a> <a class="btn btn-sm btn-success"
								onclick="toggle_adv_search();"><i
								id="toggle_adv_search_icon" class="icon-chevron-down bigger-125"></i></a>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div class="ul_table">
			<ul>
				<li class="thead">
					<span class="col-10"> 状态</span>
					<span class="col-15"> 申请人</span>
					<span class="col-10"> 类型</span>
					<span class="col-15 pull-right text-center">	操作</span>   
					<span	class="col-20 pull-right text-center">时间</span>
					<span	class="autocut auto">内容</span>
				</li>
				
				<s:iterator value="#request.voucherList" id="list">
					<s:if test=" #list.createUserId.departmentId.id == #session.User.departmentId.id   || #session.UserPosition.id==3 ">
					<li class="tbody normal">
						<span class="col-10 autocut"> 
							<s:property value="#list.state"/>
						</span> 
						<span class="col-15 autocut"> 
							<a email="<s:property value="#list.createUserId.email"/>" title="<s:property value="#list.createUserId.id"/>"><s:property value="#list.createUserId.name"/></a>
						</span> 
						<span class="col-10"> 
							报销单
						</span>
						<span class="col-15 pull-right text-center">
							<a href="###Apply_deleteVoucher?voucher.id=<s:property value="#list.id"/>" class="btn btn-primary btn-xs " <s:if test="#list.state!='未处理'">disabled="disabled"</s:if>>撤销申请</a>
							<a href="###Apply_updateVoucher?voucher.id=<s:property value="#list.id"/>" class="btn btn-primary btn-xs " <s:if test="#list.state!='未处理'">disabled="disabled"</s:if>>修改</a>
							
						</span>
						
						<span class="col-20 pull-right text-center" >20<s:property value="#list.createTime"/></span>

						<span	class="autocut auto"> 
							<i class="icon-paper-clip"	style="text-indent: -9999px;"></i> 
							<a title="<s:property value="#list.content"/>" 	href="###/Apply_checkvoucher?voucher.id=<s:property value="#list.id"/>">
							 	<s:if test="%{#list.content.length()>11}">
                                   <s:property value="%{#list.content.substring(0, 10)}"/>&nbsp;&nbsp;&nbsp;</a>
                            </s:if>
                            <s:else>
                                  <s:property value="#list.content"/>&nbsp;&nbsp;&nbsp;</a>
                             </s:else>
						</span>
						
				</li>
				</s:if>
			</s:iterator>

				<s:iterator value="#request.applyList" id="list">
				<s:if test=" #list.createUserId.departmentId.id == #session.User.departmentId.id   || #session.UserPosition.id==3 ">
					<li class="tbody normal">
						<span class="col-10 autocut"> 
							<s:property value="#list.state"/>
						</span> 
						<span class="col-15 autocut"> 
							<a email="<s:property value="#list.createUserId.email"/>" title="<s:property value="#list.createUserId.id"/>"><s:property value="#list.createUserId.name"/></a>
						</span> 
						<span class="col-10"> 
							申请单
						</span>
						<span class="col-15 pull-right text-center">
							<a href="###Apply_delete?apply.id=<s:property value="#list.id"/>" class="btn btn-primary btn-xs " <s:if test="#list.state!='未处理'">disabled="disabled"</s:if>>撤销申请</a>
							<a href="###Apply_updateapp?apply.id=<s:property value="#list.id"/>" class="btn btn-primary btn-xs " <s:if test="#list.state!='未处理'">disabled="disabled"</s:if>>修改</a>
							
						</span>
						
						<span class="col-20 pull-right text-center" >20<s:property value="#list.createTime"/></span>

						<span	class="autocut auto"> 
							<i class="icon-paper-clip"	style="text-indent: -9999px;"></i> 
							<a title="<s:property value="#list.content"/>" 	href="###/Apply_check?apply.id=<s:property value="#list.id"/>">
							 	<s:if test="%{#list.content.length()>11}">
                                   <s:property value="%{#list.content.substring(0, 10)}"/>&nbsp;&nbsp;&nbsp;</a>
                            </s:if>
                            <s:else>
                                  <s:property value="#list.content"/>&nbsp;&nbsp;&nbsp;</a>
                             </s:else>
						</span>
						
					</li>
				</s:if>
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
		
		