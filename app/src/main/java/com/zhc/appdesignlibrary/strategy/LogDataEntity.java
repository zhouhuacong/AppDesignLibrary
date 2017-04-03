package com.zhc.appdesignlibrary.strategy;

import java.util.Map;

/**
 * Created by qqq on 2017/4/3.
 */

public class LogDataEntity {

    public String app_key;

    public String app_version;

    public String sdk_type;

    public String sdk_version;

    public String imei;

    public String device_model;

    public String resolution;

    public String channel;

    public String carrier;

    public String network;

    public String os_type;

    public String os_version;

    public String language;

    public String country;

    public String city;

    public String mac_addr;

    public int is_root = 0;

    public String iccid;

    public String uid;

    public String timezone;

    public String app_sign;

    public String local_ip;

    public String package_name;

    public String ad_action;

    public String page_id;

    public String page_type = "1";

    public String ad_join_id;

    public long ad_id;

    public long ad_idea_id;

    public long ad_owner_id;

    public float ad_score;

    public int ad_cost;

    public String ad_type;

    public String ad_entity_type;

    public String ad_position_type;

    public String ad_position_id;

    public int ad_position_sub_id;

    public String ad_algo_id;

    public String event_id;

    public String event_type;

    public Map<String, String> event_params;

    public String ad_network_id;

    @Override
    public String toString() {
        return "LogDataEntity{" +
                "app_key='" + app_key + '\'' +
                ", app_version='" + app_version + '\'' +
                ", sdk_type='" + sdk_type + '\'' +
                ", sdk_version='" + sdk_version + '\'' +
                ", imei='" + imei + '\'' +
                ", device_model='" + device_model + '\'' +
                ", resolution='" + resolution + '\'' +
                ", channel='" + channel + '\'' +
                ", carrier='" + carrier + '\'' +
                ", network='" + network + '\'' +
                ", os_type='" + os_type + '\'' +
                ", os_version='" + os_version + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", mac_addr='" + mac_addr + '\'' +
                ", is_root=" + is_root +
                ", iccid='" + iccid + '\'' +
                ", uid='" + uid + '\'' +
                ", timezone='" + timezone + '\'' +
                ", app_sign='" + app_sign + '\'' +
                ", local_ip='" + local_ip + '\'' +
                ", package_name='" + package_name + '\'' +
                ", ad_action='" + ad_action + '\'' +
                ", page_id='" + page_id + '\'' +
                ", page_type='" + page_type + '\'' +
                ", ad_join_id='" + ad_join_id + '\'' +
                ", ad_id=" + ad_id +
                ", ad_idea_id=" + ad_idea_id +
                ", ad_owner_id=" + ad_owner_id +
                ", ad_score=" + ad_score +
                ", ad_cost=" + ad_cost +
                ", ad_type='" + ad_type + '\'' +
                ", ad_entity_type='" + ad_entity_type + '\'' +
                ", ad_position_type='" + ad_position_type + '\'' +
                ", ad_position_id='" + ad_position_id + '\'' +
                ", ad_position_sub_id=" + ad_position_sub_id +
                ", ad_algo_id='" + ad_algo_id + '\'' +
                ", event_id='" + event_id + '\'' +
                ", event_type='" + event_type + '\'' +
                ", event_params=" + event_params +
                ", ad_network_id='" + ad_network_id + '\'' +
                '}';
    }
}
