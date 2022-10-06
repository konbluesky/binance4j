package com.binance4j.margin.dto;

import com.binance4j.margin.param.TakeProfitLimitOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Isolated margin fee.
 *
 * @param vipLevel VIP level.
 * @param symbol   Related symbol.
 * @param leverage Leverage.
 * @param data     Isolated fee data.
 */
@ApiModel("Isolated margin fee.")
public record IsolatedFee(@ApiModelProperty("VIP level.") int vipLevel, @ApiModelProperty("Related symbol.") String symbol,
                          @ApiModelProperty("Leverage.") String leverage, @ApiModelProperty("Isolated fee data.") List<IsolatedFeeData> data) {

    /**
     * <p>
     * Obtain assets other than BUSD and USDT
     * </p>
     *
     * @return  An instance of {@link IsolatedFeeData}.
     */
    public IsolatedFeeData getUseAsset() {
        return data.stream()
                   .filter(f -> !f.coin().equalsIgnoreCase("busd"))
                   .filter(f -> !f.coin().equalsIgnoreCase("usdt"))
//                   .filter(f -> !f.coin().equalsIgnoreCase("btc"))
                   .findFirst().orElse(new IsolatedFeeData("Not Fount","-1","-1"));
    }
}