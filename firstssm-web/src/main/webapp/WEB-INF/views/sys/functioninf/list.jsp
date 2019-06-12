<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="../../common/top.jsp"%>
</head>
<body class="childrenBody">
<blockquote class="layui-elem-quote quoteBox">
	<form class="layui-form" id="searchform" onsubmit="return false">
		<div class="layui-inline">
			<div class="layui-input-inline">
				<input type="text" id="searchParam" name="searchParam" placeholder="请输入搜索的内容" autocomplete="off" class="layui-input"/>
			</div>
			<a class="layui-btn search_btn" data-type="reload" id="btnSearch">查询</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-primary reSet_btn" id="btnRetSet">重置</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-normal addNews_btn" id="btnAdd">新增</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-danger layui-btn-normal" id="btnDelAll">批量删除</a>
		</div>
	</form>
</blockquote>
	
<table id="tableList" lay-filter="tableList" class="layui-hide"></table>

<!-- 列表操作开始 -->
<!--操作-->
<script type="text/html" id="toobar">
	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="update">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<!-- 模板 -->
<script type="text/html" id="testTpl">
    <span class="layui-badge  {{ d.test == 0 ? 'layui-bg-green' : '' }} ">{{d.test}}</span>
</script>
<!-- 列表操作结束 -->
<!-- 引入自定义js -->
<script type="text/javascript" src="${CTX_PATH }/static/loc/js/sys/functioninf/list.js"></script>
</body>
</html>
