package com.bupt.bsdn.config;


import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import java.io.IOException;

@org.springframework.context.annotation.Configuration
public class HbaseConfig {
    @Bean
    public Connection hbaseConfiguration() throws IOException {
        return ConnectionFactory.createConnection();
    }
}
