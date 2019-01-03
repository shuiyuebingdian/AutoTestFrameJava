package com.example.test.api.alarm;

import com.alibaba.fastjson.JSONObject;
import com.example.test.common.Constants;
import com.example.test.conf.RealTimeAlarmInterfaceName;
import com.example.test.conf.UrlConfig;
import com.example.test.conf.VehicleInterfaceName;
import com.example.test.util.HttpUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 车辆列表查询测试用例
 */
public class AlarmCountTest {

    @Test
    public void alarmCount(){
        String url = UrlConfig.getRealTimeAlarmUrl(RealTimeAlarmInterfaceName.ALARM_COUNT);
        String response = HttpUtil.doGet(url , null, Constants.SESSIONID);
        Constants.TEST_CASE.get("alarmCount").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Assert.assertEquals(jsonObject.get("status"), 200);
        Assert.assertNotNull(jsonObject.get("alarm"));
        Assert.assertNotNull(jsonObject.get("fault"));
        Assert.assertNotNull(jsonObject.get("processed"));
        Assert.assertNotNull(jsonObject.get("unprocessed"));

    }


}
