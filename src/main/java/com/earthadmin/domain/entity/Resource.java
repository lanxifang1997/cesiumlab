package com.earthadmin.domain.entity;

import com.earthadmin.common.entity.BaseEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * @author lanxifang
 * @date 2020/12/18 11:42
 */
@Data
@Table(name = "resource")
public class Resource extends BaseEntity {

    @Column(name = "path",type = MySqlTypeConstant.VARCHAR,length = 45)
    private String path;
}
