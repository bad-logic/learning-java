package com.example.spring.security.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.owasp.encoder.Encode;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class InboundLogger extends HttpFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(InboundLogger.class);
    private final List<String> headers = Arrays.asList("X-Forwarded-For","Forwarded");

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String ip = this.headers.stream().map(request::getHeader).filter(iph-> StringUtils.hasText(iph)&&!"unknown".equalsIgnoreCase(iph)).findFirst().map(iph->String.format("%s,%s",iph,request.getRemoteAddr())).orElse(request.getRemoteAddr());
        String origin = Optional.ofNullable(request.getHeader("Origin")).orElse("no origin");
        String referer = Optional.ofNullable(request.getHeader("Referer")).orElse("no referer");
        String userAgent = Optional.ofNullable(request.getHeader("User-Agent")).orElse("no user-agent");

        LOGGER.info("INBOUND LOG: Resource {} {}?{} was requested by {} with origin ({}) referer ({}) user-agent ({})", Encode.forJava(request.getMethod()),Encode.forJava(request.getRequestURI()),Encode.forJava(request.getQueryString()),Encode.forJava(ip),Encode.forJava(origin),Encode.forJava(referer),Encode.forJava(userAgent));

        // allow the HttpRequest to go to Spring's DispatcherServlet
        // and @RestControllers/@Controllers.
        chain.doFilter(request, response); // (4)
    }
}
