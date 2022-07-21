package com.charlie.servicedemo.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.charlie.servicedemo.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表实体类
 * </p>
 *
 * @author charlie
 * @since 2022-07-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("c_user")
@ApiModel(value="CUser对象", description="")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "姓名")
    private String name;

}
