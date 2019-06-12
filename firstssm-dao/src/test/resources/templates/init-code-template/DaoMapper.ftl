package ${entityPackage!''}.${modelName};

import ${entityPackage!''}.model.${baseName!''};
import ${entityPackage!''}.search.${baseName!''}Search;
import com.my.ssm.core.basic.dao.BasicMapper;

 /**
 * ${descr}
 *
 * @${entityPackage!''}.${modelName}.${entityName}.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time ${createTime!''}
 */
public interface ${entityName!''} extends BasicMapper<${baseName!''}, ${baseName!''}Search> {

}