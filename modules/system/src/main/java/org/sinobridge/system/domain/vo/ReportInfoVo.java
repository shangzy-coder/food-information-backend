package org.sinobridge.system.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.sinobridge.system.domain.ReportInfo;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import org.sinobridge.common.excel.annotation.ExcelDictFormat;
import org.sinobridge.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 研报信息视图对象 report_info
 *
 * @author Zhao Yun
 * @date 2025-09-04
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = ReportInfo.class)
public class ReportInfoVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * 研报标题
     */
    @ExcelProperty(value = "研报标题")
    private String title;

    /**
     * 报告类型
     */
    @ExcelProperty(value = "报告类型")
    private String reportType;

    /**
     * 品种分类
     */
    @ExcelProperty(value = "品种分类")
    private String varietyType;

    /**
     * 上传PDF的URL
     */
    @ExcelProperty(value = "上传PDF的URL")
    private String pdfUrl;

    /**
     * 访问权限（如：公开/内部/部门内）
     */
    @ExcelProperty(value = "访问权限", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "如=：公开/内部/部门内")
    private String accessLevel;

    /**
     * 展示平台ID
     */
    @ExcelProperty(value = "展示平台ID")
    private Long platformId;

    /**
     * 是否关联微信公众号（0-否，1-是）
     */
    @ExcelProperty(value = "是否关联微信公众号", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=-否，1-是")
    private Long wechatPub;

    /**
     * 是否已备案公共媒体（0-否，1-是）
     */
    @ExcelProperty(value = "是否已备案公共媒体", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=-否，1-是")
    private Long publicMedia;

    /**
     * 是否已签约直播软件（0-否，1-是）
     */
    @ExcelProperty(value = "是否已签约直播软件", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=-否，1-是")
    private Long liveSoftware;

    /**
     * 第三方合作渠道
     */
    @ExcelProperty(value = "第三方合作渠道")
    private String thirdParty;

    /**
     * 上传人ID
     */
    @ExcelProperty(value = "上传人ID")
    private Long uploaderId;

    /**
     * 所属部门ID
     */
    @ExcelProperty(value = "所属部门ID")
    private Long departmentId;

    /**
     * 上传时间
     */
    @ExcelProperty(value = "上传时间")
    private Date uploadTime;

    /**
     * 审批状态（0-待提交，1-待审批，2-已通过，3-驳回）
     */
    @ExcelProperty(value = "审批状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=-待提交，1-待审批，2-已通过，3-驳回")
    private Long approveStatus;

    /**
     * 上架状态（0-未上架，1-已上架）
     */
    @ExcelProperty(value = "上架状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=-未上架，1-已上架")
    private Long publishStatus;

    /**
     * 点击量
     */
    @ExcelProperty(value = "点击量")
    private Long clickCount;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    private Date createdTime;

    /**
     * 更新时间
     */
    @ExcelProperty(value = "更新时间")
    private Date updatedTime;

    /**
     * AI生成的研报摘要
     */
    @ExcelProperty(value = "AI生成的研报摘要")
    private String aiSummary;

    /**
     * 富文本内容（支持HTML或Markdown格式）
     */
    @ExcelProperty(value = "富文本内容", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "支=持HTML或Markdown格式")
    private String richContent;

    /**
     * 咨询证号
     */
    @ExcelProperty(value = "咨询证号")
    private String consultationNo;
    @ExcelProperty(value = "租户id")
    private String tenantId;

}
