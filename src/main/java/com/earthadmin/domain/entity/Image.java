package com.earthadmin.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.earthadmin.common.entity.BaseEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lanxifang
 * @date 2020/12/14 9:19
 */
@Data
@Table(name = "images")
@TableName("images")
public class Image extends BaseEntity {

//    @Column(name = "id",type = MySqlTypeConstant.VARCHAR,length = 45,isKey = true,isNull = false)
//    private String id;
//
//    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 45)
//    private String name;
//
//    @Column(name = "desc",type = MySqlTypeConstant.VARCHAR,length = 45)
//    private String desc;

    @TableField("type")
    @Column(name = "type",type = MySqlTypeConstant.VARCHAR,length = 45)
    private String type;

    @TableField("path")
    @Column(name = "path",type = MySqlTypeConstant.VARCHAR,length = 45)
    private String path;

    @TableField("west")
    @Column(name = "west",type = MySqlTypeConstant.DECIMAL,length = 45)
    private BigDecimal west;

    @TableField("east")
    @Column(name = "east",type = MySqlTypeConstant.DECIMAL,length = 45)
    private BigDecimal east;

    @TableField("south")
    @Column(name = "south",type = MySqlTypeConstant.DECIMAL,length = 45)
    private BigDecimal south;

    @TableField("north")
    @Column(name = "north",type = MySqlTypeConstant.DECIMAL,length = 45)
    private BigDecimal north;

    @TableField("minzoom")
    @Column(name = "minzoom",type = MySqlTypeConstant.INT)
    private int minzoom;

    @TableField("maxzoom")
    @Column(name = "maxzoom",type = MySqlTypeConstant.INT)
    private int maxzoom;

    @TableField("contenttype")
    @Column(name = "contenttype",type = MySqlTypeConstant.TEXT)
    private String contenttype;

//    @Column(name = "thumbnail",type = MySqlTypeConstant.TEXT)
//    private String thumbnail;
//
//    @Column(name = "date",type = MySqlTypeConstant.DATETIME)
//    private String date;
}
