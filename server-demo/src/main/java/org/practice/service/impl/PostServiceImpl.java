package org.practice.service.impl;

import org.practice.dao.PostDao;
import org.practice.model.Post;
import org.practice.model.QueryPost;
import org.practice.service.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {

    @Resource
    private PostDao postDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return postDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Post post) {
        return postDao.insert(post);
    }

    @Override
    public Post selectByPrimaryKey(Integer id) {
        return postDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Post post) {
        return postDao.updateByPrimaryKey(post);
    }

    @Override
    public Post select(Map map){ return postDao.select(map); }

    @Override
    public List<Post> selectTen(Map map) {
        return postDao.selectTen(map);
    }

    @Override
    public List<Post> selectByStar(Map map) {return postDao.selectByStar(map); }

    @Override
    public int getCounts() {
        return postDao.getCounts();
    }

    @Override
    public List<Post> selectAllSatisfied(QueryPost queryPost) {
        return postDao.selectAllSatisfied(queryPost);
    }

    @Override
    public List<Post> selectByUid(int uid) {
        return postDao.selectByUid(uid);
    }
}
