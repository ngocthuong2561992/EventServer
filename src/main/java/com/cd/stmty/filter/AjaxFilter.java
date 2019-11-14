package com.cd.stmty.filter;

import com.cd.stmty.model.UserDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxFilter  extends GenericFilterBean {

    private final Logger logger = LoggerFactory.getLogger(AjaxFilter.class);

    private static final int EXPIRED_CODE = 901;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String ajaxHeader = ((HttpServletRequest) request).getHeader("X-Requested-With");

        if ("XMLHttpRequest".equals(ajaxHeader)) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            Object principal = auth.getPrincipal();
//            if (principal instanceof UserDetail) {
//                chain.doFilter(request, response);
//            } else {
//                logger.info("Session expired!");
//                HttpServletResponse resp = (HttpServletResponse) response;
//                resp.sendError(EXPIRED_CODE);
//            }
        } else {
            chain.doFilter(request, response);
        }

    }

}