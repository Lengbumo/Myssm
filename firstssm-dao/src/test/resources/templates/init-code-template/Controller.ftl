package ${ctlPackage!''};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ${entityPackage!''}.model.${baseName!''};
import ${entityPackage!''}.search.${baseName!''}Search;
import ${entityPackage!''}.service.${baseName!''}Service;
import com.my.ssm.core.basic.service.BasicService;
import com.my.ssm.core.controller.BasicController;

 /**
 * ${descr}
 *
 * @${entityPackage!''}.${modelName}.${entityName}.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time ${createTime!''}
 */
@Controller
@RequestMapping(value = "/myssm/manager/${lowerBaseName?lower_case!''}")
public class ${entityName!''} extends BasicController<${baseName!''}, ${baseName!''}Search> {

	@Autowired
	private transient ${baseName!''}Service ${lowerBaseName}Service;
	private String purl = "/${belongPackage!''}/${lowerBaseName?lower_case!''}";
	
	@Override
	protected BasicService<${baseName!''}, ${baseName!''}Search> getPagedService() {
		return ${lowerBaseName}Service;
	}
	
	@Override
	protected Class<${baseName!''}Search> getSearchBean() {
		return ${baseName!''}Search.class;
	}
	
	@Override
	protected String getReqUrl() {
		return "" + purl;
	}
	
	@Override
	protected String getInitPageName() {
		return purl + "/list";
	}
	
	@Override
	protected String getInitFormName() {
		return purl + "/form";
	}
	
	@Override
	protected String getInitViewName() {
		return purl + "/view";
	}

}