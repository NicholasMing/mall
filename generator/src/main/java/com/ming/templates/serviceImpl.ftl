package ${packageName};

import ${entityPackageName}.${ClassName};
import ${mapperPackageName}.${ClassName}Mapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class ${ClassName}${classLastName} implements ${ClassName}Service{
	@Autowired
	private ${ClassName}Mapper ${ClassName?uncap_first}Mapper;

	public ${ClassName} select${ClassName}ById(Long ${PrimaryKey?uncap_first}){
		return ${ClassName?uncap_first}Mapper.select${ClassName}ById(${PrimaryKey?uncap_first});
	}

	public List<${ClassName}> select${ClassName}List(){
		return ${ClassName?uncap_first}Mapper.select${ClassName}List();
	}

	public int deleteBy${PrimaryKey}(Long ${PrimaryKey?uncap_first}){
		return ${ClassName?uncap_first}Mapper.deleteBy${PrimaryKey?cap_first}(${PrimaryKey?uncap_first});
	}

	public int save${ClassName}(${ClassName} ${ClassName?uncap_first}){
		return ${ClassName?uncap_first}Mapper.save${ClassName}(${ClassName?uncap_first});
	}

	public int update${ClassName}By${PrimaryKey}(${ClassName} ${ClassName?uncap_first}){
		return ${ClassName?uncap_first}Mapper.update${ClassName}By${PrimaryKey}(${ClassName?uncap_first});
	}

	public ${ClassName} selectByCondition(${ClassName} ${ClassName?uncap_first}){
		return ${ClassName?uncap_first}Mapper.selectByCondition(${ClassName?uncap_first});
	}
}