package cn.baizhi.dao;

import java.util.List;

public interface BaseDao<T,K> {
    void insert(T t);

    List<T> selectAll(T t);

    void delete(K k);

    void update(T t);
}
