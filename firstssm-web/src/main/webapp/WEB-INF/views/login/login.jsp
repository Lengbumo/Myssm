<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html class="login">
<head>
    <meta charset="utf-8" />
	<title>${WEBNAME}</title>
	<meta name="renderer" content="webkit">
	<meta name="description" content="${DESCRIPTION}" />
	<meta name="keywords" content='${KEYWORDS }' />
	<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="icon" href="${CTX_PATH }/static/${WEBLOGO }">
	<link rel="stylesheet" type="text/css" href="${CTX_PATH }/static/3rd/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="${CTX_PATH }/static/loc/css/public.css" media="all">
	<link rel="stylesheet" type="text/css" href="${CTX_PATH }/static/loc/css/login.css" media="all">
	<script type="text/javascript" src="${CTX_PATH }/static/3rd/jquery/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="${CTX_PATH }/static/loc/js/my.js"></script>
	<script type="text/javascript">my.window.ctxPath = '${CTX_PATH }';</script>
</head>

<body class="loginBody">
	<form class="layui-form" id="loginForm" method="post" action="" onsubmit="return false">
		<div class="login_face"><img src="${CTX_PATH }/static/loc/images/face.png" class="userAvatar"></div>
		<div class="layui-form-item input-item">
			<label for="userName">用户名</label>
			<input type="text" placeholder="请输入用户名" autocomplete="off" id="username" name="username" class="layui-input" lay-verify="required">
		</div>
		<div class="layui-form-item input-item">
			<label for="password">密码</label>
			<input type="password" placeholder="请输入密码" autocomplete="off" id="password" name="password" class="layui-input" lay-verify="required">
		</div>
		<div class="layui-form-item input-item" id="imgCode">
			<label for="code">验证码</label>
			<input type="text" placeholder="请输入验证码" autocomplete="off" id="verifycode" name="verifycode" class="layui-input">
			<img id="Login_code_img" src="${CTX_PATH }/myssm/getRadomCode" style="cursor:pointer;" onclick="changeValidateCode()" title="点击图片刷新验证码" />
		</div>
		<div class="layui-form-item">
			<button class="layui-btn layui-block" lay-filter="login" id="loginSub" lay-submit>登录</button>
		</div>
		<div class="layui-form-item layui-row">
			<a href="javascript:;" class="seraph icon-qq layui-col-xs4 layui-col-sm4 layui-col-md4 layui-col-lg4"></a>
			<a href="javascript:;" class="seraph icon-wechat layui-col-xs4 layui-col-sm4 layui-col-md4 layui-col-lg4"></a>
			<a href="javascript:;" class="seraph icon-sina layui-col-xs4 layui-col-sm4 layui-col-md4 layui-col-lg4"></a>
		</div>
	</form>
	
	<script type="text/javascript" src="${CTX_PATH }/static/3rd/layui/layui.js"></script>
    <script type="text/javascript" src="${CTX_PATH }/static/loc/js/login/login.js"></script>
    <script type="text/javascript" src="${CTX_PATH }/static/loc/js/login/encode64.js"></script>
    <script type="text/javascript" src="${CTX_PATH }/static/loc/js/cache.js"></script>
</body>
	
</html>