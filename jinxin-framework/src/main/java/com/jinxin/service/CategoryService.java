
package com.jinxin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jinxin.domain.ResponseResult;
import com.jinxin.domain.entity.Category;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2023-04-20 10:06:33
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}

