package com.ymy.shiro.bo;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 通用返回对象
 * Created by macro on 2019/4/19.
 */
@Data
@Builder
@ApiModel(description = "返回的实体类")
public class BoUtil {

    @ApiModelProperty(value = "code 0:成功  -1：失败 -2：失败（需要提示）")
    private Integer code;

    @ApiModelProperty(value = "提示消息")
    private String message;

    @ApiModelProperty(value = "具体内容")
    private Object data;

    private boolean result;



    /**
     * 失败
     * @return
     */
    public static BoUtil getDefaultFailed(){
        return BoUtil.builder().result(false).code(1).message("失败").data(null).build();
    }


    /**
     * 成功
     * @return
     */
    public static BoUtil getDefaultTrue(){
        return BoUtil.builder().result(true).code(2).message("成功").data(null).build();
    }




}
