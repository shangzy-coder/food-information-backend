package org.sinobridge.system.service;

import org.sinobridge.system.domain.vo.ReportInfoVo;
import org.sinobridge.system.domain.bo.ReportInfoBo;
import org.sinobridge.common.mybatis.core.page.TableDataInfo;
import org.sinobridge.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 研报信息Service接口
 *
 * @author Zhao Yun
 * @date 2025-09-04
 */
public interface IReportInfoService {

    /**
     * 查询研报信息
     *
     * @param id 主键
     * @return 研报信息
     */
    ReportInfoVo queryById(Long id);

    /**
     * 分页查询研报信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 研报信息分页列表
     */
    TableDataInfo<ReportInfoVo> queryPageList(ReportInfoBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的研报信息列表
     *
     * @param bo 查询条件
     * @return 研报信息列表
     */
    List<ReportInfoVo> queryList(ReportInfoBo bo);

    /**
     * 新增研报信息
     *
     * @param bo 研报信息
     * @return 是否新增成功
     */
    Boolean insertByBo(ReportInfoBo bo);

    /**
     * 修改研报信息
     *
     * @param bo 研报信息
     * @return 是否修改成功
     */
    Boolean updateByBo(ReportInfoBo bo);

    /**
     * 校验并批量删除研报信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
