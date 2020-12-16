package com.earthadmin.mapper;


import com.earthadmin.entity.Model;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lanxifang
 * @date 2020/12/07 14:35
 */
public interface ModelsMapper {

    /**
     * 根据条件将查询结果进行排序
     * @return
     * @param sort
     * @param sortfield
     */
    List<Model> findModelSortDateOrDesc(@Param("sort") String sort,@Param("sortfield") String sortfield);

    int addModel(Model model);

    Model findModelByPath(String path);

    Model findModelById(String _id);
}
