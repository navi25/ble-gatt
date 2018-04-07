package com.example.android.bluetoothlegatt;


/**
 * Created by navi on 4/6/18.
 */

import android.util.Log;
import android.util.TimeUtils;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.example.android.bluetoothlegatt.HealthDataDO;
import com.example.android.bluetoothlegatt.DataModel;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;
import java.util.Calendar;

public class DataManager {


    public  static String TAG = "DataManager";

    public static DataModel parseDummyData(String rawData){
        DataModel dm = new DataModel();
        Long tsLong = System.currentTimeMillis()/1000;

        Date currentTime = Calendar.getInstance().getTime();


        String ts = currentTime.toString();
        dm.uid = UUID.randomUUID().toString();
        dm.timeStamp = ts;
        dm.deviceId = "IrSensor2";
        dm.dataD = rawData;

        return dm;
    }

    public static DataModel parseData(byte[] rawData){
        DataModel dm = new DataModel();
        Date currentTime = Calendar.getInstance().getTime();
        String ts = currentTime.toString();
        dm.uid = UUID.randomUUID().toString();
        dm.timeStamp = ts;

        dm.deviceId = "IrSensor2";
        dm.dataD = getFormattedData(rawData);
        Log.d(TAG, "parsingData " + dm.dataD);

        return dm;
    }

    static String getFormattedData(byte[] rawData){
        StringBuffer sb = new StringBuffer("");
        for(int i=0; i<rawData.length; i++){
            int curr = rawData[i];
            sb.append(curr);
        }

        return sb.toString();
    }


    public static void insertData(DataModel dm){
        final HealthDataDO dataObject = new HealthDataDO();
        dataObject.setId(dm.uid);
        dataObject.setTimeStamp(dm.timeStamp);
        dataObject.setDeviceId(dm.deviceId);
        dataObject.setData(dm.dataD);
        final DynamoDBMapper mapper = DeviceScanActivity.dynamoDBMapper;
        try {
            Log.d(TAG, "Inserting users");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    mapper.save(dataObject);
                    // Item saved
                }
            }).start();

            Log.d(TAG, "Users inserted");

        } catch (AmazonServiceException ex) {
            Log.e(TAG, "Error inserting users");
        }
    }

}


