package org.sinobridge.system.domain.bo;

import org.sinobridge.system.domain.ReportInfo;
import org.sinobridge.common.mybatis.core.domain.BaseEntity;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 研报信息业务对象 report_info
 *
 * @author Zhao Yun
 * @date 2025-09-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = ReportInfo.class, reverseConvertGenerate = false)
public class ReportInfoBo extends BaseEntity {

    /**
     *
     */
    private Long id;

    /**
     * 研报标题
     */
    private String title;

    /**
     * 报告类型
     */
    private String reportType;

    /**
     * 品种分类
     */
    private String varietyType;

    /**
     * 上传PDF的URL
     */
    private String pdfUrl;

    /**
     * 访问权限（如：公开/内部/部门内）
     */
    private String accessLevel;

    /**
     * 展示平台ID
     */
    private Long platformId;

    /**
     * 是否关联微信公众号（0-否，1-是）
     */
    private Long wechatPub;

    /**
     * 是否已备案公共媒体（0-否，1-是）
     */
    private Long publicMedia;

    /**
     * 是否已签约直播软件（0-否，1-是）
     */
    private Long liveSoftware;

    /**
     * 第三方合作渠道
     */
   // @NotBlank(message = "第三方合作渠道不能为空", groups = { AddGroup.class, EditGroup.class })
    private String thirdParty;

    /**
     * 上传人ID
     */
    private Long uploaderId;

    /**
     * 所属部门ID
     */
    private Long departmentId;

    /**
     * 上传时间
     */
    private Date uploadTime;

    /**
     * 审批状态（0-待提交，1-待审批，2-已通过，3-驳回）
     */
    private Long approveStatus;

    /**
     * 上架状态（0-未上架，1-已上架）
     */
    private Long publishStatus;

    /**
     * 点击量
     */
    private Long clickCount;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * AI生成的研报摘要
     */
   // @NotBlank(message = "AI生成的研报摘要不能为空", groups = { AddGroup.class, EditGroup.class })
    private String aiSummary;

    /**
     * 富文本内容（支持HTML或Markdown格式）
     */
 //   @NotBlank(message = "富文本内容（支持HTML或Markdown格式）不能为空", groups = { AddGroup.class, EditGroup.class })
    private String richContent;

    /**
     * 咨询证号
     */
   // @NotBlank(message = "咨询证号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String consultationNo;

    private String tenantId;


}
