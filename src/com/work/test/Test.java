package com.work.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.work.dao.NewsDao;
import com.work.daoimp.NewsDaoImp;
import com.work.service.NewsService;
import com.work.serviceimp.NewsServiceImp;
import com.worl.bean.News;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		NewsDao nd=new NewsDaoImp();
		NewsService ns=new NewsServiceImp();
		System.out.println("1：查询所有新闻信息");
		System.out.println("2：增加新闻信息");
		System.out.println("3：删除新闻信息");
		System.out.println("4：修改新闻信息");
		
		int num=input.nextInt();
		switch (num) {
		case 1:
			List<News> list=ns.SelectNews();
			for(int i=0;i<list.size();i++){
				System.out.println("新闻编号："+list.get(i).getId());
				System.out.println("新闻标题："+list.get(i).getTitle());
				System.out.println("新闻内容："+list.get(i).getContent());
				System.out.println("新闻时间："+list.get(i).getCreateTime());
				System.out.println("--------------------------------------");
			}
			break;
		case 2:
			String sql="insert into easybuy_news (title,content) values(?,?)";
			System.out.println("请输入新闻标题:");
			String title=input.next();
			System.out.println("请输入新闻内容:");
			String content=input.next();
			Object[] objs={title,content};
			int result=nd.updataNews(sql, objs);
			if(result>=1){
				System.out.println("添加成功");
			}
			break;
		case 3:
			System.out.println("请输入删除新闻编号");
			num=input.nextInt();
			String sql2="delete from easybuy_news where id=?";
			Object[] objs2={num};
			int result2=nd.updataNews(sql2, objs2);
			if(result2>=1){
				System.out.println("删除成功");
			}
			break;	
		case 4:
			System.out.println("请输入要修改的新闻编号:");
			num=input.nextInt();
			System.out.println("请输入修改后的标题");
			String str_title=input.next();
			System.out.println("请输入修改后的新闻内容");
			String str_content=input.next();
			String sql3="update easybuy_news set title=?,content=? where id=?";
			Object[] objs3={str_title,str_content,num};
			int result3=nd.updataNews(sql3, objs3);
			if(result3>=1){
				System.out.println("修改成功");
			}
			break;
			
		default:
			break;
		}
	}

}
