package com.work.dao;

import com.worl.bean.News;

public interface NewsDao extends CommonDao<News>{
	//��ɾ��ͨ�÷���                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	public int updataNews(String sql,Object... param);
	
}
