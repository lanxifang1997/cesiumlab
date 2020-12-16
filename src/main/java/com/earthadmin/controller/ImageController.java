package com.earthadmin.controller;

import com.earthadmin.Utils.FileUtils;
import com.earthadmin.dto.ResultEntity;
import com.earthadmin.entity.Image;
import com.earthadmin.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lanxifang
 * @date 2020/12/14 9:59
 */
@Api(tags = "系统:影像管理")
@Slf4j
@RestController
@RequestMapping("/image")
public class ImageController {

    public static final String IMAGE_KEY = "images";

    @Resource
    private ImageService imageService;

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
        if(sortfield==null ||"".equals(sortfield.trim())){
            ResultEntity.error("sortfield不能为空");
        }
        List<Image> image = imageService.findImageBySortField(sort,sortfield);

        return ResultEntity.success(image,IMAGE_KEY);
    }



    /**
     *  上传瓦片模型
     * @param folder    整个文件夹一起上传
     * @return
     */
    @ApiOperation("上传影像模型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "files", value = "多个文件", allowMultiple = true, dataType = "__file")
    })
    @PostMapping("/uploadImages")
    public ResultEntity uploadFolder(MultipartFile[] folder) {

        //E:/瓦片文件/image
        location = location+"image";

        String result = imageService.addImage(folder);
        if("".equals(result)){
            return ResultEntity.error();
        }else if("imagename is exist".equals(result)){
            return ResultEntity.error("imagename is exist");
        }
        FileUtils.saveMultiFile(location, folder,result);



        return ResultEntity.success();
    }



}
