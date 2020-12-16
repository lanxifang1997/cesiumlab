package com.earthadmin.entity;

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
public class User {

    @Column(name = "u_id",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private Integer Uid;
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 45)
    private String name;

}
