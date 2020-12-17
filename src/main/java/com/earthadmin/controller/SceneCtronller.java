package com.earthadmin.controller;

import com.earthadmin.dto.ResultEntity;
import com.earthadmin.entity.Scene;
import com.earthadmin.service.SceneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lanxifang
 * @date 2020/12/1 0001 15:00:46
 */
@Api(tags="系统:场景管理")
@RestController
@Slf4j
@RequestMapping("/scene")
public class SceneCtronller {

    //返回结果的key值
    public static final String SCENES_KEY = "scenes";

    @Resource
    private SceneService sceneService;


    //              TODO 列出所有数据,分页

    /**
     * 根据ID加载Scene
     *
     * @param _id
     * @return
     */
    @ApiOperation("加载场景")
    @GetMapping
    public ResultEntity uploadById(String _id){

        Scene scene = sceneService.findSceneById(_id);
//        log.info("----------------------"+scene.get_id());
        //error
        if(scene==null){
            return ResultEntity.error();
        }
        //将Scene放到list中
        List list = new ArrayList();
        list.add(scene);
        return ResultEntity.success(list,SCENES_KEY);
    }

    /**
     *
     * @param name
     * @param content
     * @return
     */
    @ApiOperation("新建场景")
    @PostMapping
    public ResultEntity saveScene(String name, String content){

        //判断是否保存成功,失败则返回""
        String id = sceneService.saveScene(name,content);
        if("".equals(id)){
            return ResultEntity.error();
        };
        log.info("---------------保存场景成功");

        return ResultEntity.success(id);
    }

    /**
     *
     * @param id
     * @param scene
     * @return
     */
    @ApiOperation("更新场景")
    @PutMapping("/{id}")
    public ResultEntity updateScene(@PathVariable String id, Scene scene){
        int temp = sceneService.updateSceneById(id, scene);
        //判断是否更新成功
        if(temp!=1) {

            return ResultEntity.error();
        }
        log.info("---------------更新场景成功");
        return ResultEntity.success();
    }


}
