package org.practice.service;

import org.practice.model.Post;
import org.practice.model.QueryPost;

import java.util.List;
import java.util.Map;

public interface PostService {
    int deleteByPrimaryKey(Integer id);

    int insert(Post post);

    Post selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Post post);

    Post select(Map map);

    List<Post> selectTen(Map map);

    List<Post> selectByStar(Map map);

    int getCounts();

    List<Post> selectAllSatisfied(QueryPost queryPost);

    List<Post> selectByUid(int uid);
}
