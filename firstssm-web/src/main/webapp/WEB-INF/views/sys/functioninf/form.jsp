<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="../../common/top.jsp"%>
</head>
<body class="childrenBody">
<form class="layui-form layui-row layui-col-space10" id="dform" enctype="multipart/form-data" method="post" action="" onsubmit="return false">
	<input  type="hidden" name="id" id="id"  value="${id }">
	<!-- 列 -->
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label" >功能编码</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="functionCode" id="functionCode" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >功能名称</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="functionName" id="functionName" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >功能地址</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="functionUrl" id="functionUrl" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >排序</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="functionSort" id="functionSort" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
	</div>
	
	<!-- 列 -->
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label" >功能图标</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="functionIcon" id="functionIcon" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >所属菜单ID</label>
			<div class="layui-input-block">
				<select name="menuId" id="menuId" lay-search lay-filter="menuSelect" lay-verify="required">
				</select>
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
		   	<button class="layui-btn" lay-submit="" lay-filter="btnSubmit" >立即提交</button>
		   	<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    <button class="layui-btn layui-btn-danger" id="close">关闭</button>
		</div>
	</div>
</form>

<!-- 引入自定义js -->
<script type="text/javascript" src="${CTX_PATH }/static/loc/js/sys/functioninf/form.js"></script>
</body>
</html>
