package com.earthadmin.service;

import com.earthadmin.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author lanxifang
 * @date 2020/12/14 10:57
 */
public interface ImageService {

    /**
     *
     * @param sort
     * @param sortfield
     * @return
     */
    List<Image> findImageBySortField(String sort, String sortfield);

    /**
     *
     * @param folder
     * @return
     */
    String addImage(MultipartFile[] folder);


}
