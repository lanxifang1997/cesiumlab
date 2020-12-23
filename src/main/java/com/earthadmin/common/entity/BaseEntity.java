package com.earthadmin.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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


    @TableId(value = "_id" ,type = IdType.ASSIGN_UUID)
    @Column(name = "_id",type = MySqlTypeConstant.VARCHAR,length = 45,isKey = true,isNull = false)
    private String _id;

    @TableField("name")
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 45)
    private String name;

    @TableField("`desc`")
    @Column(name = "desc",type = MySqlTypeConstant.VARCHAR,length = 45)
    private String desc;

    @TableField("thumbnail")
    @Column(name = "thumbnail",type = MySqlTypeConstant.TEXT)
    private String thumbnail;

    @TableField("date")
    @Column(name = "date",type = MySqlTypeConstant.DATETIME)
    private String date;

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }
}
