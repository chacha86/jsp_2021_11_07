package com.sbs.example.model;

import java.util.List;

public interface ArticleMapper {

	void insertArticle(Article a);
	List<Article> selectArticle();
	void updateArticle(Article a);
	void deleteArticle(int id);
	List<Article> selectArticleByKeyword(String keyword);
	Article selectArticleById(int id);
	void insertMember(Member m);
	Member selectMemberByLoginId(String loginId);
	Member selectMemberByLoginIdAndLoginPw(Member m);
	void insertReply(Reply r);
	List<Reply> selectRepliesByArticleId(int id);

}
