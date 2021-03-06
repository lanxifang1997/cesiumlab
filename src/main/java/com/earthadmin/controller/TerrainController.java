package com.earthadmin.controller;

import com.earthadmin.Utils.FileUtils;
import com.earthadmin.dto.ResultEntity;
import com.earthadmin.domain.entity.Terrain;

import com.earthadmin.service.TerrainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lanxifang
 * @date 2020/12/16 14:09
 */
@Api(tags = "系统:地形管理")
@Slf4j
@RestController
@RequestMapping("/terrain")
public class TerrainController {

    public static final String TERRAIN_KEY = "terrains";

    @Resource
    private TerrainService terrainService;

    /**
     * 上传文件保存的本地目录
     */
    @Value("${accessFile.location}")
    private String location;


    //              TODO 列出所有数据,分页


    /**
     *
     * @param sort     升序或降序
     * @param sortfield  条件
     * @return
     */
    @ApiOperation("加载Lab服务")
    @GetMapping
    public ResultEntity findImageBySortField(String sort, String sortfield){
//        if(sortfield==null ||"".equals(sortfield.trim())){
//            ResultEntity.error("sortfield不能为空");
//        }
        List<Terrain> terrains = terrainService.findTerrainBySortField(sort,sortfield);

        return ResultEntity.success(terrains,TERRAIN_KEY);
    }



    /**
     *  上传地形模型
     * @param folder    整个文件夹一起上传
     * @return
     */
    @ApiOperation("上传影像模型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "files", value = "多个文件", allowMultiple = true, dataType = "__file")
    })
    @PostMapping("/uploadTerrains")
    public ResultEntity uploadFolder(MultipartFile[] folder) {

        //E:/瓦片文件/Terrain
       //location+"terrain";

        String result = terrainService.addTerrain(folder);
        if("".equals(result)){
            return ResultEntity.error("save terrain failed");
        }else if("terrainname is exist".equals(result)){
            return ResultEntity.error("terrainname is exist");
        }else if("folder is null".equals(result)){
            return ResultEntity.error("folder is null");
        }
        FileUtils.saveMultiFile(location+"terrain", folder,result);



        return ResultEntity.success();
    }


    @ApiOperation("更新影像模型")
    @PutMapping("/{id}")
    public ResultEntity updateTerrainById(@PathVariable String id , Terrain terrain){
        terrain.setId(id);
        int temp = terrainService.updateTerrainById(terrain);
        if(temp!=1){
            ResultEntity.error();
        };

        return ResultEntity.success();
    }

    @ApiOperation("删除影像模型")
    @DeleteMapping("/{id}")
    public ResultEntity deleteTerrainById(@PathVariable String id){
        int temp = terrainService.deleteTerrainById(id);
        if(temp!=1){
            ResultEntity.error();
        }

        return ResultEntity.success();

    }
}
