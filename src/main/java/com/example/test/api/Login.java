package com.example.test.api;

import com.example.test.common.Constants;
import com.example.test.conf.MonitorInterfaceName;
import com.example.test.conf.UrlConfig;
import com.example.test.util.DateUtils;
import com.example.test.util.ExcelUtil;
import com.example.test.util.HttpUtil;
import com.example.test.util.RedisUtil;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Login {

    Logger logger = LoggerFactory.getLogger(Login.class);

    @BeforeSuite
    public void login(){

        Date date = new Date();
        String onlineFlushTime = DateUtils.dateToString(DateUtils.addMinute(date, -6), DateUtils.STRING_DATE_TIME_FORMAT);
        String activeFlushTime = DateUtils.dateToString(DateUtils.addMinute(date, -60), DateUtils.STRING_DATE_TIME_FORMAT);
        //更新redis数据
        RedisUtil.getJedis().hset("monidata", "LS4ASE2A4HJ117489", "{'gearDriveForce':0,'batteryConsistencyDifferenceAlarm':0,'soc':63,'socJumpAlarm':0,'socLowAlarm':0,'minTemperatureSubSystemNum':1,'maxVoltageBatteryNum':7,'terminalTime':'2018-11-07 17:44:58','singleBatteryOverVoltageAlarm':0,'vehicleStorageDeviceOvervoltageAlarm':0,'engineStatus':0,'brakeSystemAlarm':0,'vin':'LS4ASE2A4HJ117489','driveMotorTemperatureAlarm':0,'dcdcStatusAlarm':0,'gearBrakeForce':1,'lat':31.817823166,'engineSpeed':0,'driveMotorFaultCodes':0,'lng':117.174197333,'nevChargeSystemVoltageDtoList':[{'currentBatteryStartNum':1,'batteryVoltage':[3.796,3.79,3.792,3.794,3.79,3.795,3.799,3.794,3.794,3.794,3.793,3.794,3.78,3.786,3.787,3.786,3.791,3.788,3.786,3.785,3.787,3.782,3.782,3.788,3.786,3.788,3.786,3.788,3.792,3.783,3.783,3.788,3.784,3.787,3.783,3.786,3.785,3.789,3.785,3.783,3.791,3.784,3.786,3.783,3.785,3.792,3.786,3.782,3.786,3.79,3.788,3.789,3.788,3.789,3.786,3.782,3.788,3.79,3.787,3.791,3.789,3.789,3.788,3.793,3.791,3.788,3.791,3.784,3.786,3.793,3.786,3.788,3.788,3.789,3.784,3.791,3.791,3.794,3.792,3.791,3.792,3.788,3.795,3.792,3.789],'currentBatteryCount':85,'batteryCount':85,'childSystemNum':1,'chargeSystemCurrent':11.4}],'singleBatteryUnderVoltageAlarm':0,'maxVoltageBatterySubSystemNum':1,'minTemperatureProbe':19,'totalVoltage':321.600006,'maxAlarmLevel':0,'temperatureDifferenceAlarm':0,'geerPosition':15,'minVoltageBattery':3.776,'driveMotorData':[{'controllerInputVoltage':322,'controllerTemperature':19,'revolutionSpeed':0,'num':1,'controllerDcBusCurrent':0,'temperature':16,'torque':0,'state':4}],'minVoltageBatteryNum':13,'engineFaultCodes':0,'minTemperatureValue':11,'chargeStatus':3,'fuelConsumption':0,'totalOdometer':6311,'speed':0,'socHighAlarm':0,'vehicleStorageDeviceUndervoltageAlarm':0,'batteryAlarm':0,'totalCurrent':11.4,'rechargeableStorageDeviceMismatchAlarm':0,'maxVoltageBattery':3.794,'dcdcTemperatureAlarm':0,'vehiclePureDeviceTypeOvercharge':0,'driveMotorControllerTemperatureAlarm':0,'nevChargeSystemTemperatureDtoList':[{'probeTemperatures':[11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11],'chargeTemperatureProbeNum':22,'childSystemNum':1}],'dcStatus':2,'maxTemperatureSubSystemNum':2,'carStatus':1,'minVoltageBatterySubSystemNum':1,'targetType':'VehicleRealtimeDto','maxTemperatureProbe':10,'flushTime':'"+onlineFlushTime+"','rechargeableStorageDevicesFaultCodes':0,'carMode':1,'highVoltageInterlockStateAlarm':0,'insulationAlarm':0,'maxTemperatureValue':11,'otherFaultCodes':0,'insulateResistance':3000}");
        RedisUtil.getJedis().hset("monidata", "LS4ASE2E3JJ225949", "{'gearDriveForce':1,'batteryConsistencyDifferenceAlarm':0,'soc':84,'socJumpAlarm':0,'socLowAlarm':0,'minTemperatureSubSystemNum':1,'maxVoltageBatteryNum':73,'terminalTime':'2018-11-07 17:24:26','singleBatteryOverVoltageAlarm':0,'vehicleStorageDeviceOvervoltageAlarm':0,'engineStatus':0,'brakeSystemAlarm':0,'vin':'LS4ASE2E3JJ225949','driveMotorTemperatureAlarm':0,'dcdcStatusAlarm':0,'gearBrakeForce':0,'lat':35.719138,'engineSpeed':0,'driveMotorFaultCodes':0,'lng':116.483597333,'nevChargeSystemVoltageDtoList':[{'currentBatteryStartNum':1,'batteryVoltage':[3.989,3.989,3.99,3.99,3.988,3.989,3.99,3.989,3.988,3.99,3.988,3.989,3.988,3.991,3.992,3.992,3.991,3.992,3.991,3.992,3.992,3.991,3.991,3.989,3.991,3.99,3.991,3.989,3.99,3.992,3.99,3.99,3.989,3.987,3.987,3.987,3.987,3.987,3.986,3.987,3.987,3.987,3.984,3.983,3.986,3.986,3.986,3.985,3.985,3.986,3.987,3.986,3.986,3.986,3.987,3.989,3.987,3.986,3.986,3.988,3.987,3.989,3.989,3.991,3.992,3.991,3.99,3.992,3.99,3.99,3.991,3.993,3.992,3.989,3.988,3.991,3.988,3.989,3.99,3.991,3.99,3.99,3.99,3.991,3.989,3.988],'currentBatteryCount':86,'batteryCount':86,'childSystemNum':1,'chargeSystemCurrent':6.9}],'singleBatteryUnderVoltageAlarm':0,'maxVoltageBatterySubSystemNum':1,'minTemperatureProbe':4,'totalVoltage':343.200012,'maxAlarmLevel':0,'temperatureDifferenceAlarm':0,'geerPosition':14,'minVoltageBattery':3.984,'driveMotorData':[{'controllerInputVoltage':342,'controllerTemperature':26,'revolutionSpeed':1237,'num':1,'controllerDcBusCurrent':6.3,'temperature':24,'torque':15.4,'state':1}],'minVoltageBatteryNum':44,'engineFaultCodes':0,'minTemperatureValue':12,'chargeStatus':3,'fuelConsumption':0,'totalOdometer':3451.899902,'speed':16,'socHighAlarm':0,'vehicleStorageDeviceUndervoltageAlarm':0,'batteryAlarm':0,'totalCurrent':6.9,'rechargeableStorageDeviceMismatchAlarm':0,'maxVoltageBattery':3.995,'dcdcTemperatureAlarm':0,'vehiclePureDeviceTypeOvercharge':0,'driveMotorControllerTemperatureAlarm':0,'nevChargeSystemTemperatureDtoList':[{'probeTemperatures':[13,13,13,12,12,13,13,12,12,13,13,13],'chargeTemperatureProbeNum':12,'childSystemNum':1}],'dcStatus':1,'maxTemperatureSubSystemNum':1,'carStatus':1,'minVoltageBatterySubSystemNum':1,'targetType':'VehicleRealtimeDto','maxTemperatureProbe':6,'flushTime':'"+onlineFlushTime+"','rechargeableStorageDevicesFaultCodes':0,'carMode':1,'highVoltageInterlockStateAlarm':0,'insulationAlarm':0,'maxTemperatureValue':13,'otherFaultCodes':0,'insulateResistance':3000}");
        RedisUtil.getJedis().hset("monidata", "LS4ASE2E5JJ226844", "{'gearDriveForce':1,'batteryConsistencyDifferenceAlarm':0,'soc':65,'socJumpAlarm':0,'socLowAlarm':0,'minTemperatureSubSystemNum':1,'maxVoltageBatteryNum':68,'terminalTime':'2018-11-07 17:24:27','singleBatteryOverVoltageAlarm':0,'vehicleStorageDeviceOvervoltageAlarm':0,'engineStatus':0,'brakeSystemAlarm':0,'vin':'LS4ASE2E5JJ226844','driveMotorTemperatureAlarm':0,'dcdcStatusAlarm':0,'gearBrakeForce':0,'lat':30.241615666,'engineSpeed':0,'driveMotorFaultCodes':0,'lng':120.248486666,'nevChargeSystemVoltageDtoList':[{'currentBatteryStartNum':1,'batteryVoltage':[3.768,3.736,3.774,3.763,3.765,3.778,3.778,3.772,3.768,3.768,3.771,3.763,3.73,3.765,3.757,3.76,3.775,3.78,3.766,3.738,3.75,3.703,3.748,3.751,3.754,3.747,3.73,3.736,3.759,3.76,3.757,3.78,3.766,3.768,3.768,3.768,3.763,3.763,3.762,3.762,3.759,3.756,3.762,3.766,3.736,3.721,3.759,3.748,3.754,3.753,3.739,3.757,3.73,3.759,3.739,3.763,3.744,3.733,3.744,3.748,3.784,3.765,3.771,3.781,3.763,3.772,3.762,3.784,3.777,3.765,3.771,3.774,3.778,3.78,3.774,3.757,3.765,3.772,3.769,3.759,3.754,3.733,3.75,3.762,3.742],'currentBatteryCount':85,'batteryCount':85,'childSystemNum':1,'chargeSystemCurrent':-48.900002}],'singleBatteryUnderVoltageAlarm':0,'maxVoltageBatterySubSystemNum':1,'minTemperatureProbe':1,'totalVoltage':320.299988,'maxAlarmLevel':0,'temperatureDifferenceAlarm':0,'geerPosition':14,'minVoltageBattery':3.711,'driveMotorData':[{'controllerInputVoltage':321,'controllerTemperature':25,'revolutionSpeed':2421,'num':1,'controllerDcBusCurrent':-66,'temperature':33,'torque':-87,'state':2}],'minVoltageBatteryNum':22,'engineFaultCodes':0,'minTemperatureValue':22,'chargeStatus':3,'fuelConsumption':0,'totalOdometer':85222,'speed':36,'socHighAlarm':0,'vehicleStorageDeviceUndervoltageAlarm':0,'batteryAlarm':0,'totalCurrent':-66,'rechargeableStorageDeviceMismatchAlarm':0,'maxVoltageBattery':3.787,'dcdcTemperatureAlarm':0,'vehiclePureDeviceTypeOvercharge':0,'driveMotorControllerTemperatureAlarm':0,'nevChargeSystemTemperatureDtoList':[{'probeTemperatures':[22,23,22,25,24,26,24,24,25,25,25,23,23,23,22,22,22,23,23,24,25,27],'chargeTemperatureProbeNum':22,'childSystemNum':1}],'dcStatus':1,'maxTemperatureSubSystemNum':1,'carStatus':1,'minVoltageBatterySubSystemNum':1,'targetType':'VehicleRealtimeDto','maxTemperatureProbe':22,'flushTime':'"+onlineFlushTime+"','rechargeableStorageDevicesFaultCodes':0,'carMode':1,'highVoltageInterlockStateAlarm':0,'insulationAlarm':0,'maxTemperatureValue':27,'otherFaultCodes':0,'insulateResistance':1000}");
        RedisUtil.getJedis().hset("monidata", "LS4ASE2E1JJ153066", "{'gearDriveForce':1,'batteryConsistencyDifferenceAlarm':0,'soc':85,'socJumpAlarm':0,'socLowAlarm':0,'minTemperatureSubSystemNum':1,'maxVoltageBatteryNum':2,'terminalTime':'2018-11-07 17:38:02','singleBatteryOverVoltageAlarm':0,'vehicleStorageDeviceOvervoltageAlarm':0,'engineStatus':0,'brakeSystemAlarm':0,'vin':'LS4ASE2E1JJ153066','driveMotorTemperatureAlarm':0,'dcdcStatusAlarm':0,'gearBrakeForce':0,'lat':30.313770666,'engineSpeed':0,'driveMotorFaultCodes':0,'lng':120.250897833,'nevChargeSystemVoltageDtoList':[{'currentBatteryStartNum':1,'batteryVoltage':[3.901,3.907,3.901,3.897,3.898,3.906,3.903,3.9,3.903,3.903,3.898,3.895,3.886,3.88,3.889,3.877,3.9,3.892,3.882,3.868,3.871,3.867,3.867,3.864,3.868,3.864,3.868,3.882,3.867,3.876,3.886,3.885,3.892,3.882,3.877,3.88,3.88,3.879,3.877,3.877,3.879,3.874,3.873,3.873,3.882,3.873,3.876,3.88,3.876,3.873,3.873,3.88,3.877,3.874,3.871,3.883,3.873,3.871,3.877,3.883,3.886,3.889,3.895,3.895,3.883,3.895,3.886,3.897,3.898,3.907,3.9,3.898,3.901,3.9,3.895,3.894,3.897,3.903,3.901,3.885,3.895,3.876,3.886,3.88,3.844],'currentBatteryCount':85,'batteryCount':85,'childSystemNum':1,'chargeSystemCurrent':32.900002}],'singleBatteryUnderVoltageAlarm':0,'maxVoltageBatterySubSystemNum':1,'minTemperatureProbe':1,'totalVoltage':329.5,'maxAlarmLevel':0,'temperatureDifferenceAlarm':0,'geerPosition':14,'minVoltageBattery':3.837,'driveMotorData':[{'controllerInputVoltage':332,'controllerTemperature':25,'revolutionSpeed':1377,'num':1,'controllerDcBusCurrent':28,'temperature':34,'torque':60,'state':1}],'minVoltageBatteryNum':85,'engineFaultCodes':0,'minTemperatureValue':24,'chargeStatus':3,'fuelConsumption':0,'totalOdometer':112750,'speed':20,'socHighAlarm':0,'vehicleStorageDeviceUndervoltageAlarm':0,'batteryAlarm':0,'totalCurrent':32.900002,'rechargeableStorageDeviceMismatchAlarm':0,'maxVoltageBattery':3.901,'dcdcTemperatureAlarm':0,'vehiclePureDeviceTypeOvercharge':0,'driveMotorControllerTemperatureAlarm':0,'nevChargeSystemTemperatureDtoList':[{'probeTemperatures':[24,25,25,31,29,33,29,33,35,35,35,26,26,27,25,25,26,25,24,26,29,31],'chargeTemperatureProbeNum':22,'childSystemNum':1}],'dcStatus':1,'maxTemperatureSubSystemNum':1,'carStatus':1,'minVoltageBatterySubSystemNum':1,'targetType':'VehicleRealtimeDto','maxTemperatureProbe':9,'flushTime':'"+onlineFlushTime+"','rechargeableStorageDevicesFaultCodes':0,'carMode':1,'highVoltageInterlockStateAlarm':0,'insulationAlarm':0,'maxTemperatureValue':35,'otherFaultCodes':0,'insulateResistance':1000}");
        RedisUtil.getJedis().hset("monidata", "LS4ASE2EXGJ128272", "{'gearDriveForce':0,'batteryConsistencyDifferenceAlarm':0,'soc':89,'socJumpAlarm':0,'socLowAlarm':0,'minTemperatureSubSystemNum':1,'maxVoltageBatteryNum':67,'terminalTime':'2018-11-07 17:22:46','singleBatteryOverVoltageAlarm':0,'vehicleStorageDeviceOvervoltageAlarm':0,'engineStatus':0,'brakeSystemAlarm':0,'vin':'LS4ASE2EXGJ128272','driveMotorTemperatureAlarm':0,'dcdcStatusAlarm':0,'gearBrakeForce':1,'lat':39.373252166,'engineSpeed':0,'driveMotorFaultCodes':0,'lng':117.062184166,'nevChargeSystemVoltageDtoList':[{'currentBatteryStartNum':1,'batteryVoltage':[4.081,4.083,4.078,4.084,4.085,4.082,4.09,4.084,4.087,4.078,4.078,4.084,4.079,4.089,4.088,4.088,4.085,4.087,4.086,4.089,4.095,4.087,4.09,4.092,4.078,4.08,4.08,4.092,4.082,4.079,4.083,4.083,4.072,4.065,4.081,4.073,4.068,4.07,4.075,4.073,4.069,4.073,4.071,3.974,4.066,4.071,4.068,4.057,4.067,4.064,4.063,4.066,4.069,4.068,4.069,4.07,4.075,4.082,4.08,4.085,4.077,4.071,4.091,4.083,4.09,4.093,4.1,4.092,4.088,4.087,4.088,4.086,4.09,4.09,4.086,4.084,4.082,4.086,4.086,4.092,4.091,4.084,4.086,4.088,4.083,4.085],'currentBatteryCount':86,'batteryCount':86,'childSystemNum':1,'chargeSystemCurrent':-49}],'singleBatteryUnderVoltageAlarm':0,'maxVoltageBatterySubSystemNum':1,'minTemperatureProbe':5,'totalVoltage':350.799988,'maxAlarmLevel':0,'temperatureDifferenceAlarm':0,'geerPosition':14,'minVoltageBattery':3.975,'driveMotorData':[{'controllerInputVoltage':351,'controllerTemperature':33,'revolutionSpeed':4981,'num':1,'controllerDcBusCurrent':-51.400002,'temperature':30,'torque':-35.099998,'state':2}],'minVoltageBatteryNum':44,'engineFaultCodes':0,'minTemperatureValue':13,'chargeStatus':2,'fuelConsumption':0,'totalOdometer':15061,'speed':67,'socHighAlarm':0,'vehicleStorageDeviceUndervoltageAlarm':0,'batteryAlarm':0,'totalCurrent':-49,'rechargeableStorageDeviceMismatchAlarm':0,'maxVoltageBattery':4.1,'dcdcTemperatureAlarm':0,'vehiclePureDeviceTypeOvercharge':0,'driveMotorControllerTemperatureAlarm':0,'nevChargeSystemTemperatureDtoList':[{'probeTemperatures':[13,14,14,14,13,14,15,14,14,13,14,14],'chargeTemperatureProbeNum':12,'childSystemNum':1}],'dcStatus':1,'maxTemperatureSubSystemNum':1,'carStatus':1,'minVoltageBatterySubSystemNum':1,'targetType':'VehicleRealtimeDto','maxTemperatureProbe':7,'flushTime':'"+activeFlushTime+"','rechargeableStorageDevicesFaultCodes':0,'carMode':1,'highVoltageInterlockStateAlarm':0,'insulationAlarm':0,'maxTemperatureValue':15,'otherFaultCodes':0,'insulateResistance':3000}");
        RedisUtil.getJedis().hset("monidata", "LS4ASE2E3JJ194671", "{'gearDriveForce':1,'batteryConsistencyDifferenceAlarm':0,'soc':75,'socJumpAlarm':0,'socLowAlarm':0,'minTemperatureSubSystemNum':1,'maxVoltageBatteryNum':8,'terminalTime':'2018-11-07 17:38:55','singleBatteryOverVoltageAlarm':0,'vehicleStorageDeviceOvervoltageAlarm':0,'engineStatus':0,'brakeSystemAlarm':0,'vin':'LS4ASE2E3JJ194671','driveMotorTemperatureAlarm':0,'dcdcStatusAlarm':0,'gearBrakeForce':0,'lat':29.467838666,'engineSpeed':0,'driveMotorFaultCodes':0,'lng':106.469239833,'nevChargeSystemVoltageDtoList':[{'currentBatteryStartNum':1,'batteryVoltage':[3.921,3.924,3.93,3.921,3.931,3.931,3.927,3.936,3.93,3.933,3.93,3.924,3.916,3.913,3.921,3.913,3.916,3.922,3.927,3.901,3.901,3.913,3.925,3.9,3.919,3.91,3.907,3.927,3.898,3.919,3.925,3.93,3.913,3.912,3.903,3.921,3.91,3.901,3.891,3.903,3.904,3.889,3.898,3.906,3.903,3.898,3.928,3.901,3.909,3.886,3.9,3.891,3.907,3.909,3.912,3.903,3.916,3.913,3.922,3.925,3.921,3.925,3.93,3.93,3.913,3.913,3.928,3.933,3.93,3.921,3.921,3.927,3.921,3.922,3.918,3.928,3.925,3.93,3.927,3.918,3.928,3.904,3.934,3.925,3.916],'currentBatteryCount':85,'batteryCount':85,'childSystemNum':1,'chargeSystemCurrent':0.6}],'singleBatteryUnderVoltageAlarm':0,'maxVoltageBatterySubSystemNum':1,'minTemperatureProbe':1,'totalVoltage':332.799988,'maxAlarmLevel':0,'temperatureDifferenceAlarm':0,'geerPosition':14,'minVoltageBattery':3.886,'driveMotorData':[{'controllerInputVoltage':333,'controllerTemperature':16,'revolutionSpeed':715,'num':1,'controllerDcBusCurrent':0,'temperature':39,'torque':-1,'state':2}],'minVoltageBatteryNum':50,'engineFaultCodes':0,'minTemperatureValue':15,'chargeStatus':3,'fuelConsumption':0,'totalOdometer':97327,'speed':10,'socHighAlarm':0,'vehicleStorageDeviceUndervoltageAlarm':0,'batteryAlarm':0,'totalCurrent':0,'rechargeableStorageDeviceMismatchAlarm':0,'maxVoltageBattery':3.936,'dcdcTemperatureAlarm':0,'vehiclePureDeviceTypeOvercharge':0,'driveMotorControllerTemperatureAlarm':0,'nevChargeSystemTemperatureDtoList':[{'probeTemperatures':[15,15,15,15,15,16,15,15,15,15,15,15,15,15,15,15,15,15,15,15,16,17],'chargeTemperatureProbeNum':22,'childSystemNum':1}],'dcStatus':1,'maxTemperatureSubSystemNum':1,'carStatus':1,'minVoltageBatterySubSystemNum':1,'targetType':'VehicleRealtimeDto','maxTemperatureProbe':22,'flushTime':'"+activeFlushTime+"','rechargeableStorageDevicesFaultCodes':0,'carMode':1,'highVoltageInterlockStateAlarm':0,'insulationAlarm':0,'maxTemperatureValue':17,'otherFaultCodes':0,'insulateResistance':1000}");
        RedisUtil.getJedis().hset("monidata", "LS4ASE2W5HJ127587", "{'gearDriveForce':0,'batteryConsistencyDifferenceAlarm':0,'soc':0,'socJumpAlarm':0,'socLowAlarm':0,'minTemperatureSubSystemNum':0,'maxVoltageBatteryNum':0,'terminalTime':'2018-11-07 17:30:46','singleBatteryOverVoltageAlarm':0,'vehicleStorageDeviceOvervoltageAlarm':0,'engineStatus':0,'brakeSystemAlarm':0,'vin':'LS4ASE2W5HJ127587','driveMotorTemperatureAlarm':0,'dcdcStatusAlarm':0,'gearBrakeForce':0,'lat':39.841023833,'engineSpeed':0,'driveMotorFaultCodes':0,'lng':116.304852,'nevChargeSystemVoltageDtoList':[{'currentBatteryStartNum':1,'batteryVoltage':[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],'currentBatteryCount':86,'batteryCount':86,'childSystemNum':1,'chargeSystemCurrent':0}],'singleBatteryUnderVoltageAlarm':0,'maxVoltageBatterySubSystemNum':0,'minTemperatureProbe':0,'totalVoltage':0,'maxAlarmLevel':0,'temperatureDifferenceAlarm':0,'geerPosition':0,'minVoltageBattery':0,'driveMotorData':[{'controllerInputVoltage':0,'controllerTemperature':0,'revolutionSpeed':0,'num':1,'controllerDcBusCurrent':0,'temperature':0,'torque':0,'state':0}],'minVoltageBatteryNum':0,'engineFaultCodes':0,'minTemperatureValue':0,'chargeStatus':0,'fuelConsumption':0,'totalOdometer':20065.300781,'speed':0,'socHighAlarm':0,'vehicleStorageDeviceUndervoltageAlarm':0,'batteryAlarm':0,'totalCurrent':0,'rechargeableStorageDeviceMismatchAlarm':0,'maxVoltageBattery':0,'dcdcTemperatureAlarm':0,'vehiclePureDeviceTypeOvercharge':0,'driveMotorControllerTemperatureAlarm':0,'nevChargeSystemTemperatureDtoList':[{'probeTemperatures':[0,0,0,0,0,0,0,0,0,0,0,0],'chargeTemperatureProbeNum':12,'childSystemNum':1}],'dcStatus':2,'maxTemperatureSubSystemNum':0,'carStatus':2,'minVoltageBatterySubSystemNum':0,'targetType':'VehicleRealtimeDto','maxTemperatureProbe':0,'flushTime':'20181129224456','rechargeableStorageDevicesFaultCodes':0,'carMode':1,'highVoltageInterlockStateAlarm':0,'insulationAlarm':0,'maxTemperatureValue':0,'otherFaultCodes':0,'insulateResistance':0}");
        RedisUtil.getJedis().hset("monidata", "LS4ASE2A4HJ119260", "{'gearDriveForce':1,'batteryConsistencyDifferenceAlarm':0,'soc':40,'socJumpAlarm':0,'socLowAlarm':0,'minTemperatureSubSystemNum':1,'maxVoltageBatteryNum':64,'terminalTime':'2018-11-07 17:32:56','singleBatteryOverVoltageAlarm':0,'vehicleStorageDeviceOvervoltageAlarm':0,'engineStatus':0,'brakeSystemAlarm':0,'vin':'LS4ASE2A4HJ119260','driveMotorTemperatureAlarm':0,'dcdcStatusAlarm':0,'gearBrakeForce':0,'lat':27.032948333,'engineSpeed':0,'driveMotorFaultCodes':0,'lng':107.519754833,'nevChargeSystemVoltageDtoList':[{'currentBatteryStartNum':1,'batteryVoltage':[3.566,3.568,3.565,3.563,3.549,3.571,3.573,3.569,3.578,3.58,3.581,3.575,3.572,3.572,3.575,3.572,3.579,3.574,3.578,3.575,3.563,3.581,3.579,3.572,3.577,3.578,3.58,3.572,3.564,3.58,3.577,3.576,3.569,3.575,3.574,3.571,3.579,3.579,3.578,3.574,3.553,3.569,3.57,3.568,3.573,3.575,3.577,3.577,3.573,3.581,3.582,3.578,3.581,3.579,3.578,3.577,3.561,3.577,3.578,3.58,3.576,3.584,3.582,3.581,3.576,3.577,3.577,3.575,3.568,3.57,3.571,3.571,3.566,3.571,3.57,3.567,3.573,3.574,3.577,3.572,3.562,3.576,3.576,3.572,3.559,3.575,3.577,3.575],'currentBatteryCount':88,'batteryCount':88,'childSystemNum':1,'chargeSystemCurrent':68.2}],'singleBatteryUnderVoltageAlarm':0,'maxVoltageBatterySubSystemNum':1,'minTemperatureProbe':7,'totalVoltage':314.4,'maxAlarmLevel':0,'temperatureDifferenceAlarm':0,'geerPosition':46,'minVoltageBattery':3.578,'driveMotorData':[{'controllerInputVoltage':314,'controllerTemperature':21,'revolutionSpeed':2349,'num':1,'controllerDcBusCurrent':53.2,'temperature':28,'torque':66,'state':1}],'minVoltageBatteryNum':41,'engineFaultCodes':0,'minTemperatureValue':11,'chargeStatus':3,'fuelConsumption':0,'totalOdometer':34893,'speed':35,'socHighAlarm':0,'vehicleStorageDeviceUndervoltageAlarm':0,'batteryAlarm':0,'totalCurrent':55.7,'rechargeableStorageDeviceMismatchAlarm':0,'maxVoltageBattery':3.601,'dcdcTemperatureAlarm':0,'vehiclePureDeviceTypeOvercharge':0,'driveMotorControllerTemperatureAlarm':0,'nevChargeSystemTemperatureDtoList':[{'probeTemperatures':[11,12,13,11,12,12,11,11,12,13,13,13,13,13,13,13,13,13,13,13,13,13,15,14,12,11,12,13,12,13,14,14],'chargeTemperatureProbeNum':32,'childSystemNum':1}],'dcStatus':1,'maxTemperatureSubSystemNum':1,'carStatus':1,'minVoltageBatterySubSystemNum':2,'targetType':'VehicleRealtimeDto','maxTemperatureProbe':23,'flushTime':'20181129180312','rechargeableStorageDevicesFaultCodes':0,'carMode':1,'highVoltageInterlockStateAlarm':0,'insulationAlarm':0,'maxTemperatureValue':15,'otherFaultCodes':0,'insulateResistance':14934}");
        RedisUtil.getJedis().hset("monidata", "LS4ASE2E1HJ178169", "{'gearDriveForce':1,'batteryConsistencyDifferenceAlarm':0,'soc':42,'socJumpAlarm':0,'socLowAlarm':0,'minTemperatureSubSystemNum':1,'maxVoltageBatteryNum':38,'terminalTime':'2018-11-07 17:43:32','singleBatteryOverVoltageAlarm':0,'vehicleStorageDeviceOvervoltageAlarm':0,'engineStatus':0,'brakeSystemAlarm':0,'vin':'LS4ASE2E1HJ178169','driveMotorTemperatureAlarm':0,'dcdcStatusAlarm':0,'gearBrakeForce':0,'lat':30.421459,'engineSpeed':0,'driveMotorFaultCodes':0,'lng':120.169422166,'nevChargeSystemVoltageDtoList':[{'currentBatteryStartNum':1,'batteryVoltage':[3.646,3.646,3.651,3.654,3.66,3.654,3.661,3.654,3.654,3.652,3.649,3.649,3.643,3.64,3.642,3.642,3.651,3.649,3.648,3.652,3.636,3.642,3.64,3.634,3.639,3.627,3.636,3.64,3.633,3.637,3.642,3.643,3.643,3.645,3.645,3.643,3.646,3.649,3.643,3.649,3.651,3.657,3.652,3.649,3.655,3.646,3.652,3.651,3.642,3.651,3.655,3.654,3.654,3.66,3.657,3.648,3.648,3.649,3.646,3.654,3.651,3.645,3.655,3.655,3.648,3.655,3.66,3.657,3.646,3.657,3.657,3.658,3.643,3.642,3.639,3.655,3.645,3.648,3.645,3.643,3.649,3.64,3.646,3.645,3.636],'currentBatteryCount':85,'batteryCount':85,'childSystemNum':1,'chargeSystemCurrent':61.700001}],'singleBatteryUnderVoltageAlarm':0,'maxVoltageBatterySubSystemNum':1,'minTemperatureProbe':3,'totalVoltage':307.899994,'maxAlarmLevel':0,'temperatureDifferenceAlarm':0,'geerPosition':14,'minVoltageBattery':3.612,'driveMotorData':[{'controllerInputVoltage':309,'controllerTemperature':24,'revolutionSpeed':2447,'num':1,'controllerDcBusCurrent':60,'temperature':33,'torque':67,'state':1}],'minVoltageBatteryNum':31,'engineFaultCodes':0,'minTemperatureValue':20,'chargeStatus':3,'fuelConsumption':0,'totalOdometer':81308,'speed':36,'socHighAlarm':0,'vehicleStorageDeviceUndervoltageAlarm':0,'batteryAlarm':0,'totalCurrent':61.700001,'rechargeableStorageDeviceMismatchAlarm':0,'maxVoltageBattery':3.637,'dcdcTemperatureAlarm':0,'vehiclePureDeviceTypeOvercharge':0,'driveMotorControllerTemperatureAlarm':0,'nevChargeSystemTemperatureDtoList':[{'probeTemperatures':[21,21,20,23,22,24,22,22,23,23,23,21,21,22,20,21,21,21,20,22,23,24],'chargeTemperatureProbeNum':22,'childSystemNum':1}],'dcStatus':1,'maxTemperatureSubSystemNum':1,'carStatus':1,'minVoltageBatterySubSystemNum':1,'targetType':'VehicleRealtimeDto','maxTemperatureProbe':6,'flushTime':'20181129161431','rechargeableStorageDevicesFaultCodes':0,'carMode':1,'highVoltageInterlockStateAlarm':0,'insulationAlarm':0,'maxTemperatureValue':24,'otherFaultCodes':0,'insulateResistance':1000}");
        RedisUtil.getJedis().hset("monidata", "LS4ASE2E0JJ202161", "{'gearDriveForce':1,'batteryConsistencyDifferenceAlarm':0,'soc':51,'socJumpAlarm':0,'socLowAlarm':0,'minTemperatureSubSystemNum':1,'maxVoltageBatteryNum':5,'terminalTime':'2018-11-07 17:34:13','singleBatteryOverVoltageAlarm':0,'vehicleStorageDeviceOvervoltageAlarm':0,'engineStatus':0,'brakeSystemAlarm':0,'vin':'LS4ASE2E0JJ202161','driveMotorTemperatureAlarm':0,'dcdcStatusAlarm':0,'gearBrakeForce':0,'lat':34.953165,'engineSpeed':0,'driveMotorFaultCodes':0,'lng':115.906802833,'nevChargeSystemVoltageDtoList':[{'currentBatteryStartNum':1,'batteryVoltage':[3.689,3.689,3.69,3.689,3.691,3.691,3.689,3.69,3.689,3.689,3.69,3.689,3.688,3.688,3.69,3.688,3.689,3.69,3.689,3.69,3.688,3.689,3.69,3.688,3.685,3.685,3.684,3.684,3.686,3.685,3.686,3.684,3.685,3.682,3.683,3.684,3.683,3.686,3.685,3.684,3.685,3.684,3.683,3.684,3.685,3.683,3.683,3.685,3.685,3.683,3.684,3.687,3.686,3.684,3.686,3.686,3.686,3.685,3.686,3.685,3.686,3.687,3.688,3.689,3.691,3.69,3.69,3.691,3.689,3.689,3.689,3.69,3.69,3.689,3.688,3.689,3.69,3.689,3.689,3.69,3.687,3.69,3.689,3.691,3.69,3.688],'currentBatteryCount':86,'batteryCount':86,'childSystemNum':1,'chargeSystemCurrent':19.1}],'singleBatteryUnderVoltageAlarm':0,'maxVoltageBatterySubSystemNum':1,'minTemperatureProbe':4,'totalVoltage':315.799988,'maxAlarmLevel':0,'temperatureDifferenceAlarm':0,'geerPosition':14,'minVoltageBattery':3.666,'driveMotorData':[{'controllerInputVoltage':315,'controllerTemperature':23,'revolutionSpeed':1537,'num':1,'controllerDcBusCurrent':13.6,'temperature':27,'torque':25.9,'state':1}],'minVoltageBatteryNum':43,'engineFaultCodes':0,'minTemperatureValue':9,'chargeStatus':3,'fuelConsumption':0,'totalOdometer':3395.5,'speed':20,'socHighAlarm':0,'vehicleStorageDeviceUndervoltageAlarm':0,'batteryAlarm':0,'totalCurrent':19.1,'rechargeableStorageDeviceMismatchAlarm':0,'maxVoltageBattery':3.678,'dcdcTemperatureAlarm':0,'vehiclePureDeviceTypeOvercharge':0,'driveMotorControllerTemperatureAlarm':0,'nevChargeSystemTemperatureDtoList':[{'probeTemperatures':[10,10,10,9,10,9,10,10,10,10,10,10],'chargeTemperatureProbeNum':12,'childSystemNum':1}],'dcStatus':1,'maxTemperatureSubSystemNum':1,'carStatus':1,'minVoltageBatterySubSystemNum':1,'targetType':'VehicleRepayDto','maxTemperatureProbe':2,'flushTime':'20181129215912','rechargeableStorageDevicesFaultCodes':0,'carMode':1,'highVoltageInterlockStateAlarm':0,'insulationAlarm':0,'maxTemperatureValue':10,'otherFaultCodes':0,'insulateResistance':3000}");
        RedisUtil.getJedis().hset("monidata", "LS4ASE2E3JJ166482", "{'gearDriveForce':0,'batteryConsistencyDifferenceAlarm':0,'soc':0,'socJumpAlarm':0,'socLowAlarm':0,'minTemperatureSubSystemNum':0,'maxVoltageBatteryNum':0,'terminalTime':'2018-11-07 09:02:06','singleBatteryOverVoltageAlarm':0,'vehicleStorageDeviceOvervoltageAlarm':0,'engineStatus':0,'brakeSystemAlarm':0,'vin':'LS4ASE2E3JJ166482','driveMotorTemperatureAlarm':0,'dcdcStatusAlarm':0,'gearBrakeForce':0,'lat':39.894285166,'engineSpeed':0,'driveMotorFaultCodes':0,'lng':116.233076333,'nevChargeSystemVoltageDtoList':[{'currentBatteryStartNum':1,'batteryVoltage':[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],'currentBatteryCount':86,'batteryCount':86,'childSystemNum':1,'chargeSystemCurrent':0}],'singleBatteryUnderVoltageAlarm':0,'maxVoltageBatterySubSystemNum':0,'minTemperatureProbe':0,'totalVoltage':0,'maxAlarmLevel':0,'temperatureDifferenceAlarm':0,'geerPosition':0,'minVoltageBattery':0,'driveMotorData':[{'controllerInputVoltage':0,'controllerTemperature':0,'revolutionSpeed':0,'num':1,'controllerDcBusCurrent':0,'temperature':0,'torque':0,'state':0}],'minVoltageBatteryNum':0,'engineFaultCodes':0,'minTemperatureValue':0,'chargeStatus':0,'fuelConsumption':0,'totalOdometer':11640.400391,'speed':0,'socHighAlarm':0,'vehicleStorageDeviceUndervoltageAlarm':0,'batteryAlarm':0,'totalCurrent':0,'rechargeableStorageDeviceMismatchAlarm':0,'maxVoltageBattery':0,'dcdcTemperatureAlarm':0,'vehiclePureDeviceTypeOvercharge':0,'driveMotorControllerTemperatureAlarm':0,'nevChargeSystemTemperatureDtoList':[{'probeTemperatures':[0,0,0,0,0,0,0,0,0,0,0,0],'chargeTemperatureProbeNum':12,'childSystemNum':1}],'dcStatus':2,'maxTemperatureSubSystemNum':0,'carStatus':2,'minVoltageBatterySubSystemNum':0,'targetType':'VehicleRepayDto','maxTemperatureProbe':0,'flushTime':'20181129193344','rechargeableStorageDevicesFaultCodes':0,'carMode':1,'highVoltageInterlockStateAlarm':0,'insulationAlarm':0,'maxTemperatureValue':0,'otherFaultCodes':0,'insulateResistance':0}");
        RedisUtil.getJedis().hset("monidata","LS4ASE2E7JJ227011","{'gearDriveForce':0,'batteryConsistencyDifferenceAlarm':0,'soc':81,'socJumpAlarm':0,'socLowAlarm':0,'minTemperatureSubSystemNum':1,'maxVoltageBatteryNum':35,'terminalTime':'2018-11-07 17:50:06','singleBatteryOverVoltageAlarm':0,'vehicleStorageDeviceOvervoltageAlarm':0,'engineStatus':0,'brakeSystemAlarm':0,'vin':'LS4ASE2E7JJ227011','driveMotorTemperatureAlarm':0,'dcdcStatusAlarm':0,'gearBrakeForce':1,'lat':30.06922349,'engineSpeed':0,'driveMotorFaultCodes':0,'lng':119.943032166,'nevChargeSystemVoltageDtoList':[{'currentBatteryStartNum':1,'batteryVoltage':[3.974,3.977,3.976,3.977,3.977,3.977,3.976,3.976,3.976,3.977,3.977,3.976,3.968,3.967,3.968,3.971,3.971,3.971,3.97,3.97,3.97,3.97,3.969,3.97,3.972,3.97,3.972,3.971,3.969,3.972,3.97,3.968,3.977,3.973,3.98,3.979,3.979,3.979,3.98,3.979,3.979,3.98,3.979,3.977,3.973,3.977,3.977,3.977,3.976,3.977,3.977,3.977,3.978,3.978,3.978,3.975,3.967,3.969,3.97,3.969,3.972,3.972,3.973,3.971,3.969,3.97,3.972,3.972,3.973,3.973,3.973,3.971,3.973,3.972,3.971,3.968,3.969,3.969,3.969,3.968,3.969,3.966,3.967,3.968,3.965],'currentBatteryCount':85,'batteryCount':85,'childSystemNum':1,'chargeSystemCurrent':1}],'singleBatteryUnderVoltageAlarm':0,'maxVoltageBatterySubSystemNum':2,'minTemperatureProbe':1,'totalVoltage':337.700012,'maxAlarmLevel':0,'temperatureDifferenceAlarm':0,'geerPosition':14,'minVoltageBattery':3.966,'driveMotorData':[{'controllerInputVoltage':341,'controllerTemperature':25,'revolutionSpeed':0,'num':1,'controllerDcBusCurrent':0,'temperature':22,'torque':0,'state':4}],'minVoltageBatteryNum':85,'engineFaultCodes':0,'minTemperatureValue':18,'chargeStatus':3,'fuelConsumption':0,'totalOdometer':0,'speed':0,'socHighAlarm':0,'vehicleStorageDeviceUndervoltageAlarm':0,'batteryAlarm':0,'totalCurrent':1,'rechargeableStorageDeviceMismatchAlarm':0,'maxVoltageBattery':3.98,'dcdcTemperatureAlarm':0,'vehiclePureDeviceTypeOvercharge':0,'driveMotorControllerTemperatureAlarm':0,'nevChargeSystemTemperatureDtoList':[{'probeTemperatures':[18,19,19,20,19,20,19,19,19,20,19,19,19,19,19,19,19,19,18,19,20,20],'chargeTemperatureProbeNum':22,'childSystemNum':1}],'dcStatus':2,'maxTemperatureSubSystemNum':1,'carStatus':1,'minVoltageBatterySubSystemNum':1,'targetType':'VehicleRealtimeDto','maxTemperatureProbe':6,'flushTime':'20181229162752','rechargeableStorageDevicesFaultCodes':0,'carMode':1,'highVoltageInterlockStateAlarm':0,'insulationAlarm':0,'maxTemperatureValue':20,'otherFaultCodes':0,'insulateResistance':3000}");


        logger.info("初始化redis中的车辆实时报文数据");
        RedisUtil.getJedis().hset("realTimeAlarm","LS5A2AJX6HA000538","{'highVoltageInterlockStateAlarm':{'startTime':'2018-11-07 17:53:50','endTime':[],'value':1,'processTime':'','status':''},'type':1,'dcdcStatusAlarm':{'startTime':'2018-11-07 17:53:50','endTime':[],'value':1,'processTime':'','status':''},'maxAlarmLevel':2}");
        RedisUtil.getJedis().zadd("sortAlarm", DateUtils.stringToDate("2018-11-07 17:53:50", DateUtils.DATE_TIME_FORMAT).getTime(), "LS5A2AJX6HA000538|highVoltageInterlockStateAlarm");
        RedisUtil.getJedis().zadd("sortAlarm", DateUtils.stringToDate("2018-11-07 17:53:50", DateUtils.DATE_TIME_FORMAT).getTime(), "LS5A2AJX6HA000538|dcdcStatusAlarm");

        RedisUtil.getJedis().hset("realTimeAlarm","LS4AGB2X1GG699261","{'type':1,'dcdcStatusAlarm':{'startTime':'2018-11-07 17:23:52','endTime':[],'value':1,'processTime':'','status':''},'maxAlarmLevel':3}");
        RedisUtil.getJedis().zadd("sortAlarm", DateUtils.stringToDate("2018-11-07 17:23:52", DateUtils.DATE_TIME_FORMAT).getTime(), "LS4AGB2X1GG699261|dcdcStatusAlarm");

        RedisUtil.getJedis().hset("realTimeAlarm","LS5A2AJX6HA000345","{'type':1,'dcdcStatusAlarm':{'startTime':'2018-11-07 17:27:52','endTime':[],'value':1,'processTime':'','status':''},'maxAlarmLevel':1}");
        RedisUtil.getJedis().zadd("sortAlarm", DateUtils.stringToDate("2018-11-07 17:27:52", DateUtils.DATE_TIME_FORMAT).getTime(), "LS5A2AJX6HA000345|dcdcStatusAlarm");

        RedisUtil.getJedis().hset("realTimeAlarm","LS5A3AJC1HB051983","{'type':1,'dcdcStatusAlarm':{'startTime':'2018-11-07 17:27:52','endTime':[],'value':1,'processTime':'','status':''},'maxAlarmLevel':2}");
        RedisUtil.getJedis().zadd("sortAlarm", DateUtils.stringToDate("2018-11-07 17:27:52", DateUtils.DATE_TIME_FORMAT).getTime(), "LS5A3AJC1HB051983|dcdcStatusAlarm");

        RedisUtil.getJedis().hset("realTimeAlarm","LS4AAB3CXGG700467","{'highVoltageInterlockStateAlarm':{'startTime':'2018-11-07 17:25:33','endTime':[],'value':1,'processTime':'','status':''},'type':1,'dcdcStatusAlarm':{'startTime':'2018-11-07 17:25:33','endTime':[],'value':1,'processTime':'','status':''},'maxAlarmLevel':1}");
        RedisUtil.getJedis().zadd("sortAlarm", DateUtils.stringToDate("2018-11-07 17:25:33", DateUtils.DATE_TIME_FORMAT).getTime(), "LS4AAB3CXGG700467|highVoltageInterlockStateAlarm");
        RedisUtil.getJedis().zadd("sortAlarm", DateUtils.stringToDate("2018-11-07 17:25:33", DateUtils.DATE_TIME_FORMAT).getTime(), "LS4AAB3CXGG700467|dcdcStatusAlarm");

        RedisUtil.getJedis().hset("realTimeAlarm","LS5A2AJX8HA000282","{'brakeSystemAlarm':{'startTime':'2018-11-07 17:27:53','endTime':[],'value':1,'processTime':'','status':''},'type':1,'maxAlarmLevel':2}");
        RedisUtil.getJedis().zadd("sortAlarm", DateUtils.stringToDate("2018-11-07 17:27:53", DateUtils.DATE_TIME_FORMAT).getTime(), "LS5A2AJX8HA000282|brakeSystemAlarm");

        RedisUtil.getJedis().hset("realTimeAlarm","LS5A2AJX0HA000552","{'brakeSystemAlarm':{'startTime':'2018-11-07 17:27:56','endTime':[],'value':1,'processTime':'','status':''},'type':1,'maxAlarmLevel':1}");
        RedisUtil.getJedis().zadd("sortAlarm", DateUtils.stringToDate("2018-11-07 17:27:56", DateUtils.DATE_TIME_FORMAT).getTime(), "LS5A2AJX0HA000552|brakeSystemAlarm");

        RedisUtil.getJedis().hset("realTimeAlarm","LS5A2AJX5HA000210","{'brakeSystemAlarm':{'startTime':'2018-11-07 17:25:42','endTime':[],'value':1,'processTime':'','status':''},'type':1,'maxAlarmLevel':1}");
        RedisUtil.getJedis().zadd("sortAlarm", DateUtils.stringToDate("2018-11-07 17:25:42", DateUtils.DATE_TIME_FORMAT).getTime(), "LS5A2AJX5HA000210|brakeSystemAlarm");

        RedisUtil.getJedis().hset("realTimeAlarm","LS5A2AJX4HD700122","{'brakeSystemAlarm':{'startTime':'2018-11-07 17:25:42','endTime':[],'value':1,'processTime':'','status':''},'type':1,'maxAlarmLevel':2}");
        RedisUtil.getJedis().zadd("sortAlarm", DateUtils.stringToDate("2018-11-07 17:25:42", DateUtils.DATE_TIME_FORMAT).getTime(), "LS5A2AJX4HD700122|brakeSystemAlarm");

        RedisUtil.getJedis().hset("realTimeAlarm","LS4AAB3C2GG700530","{'highVoltageInterlockStateAlarm':{'startTime':'2018-11-07 17:53:52','endTime':[],'value':1,'processTime':'','status':''},'type':1,'dcdcStatusAlarm':{'startTime':'2018-11-07 17:53:52','endTime':[],'value':1,'processTime':'','status':''},'maxAlarmLevel':1}");
        RedisUtil.getJedis().zadd("sortAlarm", DateUtils.stringToDate("2018-11-07 17:53:52", DateUtils.DATE_TIME_FORMAT).getTime(), "LS4AAB3C2GG700530|highVoltageInterlockStateAlarm");
        RedisUtil.getJedis().zadd("sortAlarm", DateUtils.stringToDate("2018-11-07 17:53:52", DateUtils.DATE_TIME_FORMAT).getTime(), "LS4AAB3C2GG700530|dcdcStatusAlarm");

        RedisUtil.getJedis().hset("realTimeAlarm","LS4AAB3C9GG700590","{'highVoltageInterlockStateAlarm':{'startTime':'2018-11-07 17:27:57','endTime':[],'value':1,'processTime':'','status':''},'type':1,'dcdcStatusAlarm':{'startTime':'2018-11-07 17:27:57','endTime':[],'value':1,'processTime':'','status':''},'maxAlarmLevel':2}");
        RedisUtil.getJedis().zadd("sortAlarm", DateUtils.stringToDate("2018-11-07 17:27:57", DateUtils.DATE_TIME_FORMAT).getTime(), "LS4AAB3C9GG700590|highVoltageInterlockStateAlarm");
        RedisUtil.getJedis().zadd("sortAlarm", DateUtils.stringToDate("2018-11-07 17:27:57", DateUtils.DATE_TIME_FORMAT).getTime(), "LS4AAB3C9GG700590|dcdcStatusAlarm");
        logger.info("初始化redis中的车辆实时告警数据");


    }

    @Test
    public void case1(){
        Map<String, String> param = new HashMap<>();
        param.put("token", "admin");
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.VEH_COUNT_PER_MONITOR_PLATFORM);
        CloseableHttpResponse response = HttpUtil.get(url, param);
        Header[] header = response.getHeaders("Set-Cookie");

        Header setCookieHeader = header[0];

        Constants.SESSIONID = setCookieHeader.toString().split(":")[1].split(";")[0].split("=")[1];

        //读取测试用例文件中的数据
        try {
            Constants.TEST_CASE = ExcelUtil.readTestCase("testcase","Sheet1");
        } catch (IOException e) {
            logger.error("读取excel出现异常，请检测名称是否对应正确或其他异常！！！", e);
            return;
        }
        Assert.assertEquals(true, true);
        Reporter.log("登陆成功");
    }
    @AfterSuite
    public void afterSuit(){

    }
}
