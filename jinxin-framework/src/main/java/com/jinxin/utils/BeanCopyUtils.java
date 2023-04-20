package com.jinxin.utils;

import com.jinxin.domain.entity.Article;
import com.jinxin.domain.vo.HotArticleVo;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 86188
 * @version 1.0
 * @description 今心Blog
 * @data 2023/4/20 9:02
 */
public class BeanCopyUtils {
    private BeanCopyUtils() {
    }

    //泛型
    public static <V>V copyBean(Object source, Class<V> clazz) {
        // 创建目标对象
        V result = null;
        try {
            result = clazz.newInstance();
            // 实现属性copy
            BeanUtils.copyProperties(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 返回结果
        return result;

    }

    public static <O,V>List<V> copyBeanList(List<O> list, Class<V> clazz){
        return list.stream()
                .map(o -> copyBean(o, clazz))
                .collect(Collectors.toList());

    }


}
