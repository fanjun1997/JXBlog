package com.jinxin.service.impl;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jinxin.constants.SystemConstants;
import com.jinxin.domain.ResponseResult;
import com.jinxin.domain.entity.Article;
import com.jinxin.domain.entity.Category;
import com.jinxin.domain.vo.CategoryVo;
import com.jinxin.mapper.CategoryMapper;
import com.jinxin.service.ArticleService;
import com.jinxin.service.CategoryService;
import com.jinxin.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 分类表(Category)表服务实现类
 *
 * @author makejava
 * @since 2023-04-20 10:08:00
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private ArticleService articleService;

    @Override
    public ResponseResult getCategoryList() {
        // 查询问文章表 状态位已发布
        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
        //必须是正式文章
        articleWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        List<Article> articlelist = articleService.list(articleWrapper);
        // 过去文章的分类id，并求去重
        Set<Long> categoryIds = articlelist.stream()
                .map(article -> article.getCategoryId())
                .collect(Collectors.toSet());

        //查询分类表
        List<Category> categories = listByIds(categoryIds);
        categories = categories.stream()
                .filter(category -> SystemConstants.STATUS_NORMAL.equals(category.getStatus()))
                .collect(Collectors.toList());


        //封装vo
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categories, CategoryVo.class);
        return ResponseResult.okResult(categoryVos);
    }
}
