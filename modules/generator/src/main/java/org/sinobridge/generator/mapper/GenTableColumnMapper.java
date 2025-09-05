package org.sinobridge.generator.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.sinobridge.common.mybatis.core.mapper.BaseMapperPlus;
import org.sinobridge.generator.domain.GenTableColumn;

/**
 * 业务字段 数据层
 *
 * @author Zhao Yun
 */
@InterceptorIgnore(dataPermission = "true", tenantLine = "true")
public interface GenTableColumnMapper extends BaseMapperPlus<GenTableColumn, GenTableColumn> {

}
