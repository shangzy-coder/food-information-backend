package org.sinobridge.system.controller.system;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.sinobridge.common.idempotent.annotation.RepeatSubmit;
import org.sinobridge.common.log.annotation.Log;
import org.sinobridge.common.web.core.BaseController;
import org.sinobridge.common.mybatis.core.page.PageQuery;
import org.sinobridge.common.core.domain.R;
import org.sinobridge.common.core.validate.AddGroup;
import org.sinobridge.common.core.validate.EditGroup;
import org.sinobridge.common.log.enums.BusinessType;
import org.sinobridge.common.excel.utils.ExcelUtil;
import org.sinobridge.system.domain.vo.ReportInfoVo;
import org.sinobridge.system.domain.bo.ReportInfoBo;
import org.sinobridge.system.service.IReportInfoService;
import org.sinobridge.common.mybatis.core.page.TableDataInfo;

/**
 * 研报信息
 *
 * @author Zhao Yun
 * @date 2025-09-04
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/info")
public class ReportInfoController extends BaseController {

    private final IReportInfoService reportInfoService;

    /**
     * 查询研报信息列表
     */
    @SaCheckPermission("system:info:list")
    @GetMapping("/list")
    public TableDataInfo<ReportInfoVo> list(ReportInfoBo bo, PageQuery pageQuery) {
        return reportInfoService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出研报信息列表
     */
    @SaCheckPermission("system:info:export")
    @Log(title = "研报信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(ReportInfoBo bo, HttpServletResponse response) {
        List<ReportInfoVo> list = reportInfoService.queryList(bo);
        ExcelUtil.exportExcel(list, "研报信息", ReportInfoVo.class, response);
    }

    /**
     * 获取研报信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:info:query")
    @GetMapping("/{id}")
    public R<ReportInfoVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(reportInfoService.queryById(id));
    }

    /**
     * 新增研报信息
     */
    @SaCheckPermission("system:info:add")
    @Log(title = "研报信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody ReportInfoBo bo) {
        return toAjax(reportInfoService.insertByBo(bo));
    }

    /**
     * 修改研报信息
     */
    @SaCheckPermission("system:info:edit")
    @Log(title = "研报信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody ReportInfoBo bo) {
        return toAjax(reportInfoService.updateByBo(bo));
    }

    /**
     * 删除研报信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:info:remove")
    @Log(title = "研报信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(reportInfoService.deleteWithValidByIds(List.of(ids), true));
    }
}
