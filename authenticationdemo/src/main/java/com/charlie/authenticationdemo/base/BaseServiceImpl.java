package com.charlie.authenticationdemo.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.charlie.authenticationdemo.utils.UUIDUtil;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @author liuqi
 * @date 2020/7/22
 * @Description
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

    protected Log logger = LogFactory.getLog(getClass());

    private String userId = null;

    /**
     * 是否继承 BaseEntity
     * @param clz clz
     * @return 是否继承
     */
    public boolean isExtendsBaseEntity(Class<?> clz) {
        if (clz == Object.class) {
            return false;
        } else {
            Class<?> clzSuper = clz.getSuperclass();
            if (clzSuper == BaseEntity.class) {
                return true;
            } else {
                return isExtendsBaseEntity(clzSuper);
            }
        }
    }

    public boolean save(T item) {
        if (item != null && isExtendsBaseEntity(item.getClass())) {
            LocalDateTime nowTime = LocalDateTime.now();
            BaseEntity entity = (BaseEntity) item;
            if (StringUtils.isBlank(entity.getId())) {
                entity.setId(UUIDUtil.randomUUID());
            }
            entity.setCreateDate(nowTime);
            entity.setUpdateDate(nowTime);
            entity.setDelFlag(false);
            if (StringUtils.isNotBlank(userId)) {
                entity.setCreateBy(userId);
                entity.setUpdateBy(userId);
            }
        }
        userId = null;
        return super.save(item);
    }

    /**
     * 批量插入
     *
     * @param entityList ignore
     * @param batchSize  ignore
     * @return ignore
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean saveBatch(Collection<T> entityList, int batchSize) {
        if (entityList != null && !entityList.isEmpty()) {
            T firstItem = entityList.stream().filter(t -> t != null).findFirst().orElse(null);
            if (firstItem != null && isExtendsBaseEntity(firstItem.getClass())) {
                for (T item : entityList) {
                    LocalDateTime nowTime = LocalDateTime.now();
                    BaseEntity entity = (BaseEntity) item;
                    if (StringUtils.isBlank(entity.getId())) {
                        entity.setId(UUIDUtil.randomUUID());
                    }
                    entity.setCreateDate(nowTime);
                    entity.setUpdateDate(nowTime);
                    entity.setDelFlag(false);
                    if (StringUtils.isNotBlank(userId)) {
                        entity.setCreateBy(userId);
                        entity.setUpdateBy(userId);
                    }
                }
            }
        }
        return super.saveBatch(entityList, batchSize);
    }

    public boolean saveOrUpdate(T item) {
        if (item != null && isExtendsBaseEntity(item.getClass())) {
            BaseEntity entity = (BaseEntity) item;
            LocalDateTime nowTime = LocalDateTime.now();
            if (StringUtils.isBlank(entity.getId())) {
                entity.setId(UUIDUtil.randomUUID());
                entity.setCreateDate(nowTime);
                entity.setDelFlag(false);
                if (StringUtils.isNotBlank(userId)) {
                    entity.setCreateBy(userId);
                }
            }
            entity.setUpdateDate(nowTime);
            if (StringUtils.isNotBlank(userId)) {
                entity.setUpdateBy(userId);
            }
        }
        return super.saveOrUpdate(item);
    }

    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
        if (entityList != null && !entityList.isEmpty()) {
            T firstItem = entityList.stream().filter(t -> t != null).findFirst().orElse(null);
            if (firstItem != null && isExtendsBaseEntity(firstItem.getClass())) {
                for (T item : entityList) {
                    BaseEntity entity = (BaseEntity) item;
                    LocalDateTime nowTime = LocalDateTime.now();
                    if (StringUtils.isBlank(entity.getId())) {
                        entity.setId(UUIDUtil.randomUUID());
                        entity.setCreateDate(nowTime);
                        entity.setDelFlag(false);
                        if (StringUtils.isNotBlank(userId)) {
                            entity.setCreateBy(userId);
                        }
                    }
                    entity.setUpdateDate(nowTime);
                    if (StringUtils.isNotBlank(userId)) {
                        entity.setUpdateBy(userId);
                    }
                }
            }
        }
        return super.saveOrUpdateBatch(entityList, batchSize);
    }

    public boolean updateById(T item) {
        if (item != null && isExtendsBaseEntity(item.getClass())) {
            BaseEntity entity = (BaseEntity) item;
            entity.setUpdateDate(LocalDateTime.now());
            if (StringUtils.isNotBlank(userId)) {
                entity.setUpdateBy(userId);
            }
        }
        return super.updateById(item);
    }

    public boolean update(T item, Wrapper<T> updateWrapper) {
        if (item != null && isExtendsBaseEntity(item.getClass())) {
            BaseEntity entity = (BaseEntity) item;
            entity.setUpdateDate(LocalDateTime.now());
            if (StringUtils.isNotBlank(userId)) {
                entity.setUpdateBy(userId);
            }
        }
        return super.update(item, updateWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatchById(Collection<T> entityList, int batchSize) {
        if (entityList != null && !entityList.isEmpty()) {
            T firstItem = entityList.stream().filter(t -> t != null).findFirst().orElse(null);
            if (firstItem != null && isExtendsBaseEntity(firstItem.getClass())) {
                for (T item : entityList) {
                    BaseEntity entity = (BaseEntity) item;
                    entity.setUpdateDate(LocalDateTime.now());
                    if (StringUtils.isNotBlank(userId)) {
                        entity.setUpdateBy(userId);
                    }
                }
            }
        }
        return super.updateBatchById(entityList, batchSize);
    }

}