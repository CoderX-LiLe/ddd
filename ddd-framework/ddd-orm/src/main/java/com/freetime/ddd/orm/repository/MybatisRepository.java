package com.freetime.ddd.orm.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class MybatisRepository<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

    protected abstract SFunction<T, ?> getIdAccessor();

    public T findOne(List<Triple<SFunction<T, ?>, Object, Predicate>> conditions) {
        LambdaQueryWrapper<T> queryWrapper = createQueryWrapperFromFunctions(conditions);
        queryWrapper.last("limit 1");
        return baseMapper.selectOne(queryWrapper);
    }

    public T findOne(List<Triple<SFunction<T, ?>, Object, Predicate>> conditions, SFunction<T, ?>[] selectFields) {
        LambdaQueryWrapper<T> queryWrapper = createQueryWrapperFromFunctions(conditions);
        queryWrapper.select(selectFields);
        queryWrapper.last("limit 1");
        return baseMapper.selectOne(queryWrapper);
    }

    public List<T> findList(List<Triple<SFunction<T, ?>, Object, Predicate>> conditions) {
        LambdaQueryWrapper<T> queryWrapper = createQueryWrapperFromFunctions(conditions);
        return baseMapper.selectList(queryWrapper);
    }

    public List<T> findList(List<Triple<SFunction<T, ?>, Object, Predicate>> conditions, SFunction<T, ?>[] selectFields) {
        LambdaQueryWrapper<T> queryWrapper = createQueryWrapperFromFunctions(conditions);
        queryWrapper.select(selectFields);
        return baseMapper.selectList(queryWrapper);
    }

    public IPage<T> findPage(List<Triple<SFunction<T, ?>, Object, Predicate>> conditions, Long pageNum, Long pageSize) {
        IPage<T> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<T> queryWrapper = createQueryWrapperFromFunctions(conditions);
        return baseMapper.selectPage(page, queryWrapper);
    }

    public IPage<T> findPage(List<Triple<SFunction<T, ?>, Object, Predicate>> conditions, SFunction<T, ?>[] selectFields, Long pageNum, Long pageSize) {
        IPage<T> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<T> queryWrapper = createQueryWrapperFromFunctions(conditions);
        queryWrapper.select(selectFields);
        return baseMapper.selectPage(page, queryWrapper);
    }

    public boolean updateById(Long id, T object, List<Pair<SFunction<T, ?>, Object>> updates) {
        if (object == null) {
            log.error("修改对象没有传id");
            throw new IllegalArgumentException();
        }
        if (CollectionUtils.isEmpty(updates)) {
            return true;
        }
        LambdaUpdateWrapper<T> updateWrapper = createUpdateWrapperFromFunctions(updates);
        updateWrapper.eq(getIdAccessor(), id);
        return update(object, updateWrapper);
    }

    public int delete(List<Triple<SFunction<T, ?>, Object, Predicate>> conditions) {
        LambdaQueryWrapper<T> queryWrapperFromFunctions = createQueryWrapperFromFunctions(conditions);
        return baseMapper.delete(queryWrapperFromFunctions);
    }

    /**
     * 获取查询条件构造器
     *
     * @return
     */
    public List<Triple<SFunction<T, ?>, Object, Predicate>> getQueryConditions() {
        List<Triple<SFunction<T, ?>, Object, Predicate>> conditions = new ArrayList<>();
        return conditions;
    }

    /**
     * 获取修改字段条件构造器
     *
     * @return
     */
    public List<Pair<SFunction<T, ?>, Object>> getUpdateConditions() {
        List<Pair<SFunction<T, ?>, Object>> conditions = new ArrayList<>();
        return conditions;
    }

    /**
     * 创建wrapper
     *
     * @param conditions
     * @return
     */
    private LambdaQueryWrapper<T> createQueryWrapperFromFunctions(List<Triple<SFunction<T, ?>, Object, Predicate>> conditions) {
        LambdaQueryWrapper<T> queryWrapper = new LambdaQueryWrapper<>();

        for (Triple<SFunction<T, ?>, Object, Predicate> condition : conditions) {
            SFunction<T, ?> column = condition.getLeft();
            Object value = condition.getMiddle();
            Predicate predicate = condition.getRight();

            switch (predicate) {
                case IS_EQUAL:
                    queryWrapper.eq(value != null, column, value);
                    break;
                case NOT_EQUAL:
                    queryWrapper.ne(value != null, column, value);
                    break;
                case IS_IN:
                    queryWrapper.in(value != null, column, (Collection<?>) value);
                    break;
                case IS_BETWEEN:
                    queryWrapper.between(column, ((List<?>) value).get(0), ((List<?>) value).get(1));
                    break;
                case NOT_BETWEEN:
                    queryWrapper.notBetween(column, ((List<?>) value).get(0), ((List<?>) value).get(1));
                    break;
                case LIKE:
                    queryWrapper.like(value != null, column, value);
                    break;
                case LIKE_LEFT:
                    queryWrapper.likeLeft(value != null, column, value);
                    break;
                case LIKE_RIGHT:
                    queryWrapper.likeRight(value != null, column, value);
                    break;
                case NOT_LIKE:
                    queryWrapper.notLike(value != null, column, value);
                    break;
                case IS_NOT_NULL:
                    queryWrapper.isNotNull(column);
                    break;
                case ORDER_ASC:
                    queryWrapper.orderByAsc(column);
                    break;
                case ORDER_DESC:
                    queryWrapper.orderByDesc(column);
                    break;
                case LAST:
                    queryWrapper.last(value.toString());
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported predicate: " + predicate);
            }
        }
        return queryWrapper;
    }

    /**
     * 创建更新wrapper
     *
     * @param conditions
     * @return
     */
    private LambdaUpdateWrapper<T> createUpdateWrapperFromFunctions(List<Pair<SFunction<T, ?>, Object>> conditions) {
        LambdaUpdateWrapper<T> updateWrapper = new LambdaUpdateWrapper<>();
        for (Pair<SFunction<T, ?>, Object> condition : conditions) {
            SFunction<T, ?> column = condition.getLeft();
            Object value = condition.getRight();
            updateWrapper.set(column, value);
        }
        return updateWrapper;

    }

}
