package com.bupt.bsdn.service;

public interface bsHbaseService {
    void addCount(String user_id,String article_id);
    void put(String user_id,String article_id,Integer value);
}
