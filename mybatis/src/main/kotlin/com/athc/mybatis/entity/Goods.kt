package com.athc.mybatis.entity

import java.math.BigDecimal
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
@ApiModel(value = "Goods对象", description = "")
class Goods : Serializable {


  @TableId(value = "id", type = IdType.AUTO)
  var id: Long? = null

  @ApiModelProperty(value = "总量")
  var amount: BigDecimal? = null


  override fun toString(): String {
    return "Goods{" +
        "id=" + id +
        ", amount=" + amount +
        "}"
  }
}
