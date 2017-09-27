package com.example.demo.Utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class RestUtil {


    public Map<String,Object> createResponseObject(int code, Object data) {

        Map<String,Object> jsonMap= new LinkedHashMap<String,Object>();
        Map<String,Object> operationResultMap = new LinkedHashMap<String,Object>();
        operationResultMap.put("code", code);
        operationResultMap.put("message", "Success");

        jsonMap.put("operationResult", operationResultMap);
        jsonMap.put("data", data);
        return jsonMap;
    }
}
