package ${entityPackage!''}.${modelName};

<#if dateFlag == true>import java.util.Date;</#if>
import com.my.ssm.core.basic.model.BasicModel;
<#if bigDecimalFlag == true>import java.math.BigDecimal;</#if>

/**
 * ${descr}
 *
 * @${entityPackage!''}.${modelName}.${entityName}.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time ${createTime!''}
 */
public class ${entityName!''} extends BasicModel {

	private static final long serialVersionUID = 1L;

<#list columns as data>
<#if data.publicFlag != true >
    // ${data.comment}
	private ${data.type!''} ${data.name!''};
	
</#if>
</#list>

	
<#list columns as data>
<#if data.publicFlag != true >
	/**
     * 设置${data.comment!''} 
     *
     * @param :${data.comment!''}
     *
     * @author system
     * @remark 方法初始化
     * @create time ${createTime!''}
     */
	public void set${data.methodName!''}(${data.type!''} ${data.name!''}) {
		this.${data.name!''} = ${data.name!''}<#if data.type == "String"> == null ? null : ${data.name}.trim()</#if>;
	}
	
	/**
     * 获取${data.comment!''} 
     *
     * @author system
     * @remark 方法初始化
     * @create time ${createTime!''}
     */
	public ${data.type!''} get${data.methodName!''}() {
		return ${data.name!''};
	}
			
</#if>
</#list>
}