package com.jinxin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jinxin.constants.SystemConstants;
import com.jinxin.domain.ResponseResult;
import com.jinxin.domain.entity.Article;
import com.jinxin.domain.vo.HotArticleVo;
import com.jinxin.mapper.ArticleMapper;
import com.jinxin.service.ArticleService;
import com.jinxin.utils.BeanCopyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 86188
 * @version 1.0
 * @description 今心Blog
 * @data 2023/4/19 13:23
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Override
    public ResponseResult hotArticleList() {

        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //必须是正式文章
        queryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        // 必须是按照浏览量进行排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多值查询10条
        Page<Article> page = new Page(1,10);
        page(page,queryWrapper);

        List<Article> articles = page.getRecords();

        // bean拷贝
        // List<HotArticleVo> articleVos = new ArrayList<>();

        // for(Article article : articles){
        //     HotArticleVo vo = new HotArticleVo();
        //     BeanUtils.copyProperties(article, vo);
        //     articleVos.add(vo);
        // }

        List<HotArticleVo> vs = BeanCopyUtils.copyBeanList(articles, HotArticleVo.class);


        return ResponseResult.okResult(vs);
    }
}
