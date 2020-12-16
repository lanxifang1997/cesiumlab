package com.earthadmin.service.impl;

import com.earthadmin.entity.Model;
import com.earthadmin.mapper.ModelsMapper;
import com.earthadmin.service.ModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
     * @param model
     * @return
     */
    @Override
    public int addModel(Model model) {
        String id = UUID.randomUUID().toString().replace("-","").toLowerCase();
        log.info("-----------------ID:"+id);
        model.set_id(id);

        return modelMapper.addModel(model);
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
