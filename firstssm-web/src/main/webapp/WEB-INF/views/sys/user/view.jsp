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
			<label class="layui-form-label" >用户编码</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="userCode" id="userCode" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >用户名称</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="userName" id="userName" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >用户英文名称</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="userEname" id="userEname" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >用户描述</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="userDescr" id="userDescr" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
	</div>
	
	<!-- 列 -->
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label" >员工ID</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="empId" id="empId" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >员工CODE</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="empCode" id="empCode" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >PC登录密码</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="pcPassword" id="pcPassword" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >手持登录密码</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="rfPassword" id="rfPassword" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
	</div>
	
	<!-- 列 -->
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label" >盐</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="salt" id="salt" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >用户类型</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="userType" id="userType" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >管理员标识</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="adminFlag" id="adminFlag" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >电话</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="tel" id="tel" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
	</div>
	
	<!-- 列 -->
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label" >手机</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="phone" id="phone" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >邮箱</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="emial" id="emial" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >其他信息</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="others" id="others" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >默认语言</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="defLanguage" id="defLanguage" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
	</div>
	
	<!-- 列 -->
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label" >默认部门ID</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="depId" id="depId" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >默认部门CODE</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="depCode" id="depCode" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >PC是否激活</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="afPc" id="afPc" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >APP是否激活</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="afApp" id="afApp" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
	</div>
	
	<!-- 列 -->
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label" >密码有效开始时间</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="effDate" id="effDate" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >密码有效结束时间</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="endDate" id="endDate" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >密码更新日期</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="pwdModifyDate" id="pwdModifyDate" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >密码更新周日</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="pwdCycle" id="pwdCycle" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
	</div>
	
	<!-- 列 -->
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label" >密码重置标识</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="pwdRestFlag" id="pwdRestFlag" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >最后一次登录时间</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="lastDate" id="lastDate" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >头像</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="faceImg" id="faceImg" lay-verify="required" autocomplete="off" value=""/>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" >描述</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" name="remark" id="remark" lay-verify="required" autocomplete="off" value=""/>
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
<script type="text/javascript" src="${CTX_PATH }/static/loc/js/sys/user/view.js"></script>
</body>
</html>
