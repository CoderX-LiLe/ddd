package com.freetime.ddd.core.dto;

import lombok.Data;

import java.util.Collection;

@Data
public class PageResult<T> {

    private Long current;

    private Long size;

    private Long total;

    private Long pages;

    private Collection<T> data;

    public static <T> PageResult<T> of(Long current, Long size, Long total, Long pages, Collection<T> data) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setCurrent(current);
        pageResult.setSize(size);
        pageResult.setTotal(total);
        pageResult.setPages(pages);
        pageResult.setData(data);
        return pageResult;
    }
}
