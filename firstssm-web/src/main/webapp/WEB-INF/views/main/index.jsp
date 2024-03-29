<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8" />
	<title>${WEBNAME}</title>
	<meta name="renderer" content="webkit">
	<meta name="description" content="${DESCRIPTION}" />
	<meta name="keywords" content='${KEYWORDS }' />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="icon" href="${CTX_PATH }/static/${WEBLOGO }">
	<link rel="stylesheet" type="text/css" href="${CTX_PATH }/static/3rd/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="${CTX_PATH }/static/3rd/font-awesome/css/font-awesome.min.css" media="all"/>
	<link rel="stylesheet" href="${CTX_PATH }/static/loc/css/index.css" media="all" />
	<script type="text/javascript" src="${CTX_PATH }/static/3rd/jquery/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="${CTX_PATH }/static/loc/js/my.js"></script>
	<script type="text/javascript">my.window.ctxPath = '${CTX_PATH }';</script>

	<style type="text/css">
		.layui-form-select dl dd.layui-this {
			background-color: #393d49;
			color: #fff;
		}
		.component .layui-input {
			color: white;
		}
	</style>
</head>

<body class="main_body">
	<div class="layui-layout layui-layout-admin">
		<!-- 顶部 -->
		<div class="layui-header header">
			<div class="layui-main mag0">
				<a href="#" class="logo">MYSSM</a>
				<!-- 显示/隐藏菜单 -->
				<a href="javascript:;" class="seraph hideMenu icon-caidan"></a>
				<!-- 顶级菜单 -->
				<ul class="layui-nav mobileTopLevelMenus" mobile>
					<li class="layui-nav-item" data-menu="contentManagement">
						<a href="javascript:;"><i class="seraph icon-caidan"></i><cite>myssm</cite></a>
						<dl class="layui-nav-child">
							<dd class="layui-this" data-menu="sys"><a href="javascript:;"><i class="layui-icon" data-icon="&#xe620;">&#xe620;</i><cite>系统管理</cite></a></dd>
							<dd data-menu="base"><a href="javascript:;"><i class="layui-icon">&#xe60a;</i><cite>业务管理</cite></a></dd>
							<%-- <dd data-menu="systemeSttings"><a href="javascript:;"><i class="layui-icon" data-icon="&#xe620;">&#xe620;</i><cite>系统设置</cite></a></dd>
							<dd data-menu="seraphApi"><a href="javascript:;"><i class="layui-icon" data-icon="&#xe705;">&#xe705;</i><cite>使用文档</cite></a></dd> --%>
						</dl>
					</li>
				</ul>
				<ul class="layui-nav topLevelMenus" pc>
					<li class="layui-nav-item layui-this" data-menu="sys">
						<a href="javascript:;"><i class="layui-icon" data-icon="&#xe620;">&#xe620;</i><cite>系统管理</cite></a>
					</li>
					<li class="layui-nav-item" data-menu="base" pc>
						<a href="javascript:;"><i class="layui-icon">&#xe60a;</i><cite>业务管理</cite></a>
					</li>
					<%-- <li class="layui-nav-item" data-menu="systemeSttings" pc>
						<a href="javascript:;"><i class="layui-icon" data-icon="&#xe620;">&#xe620;</i><cite>系统设置</cite></a>
					</li>
					<li class="layui-nav-item" data-menu="seraphApi" pc>
						<a href="javascript:;"><i class="layui-icon" data-icon="&#xe705;">&#xe705;</i><cite>使用文档</cite></a>
					</li> --%>
					<li class="layui-nav-item" pc style="cursor: pointer">
						<div id="tp-weather-widget" style="margin-top: -5px;"></div>
							<script>(function(T,h,i,n,k,P,a,g,e){g=function(){P=h.createElement(i);a=h.getElementsByTagName(i)[0];P.src=k;P.charset="utf-8";P.async=1;a.parentNode.insertBefore(P,a)};T["ThinkPageWeatherWidgetObject"]=n;T[n]||(T[n]=function(){(T[n].q=T[n].q||[]).push(arguments)});T[n].l=+new Date();if(T.attachEvent){T.attachEvent("onload",g)}else{T.addEventListener("load",g,false)}}(window,document,"script","tpwidget","//widget.seniverse.com/widget/chameleon.js"))</script>
							<script>tpwidget("init", {
							    "flavor": "slim",
							    "location": "WX4FBXXFKE4F",
							    "geolocation": "enabled",
							    "language": "zh-chs",
							    "unit": "c",
							    "theme": "chameleon",
							    "container": "tp-weather-widget",
							    "bubble": "disabled",
							    "alarmType": "badge",
							    "color": "#FFFFFF",
							    "uid": "U9EC08A15F",
							    "hash": "039da28f5581f4bcb5c799fb4cdfb673",
							});
							tpwidget("show");</script>
					</li>
				</ul>
				
			    <!-- 顶部右侧菜单 -->
			    <ul class="layui-nav top_menu">
					<li class="layui-nav-item">
						<div class="layui-form component" style="width: 82px">
							<select id="chglang" lay-filter="chgLangSelect" >
								<option value="ch">中文</option>
								<option value="en">english</option>
							</select>
						</div>
					</li>
					<li class="layui-nav-item" pc>
						<a href="javascript:;" class="clearCache"><i class="layui-icon" data-icon="&#xe640;">&#xe640;</i><cite>清除缓存</cite></a>
					</li>
					<%-- <li class="layui-nav-item lockcms" pc>
						<a href="javascript:;"><i class="seraph icon-lock"></i><cite>锁屏</cite></a>
					</li> --%>
					<li class="layui-nav-item" id="userInfo">
						<a href="javascript:;"><img src="${CTX_PATH }/static/loc/images/face.png" class="layui-nav-img userAvatar" width="35" height="35"><cite class="adminName">admin</cite></a>
						<dl class="layui-nav-child">
							<dd><a href="javascript:;" data-url=""><i class="seraph icon-ziliao" data-icon="icon-ziliao"></i><cite>个人资料</cite></a></dd>
							<dd><a href="javascript:;" data-url=""><i class="seraph icon-xiugai" data-icon="icon-xiugai"></i><cite>修改密码</cite></a></dd>
							<%-- <dd><a href="javascript:;" class="showNotice"><i class="layui-icon">&#xe645;</i><cite>系统公告</cite><span class="layui-badge-dot"></span></a></dd> --%>
							<dd pc><a href="javascript:;" class="functionSetting"><i class="layui-icon">&#xe620;</i><cite>功能设定</cite><span class="layui-badge-dot"></span></a></dd>
							<dd pc><a href="javascript:;" class="changeSkin"><i class="layui-icon">&#xe61b;</i><cite>更换皮肤</cite></a></dd>
							<dd><a href="${CTX_PATH }/myssm/logout" class="signOut"><i class="seraph icon-tuichu"></i><cite>退出</cite></a></dd>
						</dl>
					</li>
				</ul>
			</div>
		</div>
		<!-- 左侧导航 -->
		<div class="layui-side layui-bg-black">
			<div class="user-photo">
				<a class="img" title="我的头像" ><img src="${CTX_PATH }/static/loc/images/face.png" class="userAvatar"></a>
				<p>你好！<span class="userName">admin</span>, 欢迎登录</p>
			</div>
			<!-- 搜索 -->
			<div class="layui-form component">
				<select name="search" id="search" lay-search lay-filter="searchPage">
					<option value="">搜索页面或功能</option>
					<option value="1">layer</option>
					<option value="2">form</option>
				</select>
				<i class="layui-icon">&#xe615;</i>
			</div>
			<div class="navBar layui-side-scroll" id="navBar">
				<ul class="layui-nav layui-nav-tree">
					<li class="layui-nav-item layui-this">
						<a href="javascript:;" data-url="page/main.html"><i class="layui-icon" data-icon=""></i><cite>后台首页</cite></a>
					</li>
				</ul>
			</div>
		</div>
		<!-- 右侧内容 -->
		<div class="layui-body layui-form">
			<div class="layui-tab mag0" lay-filter="bodyTab" id="top_tabs_box">
				<ul class="layui-tab-title top_tab" id="top_tabs">
					<li class="layui-this" lay-id=""><i class="layui-icon">&#xe68e;</i> <cite>后台首页</cite></li>
				</ul>
				<ul class="layui-nav closeBox">
				  <li class="layui-nav-item">
				    <a href="javascript:;"><i class="layui-icon caozuo">&#xe643;</i> 页面操作</a>
				    <dl class="layui-nav-child">
					  <dd><a href="javascript:;" class="refresh refreshThis"><i class="layui-icon">&#x1002;</i> 刷新当前</a></dd>
				      <dd><a href="javascript:;" class="closePageOther"><i class="seraph icon-prohibit"></i> 关闭其他</a></dd>
				      <dd><a href="javascript:;" class="closePageAll"><i class="seraph icon-guanbi"></i> 关闭全部</a></dd>
				    </dl>
				  </li>
				</ul>
				<div class="layui-tab-content clildFrame">
					<div class="layui-tab-item layui-show">
						<iframe src="${CTX_PATH }/myssm/manager/main"></iframe>
					</div>
				</div>
			</div>
		</div>
		<!-- 底部 -->
		<div class="layui-footer footer">
			<p>
				<span>copyright @2019 WJ</span>　　<a onclick="" class="layui-btn layui-btn-danger layui-btn-sm">测试</a>
			</p>
		</div>
	</div>

	<!-- 移动导航 -->
	<div class="site-tree-mobile"><i class="layui-icon">&#xe602;</i></div>
	<div class="site-mobile-shade"></div>
	
	<script type="text/javascript" src="${CTX_PATH }/static/3rd/layui/layui.js"></script>
    <script type="text/javascript" src="${CTX_PATH }/static/loc/js/index.js"></script>
	<script type="text/javascript" src="${CTX_PATH }/static/loc/js/mycookie.js"></script>
    <script type="text/javascript" src="${CTX_PATH }/static/loc/js/cache.js"></script>
	<script type="text/javascript" src="${CTX_PATH }/static/loc/js/main/index.js"></script>
</body>
	
</html>