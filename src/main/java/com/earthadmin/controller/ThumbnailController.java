package com.earthadmin.controller;

import com.earthadmin.dto.ResultEntity;
import com.earthadmin.service.SceneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lanxifang
 * @date 2020/12/18 14:29
 */
@Api(tags="系统:缩略图管理")
@Slf4j
@RestController
public class ThumbnailController {

    @Resource
    private SceneService sceneService;


    @ApiOperation("更新缩略图")
    @PutMapping("/other/thumbnail/scenes/{id}")
    public ResultEntity updateThumbnailOfScene(@PathVariable String id,String thumbnail){
        sceneService.updateThumbnailById(id,thumbnail);

        return ResultEntity.success();
    }


}
