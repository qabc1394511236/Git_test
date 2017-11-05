package com.work.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.basedao.BaseDao;
import com.work.dao.NewsDao;
import com.worl.bean.News;

public class NewsDaoImp extends BaseDao implements NewsDao{
	Connection con=getCon();
	PreparedStatement ps=null;
	ResultSet rs=null;
	

	@Override
	public int updataNews(String sql, Object... param) {
		// TODO Auto-generated method stub
		int num=0;		//影响行数
		try {
			ps=con.prepareStatement(sql);
			//为参数赋值
			if(param!=null){
				for(int i=0;i<param.length;i++){
					ps.setObject(i+1,param[i]);
				}
			}
			//执行sql语句
			num=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(null, ps,null);
		}
		return num;
	}

	
	@Override
	public void Test(News t) {
		// TODO Auto-generated method stub
		
	}

}
