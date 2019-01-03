package com.example.test.api.alarm;

import com.alibaba.fastjson.JSONObject;
import com.example.test.common.Constants;
import com.example.test.conf.RealTimeAlarmInterfaceName;
import com.example.test.conf.UrlConfig;
import com.example.test.util.HttpUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RealAlarmCountTest {

    @Test
    public void realAlarmCount(){
        String url = UrlConfig.getRealTimeAlarmUrl(RealTimeAlarmInterfaceName.REAL_ALARM_COUNT);
        String response = HttpUtil.doGet(url , null, Constants.SESSIONID);
        Constants.TEST_CASE.get("realAlarmCount").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Assert.assertEquals(jsonObject.get("status"), 200);
        Assert.assertNotNull(jsonObject.get("data"));
    }
}
