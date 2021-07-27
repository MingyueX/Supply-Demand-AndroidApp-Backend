package org.practice.service.impl;

import org.practice.dao.CategoryDao;
import org.practice.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryDao categoryDao;

    @Override
    public int getCid(String name) {
        return categoryDao.getCid(name);
    }
}
