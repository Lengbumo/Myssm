package ${entityPackage!''}.${modelName};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${entityPackage!''}.model.${baseName!''};
import ${entityPackage!''}.search.${baseName!''}Search;
import ${entityPackage!''}.dao.${baseName!''}Mapper;
import ${entityPackage!''}.service.${baseName!''}Service;
import com.my.ssm.core.basic.dao.BasicMapper;
import com.my.ssm.core.basic.service.impl.BasicServiceImpl;

 /**
 * ${descr}
 *
 * @${entityPackage!''}.${modelName}.${entityName}.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time ${createTime!''}
 */
@Service
public class ${entityName!''} extends BasicServiceImpl<${baseName!''}, ${baseName!''}Search> implements ${baseName!''}Service {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ${baseName!''}Mapper ${lowerBaseName}Mapper;
	
	@Override
    protected BasicMapper<${baseName!''}, ${baseName!''}Search> getBasicMapper() {
        return ${lowerBaseName}Mapper;
    }

}