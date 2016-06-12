package com.xiaopang.oschina.bean;

import java.util.List;

public class Tweet {

	public int id;//ID
	public String userImage;// 用户头像
	public String userName;// 用户名称
	public String body;// 内容
	public List<TweetImage> images;// 图片列表
	public String pubDate;// 发布时间
	public String pubDevice;// 发布设备
	public boolean isGood;// 是否赞过
	public int commentCount;// 评论数量

}
