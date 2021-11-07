package com.sbs.example.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ArticleDao {

	SqlSessionFactory sqlSessionFactory;

	public ArticleDao() {
		init();
	}
	
	public void init() {
		try {
			String resource = "com/sbs/example/model/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertArticle(Article a) {
		try {
			SqlSession session = sqlSessionFactory.openSession();
			ArticleMapper mapper = session.getMapper(ArticleMapper.class);
			mapper.insertArticle(a);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Article> getArticles() {
		try {
			SqlSession session = sqlSessionFactory.openSession();
			ArticleMapper mapper = session.getMapper(ArticleMapper.class);
			return mapper.selectArticle();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateArticle(Article a) {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		mapper.updateArticle(a);
		session.commit();
	}

	public void deleteArticle(int id) {

		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		mapper.deleteArticle(id);
		session.commit();
	}

	public List<Article> getSearchedList(String keyword) {
		try {
			SqlSession session = sqlSessionFactory.openSession();
			ArticleMapper mapper = session.getMapper(ArticleMapper.class);
			return mapper.selectArticleByKeyword(keyword);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Article getArticleById(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.selectArticleById(id);
	}

	public void insertMember(Member m) {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		mapper.insertMember(m);
		session.commit();
	}

	public Member getMemberByLoginId(String loginId) {

		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.selectMemberByLoginId(loginId);

	}

	public Member getMemberByLoginIdAndLoginPw(Member m) {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.selectMemberByLoginIdAndLoginPw(m);
	}

	public void insertReply(Reply r) {

		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		mapper.insertReply(r);

		session.commit();

	}

	public List<Reply> getArticleRepliesByAritcleId(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.selectRepliesByArticleId(id);
	}
}
