package com.earthadmin.entity;

import com.earthadmin.common.entity.BaseEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * @author lanxifang
 * @date 2020/12/04 16:58
 */
@Table(name = "models")
@Data
public class Model extends BaseEntity {

//    @Column(name = "_id",type = MySqlTypeConstant.VARCHAR,length = 45,isKey = true,isNull = false)
//    private String _id;
//
//    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 45)
//    private String name;
//
//    @Column(name = "desc",type = MySqlTypeConstant.TEXT)
//    private String desc;

    @Column(name = "path",type = MySqlTypeConstant.TEXT)
    private String path;

    @Column(name = "type",type = MySqlTypeConstant.TEXT)
    private String type;

//    @Column(name = "thumbnail",type = MySqlTypeConstant.TEXT)
//    private String thumbnail;
//
//    @Column(name = "date",type = MySqlTypeConstant.DATETIME)
//    private String date;
}
