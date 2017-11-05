package com.work.serviceimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.basedao.BaseDao;
import com.work.service.NewsService;
import com.worl.bean.News;

public class NewsServiceImp extends BaseDao implements NewsService{
	Connection con=getCon();
	PreparedStatement ps=null;
	ResultSet rs=null;
	@Override
	public List<News> SelectNews() {
		// TODO Auto-generated method stub
		List<News> list=new ArrayList<News>();
		try {
			String sql="Select * from easybuy_news";
			rs=executeQuery(sql);
			while(rs.next()){
				News ns=new News();
				ns.setId(rs.getInt("id"));
				ns.setTitle(rs.getString("title"));
				ns.setContent(rs.getString("content"));
				ns.setCreateTime(rs.getString("createTime"));
				list.add(ns);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}
