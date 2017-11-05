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
		System.out.println("1����ѯ����������Ϣ");
		System.out.println("2������������Ϣ");
		System.out.println("3��ɾ��������Ϣ");
		System.out.println("4���޸�������Ϣ");
		
		int num=input.nextInt();
		switch (num) {
		case 1:
			List<News> list=ns.SelectNews();
			for(int i=0;i<list.size();i++){
				System.out.println("���ű�ţ�"+list.get(i).getId());
				System.out.println("���ű��⣺"+list.get(i).getTitle());
				System.out.println("�������ݣ�"+list.get(i).getContent());
				System.out.println("����ʱ�䣺"+list.get(i).getCreateTime());
				System.out.println("--------------------------------------");
			}
			break;
		case 2:
			String sql="insert into easybuy_news (title,content) values(?,?)";
			System.out.println("���������ű���:");
			String title=input.next();
			System.out.println("��������������:");
			String content=input.next();
			Object[] objs={title,content};
			int result=nd.updataNews(sql, objs);
			if(result>=1){
				System.out.println("��ӳɹ�");
			}
			break;
		case 3:
			System.out.println("������ɾ�����ű��");
			num=input.nextInt();
			String sql2="delete from easybuy_news where id=?";
			Object[] objs2={num};
			int result2=nd.updataNews(sql2, objs2);
			if(result2>=1){
				System.out.println("ɾ���ɹ�");
			}
			break;	
		case 4:
			System.out.println("������Ҫ�޸ĵ����ű��:");
			num=input.nextInt();
			System.out.println("�������޸ĺ�ı���");
			String str_title=input.next();
			System.out.println("�������޸ĺ����������");
			String str_content=input.next();
			String sql3="update easybuy_news set title=?,content=? where id=?";
			Object[] objs3={str_title,str_content,num};
			int result3=nd.updataNews(sql3, objs3);
			if(result3>=1){
				System.out.println("�޸ĳɹ�");
			}
			break;
			
		default:
			break;
		}
	}

}
