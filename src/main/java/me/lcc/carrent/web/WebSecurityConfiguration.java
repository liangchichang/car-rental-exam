package me.lcc.carrent.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author lcc
 * @version 2022/7/30
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //custom login page
        http.formLogin()
                .loginPage("/login.html")//自定义登录页面
                .usernameParameter("userId")//表单中的用户名项
                .passwordParameter("password")//表单中的密码项
                .loginProcessingUrl("/login")//表单提交路劲，提交后执行认证逻辑
                .successForwardUrl("/carRent/rentPage?")//登录成功后的路劲
                .failureForwardUrl("/user/logInFail");//登录失败后的路劲

        //resources need to auth
        http.authorizeRequests()
                .antMatchers("/login.html", "/user/register", "/register.html")
                .permitAll()
                .anyRequest().authenticated();

        http.csrf().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider);
    }
}


