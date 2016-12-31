package com.paddycurtin;

import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class HttpHeaderFilter
 */
public class HttpHeaderFilter implements Filter {

   public void  init(FilterConfig config) throws ServletException{
      String testParam = config.getInitParameter("test-parameter"); 
      System.out.println("Test Parameter: " + testParam); 
   }
   public void  doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws java.io.IOException, ServletException {
      // Get the IP address of client machine.   
      String ipAddress = request.getRemoteAddr();
      // Log the IP address and current time stamp.
      System.out.println("IP "+ ipAddress + ", Time " + new Date().toString());
      // Pass request back down the filter chain
      
      response.setContentType("text/html; charset=utf-8");
      System.out.println("Filter activated. Setting content-type to text/html; charset=utf-8");
      //response.setContentType("text/html; charset=us-ascii");
      chain.doFilter(request,response);
   }
   public void destroy( ){
   }

}
