<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${packageName}.${ClassName}${classLastName}" >
    <resultMap id="BaseResultMap" type="${entityPackageName}.${ClassName}" >
<#list columnList as list>
    <#if primaryKey==list.nativeColumnName>
    <id column="${list.nativeColumnName}" property="${list.columnName}" jdbcType="${list.jdbcType!}"/>
    <#else>
    <result column="${list.nativeColumnName}" property="${list.columnName}" jdbcType="${list.jdbcType!}"/>
</#if>
</#list>
    </resultMap>
    <sql id="Base_Column_List" >
            <#list columnList as list>
                <#if list_has_next>${list.nativeColumnName},<#else>${list.nativeColumnName}</#if>
            </#list>
    </sql>
    <select id="select${ClassName}ById" resultMap="BaseResultMap" parameterType="java.lang.Long" >
        select
        <include refid="Base_Column_List" />
        from ${tableName}
        where ${primaryKey}=${"#"}{${PrimaryKey?uncap_first},jdbcType=INTEGER}
    </select>

    <select id="select${ClassName}List" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from ${tableName}
    </select>

    <delete id="deleteBy${PrimaryKey}" parameterType="java.lang.Long">
        delete from ${tableName}
        where ${primaryKey} =${"#"}{${PrimaryKey?uncap_first},jdbcType=INTEGER}
    </delete>

    <insert id="save${ClassName}" parameterType="${entityPackageName}.${ClassName}">

        insert into ${tableName}
        <trim prefix="(" suffix=")" suffixOverrides="," >
            <#list columnList as list>
            <if test="${list.columnName} != null" >
               ${list.nativeColumnName},
            </if>
            </#list>
        </trim>
        values
        <trim prefix="(" suffix=")" suffixOverrides="," >
    <#list columnList as list>
    <if test="${list.columnName} != null" >
        ${"#"}{${list.columnName},jdbcType=${list.jdbcType!}},
    </if>
        </#list>
        </trim>
    </insert>

    <update id="update${ClassName}By${PrimaryKey}" parameterType="${entityPackageName}.${ClassName}" >
        update ${tableName}
        <set >
        <#list columnList as list>
            <#if primaryKey!=list.nativeColumnName>
        <if test="${list.columnName} != null" >
         ${list.nativeColumnName} = ${"#"}{${list.columnName},jdbcType=${list.jdbcType!}},
        </if>
            </#if>
        </#list>
        </set>
        where ${primaryKey} =${"#"}{${PrimaryKey?uncap_first},jdbcType=INTEGER}
    </update>

    <select id="selectByCondition" parameterType="${entityPackageName}.${ClassName}" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from ${tableName}
        <where>
            <trim prefix="(" suffix=")" suffixOverrides="," >
            <#list columnList as list>
                <if test="${list.columnName} != null" >
                ${list.nativeColumnName} = ${"#"}{${list.columnName},jdbcType=${list.jdbcType!}},
                </if>
            </#list>
            </trim>
        </where>
    </select>
</mapper>