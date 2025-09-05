package org.sinobridge.demo.mapper;

import org.sinobridge.common.mybatis.annotation.DataColumn;
import org.sinobridge.common.mybatis.annotation.DataPermission;
import org.sinobridge.common.mybatis.core.mapper.BaseMapperPlus;
import org.sinobridge.demo.domain.TestTree;
import org.sinobridge.demo.domain.vo.TestTreeVo;

/**
 * 测试树表Mapper接口
 *
 * @author Zhao Yun
 * @date 2021-07-26
 */
@DataPermission({
    @DataColumn(key = "deptName", value = "dept_id"),
    @DataColumn(key = "userName", value = "user_id")
})
public interface TestTreeMapper extends BaseMapperPlus<TestTree, TestTreeVo> {

}
