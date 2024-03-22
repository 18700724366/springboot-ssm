package xian.woniuxy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("过滤器开始");
        filterChain.doFilter(servletRequest, servletResponse);
//        System.out.println("过滤器结束");
    }
}