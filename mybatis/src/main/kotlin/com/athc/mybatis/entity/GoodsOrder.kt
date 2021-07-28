package com.athc.mybatis.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import java.io.Serializable
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 
 * </p>
 *
 * @author jjj
 * @since 2020-09-16
 */
@ApiModel(value="GoodsOrder对象", description="")
class GoodsOrder : Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    var id: Long? = null

        @ApiModelProperty(value = "订单号")
    var orderId: String? = null

        @ApiModelProperty(value = "商品id")
    var goodsId: Long? = null


    override fun toString(): String {
        return "GoodsOrder{" +
        "id=" + id +
        ", orderId=" + orderId +
        ", goodsId=" + goodsId +
        "}"
    }
}
