package com.earthadmin.service.impl;

import com.earthadmin.Utils.FileUtils;
import com.earthadmin.entity.Terrain;
import com.earthadmin.mapper.TerrainMapper;
import com.earthadmin.service.TerrainService;
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
 * @date 2020/12/16 14:20
 */
@Service
public class TerrainServiceImpl implements TerrainService {

    @Resource
    private TerrainMapper terrainMapper;

    private static final String JSON_NAME = "meta.json";

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
    public List<Terrain> findTerrainBySortField(String sort, String sortfield) {

        return terrainMapper.findTerrainBySortField(sort,sortfield);
    }

    /**
     *
     * @param folder
     * @return
     */
    @Override
    public String addTerrain(MultipartFile[] folder) {

        String[] split = folder[0].getOriginalFilename().split("/");
        String name = split[0];
        /** 名字查重 */
        Terrain temp = terrainMapper.findTerrainByName(name);
        if(temp!=null){
            return "terrainname is exist";
        }
        String id = UUID.randomUUID().toString().replace("-","").toLowerCase();
        String path = location+"/"+name;
        String desc = "";
        JSONObject jsonObject = FileUtils.extractionJson(folder,JSON_NAME);
        if(jsonObject==null){
            throw new RuntimeException(JSON_NAME+"文件不存在或解析异常");
        }

        List bounds = (List) jsonObject.get("bounds");

        BigDecimal west = new BigDecimal(bounds.get(0).toString());

        BigDecimal south = new BigDecimal(bounds.get(1).toString());
        BigDecimal east = new BigDecimal(bounds.get(2).toString());
        BigDecimal north = new BigDecimal(bounds.get(3).toString());
        String type = jsonObject.get("type").toString();
        String contenttype =  jsonObject.get("contentType").toString();
        int minzoom = (int) jsonObject.get("minzoom");

        int maxzoom = (int) jsonObject.get("maxzoom");

        Terrain terrain = new Terrain();
        terrain.set_id(id);
        terrain.setName(name);
        terrain.setPath(path);
        terrain.setDesc(desc);
        terrain.setWest(west);
        terrain.setSouth(south);
        terrain.setEast(east);
        terrain.setNorth(north);
        terrain.setType(type);
        terrain.setContenttype(contenttype);
        terrain.setMaxzoom(maxzoom);
        terrain.setMinzoom(minzoom);

        if(terrainMapper.addTerrain(terrain)!=1){
            return "";
        };

        return id;
    }
}