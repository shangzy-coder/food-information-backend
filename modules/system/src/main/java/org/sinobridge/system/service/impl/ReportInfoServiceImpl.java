package org.sinobridge.system.service.impl;

import org.sinobridge.common.core.utils.MapstructUtils;
import org.sinobridge.common.core.utils.StringUtils;
import org.sinobridge.common.mybatis.core.page.TableDataInfo;
import org.sinobridge.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.sinobridge.system.domain.bo.ReportInfoBo;
import org.sinobridge.system.domain.vo.ReportInfoVo;
import org.sinobridge.system.domain.ReportInfo;
import org.sinobridge.system.mapper.ReportInfoMapper;
import org.sinobridge.system.service.IReportInfoService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 研报信息Service业务层处理
 *
 * @author Zhao Yun
 * @date 2025-09-04
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ReportInfoServiceImpl implements IReportInfoService {

    private final ReportInfoMapper baseMapper;

    /**
     * 查询研报信息
     *
     * @param id 主键
     * @return 研报信息
     */
    @Override
    public ReportInfoVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询研报信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 研报信息分页列表
     */
    @Override
    public TableDataInfo<ReportInfoVo> queryPageList(ReportInfoBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<ReportInfo> lqw = buildQueryWrapper(bo);
        Page<ReportInfoVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的研报信息列表
     *
     * @param bo 查询条件
     * @return 研报信息列表
     */
    @Override
    public List<ReportInfoVo> queryList(ReportInfoBo bo) {
        LambdaQueryWrapper<ReportInfo> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<ReportInfo> buildQueryWrapper(ReportInfoBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<ReportInfo> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(ReportInfo::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getTitle()), ReportInfo::getTitle, bo.getTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getReportType()), ReportInfo::getReportType, bo.getReportType());
        lqw.eq(StringUtils.isNotBlank(bo.getVarietyType()), ReportInfo::getVarietyType, bo.getVarietyType());
        lqw.eq(StringUtils.isNotBlank(bo.getPdfUrl()), ReportInfo::getPdfUrl, bo.getPdfUrl());
        lqw.eq(StringUtils.isNotBlank(bo.getAccessLevel()), ReportInfo::getAccessLevel, bo.getAccessLevel());
        lqw.eq(bo.getPlatformId() != null, ReportInfo::getPlatformId, bo.getPlatformId());
        lqw.eq(bo.getWechatPub() != null, ReportInfo::getWechatPub, bo.getWechatPub());
        lqw.eq(bo.getPublicMedia() != null, ReportInfo::getPublicMedia, bo.getPublicMedia());
        lqw.eq(bo.getLiveSoftware() != null, ReportInfo::getLiveSoftware, bo.getLiveSoftware());
        lqw.eq(StringUtils.isNotBlank(bo.getThirdParty()), ReportInfo::getThirdParty, bo.getThirdParty());
        lqw.eq(bo.getUploaderId() != null, ReportInfo::getUploaderId, bo.getUploaderId());
        lqw.eq(bo.getDepartmentId() != null, ReportInfo::getDepartmentId, bo.getDepartmentId());
        lqw.eq(bo.getUploadTime() != null, ReportInfo::getUploadTime, bo.getUploadTime());
        lqw.eq(bo.getApproveStatus() != null, ReportInfo::getApproveStatus, bo.getApproveStatus());
        lqw.eq(bo.getPublishStatus() != null, ReportInfo::getPublishStatus, bo.getPublishStatus());
        lqw.eq(bo.getClickCount() != null, ReportInfo::getClickCount, bo.getClickCount());
        lqw.eq(bo.getCreatedTime() != null, ReportInfo::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, ReportInfo::getUpdatedTime, bo.getUpdatedTime());
        lqw.eq(StringUtils.isNotBlank(bo.getAiSummary()), ReportInfo::getAiSummary, bo.getAiSummary());
        lqw.eq(StringUtils.isNotBlank(bo.getRichContent()), ReportInfo::getRichContent, bo.getRichContent());
        lqw.eq(StringUtils.isNotBlank(bo.getConsultationNo()), ReportInfo::getConsultationNo, bo.getConsultationNo());
        return lqw;
    }

    /**
     * 新增研报信息
     *
     * @param bo 研报信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(ReportInfoBo bo) {
        ReportInfo add = MapstructUtils.convert(bo, ReportInfo.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改研报信息
     *
     * @param bo 研报信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(ReportInfoBo bo) {
        ReportInfo update = MapstructUtils.convert(bo, ReportInfo.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(ReportInfo entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除研报信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteByIds(ids) > 0;
    }
}
