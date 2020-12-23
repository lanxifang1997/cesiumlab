package com.earthadmin.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.earthadmin.common.entity.BaseEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * @author Administrator
 * @date 2020/11/30 0030 17:26:39
 * @description
 */
@Data
@Table(name = "user")
public class User extends BaseEntity {


    @TableField("password")
    @Column(name = "password",type = MySqlTypeConstant.VARCHAR,length = 45)
    private String password;


}
