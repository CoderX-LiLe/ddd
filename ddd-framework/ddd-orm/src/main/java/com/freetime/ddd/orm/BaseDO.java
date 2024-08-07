package com.freetime.ddd.orm;

import com.baomidou.mybatisplus.annotation.*;
import com.freetime.ddd.core.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseDO extends BaseDTO {

    @TableId(type = IdType.AUTO)
    private Long id;

    @Version
    private Integer version;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer del;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}
