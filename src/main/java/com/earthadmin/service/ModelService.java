package com.earthadmin.service;

import com.earthadmin.domain.entity.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author lanxifang
 * @date 2020/12/07 14:23
 */
public interface ModelService {

    /**
     * 查找所有model根据条件排序
     * @param sort    升序或降序
     * @param sortfield  条件
     * @return
     */
    List<Model> findModelSortDateOrDesc(String sort, String sortfield);

    /**
     *
     * @param folder
     * @return
     */
    String addModel(MultipartFile[] folder);

    /**
     *
     * @param path
     * @return
     */
    boolean existsPath(String path);

    /**
     *
     * @param model
     * @return
     */
    int updateModelById(Model model);

    /**
     *
     * @param id
     * @return
     */
    int deleteModelById(String id);
}
