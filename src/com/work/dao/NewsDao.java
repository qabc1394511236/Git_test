package com.work.dao;

import com.worl.bean.News;

public interface NewsDao extends CommonDao<News>{
	//增删改通用方法                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	public int updataNews(String sql,Object... param);
	
}
