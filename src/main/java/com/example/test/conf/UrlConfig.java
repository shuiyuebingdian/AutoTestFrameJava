package com.example.test.conf;

import java.util.Locale;
import java.util.ResourceBundle;

public class UrlConfig {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);
//    private static Config bundle = Config.getConfig();
    private static String address = bundle.getString("server_host");

    /**
     * 获取监控分析接口的地址
     * @param name
     * @return
     */
    public static String getMonitorUrl(MonitorInterfaceName name){
        //完整的测试地址
        StringBuilder url = new StringBuilder();
        url.append(address);

        switch (name){
            case SEARCH:
                url.append(bundle.getString("uri_monitor_search"));
                break;
            case VEHICLE:
                url.append(bundle.getString("uri_monitor_vehicle"));
                break;
            case GET_VEH_LOCATE:
                url.append(bundle.getString("uri_monitor_get_veh_locate"));
                break;
            case GET_STA_VEHICLE_NUM:
                url.append(bundle.getString("uri_monitor_get_sta_vehicle_num"));
                break;
            case EXPORT_VEHICLE_MONITOR:
                url.append(bundle.getString("uri_monitor_export_vehicle_monitor"));
                break;
            case GET_VEH_REALTIME_LOCATE:
                url.append(bundle.getString("uri_monitor_get_veh_realtime_locate"));
                break;
            case VEHICLE_REALTIME_MONITOR:
                url.append(bundle.getString("uri_monitor_vehicle_realtime_monitor"));
                break;
            case VEH_COUNT_PER_MONITOR_PLATFORM:
                url.append(bundle.getString("uri_monitor_veh_count_per_monitor_platform"));
                break;
            default:
                break;
        }
        return url.toString();
    }

    /**
     * 获取用户关注数据接口的地址
     * @param name
     * @return
     */
    public static String getUserFavorUrl(UserFavorInterfaceName name){
        //完整的测试地址
        StringBuilder url = new StringBuilder();
        url.append(address);

        switch (name){
            case CANCLE_FAVOR:

                url.append(bundle.getString("uri_monitor_user_cancle_favor"));
                break;
            case SET_FAVOR:
                url.append(bundle.getString("uri_monitor_user_set_favor"));
                break;
            case DATAITEMS:
                url.append(bundle.getString("uri_monitor_user_data_items"));
                break;
            default:
                break;
        }
        return url.toString();
    }

    /**
     * 获取实时报警监控接口的地址
     * @param name
     * @return
     */
    public static String getRealTimeAlarmUrl(RealTimeAlarmInterfaceName name){

        //完整的测试地址
        StringBuilder url = new StringBuilder();
        url.append(address);

        switch (name){
            case ALARM_COUNT:
                url.append(bundle.getString("uri_real_time_alarm_search"));
                break;
            case EXPORT:
                url.append(bundle.getString("uri_real_time_alarm_export"));
                break;
            case REAL_ALARM_COUNT:
                url.append(bundle.getString("uri_real_time_alarm_real_alarm_count"));
                break;
            case SEARCH:
                url.append(bundle.getString("uri_real_time_alarm_search"));
                break;

            default:
                break;
        }
        return url.toString();
    }

    /**
     * 获取车辆信息接口的地址
     * @param name
     * @return
     */
    public static String getVehicleUrl(VehicleInterfaceName name){
        //完整的测试地址
        StringBuilder url = new StringBuilder();
        url.append(address);

        switch (name){
            case EXPORT_VEHICLES:
                url.append(bundle.getString("uri_sys_vehicle_export_vehicles"));
                break;
            case VEHICLE:
                url.append(bundle.getString("uri_sys_vehicle_vehicle"));
                break;
            case GET_VIN_BY_LICENSE_PLATE:
                url.append(bundle.getString("uri_sys_vehicle_get_vin_by_license_plate"));
                break;
            case VEHICLES:
                url.append(bundle.getString("uri_sys_vehicle_vehicles"));
                break;
            default:
                break;
        }
        return url.toString();
    }
}
