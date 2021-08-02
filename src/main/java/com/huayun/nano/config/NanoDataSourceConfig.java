package com.huayun.nano.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.huayun.cms.entity.TbDataSync;
import com.huayun.cms.service.ITbDataSyncService;
import com.huayun.cms.utils.DecodeBasePwd;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.huayun.nano.mapper", sqlSessionTemplateRef = "nanoSqlSessionTemplate")
@Slf4j
public class NanoDataSourceConfig {
    private TbDataSync slaveInfo;

    @Bean(name = "nanoDataSource")
    public DataSource testDataSource() {
        log.info("create sqlSession:nano");
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
        builder.driverClassName(slaveInfo.getDriver());
        builder.url(slaveInfo.getDbConn());
        builder.username(slaveInfo.getDbUser());
        builder.password(DecodeBasePwd.getDecodeBasePwd(slaveInfo.getDbPwd()));
        return builder.build();
    }

    @Bean(name = "nanoSqlSessionFactory")
    public SqlSessionFactory oldSqlSessionFactory(@Qualifier("nanoDataSource") DataSource dataSource) throws Exception {
        //SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeEnumsPackage("com.huayun.cms.entity");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/nano/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "nanoSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("nanoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Autowired
    private ITbDataSyncService service;

    /**
     * datasource
     */
    @PostConstruct
    public void getSlaveInfo() {
        this.slaveInfo = service.getById("Nano");
        log.info(slaveInfo.toString());
    }
}
