package com.charlie.authenticationdemo.base;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -6845899986543323855L;

    @TableId(type = IdType.INPUT)
    @ApiModelProperty(value = "UUID(32位)")
    private String id;

    @ApiModelProperty(value = "创建人ID", hidden = true)

    private String createBy;

    @ApiModelProperty(value = "创建时间", hidden = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss" , timezone="GMT+8")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新人ID", hidden = true)
    private String updateBy;

    @ApiModelProperty(value = "修改时间", hidden = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss" , timezone="GMT+8")
    private LocalDateTime updateDate;

    @TableField("is_del_flag")
    @ApiModelProperty(value = "删除标记(false：正常；true：删除)", hidden = true)
    private Boolean delFlag;

    @Override
    public int hashCode() {
        return id == null ? System.identityHashCode(this) : id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass().getPackage() != obj.getClass().getPackage()) {
            return false;
        }
        final BaseEntity other = (BaseEntity) obj;
        if (id == null) {
            if (other.getId() != null) {
                return false;
            }
        } else if (!id.equals(other.getId())) {
            return false;
        }
        return true;
    }

//    public String toJson() {
//        return PojoMapper.toJson(this);
//    }
//
//    public String toString() {
//
//        return ToStringBuilder.reflectionToString(this);
//    }

}
