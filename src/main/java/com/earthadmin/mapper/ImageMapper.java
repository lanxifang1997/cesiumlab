package com.earthadmin.mapper;

import com.earthadmin.entity.Image;

import java.util.List;

/**
 * @author lanxifang
 * @date 2020/12/14 10:59
 */
public interface ImageMapper {
    /**
     *
     * @param sort
     * @param sortfield
     * @return
     */
    List<Image> findImageBySortField(String sort, String sortfield);

    int addImage(Image image);

}
