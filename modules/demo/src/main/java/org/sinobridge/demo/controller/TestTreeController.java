package org.sinobridge.demo.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import org.sinobridge.common.core.domain.R;
import org.sinobridge.common.core.validate.AddGroup;
import org.sinobridge.common.core.validate.EditGroup;
import org.sinobridge.common.core.validate.QueryGroup;
import org.sinobridge.common.web.core.BaseController;
import org.sinobridge.common.excel.utils.ExcelUtil;
import org.sinobridge.common.idempotent.annotation.RepeatSubmit;
import org.sinobridge.common.log.annotation.Log;
import org.sinobridge.common.log.enums.BusinessType;
import org.sinobridge.demo.domain.bo.TestTreeBo;
import org.sinobridge.demo.domain.vo.TestTreeVo;
import org.sinobridge.demo.service.ITestTreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

/**
 * 测试树表Controller
 *
 * @author Zhao Yun
 * @date 2021-07-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/demo/tree")
public class TestTreeController extends BaseController {

    private final ITestTreeService testTreeService;

    /**
     * 查询测试树表列表
     */
    @SaCheckPermission("demo:tree:list")
    @GetMapping("/list")
    public R<List<TestTreeVo>> list(@Validated(QueryGroup.class) TestTreeBo bo) {
        List<TestTreeVo> list = testTreeService.queryList(bo);
        return R.ok(list);
    }

    /**
     * 导出测试树表列表
     */
    @SaCheckPermission("demo:tree:export")
    @Log(title = "测试树表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public void export(@Validated TestTreeBo bo, HttpServletResponse response) {
        List<TestTreeVo> list = testTreeService.queryList(bo);
        ExcelUtil.exportExcel(list, "测试树表", TestTreeVo.class, response);
    }

    /**
     * 获取测试树表详细信息
     *
     * @param id 测试树ID
     */
    @SaCheckPermission("demo:tree:query")
    @GetMapping("/{id}")
    public R<TestTreeVo> getInfo(@NotNull(message = "主键不能为空")
                                 @PathVariable("id") Long id) {
        return R.ok(testTreeService.queryById(id));
    }

    /**
     * 新增测试树表
     */
    @SaCheckPermission("demo:tree:add")
    @Log(title = "测试树表", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody TestTreeBo bo) {
        return toAjax(testTreeService.insertByBo(bo));
    }

    /**
     * 修改测试树表
     */
    @SaCheckPermission("demo:tree:edit")
    @Log(title = "测试树表", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody TestTreeBo bo) {
        return toAjax(testTreeService.updateByBo(bo));
    }

    /**
     * 删除测试树表
     *
     * @param ids 测试树ID串
     */
    @SaCheckPermission("demo:tree:remove")
    @Log(title = "测试树表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(testTreeService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}
