package com.basedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	
	//连接
	 private static Connection conn = null;
	    public static Connection getCon() {
	        try {
             Class.forName("com.mysql.jdbc.Driver"); //加载数据库连接驱动
             	//建立连接
	            
	             conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/easybuy","sqks","1234"); //获取连接
	        } catch (Exception e) {
	             System.out.println("连接数据库失败");
	             e.printStackTrace();
	        }
	         return conn;
	     }
	    
	    
	    
	    protected static ResultSet executeQuery(String sql,Object... param){
			ResultSet rs=null;
			PreparedStatement ps=null;
			try {
				ps=getCon().prepareStatement(sql);
				if(param!=null){
					for(int i=0;i<param.length;i++){
						ps.setObject(i+1,param[i]);
					}
				}
				rs=ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    	return rs;
	    	
	    }
	    
	    
	    
	    //关闭
	    public static void closeAll(Connection con,Statement st,ResultSet rs){
	    	
	    	if(rs!=null){
	    		try {
	    			rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	
	    	
	    	if(st!=null){
	    		try {
	    			st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	
	    	
	    	if(con!=null){
	    		try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    }
		

}
