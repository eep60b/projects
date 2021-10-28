package com.etlsolutions.excel.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

@WebFilter("/*") // default value is for urlPatterns
public final class HardenServletSecurity implements Filter 
{
  private static final String[] IP_HEADER_CANDIDATES =
  {
    "X-Forwarded-For",
    "Proxy-Client-IP",
    "WL-Proxy-Client-IP",
    "HTTP_X_FORWARDED_FOR",
    "HTTP_X_FORWARDED",
    "HTTP_X_CLUSTER_CLIENT_IP",
    "HTTP_CLIENT_IP",
    "HTTP_FORWARDED_FOR",
    "HTTP_FORWARDED",
    "HTTP_VIA",
    "REMOTE_ADDR"
  }; 
  
  @Override
  public void init(FilterConfig filterConfig) throws ServletException 
  {
    // Do nothing 
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException 
  {
    Logger logger = Logger.getLogger(HardenServletSecurity.class);
    HttpServletResponse response = (HttpServletResponse) res;
    HttpServletRequest request = (HttpServletRequest) req;
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, private"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setHeader("X-Content-Type-Options", "nosniff");
    response.setHeader("X-Frame-Options", "deny");
    response.setHeader("X-XSS-Protection", "1; mode=block");
    response.setDateHeader("Expires", 0); // Proxies.
    MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest(request);
    mutableRequest.putHeader("X-Content-Type-Options", "nosniff");
    mutableRequest.putHeader("Cache-Control", "no-cache, no-store, must-revalidate, private");
    HttpSession session = request.getSession();
    logger.info("HTTP request from: " + getClientIpAddress(request) + " with Session ID: " + session.getId());
    chain.doFilter(mutableRequest,  response);
  }

  @Override
  public void destroy() 
  {
    // Do nothing
  }
  
  private String getClientIpAddress(HttpServletRequest request)
  {
    for (String header : IP_HEADER_CANDIDATES)
    {
      String ip = request.getHeader(header);
      if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip))
      {
        return ip;
      }
    }
    return request.getRemoteAddr();
  }  
  
}
