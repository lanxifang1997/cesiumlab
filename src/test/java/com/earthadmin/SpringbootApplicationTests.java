package com.earthadmin;

import com.earthadmin.domain.entity.Scene;
import com.earthadmin.mapper.SceneMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringbootApplicationTests {

    @Resource
    private SceneMapper sceneMapper;

    @Test
    void contextLoads() {
        List<Scene> list = sceneMapper.selectList(null);
        System.out.println(list.toString());

    }

}
