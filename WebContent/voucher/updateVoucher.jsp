<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

		<div class="page-header clearfix">
			<h1 class="col-sm-8">报销单</h1>
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

	
	
	
<form method="post" action="Apply_updateVoucherCheck" name="form_data" id="form_data">
					
		<div class="ul_table">
			<ul>
				<li class="thead">
				<div class="form-group">
				<span class="col-5"> 标题：</span>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="name" name="voucher.content" value="${voucher.content}">
					总金额：	<input class="form-control" readonly="true"  type="text" id="name" name="voucher.money" value="${voucher.money}">
				</div>				
	             </div>			
				</li>
				
				<li class="thead">			
					<span class="col-20"> 项目</span>				
					<span	class="col-20 pull-right text-center">金额</span>
					<span	class="autocut auto">内容</span>
				</li>
				
			
				<%int i=0; %>
 				<s:iterator value="voucher.voucherInfos" id="v">
					<li id="list" class="tbody normal">
						<span class="col-10 autocut"> 
							<input  type="hidden" name="VoucherInfoList[<%=i%>].voucherId.id" value="${v.voucherId.id}"/ >
							<input  type="hidden" name="VoucherInfoList[<%=i%>].id" value=" ${v.id}"/ >
							<input class="form-control"  type="text" id="name" name="VoucherInfoList[<%=i%>].item" value="${v.item}">
						</span> 
						<span class="col-15 pull-right text-center">
							<input class="form-control"  type="text" id="name" name="VoucherInfoList[<%=i%>].money" value="${v.money}" >
							
						</span>
						<span	class="autocut auto"> 
							<input class="form-control"  type="text" id="name" name="VoucherInfoList[<%=i%>].content"  value="${v.content}">
						</span>
					
					<% i=i+1;%>
				</s:iterator>
		
					
					
					<div class="operate panel panel-default">
				<div class="panel-body">
					<div class="pull-left">
						<a onclick="go_return_url();" class="btn btn-sm btn-primary">返回</a>
						<a onclick="popup_confirm();" class="btn btn-sm btn-primary">选择审批流程</a>
					</div>
					<div class="pull-right">
						<a onclick="addList();" class="btn btn-sm btn-primary">增加一行</a> 
						<input  type="hidden" name="voucher.id" value="${voucher.id}"/ >
						<input	type="submit"   class="btn btn-sm btn-primary button"  value="　　提交　　">
					</div>
				</div>
			</div>
					
				</form>
			
				
	
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
		var sum=1;
		$(document).ready(function(){
			$("[href^='###']").click(function(){
				$(".page-content").load($(this).attr("href").replace("###","./"));
			});			
		});
		function addList(){
			$("#list").before("<li id='list' class='tbody normal'><span class='col-10 autocut'><input class='form-control'  type='text' id='name' name='VoucherInfoList["+sum+"].item'></span><span class='col-15 pull-right text-center'><input class='form-control'  type='text' id='name' name='VoucherInfoList["+sum+"].money'></span><span	class='autocut auto'><input class='form-control'  type='text' id='name' name='VoucherInfoList["+sum+"].content'></span></li>");
			sum++;
		}
	</script>
		
		
		
		