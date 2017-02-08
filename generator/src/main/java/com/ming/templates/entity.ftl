package ${packageName};
<#list columnList as list>
    <#if list.dataType=='timestamp' >
import java.util.Date;
    </#if>
</#list>

public class ${ClassName} {
    <#list columnList as list>
    private <#if list.dataType=='int' >Integer <#elseif list.dataType='timestamp'>Date <#else>String </#if>${list.columnName};//${list.comment}
    </#list>

    <#list columnList as list>
    public <#if list.dataType=='int' >Integer <#elseif list.dataType='timestamp'>Date <#else>String </#if> get${list.columnName?cap_first}() {
    return ${list.columnName};
    }

    public void set${list.columnName?cap_first}(<#if list.dataType=='int' >Integer <#elseif list.dataType='timestamp'>Date <#else>String </#if> ${list.columnName}) {
    this.${list.columnName} = ${list.columnName};
    }

</#list>
}
