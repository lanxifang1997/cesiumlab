package com.earthadmin.service;

import com.earthadmin.domain.entity.Scene;

/**
 * @author lanxifang
 * @date 2020/12/1 0001 18:07:45
 */
public interface SceneService {


    String saveScene(String name, String content);

    /**
     * 根据id查询或加载场景
     *
     * @param id
     * @return
     */
    Scene findSceneById(String id);

    /**
     * 根据id更新场景
     *
     * @param id
     * @param scene
     * @return
     */
    int updateSceneById(String id, Scene scene);

    /**
     *
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     * 根据id更新缩略图
     * @param id
     * @param thumbnail
     */
    void updateThumbnailById(String id,String thumbnail);
}
