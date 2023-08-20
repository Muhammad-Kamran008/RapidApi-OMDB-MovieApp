package com.example.rpaidapi_omdb.Model;

public class MetaData {
    private String operation="";
    private String requestId="";
    private double serviceTimeMs=1;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public double getServiceTimeMs() {
        return serviceTimeMs;
    }

    public void setServiceTimeMs(double serviceTimeMs) {
        this.serviceTimeMs = serviceTimeMs;
    }
}
