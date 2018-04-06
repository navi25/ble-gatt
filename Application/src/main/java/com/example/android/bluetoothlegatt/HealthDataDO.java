package com.example.android.bluetoothlegatt;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.util.List;
import java.util.Map;
import java.util.Set;

@DynamoDBTable(tableName = "blegatt-mobilehub-1627566919-HealthData")

public class HealthDataDO {
    private String _id;
    private String _timeStamp;
    private String _data;
    private String _deviceId;

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAttribute(attributeName = "id")
    public String getId() {
        return _id;
    }

    public void setId(final String _id) {
        this._id = _id;
    }
    @DynamoDBRangeKey(attributeName = "timeStamp")
    @DynamoDBAttribute(attributeName = "timeStamp")
    public String getTimeStamp() {
        return _timeStamp;
    }

    public void setTimeStamp(final String _timeStamp) {
        this._timeStamp = _timeStamp;
    }
    @DynamoDBAttribute(attributeName = "data")
    public String getData() {
        return _data;
    }

    public void setData(final String _data) {
        this._data = _data;
    }
    @DynamoDBAttribute(attributeName = "deviceId")
    public String getDeviceId() {
        return _deviceId;
    }

    public void setDeviceId(final String _deviceId) {
        this._deviceId = _deviceId;
    }

}
