package com.earthadmin.service;

import com.earthadmin.entity.Model;

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
     * @param model
     * @return
     */
    int addModel(Model model);

    boolean existsPath(String path);
}
