import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Map;

public class CouponCommodityService implements ICommodity{
    private Logger logger = LoggerFactory.getLogger(CouponCommodityService.class);

    private CouponCommodityService couponService = new CouponCommodityService();
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> exMap) throws Exception {
        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        logger.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));
        if (!"0000".equals(couponResult.getCode())) throw new RuntimeException(couponResult.getInfo());
    }
}
