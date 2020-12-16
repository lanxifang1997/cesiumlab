package com.earthadmin.controller;

import com.earthadmin.Utils.FileUtils;
import com.earthadmin.dto.ResultEntity;
import com.earthadmin.entity.Model;
import com.earthadmin.service.ModelService;
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
        if(sortfield==null ||"".equals(sortfield.trim())){
            ResultEntity.error("sortfield不能为空");
        }
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
        String[] split = folder[0].getOriginalFilename().split("/");
        String name = split[0];
        String path = location+name+"/tileset.json";
        String id = addModel(name, path);
        if("".equals(id)){
            return ResultEntity.error();
        }

        // E:/瓦片文件/model
        location = location+"model";

        FileUtils.saveMultiFile(location, folder,id);
        return ResultEntity.success();
    }

    /**
     *  将model保存在数据库
     * @param name    文件名
     * @param path   文件路径
     * @return
     */
    public String addModel(String name,String path){

        Model model = new Model();
        model.setName(name);
        model.setPath(path);
        model.setType("file");
        int result = modelService.addModel(model);
        if(result!=1){
            return "";
        }
        return model.get_id();
    }

//     /**
//     * 上传瓦片
//     * @param file
//     * @return
//     */
//    @ApiOperation("上传瓦片模型")
//    @RequestMapping("/uploadModel")
//    public ResultEntity uploadModel(@ApiParam(value = "上传文件",required = true) @RequestParam("file")MultipartFile file,String path){
//        String pathName = file.getOriginalFilename();
//        path = StringUtils.replace(path,"\\","/");
//        String[] split = StringUtils.split(path, "/");
//
//        String name = split[split.length - 2];
//        String id = addModel(name, path);
//        try {
//            String uploadpath = location+id+"/"+pathName;
//            File dest = new File(uploadpath);
//            if(!dest.getParentFile().exists()){
//                dest.getParentFile().mkdirs();
//            }
//            file.transferTo(dest);
//        } catch (IOException e) {
//            log.info(e.getMessage());
//        }
//
//        return ResultEntity.success(id);
//    }

}
