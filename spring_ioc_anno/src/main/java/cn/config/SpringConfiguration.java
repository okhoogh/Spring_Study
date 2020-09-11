package cn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 标志该类是Spring的核心配置类
@Configuration

//<context:component-scan base-package="cn"/>
@ComponentScan("cn")

//<import resource=""/>
@Import({DataSourceConfigration.class})
public class SpringConfiguration {

}