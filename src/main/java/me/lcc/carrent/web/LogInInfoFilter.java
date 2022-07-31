package me.lcc.carrent.web;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lcc
 * @version 2022/7/31
 */
@Component
public class LogInInfoFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String remoteAddr = request.getRemoteAddr();
        String userId = LogInContext.getUserId(remoteAddr);
        if (userId != null && !userId.isBlank()) {
            LogInContext.setUserId(userId);
        }
        filterChain.doFilter(request, response);
    }
}
