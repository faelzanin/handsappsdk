package com.dvloop.sdk.models.domain;

import android.location.Location;

/**
 * Created by rafaelzanin on 25/09/17.
 */

public class User {

    private String euid;
    private String deviceId;
    private String os;
    private String osVersion;
    private String deviceModel;
    private String home;
    private String work;
    private String istInstalledApps;
    private Float batteryState;
    private Float batteryPercentage;
    private String arrival;
    private String departure;
    private String categorie;
    private String venueName;
    private Float venueTotalTime;
    private Float precision;
    private String venueLngLat;
    private String address;
    private String city;
    private String state;
    private String country;

    public String getEuid() {
        return euid;
    }

    public void setEuid(String euid) {
        this.euid = euid;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getIstInstalledApps() {
        return istInstalledApps;
    }

    public void setIstInstalledApps(String istInstalledApps) {
        this.istInstalledApps = istInstalledApps;
    }

    public Float getBatteryState() {
        return batteryState;
    }

    public void setBatteryState(Float batteryState) {
        this.batteryState = batteryState;
    }

    public Float getBatteryPercentage() {
        return batteryPercentage;
    }

    public void setBatteryPercentage(Float batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public Float getVenueTotalTime() {
        return venueTotalTime;
    }

    public void setVenueTotalTime(Float venueTotalTime) {
        this.venueTotalTime = venueTotalTime;
    }

    public Float getPrecision() {
        return precision;
    }

    public void setPrecision(Float precision) {
        this.precision = precision;
    }

    public String getVenueLngLat() {
        return venueLngLat;
    }

    public void setVenueLngLat(String venueLngLat) {
        this.venueLngLat = venueLngLat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
