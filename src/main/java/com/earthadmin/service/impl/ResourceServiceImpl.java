package com.earthadmin.service.impl;

import com.earthadmin.domain.entity.Resource;
import com.earthadmin.mapper.ResourceMapper;
import com.earthadmin.service.ResourceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @author lanxifang
 * @date 2020/12/18 12:09
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @javax.annotation.Resource
    private ResourceMapper resourceMapper;

    /**
     * 上传文件保存的本地目录
     */
    @Value("${accessFile.location}")
    private String location;

    /**
     *
     * @param file
     * @return
     */
    @Override
    public String addResource(MultipartFile file) {
        String[] split = file.getOriginalFilename().split("/");
        String name = split[0];
        /** 名字查重 */
//        QueryWrapper<Resource> wrapper = new QueryWrapper<Resource>();
//
//        wrapper.eq("name",name);
//        Resource temp = resourceMapper.selectOne(wrapper);
//
//        if(temp!=null){
//            return "filename is exist";
//        }
        String id = UUID.randomUUID().toString().replace("-","").toLowerCase();
        String path = location+"resource"+"/"+name;
        Resource resource = new Resource();
        resource.setId(id);
        resource.setPath(path);
        resource.setName(name);
        int insert = resourceMapper.insert(resource);
        if (insert!=1){
            return "insert file is failed";
        }
        return id;
    }
}
