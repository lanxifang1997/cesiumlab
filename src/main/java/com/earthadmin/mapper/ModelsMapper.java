package com.earthadmin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.earthadmin.domain.entity.Model;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lanxifang
 * @date 2020/12/07 14:35
 */
@Mapper
public interface ModelsMapper extends BaseMapper<Model> {

    /**
     * 根据条件将查询结果进行排序
     * @return
     * @param sort
     * @param sortfield
     */
    List<Model> findModelSortDateOrDesc(@Param("sort") String sort,@Param("sortfield") String sortfield);

    int addModel(Model model);

    Model findModelByPath(String path);

    Model findModelById(String id);

    Model findModelByName(String name);
}
