package com.freetime.ddd.orm.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.freetime.ddd.orm.handler.DefaultDataFillHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MybatisPlusConfig {

    @Bean
    public MybatisSqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        Interceptor[] plugins = new Interceptor[1];
        plugins[0] = interceptor();
        sessionFactory.setPlugins(plugins);
        //全局配置
        GlobalConfig globalConfig  = new GlobalConfig();
        //配置填充器
        globalConfig.setMetaObjectHandler(new DefaultDataFillHandler());
        sessionFactory.setGlobalConfig(globalConfig);
        return sessionFactory;
    }

    @Bean
    public MybatisPlusInterceptor interceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

        // 乐观锁插件
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        // 分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        // 防止全表更新与删除插件
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());

        return interceptor;
    }
}
