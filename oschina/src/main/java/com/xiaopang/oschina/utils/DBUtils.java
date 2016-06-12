package com.xiaopang.oschina.utils;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * Created by yaoshouyun on 2016/5/16.
 */
public class DBUtils {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.itheima.oschina.db");
        addNews(schema);
        new DaoGenerator().generateAll(schema,"D:\\android-studio-projects\\OsChina\\app\\src\\main\\java");
    }

    private static void addNews(Schema schema) {
        Entity news = schema.addEntity("News");
        news.addIntProperty("id");
        news.addStringProperty("title");
        news.addStringProperty("body");
        news.addStringProperty("author");
        news.addStringProperty("pubDate");
        news.addIntProperty("commentCount");
        news.addStringProperty("url");
    }
//
//    private static void addNewsList(Schema schema) {
//        Entity newsList = schema.addEntity("NewsList");
//        newsList.addIdProperty();
//        newsList.addIntProperty("catalog");
//        newsList.addIntProperty("pageCount");
//        newsList.addIntProperty("pageIndex");
//    }

}
