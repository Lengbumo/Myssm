<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="../common/top.jsp"%>
    <script type="text/javascript">
    $(function() {
    	$('#goBack').click(function() {
    		$.closeLayer();
    	});
    });
    </script>
</head>
<body class="gray-bg">
    <div class="middle-box text-center animated fadeInDown">
        <h1>ERROR</h1>
        <h3 class="font-bold">请求异常 —— <a id="goBack" href="javascript:history.go(-1);">返回</a></h3>
        <div class="error-desc">您向服务器发送的请求出现了异常，请联系管理员。</div>
        <div class="error-desc">${exception }</div>
    </div>
</body>
</html>