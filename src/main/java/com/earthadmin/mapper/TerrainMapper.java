package com.earthadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.earthadmin.domain.entity.Terrain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lanxifang
 * @date 2020/12/16 14:33
 */
@Mapper
public interface TerrainMapper extends BaseMapper<Terrain> {

    /**
     *
     * @param sort
     * @param sortfield
     * @return
     */
    List<Terrain> findTerrainBySortField(String sort, String sortfield);

    /**
     *
     * @param name
     * @return
     */
    Terrain findTerrainByName(String name);

    /**
     *
     * @param terrain
     */
    int addTerrain(Terrain terrain);
}
