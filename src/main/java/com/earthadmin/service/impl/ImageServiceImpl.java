package com.earthadmin.service.impl;

import com.earthadmin.Utils.FileUtils;
import com.earthadmin.entity.Image;
import com.earthadmin.mapper.ImageMapper;
import com.earthadmin.service.ImageService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * @author lanxifang
 * @date 2020/12/14 10:58
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Resource
    private ImageMapper imageMapper;

    /**
     * 上传文件保存的本地目录
     */
    @Value("${accessFile.location}")
    private String location;

    /**
     *
     * @param sort
     * @param sortfield
     * @return
     */
    @Override
    public List<Image> findImageBySortField(String sort, String sortfield) {


        return imageMapper.findImageBySortField(sort,sortfield);
    }

    /**
     * 添加镜像 ,从json串得到其他的数据
     * @param folder
     * @return
     */
    @Override
    public String addImage(MultipartFile[] folder) {
        String[] split = folder[0].getOriginalFilename().split("/");
        String id = UUID.randomUUID().toString().replace("-","").toLowerCase();
        String name = split[0];
        String path = location+"/"+name;
        String desc = "";
        String contenttype = "image/png";
        JSONObject jsonObject = FileUtils.extractionLayerJson(folder);
        if(jsonObject==null){
            throw new RuntimeException("layer.json文件不存在或解析异常");
        }

        List bounds = (List) jsonObject.get("bounds");

        BigDecimal west = new BigDecimal(bounds.get(0).toString());

        BigDecimal south = new BigDecimal(bounds.get(1).toString());
        BigDecimal east = new BigDecimal(bounds.get(2).toString());
        BigDecimal north = new BigDecimal(bounds.get(3).toString());

        String type = jsonObject.get("scheme").toString();

        int minzoom = (int) jsonObject.get("minzoom");

        int maxzoom = (int) jsonObject.get("maxzoom");

        Image image = new Image();
        image.set_id(id);
        image.setName(name);
        image.setPath(path);
        image.setDesc(desc);

        image.setContenttype(contenttype);
        image.setWest(west);
        image.setEast(east);
        image.setSouth(south);
        image.setNorth(north);
        image.setType(type);
        image.setMaxzoom(maxzoom);
        image.setMinzoom(minzoom);

        imageMapper.addImage(image);

        return id;
    }


}
