package com.earthadmin.controller;

import com.earthadmin.Utils.FileUtils;
import com.earthadmin.dto.ResultEntity;
import com.earthadmin.domain.entity.Model;
import com.earthadmin.service.ModelService;
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
 * @date 2020/12/07 11:04
 */
@Api(tags = "系统:瓦片管理")
@Slf4j
@RestController
@RequestMapping("/model")
public class ModelController {

    public static final String MONDEL_KEY = "models";

    @Resource
    private ModelService modelService;

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
    public ResultEntity findModelSortDateOrDesc(String sort, String sortfield){
//        if(sortfield==null ||"".equals(sortfield.trim())){
//            ResultEntity.error("sortfield不能为空");
//        }
        List<Model> models = modelService.findModelSortDateOrDesc(sort,sortfield);

        return ResultEntity.success(models,MONDEL_KEY);
    }


    /**
     *  上传瓦片模型
     * @param folder    整个文件夹一起上传
     * @return
     */
    @ApiOperation("上传瓦片模型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "files", value = "多个文件", allowMultiple = true, dataType = "__file")
    })
    @PostMapping("/uploadModels")
    public ResultEntity uploadFolder(MultipartFile[] folder) {

        //E:/瓦片文件/model
        //location+"model";

        String result = modelService.addModel(folder);
        if("".equals(result)){
            return ResultEntity.error("save model failed");
        }else if("modelname is exist".equals(result)){
            return ResultEntity.error("modelname is exist");
        }
        FileUtils.saveMultiFile(location+"model", folder,result);
        return ResultEntity.success();
    }


    @ApiOperation("更新影像模型")
    @PutMapping("/{id}")
    public ResultEntity updateModelBById(@PathVariable String id , Model model){
        model.setId(id);
        int temp = modelService.updateModelById(model);
        if(temp!=1){
            ResultEntity.error();
        };

        return ResultEntity.success();
    }

    @ApiOperation("删除影像模型")
    @DeleteMapping("/{id}")
    public ResultEntity deleteModelById(@PathVariable String id){
        int temp = modelService.deleteModelById(id);
        if(temp!=1){
            ResultEntity.error();
        }

        return ResultEntity.success();

    }
}
