package com.earthadmin.service;

import com.earthadmin.entity.Terrain;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author lanxifang
 * @date 2020/12/16 14:17
 */
public interface TerrainService {

    /**
     *
     * @param sort
     * @param sortfield
     * @return
     */
    List<Terrain> findTerrainBySortField(String sort, String sortfield);


    /**
     *
     * @param folder
     * @return
     */
    String addTerrain(MultipartFile[] folder);
}
