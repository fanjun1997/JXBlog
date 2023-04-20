package com.jinxin.controller;

import com.jinxin.domain.ResponseResult;
import com.jinxin.domain.entity.Article;
import com.jinxin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 86188
 * @version 1.0
 * @description 今心Blog
 * @data 2023/4/19 13:28
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList() {

        ResponseResult result = articleService.hotArticleList();
        return result;
    }



}
