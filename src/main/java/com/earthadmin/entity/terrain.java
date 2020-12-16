package com.earthadmin.entity;

import com.earthadmin.common.entity.BaseEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * @author lanxifang
 * @date 2020/12/14 9:19
 */
@Data
@Table(name ="terrains")
public class terrain extends BaseEntity {

//    @Column(name = "_id",type = MySqlTypeConstant.VARCHAR,length = 45,isKey = true,isNull = false)
//    private String _id;
//
//    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 45)
//    private String name;
//
//    @Column(name = "desc",type = MySqlTypeConstant.VARCHAR,length = 45)
//    private String desc;

    @Column(name = "type",type = MySqlTypeConstant.VARCHAR,length = 45)
    private String type;

    @Column(name = "path",type = MySqlTypeConstant.VARCHAR,length = 45)
    private String path;

    @Column(name = "west",type = MySqlTypeConstant.DOUBLE)
    private double west;

    @Column(name = "east",type = MySqlTypeConstant.DOUBLE)
    private double east;

    @Column(name = "south",type = MySqlTypeConstant.DOUBLE)
    private double south;

    @Column(name = "north",type = MySqlTypeConstant.DOUBLE)
    private double north;

    @Column(name = "minzoom",type = MySqlTypeConstant.INT)
    private int minzoom;

    @Column(name = "maxzoom",type = MySqlTypeConstant.INT)
    private int maxzoom;

    @Column(name = "contenttype",type = MySqlTypeConstant.TEXT)
    private String contenttype;

//    @Column(name = "thumbnail",type = MySqlTypeConstant.TEXT)
//    private String thumbnail;
//
//    @Column(name = "date",type = MySqlTypeConstant.DATETIME)
//    private String date;
}