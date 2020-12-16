package com.earthadmin.common.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lanxifang
 * @date 2020/12/14 10:17
 */
@Data
public class BaseEntity implements Serializable {

    @Column(name = "_id",type = MySqlTypeConstant.VARCHAR,length = 45,isKey = true,isNull = false)
    private String _id;

    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 45)
    private String name;

    @Column(name = "desc",type = MySqlTypeConstant.VARCHAR,length = 45)
    private String desc;

    @Column(name = "thumbnail",type = MySqlTypeConstant.TEXT)
    private String thumbnail;

    @Column(name = "date",type = MySqlTypeConstant.DATETIME)
    private String date;

}
