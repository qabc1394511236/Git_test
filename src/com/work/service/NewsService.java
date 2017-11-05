package com.work.service;

import java.util.List;

import com.worl.bean.News;

public interface NewsService {
	
	//查找所有新闻的需求
	public List<News> SelectNews();
	
}
