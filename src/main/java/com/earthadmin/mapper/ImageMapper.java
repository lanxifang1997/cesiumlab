package com.earthadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.earthadmin.domain.entity.Image;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lanxifang
 * @date 2020/12/14 10:59
 */
@Mapper
public interface ImageMapper extends BaseMapper<Image> {
    /**
     *
     * @param sort
     * @param sortfield
     * @return
     */
    List<Image> findImageBySortField(String sort, String sortfield);

    int addImage(Image image);

    Image findImageByName(String name);
}
