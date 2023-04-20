package com.jinxin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jinxin.domain.ResponseResult;
import com.jinxin.domain.entity.Article;

/**
 * @author 86188
 * @version 1.0
 * @description 今心Blog
 * @data 2023/4/19 13:21
 */
public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleList();
}
