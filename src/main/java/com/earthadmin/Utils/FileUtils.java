package com.earthadmin.Utils;


import net.sf.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author lanxifang
 * @date 2020/12/11 15:38
 */
public class FileUtils {

    public static void saveMultiFile(String basePath, MultipartFile[] files,String id) {
        if (files == null || files.length == 0) {
            return;
        }
        if (basePath.endsWith("/")) {
            basePath = basePath.substring(0, basePath.length() - 1);
        }

        for (MultipartFile file : files) {

            String substring = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("/"));
            String filePath = basePath + "/" +id+ substring;
            makeDir(filePath);
            File dest = new File(filePath);
            try {
                file.transferTo(dest);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 确保目录存在，不存在则创建
     * @param filePath
     */
    private static void makeDir(String filePath) {
        if (filePath.lastIndexOf('/') > 0) {
            String dirPath = filePath.substring(0, filePath.lastIndexOf('/'));
            File dir = new File(dirPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
        }
    }

    /**
     * 提取文件夹里面的json文件
     * @param files
     * @return
     */
    public static JSONObject extractionLayerJson(MultipartFile[] files) {
        if (files == null || files.length == 0) {
            throw new RuntimeException("files is empty");
        }
        for (MultipartFile file : files) {

            if (file.getOriginalFilename().endsWith("layer.json")){
                byte[] bytes = new byte[0];
                try {
                    //获取里面的数据
                    InputStream inputStream = file.getInputStream();
                    BufferedReader streamReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                    StringBuilder responseStrBuilder = new StringBuilder();

                    String inputStr;
                    while ((inputStr = streamReader.readLine()) != null) {
                        responseStrBuilder.append(inputStr);
                    }
                    String str = responseStrBuilder.toString();
                    JSONObject jsonObject = JSONObject.fromObject(str);
                    return jsonObject;
                } catch (Exception e) {
                    System.out.println("文件解析异常");
                }



                return null;
            }

        }
        return null;
    }
}
