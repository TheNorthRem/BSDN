package com.bupt.bsdn.util;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.List;

public class HbaseUtil {

    public static void createTable(String tableName,String [] fields,Admin admin)  throws IOException {
        TableName tablename=TableName.valueOf(tableName); //创建表名对象

        if(admin.tableExists(tablename)){ //判断表明是否存在，存在则先删除
            System.out.println("table exists!");
            admin.disableTable(tablename);
            admin.deleteTable(tablename);
        }

        TableDescriptorBuilder tableDescriptorBuilder= TableDescriptorBuilder.newBuilder(tablename); //通过表明创建表的描述构造器

        for(String field: fields){ //遍历属性 同构列构造器构造表的列
            ColumnFamilyDescriptor familyDescriptor= ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes(field)).build();
            tableDescriptorBuilder.setColumnFamily(familyDescriptor);
        }

        admin.createTable(tableDescriptorBuilder.build()); //创建表

    }

    public static void addRecord(String tableName,String row,String []fields,String []values,Connection connection) throws IOException {

        Table table=connection.getTable(TableName.valueOf(tableName)); //通过连接拿到表对象

        Put put=new Put(row.getBytes()); //通过行键创建put实例

        for(int i=0;i<fields.length;i++){ //遍历属性

            String []columns= fields[i].split(":"); //判断列是否通过列簇:列的格式进行标识
            if(columns.length==1)//若不是，则直接添加
                put.addColumn(fields[i].getBytes(),"".getBytes(),values[i].getBytes());
            else
                put.addColumn(columns[0].getBytes(),columns[1].getBytes(),values[i].getBytes());//否则 以列簇列的形式添加

            table.put(put); //向表中添加数据
        }

    }

    public static void scanColumn(String tableName,String column,Connection connection) throws IOException {
        Table table= connection.getTable(TableName.valueOf(tableName)); //建立表连接
        Scan scan=new Scan(); //创建Scan对象
        scan.addFamily(column.getBytes()); //设置要扫描的列
        ResultScanner scanner=table.getScanner(scan); //获取扫描结果，返回的是一个可迭代的容器
        System.out.println(scanner.getScanMetrics());
        for(Result result: scanner){ //遍历结果
            List<Cell> cells=result.listCells();
            for(Cell cell : cells) {
                System.out.println("row: " + new String(CellUtil.cloneRow(cell)));
                System.out.println("ColumnName: " + new String(CellUtil.cloneQualifier(cell)));
                System.out.println("Value: " + new String(CellUtil.cloneValue(cell)));
                System.out.println("Family: " + new String(CellUtil.cloneFamily(cell)));
                System.out.println();
            }
        }
    }

    public static void ModifyData(String tableName,String row,String column,String value,Connection connection) throws IOException {
        addRecord(tableName,row,new String[]{column},new String[]{value},connection);
    }

    public static void deleteRow(String tableName,String row,Connection connection) throws IOException {
        Table table=connection.getTable(TableName.valueOf(tableName)); //获取表
        Delete delete=new Delete(row.getBytes());//建立删除对象
        table.delete(delete);//删除表
    }

    public static Integer getData(Connection connection, String tableName, String rowKey) throws IOException {
        try (Table table = connection.getTable(TableName.valueOf(tableName))) {
            Get get = new Get(Bytes.toBytes(rowKey));
            Result result = table.get(get);

            Cell cell = result.getColumnLatestCell(Bytes.toBytes("count"), Bytes.toBytes(""));

            if (cell != null) {
                return  Integer.valueOf(Bytes.toString(CellUtil.cloneValue(cell)));
            }
            return 0;
        }
    }

}
