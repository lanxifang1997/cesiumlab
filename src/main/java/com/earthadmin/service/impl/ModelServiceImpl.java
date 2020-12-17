package com.earthadmin.service.impl;

import com.earthadmin.entity.Model;
import com.earthadmin.mapper.ModelsMapper;
import com.earthadmin.service.ModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author lanxifang
 * @date 2020/12/07 14:29
 */
@Slf4j
@Service
public class ModelServiceImpl implements ModelService {

    @Resource
    private ModelsMapper modelMapper;

    /**
     * 上传文件保存的本地目录
     */
    @Value("${accessFile.location}")
    private String location;

    /**
     * 查询所有结果根据条件排序
     * @param sort        升序或降序
     * @param sortfield        条件
     * @return
     */
    @Override
    public List<Model> findModelSortDateOrDesc(String sort, String sortfield) {

        return modelMapper.findModelSortDateOrDesc(sort,sortfield);
    }

    /**
     * 添加瓦片模型
     * @param folder
     * @return
     */
    @Override
    public String addModel(MultipartFile[] folder) {
        //id
        String id = UUID.randomUUID().toString().replace("-","").toLowerCase();
        //name
        String[] split = folder[0].getOriginalFilename().split("/");
        String name = split[0];
        //path
        String path = location+name+"/tileset.json";
        /** 名字查重 */
        Model temp = modelMapper.findModelByName(name);
        if(temp!=null){
            return "modelname is exist";
        }
        Model model = new Model();
        model.set_id(id);
        model.setName(name);
        model.setPath(path);
        model.setType("file");
        int result = modelMapper.addModel(model);
        if(result!=1){
            return "";
        }

        return id;
    }

    /**
     * 判断是否已添加该文件
     * @param path
     * @return
     */
    @Override
    public boolean existsPath(String path) {
         if(modelMapper.findModelByPath(path)!=null){
             return true;
         }
         return false;
    }
}
