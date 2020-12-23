package com.earthadmin.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author lanxifang
 * @date 2020/12/18 12:09
 */
public interface ResourceService {

    /**
     *
     * @param file
     * @return
     */
    String addResource(MultipartFile file);
}
