package com.earthadmin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class SpringbootApplicationTests {

    @Test
    void contextLoads() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> resourceUrl1 = restTemplate.getForEntity("E:/共享文件/综合井场布/场布实景/tileset.json", Object.class);
        System.out.println("----");
    }

}
