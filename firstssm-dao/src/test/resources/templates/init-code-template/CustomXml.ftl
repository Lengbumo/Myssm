<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${entityPackage!''}.dao.${entityName!''}">

	<!-- ExtBaseResultMap -->
	<resultMap id="ExtBaseResultMap" type="${entityPackage!''}.pojo.${baseName!''}Pojo" extends="BaseResultMap">
	    
	</resultMap>

	<!-- page -->
	<select id="page" resultMap="BaseResultMap" parameterType="${entityPackage!''}.search.${baseName!''}Search">
        <![CDATA[${r'${PAGE_HEAD}'}]]>
		select
		<include refid="Base_Column_List" />
		from ${tableName}
		<include refid="where" />
		order by ID desc
        <![CDATA[${r'${PAGE_FOOT}'}]]>
	</select>
	
	<!-- count -->
	<select id="count" resultType="java.lang.Long" parameterType="${entityPackage!''}.search.${baseName!''}Search">
		select count(*) FROM ${tableName}
		<include refid="where" />
	</select>
	
	<!-- pageExt -->
	<select id="pageExt" resultMap="ExtBaseResultMap" parameterType="${entityPackage!''}.search.${baseName!''}Search">
        <![CDATA[${r'${PAGE_HEAD}'}]]>
		select
		<include refid="Base_Column_List" />
		from ${tableName}
		<include refid="whereExt" />
		order by ID desc
        <![CDATA[${r'${PAGE_FOOT}'}]]>
	</select>
	
	<!-- countExt -->
	<select id="countExt" resultType="java.lang.Long" parameterType="${entityPackage!''}.search.${baseName!''}Search">
		select count(*) FROM ${tableName}
		<include refid="whereExt" />
	</select>
	
	<!-- list -->
	<select id="list" resultMap="BaseResultMap" parameterType="${entityPackage!''}.search.${baseName!''}Search">
		select
		<include refid="Base_Column_List" />
		from ${tableName}
		<include refid="where" />
	</select>
	
	<!-- listExt -->
	<select id="listExt" resultMap="ExtBaseResultMap" parameterType="${entityPackage!''}.search.${baseName!''}Search">
		select
		<include refid="Base_Column_List" />
		from ${tableName}
		<include refid="whereExt" />
	</select>
	
	<!-- listExport -->
	<select id="listExport" resultMap="BaseResultMap" parameterType="${entityPackage!''}.search.${baseName!''}Search">
		select
		<include refid="Base_Column_List" />
		from ${tableName} 
		<include refid="where" />
	</select>
	
	<!-- listExportExt -->
	<select id="listExportExt" resultMap="ExtBaseResultMap" parameterType="${entityPackage!''}.search.${baseName!''}Search">
		select
		<include refid="Base_Column_List" />
		from ${tableName} 
		<include refid="whereExt" />
	</select>
    
    <!-- selectExtByPrimaryKey -->
    <select id="selectExtByPrimaryKey" resultMap="ExtBaseResultMap" parameterType="java.lang.Long">
        select
        <include refid="Base_Column_List" />
        from ${tableName}
        where ID = ${r'#{id,jdbcType=BIGINT}'}
    </select>
    
	<!-- selectByBizKey -->
	<select id="selectByBizKey" resultMap="BaseResultMap" parameterType="${entityPackage!''}.search.${baseName!''}Search">
		select
		<include refid="Base_Column_List" />
		from ${tableName}
		<include refid="whereByBizKey" />
	</select>
	
	<!-- selectExtByBizKey -->
    <select id="selectExtByBizKey" resultMap="BaseResultMap" parameterType="${entityPackage!''}.search.${baseName!''}Search">
        select
        <include refid="Base_Column_List" />
        from ${tableName}
        <include refid="whereByBizKey" />
    </select>
    
	<!-- deleteByBizKey -->
	<delete id="deleteByBizKey" parameterType="${entityPackage!''}.model.${baseName!''}">
		delete from ${tableName}
		<include refid="whereByBizKey" />
	</delete>
	
	<!-- bulkDelete -->
	<delete id="bulkDelete" parameterType="java.util.List" >
        delete from ${tableName}
        <where>
	        <foreach collection="keyList" item="data" open="ID IN(" separator="," close=")">
	            ${r'${data.id}'}
	        </foreach>
        </where>
    </delete>
	
	<!-- updateByBizKey -->
    <update id="updateByBizKey" parameterType="${entityPackage!''}.model.${baseName!''}">
    	update ${tableName}
        <set>
      		<#list columns as data>
      		<#if data.name != "id" >
      		<if test="${data.name!''} != null <#if data.stringFlag == true>and ${data.name!''} != '' </#if>" >
        		${data.filedName} = ${data.mark!'#'}{${data.name!''},jdbcType=${data.jdbcType}},
      		</if>
      		</#if>
      		</#list>
		</set>
		<include refid="whereByBizKey" />
    </update>
	
	<!-- where -->
	<sql id="where">
		<where>
      		<if test="orgnId != null" >
        		AND ORGN_ID = ${r'#{orgnId,jdbcType=BIGINT}'}
      		</if>
      		<if test="orgn != null and orgn != '' ">
        		AND ORGN = ${r'#{orgn,jdbcType=VARCHAR}'}
      		</if>
		</where>
	</sql>
	
	<!-- whereExt -->
	<sql id="whereExt">
		<where>
      		<if test="orgnId != null" >
        		AND ORGN_ID = ${r'#{orgnId,jdbcType=BIGINT}'}
      		</if>
      		<if test="orgn != null and orgn != '' ">
        		AND ORGN = ${r'#{orgn,jdbcType=VARCHAR}'}
      		</if>
		</where>
	</sql>
	
	<!-- whereByBizKey -->
	<sql id="whereByBizKey">
		<where>
      		<if test="orgnId != null" >
        		AND ORGN_ID = ${r'#{orgnId,jdbcType=BIGINT}'}
      		</if>
      		<if test="orgn != null and orgn != '' ">
        		AND ORGN = ${r'#{orgn,jdbcType=VARCHAR}'}
      		</if>
		</where>
	</sql>
	
</mapper>