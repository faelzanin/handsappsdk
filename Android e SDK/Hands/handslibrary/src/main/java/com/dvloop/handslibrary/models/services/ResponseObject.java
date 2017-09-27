package com.dvloop.handslibrary.models.services;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rafaelzanin on 15/09/17.
 */

public class ResponseObject {

    @SerializedName("operationResult")
    @Expose
    private OperationResult operationResult;

    @SerializedName("data")
    @Expose
    private JsonObject data;

    public ResponseObject(OperationResult operationResult, JsonObject data) {
        this.operationResult = operationResult;
        this.data = data;
    }

    public OperationResult getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(OperationResult operationResult) {
        this.operationResult = operationResult;
    }

    public JsonObject getData() {
        return data;
    }

    public void setData(JsonObject data) {
        this.data = data;
    }
}


