package com.earthadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.earthadmin.domain.entity.Scene;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lanxifang
 * @date 2020/12/1 0001 18:19:47
 */
@Mapper
public interface SceneMapper extends BaseMapper<Scene> {

//    private String id;
//    private String name;
//    private String desc;
//    private String content;
//    private String thumbnail;
//    private Date date;
//    private String udate;


    int saveScene(Scene scene);

    Scene findSceneById(String id);

    int updateSceneById(String id,Scene scene);

}

