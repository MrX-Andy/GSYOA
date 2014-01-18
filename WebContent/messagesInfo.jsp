<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="#session.SystemInfo.name" />,提示！</title>
<s:if test="message.time!=0"><meta http-equiv="refresh" content="${message.time};url=${message.http}"></s:if>
<script type="text/javascript" src="public/js/jquery.js"></script>
</head>
<script type="text/javascript">
        var leftSeconds = ${message.time};
        var timeIntervalId;
        $(function() {
            timeIntervalId=setInterval("CountDown()", 1000);
        });
        function CountDown() {
            leftSeconds--;
            $("#timeout").html(leftSeconds);
        }
    </script>
<body>
		<h2>${message.msg}</h2>
		<s:if test="message.time!=0">系统在 <span id="timeout">${message.time}</span> 秒后 将自动跳转到 <a href="${message.http}">${message.httpTitle}</a></s:if>
		<%-- <s:debug></s:debug> --%>
</body>
</html>