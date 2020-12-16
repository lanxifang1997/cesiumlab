package com.earthadmin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lanxifang
 * @date 2020/12/1 0001 16:54:08
 */
@Getter
@Setter
@NoArgsConstructor
public class ResultEntity extends HashMap<String,Object> implements Serializable {

    /** 状态码 */
    public static final String STATUS_TAG = "status";

    /** 返回ID */
    public static final String ID_TAG = "id";

//    /** 返回场景 */
//    public static final String SCENES_TAG = "scenes";
//
//    /** 返回模型 */
//    public static final String MODELS_TAG = "models";

    public static final String ROWS_TAG = "rows";

    public static final String MSG_TAG = "msg";

    /** 参数错误 */
    public static final String PARAM_ERROR_TAG = "param error";

//    /** 数据对象 */
//    public static String DATA_TAG;

    public ResultEntity(String status){
        super.put(STATUS_TAG, status);
    }


    /** 不传参数直接返回一个status */
    public static ResultEntity success(){
        return new ResultEntity(HttpStatus.OK.getReasonPhrase().toLowerCase());
    }

    public static ResultEntity error(){
        return new ResultEntity(PARAM_ERROR_TAG);
    }

    public static ResultEntity error(String msg){
        ResultEntity resultEntity = new ResultEntity(PARAM_ERROR_TAG);
        resultEntity.put(MSG_TAG,msg);
        return resultEntity;
    }

    /** 传入String和key */
    public static ResultEntity success(String id,String key){
        ResultEntity resultEntity = ResultEntity.success();
        resultEntity.put(key,id);
        return resultEntity;
    }

    /** 传String的话判断为id */
    public static ResultEntity success(String id){
        ResultEntity resultEntity = ResultEntity.success();
        resultEntity.put(ID_TAG,id);
        return resultEntity;
    }

    public static ResultEntity success(List list,String key){
        ResultEntity resultEntity = ResultEntity.success();
        resultEntity.put(key,setObject(list));

        return resultEntity;
    }

    /** 把对象放进 list 再把 list放进 map里,key为rows  */
    public static Map<String,Object> setObject(List list){

        Map map = new HashMap();
        map.put(ROWS_TAG,list);
        return map;
    }


}
