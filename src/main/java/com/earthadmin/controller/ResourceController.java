package com.earthadmin.controller;

import com.earthadmin.Utils.FileUtils;
import com.earthadmin.dto.ResultEntity;
import com.earthadmin.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author lanxifang
 * @date 2020/12/18 11:27
 */
@Api(tags = "系统:资源管理")
@Slf4j
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Resource
    private ResourceService resourceService;

    /**
     * 上传文件保存的本地目录
     */
    @Value("${accessFile.location}")
    private String location;

    /**
     *
     * @param file
     * @return
     */
    @ApiOperation("上传资源文件")
    @PostMapping("/uploadResource")
    public ResultEntity uploadResource (@ApiParam(required = true) MultipartFile file){

        String id = resourceService.addResource(file);
        if("insert file is failed".equals(id)){
            return ResultEntity.error("insert file is failed");
        }else if("filename is exist".equals(id)){
            return ResultEntity.error("filename is exist");
        }

        FileUtils.saveMultiFile(location+"resource",file,id);



        return ResultEntity.success(id);
    }

}
