package com.bupt.bsdn.service.impl;

import com.bupt.bsdn.util.HbaseUtil;
import org.apache.hadoop.hbase.client.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bupt.bsdn.service.bsHbaseService;

import java.io.IOException;

@Service
public class bsHbaseServiceImpl implements bsHbaseService{

    Connection connection;

    @Autowired
    public bsHbaseServiceImpl(Connection connection){
        this.connection=connection;
    }

    @Override
    public void addCount(String user_id, String article_id) {
        String key = user_id+"_"+article_id;
        try {
            Integer click_count = HbaseUtil.getData(connection, "click_count", key);
            click_count+=1;

            HbaseUtil.ModifyData("click_count",key,"count",click_count.toString(),connection);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void put(String user_id, String article_id, Integer value) {
        String key = user_id+"_"+article_id;
        try {
            HbaseUtil.ModifyData("click_count",key,"count",value.toString(),connection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
