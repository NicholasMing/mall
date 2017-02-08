package ${packageName};

import ${entityPackageName}.${ClassName};

import java.util.List;

public interface ${ClassName}${classLastName} {
    ${ClassName} select${ClassName}ById(int ${PrimaryKey?uncap_first});

    List<${ClassName}> select${ClassName}List();

    int deleteBy${PrimaryKey}(int ${PrimaryKey?uncap_first});

    int save${ClassName}(${ClassName} ${ClassName?uncap_first});

    int update${ClassName}By${PrimaryKey}(${ClassName} ${ClassName?uncap_first});

    ${ClassName} selectByCondition(${ClassName} ${ClassName?uncap_first});
}