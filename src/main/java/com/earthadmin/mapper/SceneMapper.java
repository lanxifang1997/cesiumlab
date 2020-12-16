package com.earthadmin.mapper;

import com.earthadmin.entity.Scene;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author lanxifang
 * @date 2020/12/1 0001 18:19:47
 */
@Mapper
@Repository
public interface SceneMapper{

//    private String _id;
//    private String name;
//    private String desc;
//    private String content;
//    private String thumbnail;
//    private Date date;
//    private String udate;


    int saveScene(Scene scene);

    Scene findSceneById(String id);

    int updateSceneById(String _id,Scene scene);

}

