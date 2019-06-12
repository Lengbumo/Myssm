<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="../common/top.jsp"%>
</head>

<body class="childrenBody">
	<blockquote class="layui-elem-quote layui-bg-green">
		<div id="nowTime"></div>
	</blockquote>
	<div class="layui-row layui-col-space10 panel_box">
		<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
			<a href="javascript:;" data-url="" target="_blank">
				<div class="panel_icon layui-bg-green">
					<i class="layui-anim seraph icon-good"></i>
				</div>
				<div class="panel_word">
					<span>为我点赞</span>
					<cite>点赞地址链接</cite>
				</div>
			</a>
		</div>
		<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
			<a href="javascript:;" data-url="" target="_blank">
				<div class="panel_icon layui-bg-black">
					<i class="layui-anim seraph icon-github"></i>
				</div>
				<div class="panel_word">
					<span>Github</span>
					<cite>模版下载链接</cite>
				</div>
			</a>
		</div>
		<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
			<a href="javascript:;" data-url="" target="_blank">
				<div class="panel_icon layui-bg-red">
					<i class="layui-anim seraph icon-oschina"></i>
				</div>
				<div class="panel_word">
					<span>码云</span>
					<cite>模版下载链接</cite>
				</div>
			</a>
		</div>
		<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
			<a href="javascript:;" data-url="page/user/userList.html">
				<div class="panel_icon layui-bg-orange">
					<i class="layui-anim seraph icon-icon10" data-icon="icon-icon10"></i>
				</div>
				<div class="panel_word userAll">
					<span></span>
					<em>用户总数</em>
					<cite class="layui-hide">用户中心</cite>
				</div>
			</a>
		</div>
		<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
			<a href="javascript:;" data-url="page/systemSetting/icons.html">
				<div class="panel_icon layui-bg-cyan">
					<i class="layui-anim layui-icon" data-icon="&#xe857;">&#xe857;</i>
				</div>
				<div class="panel_word outIcons">
					<span></span>
					<em>外部图标</em>
					<cite class="layui-hide">图标管理</cite>
				</div>
			</a>
		</div>
		<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
			<a href="javascript:;">
				<div class="panel_icon layui-bg-blue">
					<i class="layui-anim seraph icon-clock"></i>
				</div>
				<div class="panel_word">
					<span class="loginTime"></span>
					<cite>上次登录时间</cite>
				</div>
			</a>
		</div>
	</div>
	<blockquote class="layui-elem-quote main_btn">
		<p>本模板基于Layui2.*实现，支持除LayIM外所有的Layui组件。<a href="" target="_blank" class="layui-btn layui-btn-xs" title="myssm后台管理">layui</a>　</p>
		<p>注：本模版未引入任何第三方组件，单纯的layui+js实现的各种功能</p>
		<p class="layui-blue">PS</p>
	</blockquote>
	<div class="layui-row layui-col-space10">
		<div class="layui-col-lg6 layui-col-md12">
			<blockquote class="layui-elem-quote title">系统基本参数</blockquote>
			<table class="layui-table magt0">
				<colgroup>
					<col width="150">
					<col>
				</colgroup>
				<tbody>
				<tr>
					<td>当前版本</td>
					<td class="version"></td>
				</tr>
				<tr>
					<td>开发作者</td>
					<td class="author"></td>
				</tr>
				<tr>
					<td>网站首页</td>
					<td class="homePage"></td>
				</tr>
				<tr>
					<td>服务器环境</td>
					<td class="server"></td>
				</tr>
				<tr>
					<td>数据库版本</td>
					<td class="dataBase"></td>
				</tr>
				<tr>
					<td>最大上传限制</td>
					<td class="maxUpload"></td>
				</tr>
				<tr>
					<td>当前用户权限</td>
					<td class="userRights"></td>
				</tr>
				</tbody>
			</table>
			<blockquote class="layui-elem-quote title">最新文章 <i class="layui-icon layui-red">&#xe756;</i></blockquote>
			<table class="layui-table mag0" lay-skin="line">
				<colgroup>
					<col>
					<col width="110">
				</colgroup>
				<tbody class="hot_news"></tbody>
			</table>
		</div>
		<div class="layui-col-lg6 layui-col-md12">
			<blockquote class="layui-elem-quote title">发展历程&更新日志</blockquote>
			<div class="layui-elem-quote layui-quote-nm history_box magb0">
				<ul class="layui-timeline">
					<li class="layui-timeline-item">
						<i class="layui-icon layui-timeline-axis">&#xe63f;</i>
						<div class="layui-timeline-content layui-text">
							<div class="layui-timeline-title">
								<h3 class="layui-inline">layuiCMS V1.0正式与大家见面，提供了一些简单功能　</h3>
								<span class="layui-badge-rim">2017-06-21</span>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="${CTX_PATH }/static/loc/js/main.js"></script>
</body>
	
</html>