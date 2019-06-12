<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="../../common/top.jsp"%>
</head>
<body class="childrenBody">
<form class="layui-form layui-row layui-col-space10" id="dform" enctype="multipart/form-data" method="post" action="" onsubmit="return false">
	<!-- 列 -->
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label" >所属模块</label>
			<div class="layui-input-block">
				<input  type="hidden" name="id" id="id" >
				<input  type="hidden" name="moduleCode" id="moduleCode" >
				<select name="moduleId" id="moduleId" lay-search lay-filter="moduleSelect" lay-verify="required">
					<option value="">请选择</option>
					<option value="1000">sys</option>
					<option value="2000">base</option>
				</select>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >菜单名称</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="menuName" id="menuName" autocomplete="off"/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >菜单编码</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="menuCode" id="menuCode" autocomplete="off"/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >菜单图标</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="menuIcon" id="menuIcon" autocomplete="off"/>
			</div>
		</div>
	</div>
	
	<!-- 列 -->
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label" >上级菜单</label>
			<div class="layui-input-block">
				<select name="parentId" id="parentId" lay-search lay-filter="menuSelect">
				</select>
				<!-- <input type="text" class="layui-input" name="parentId" id="parentId" autocomplete="off"/> -->
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >菜单排序</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="menuSort" id="menuSort" lay-verify="required|number" autocomplete="off"/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >菜单URL</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="menuUrl" id="menuUrl" style="width:450px" autocomplete="off"/>
			</div>
		</div>
	</div>
	
	<!-- 列 -->
  	<div class="layui-form-item">
	    <label class="layui-form-label">备注</label>
	    <div class="layui-input-block">
	      <input type="text" class="layui-input" name="remark" id="remark" placeholder="请输入" autocomplete="off" />
	    </div>
  	</div>
	
	<!-- 列 -->
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label" >创建人</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="createdBy" id="createdBy" value="${data.createdBy }" disabled/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >创建时间</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="createdDate" id="createdDate" value="<fmt:formatDate value="${data.createdDate }" pattern="yyyy-MM-dd HH:mm:ss"/>" disabled/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >修改人</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="modifiedBy" id="modifiedBy" value="${data.modifiedBy }" disabled/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >修改时间</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="modifiedDate" id="modifiedDate" value="<fmt:formatDate value="${data.modifiedDate }" pattern="yyyy-MM-dd HH:mm:ss"/>" disabled/>
			</div>
		</div>
	</div>
	
	<!-- 按钮组 -->
	<div class="layui-form-item">
		<div class="layui-input-block">
		    <button class="layui-btn layui-btn-danger" id="close">关闭</button>
		</div>
	</div>
</form>

<!-- 引入自定义js -->
<script type="text/javascript" src="${CTX_PATH }/static/loc/js/sys/menu/view.js"></script>
</body>
</html>
