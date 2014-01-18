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
			<h1>员工管理</h1>
		</div>

		<form method="post" id="form_data" name="form_data"	 action="Employee_add"  	class="well form-horizontal">
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
				<label class="col-sm-2 control-label" for="name">状   态：</label>
				<div class="col-sm-3">
					<select name="user.state" class="form-control">
						<option value="正常" <s:if test="user.state=='正常'">selected</s:if>>正常</option>
						<option value="冻结" <s:if test="user.state=='冻结'">selected</s:if> >冻结</option>
				    </select>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="name">员工email：</label>
				<div class="col-sm-3">
					<input class="form-control"  type="text" id="email" name="user.email" value="${user.email}">	
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="name">员工姓名：</label>
				<div class="col-sm-3">
					<input class="form-control" type="text" id="name" name="user.name" value="${user.name}">	
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="name">登陆密码：</label>
				<div class="col-sm-3">
					<input class="form-control"  type="password" id="password" name="user.password" value="${user.password}">
				</div>
<%-- 				<s:if test="user.password!=''">
					<div class="col-sm-3">
						（留空则为不修改）
					</div>
				</s:if> --%>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="name">电话号码：</label>
				<div class="col-sm-3">
					<input class="form-control"  type="text" id="phone" name="user.phone" value="${user.phone}">	
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="name">所属部 门：</label>
				<div class="col-sm-3">
					<select name="user.departmentId.id" class="form-control">
						<s:if test="#session.UserPosition.id ==3 ">
							<s:iterator value="#request.departmentList" id="department">
						    <option value="<s:property value="#department.id"/>" <s:if test="user.departmentId.id==#department.id">selected</s:if>><s:property value="#department.name"/></option>
						  	</s:iterator>
						</s:if><s:else>
							<option value="<s:property value="#session.User.departmentId.id"/>" ><s:property value="#session.User.departmentId.name"/></option>
						</s:else>
				   	</select>
					
				</div>
			</div>
          <div class="form-group">
					<label class="col-sm-2  control-label" for="password">身　份：</label>
					<div class="col-sm-3">
						<select name="position.id" class="form-control">
							<s:if test="#session.UserPosition.id==3">
							<option value="0">请选择身份</option>
							<s:iterator value="#request.positionList" id="position">
						    	<option value="<s:property value="#position.id"/>"><s:property value="#position.name"/></option>
						    </s:iterator>
						    </s:if><s:else>
						    	<option value="0">普通员工</option>
						    </s:else>
				        </select>
					</div>
				</div>
			

			<div class="operate panel panel-default">
				<div class="panel-body">
					<div class="pull-left">
						<a onclick="Main_main" class="btn btn-sm btn-primary">返回首页</a>
					</div>
					<div class="pull-right">
						<a onclick="save(10);" class="btn btn-sm btn-primary">临时保存</a> 
						<input type="hidden"  value="${user.id}" name="user.id"/> 
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