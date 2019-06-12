<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="../../common/top.jsp"%>
</head>
<body class="childrenBody">
<form class="layui-form layui-row layui-col-space10" id="dform" enctype="multipart/form-data" method="post" action="" onsubmit="return false">
	<input  type="hidden" name="id" id="id"  value="${r'${id }'}">
	<#assign n = 0 />
	<#assign i = 0 />
<#list columns as data>
	<#assign i = i+1 /> 
	<#if data.publicFlag != true >
	<#if n%4 == 0 >
	<#if n != 0 >
	
	</#if>
	<!-- 列 -->
	<div class="layui-form-item">
	</#if>
		<div class="layui-inline">
			<label class="layui-form-label" >${data.comment!''}</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="${data.name!''}" id="${data.name!''}" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
	<#if (n+1)%4 == 0 && (columns?size-1) != n >
	</div>
	</#if>
	<#assign n = n+1 /> 
	</#if>
	<#if (columns?size == i) >
	</div>	
	</#if>
</#list>
	
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
				<input type="text" class="layui-input" name="createdBy" id="createdBy" value="${r'${data.createdBy }'}" disabled/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >创建时间</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="createdDate" id="createdDate" value="<fmt:formatDate value="${r'${data.createdDate }'}" pattern="yyyy-MM-dd HH:mm:ss"/>" disabled/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >修改人</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="modifiedBy" id="modifiedBy" value="${r'${data.modifiedBy }'}" disabled/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >修改时间</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="modifiedDate" id="modifiedDate" value="<fmt:formatDate value="${r'${data.modifiedDate }'}" pattern="yyyy-MM-dd HH:mm:ss"/>" disabled/>
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
<script type="text/javascript" src="${r'${CTX_PATH }'}/static/loc/js/${jspPackage!''}/${lowerBaseName?lower_case!''}/form.js?v=${r'${JS_VERSION }'}"></script>
</body>
</html>
