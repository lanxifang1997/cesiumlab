package com.earthadmin.domain.entity;

import com.earthadmin.common.entity.BaseEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Administrator
 * @date 2020/11/27 10:09:37
 * @description
 */
@Getter
@Setter
@Table(name = "scene")
public class Scene extends BaseEntity {

    /**
     * sceneTree : {"root":{"title":"影像","children":[{"title":"地图","children":[{"czmObject":{"xbsjType":"Imagery","xbsjGuid":"3b97edd5-a9dd-43a4-9952-6523e2cf61aa","name":"谷歌影像&标注","xbsjImageryProvider":{"XbsjImageryProvider":{"url":"http://mt1.google.cn/vt/lyrs=s&x={x}&y={y}&z={z}"},"UrlTemplateImageryProvider":{},"WebMapTileServiceImageryProvider":{},"createTileMapServiceImageryProvider":{}}}}]}]}}
     * cameraViewManager : {"globe":{"position":[2.1031217486531677,0.5042461979915104,2.2191651019924622E7],"rotation":[0,-1.5704894508531937,0],"near":0.1,"far":10000000000},"china":{"position":[1.8770894704964525,0.662547523843314,8511735.797037361],"rotation":[0,-1.5701114159178209,0],"near":0.1,"far":10000000000},"lastView":{"position":[2.1031217486531673,0.5041488444338827,2.080359374891228E7],"rotation":[6.283185307179586,-1.570619506862022,0],"fov":1.0471975511965976,"near":0.1,"far":10000000000}}
     * cameraFlight : {"xbsjType":"CameraFlight","xbsjGuid":"e83641b4-1b9e-42e3-bcc8-f12f875cac05","rotateGlobe":{"xbsjType":"RotateGlobe","xbsjGuid":"53f8538b-0996-49d8-959a-519022090a3c","latitude":0.6632251157578453},"rotateCenter":{"xbsjType":"RotateCenter","xbsjGuid":"6d0e74b8-fa8e-4b34-b8b9-de1dd173d0c6","pitch":-0.5235987755982988},"track":{"xbsjType":"CameraTrack","xbsjGuid":"2b8bd4d2-f70a-4863-af57-1d9842feed7c"}}
     * weather : {"fog":{},"sun":{},"skyBox":{},"moon":{},"rain":{},"snow":{},"cloud":{},"atmosphere":{},"rainPostProcess":{},"snowPostProcess":{},"fogPostProcess":{}}
     * terrainEffect : {"elevation":{"xbsjType":"ElevationRamp","xbsjGuid":"17bf6e3b-446c-4174-9b5f-1fab2b5b325e"},"slope":{"xbsjType":"SlopeRamp","xbsjGuid":"503ccff3-800a-4a26-b5ad-e64182ae3c98"},"aspect":{"xbsjType":"AspectRamp","xbsjGuid":"1eea3205-56cd-4b05-90b9-9f5ebdc4ebab"},"contour":{},"restrict":{},"globeTranslucency":{}}
     * postProcess : {"xbsjType":"PostProcess","xbsjGuid":"320cdb6b-f255-4bd5-aa00-3eef6af4daed","ambientOcclusion":{"xbsjType":"AmbientOcclusionStage","xbsjGuid":"3e7944d1-26fb-42a0-ab13-733f84c041fb"},"bloom":{"xbsjType":"BloomStage","xbsjGuid":"a3786647-771f-4b89-a871-eb66c153faa7"},"blackAndWhite":{"xbsjType":"BlackAndWhiteStage","xbsjGuid":"e2755a5b-a46d-4814-a333-15167d9dfb0d"},"brightness":{"xbsjType":"BrightnessStage","xbsjGuid":"332e0059-3c6e-4e5f-8912-8b24006efc36"},"depthOfField":{"xbsjType":"DepthOfFieldStage","xbsjGuid":"56b1944f-ac53-49d6-a00e-1d6f20a3f4f8"},"lensFlare":{"xbsjType":"LensFlareStage","xbsjGuid":"b43df682-a6a2-4dfa-8155-ab10347fabaa"},"mosaic":{"xbsjType":"MosaicStage","xbsjGuid":"f6b8087a-a81a-4294-8117-2d449c2acda4"},"nightVision":{"xbsjType":"NightVisionStage","xbsjGuid":"0cfbb007-376d-465b-86dd-8520a2a35007"},"silhouette":{"xbsjType":"XbsSilhouetteStage","xbsjGuid":"849dae94-c0c0-45c0-9441-4bb13aa92d9a"}}
     * effect : {"xbsjType":"Effect","xbsjGuid":"7a886fbd-b3b2-4af6-9857-03f27cae2707","shadow":{"xbsjType":"Shadow","xbsjGuid":"73194c17-d77c-4b6a-862d-61e26270b1ca"},"forceSunPos":{"position":[2.0245819323134224,0.6981317007977318,10000000]}}
     */
//    @Column(name = "id",type = MySqlTypeConstant.VARCHAR,length = 45,isKey = true,isNull = false)
//    private String id;
//
//    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 45)
//    private String name;
//
//    @Column(name = "desc",type = MySqlTypeConstant.TEXT)
//    private String desc;

    @Column(name = "content",type = MySqlTypeConstant.TEXT)
    private String content;

//    @Column(name = "thumbnail",type = MySqlTypeConstant.TEXT)
//    private String thumbnail;
//
//    @Column(name = "date",type = MySqlTypeConstant.DATETIME)
//    private String date;

    @Column(name = "udate",type = MySqlTypeConstant.DATETIME)
    private String udate;

}
