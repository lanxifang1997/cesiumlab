package com.earthadmin.service.impl;

import com.earthadmin.domain.entity.Scene;
import com.earthadmin.mapper.SceneMapper;
import com.earthadmin.service.SceneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author lanxifang
 * @date 2020/12/1 0001 18:17:42
 */
@Slf4j
@Service("sceneService")
public class SceneServiceImpl implements SceneService {

    @Autowired
    private SceneMapper sceneMapper;



    /**
     *  保存场景
     * @param name      名字
     * @param content   内容
     * @return
     */
    @Override
    public String saveScene(String name,String content) {
        Scene scene = new Scene();
        scene.setName(name);
        scene.setContent(content);
        //生成UUID
        String id = UUID.randomUUID().toString().replace("-","").toLowerCase();
        log.info("-----------------ID:"+id);
        scene.setId(id);
        int temp = sceneMapper.saveScene(scene);
        if(temp!=1){
            return "";
        }

        return id;
    }

    /**
     * 根据id查询或加载场景
     *
     * @param id
     * @return 结果
     */
    @Override
    public Scene findSceneById(String id) {

        Scene scene = sceneMapper.findSceneById(id);

        return scene;
    }

    /**
     * 根据id更新场景  TODO
     *
     * @param id
     * @param scene 场景
     * @return 结果
     */
    @Override
    public int updateSceneById(String id, Scene scene) {
        //id不为空
        if (id!=null ||"".equals(id)){
           log.info("-----------更新场景Id"+id);
           // TODO
        }
        //Scene sceneById = sceneMapper.findSceneById(id);
        // log.info("-----------更新scene"+scene.toString());

        return sceneMapper.updateSceneById(id,scene);
    }

    @Override
    public int deleteById(String id) {
        return sceneMapper.deleteById(id);
    }

    @Override
    public void updateThumbnailById(String id, String thumbnail) {
        Scene scene = sceneMapper.selectById(id);
        scene.setThumbnail(thumbnail);
        sceneMapper.updateById(scene);
    }


}
