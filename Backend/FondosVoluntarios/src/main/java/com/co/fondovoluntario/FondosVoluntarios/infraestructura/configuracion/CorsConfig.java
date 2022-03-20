package com.co.fondovoluntario.FondosVoluntarios.infraestructura.configuracion;

import com.co.fondovoluntario.FondosVoluntarios.infraestructura.configuracion.propiedades.PropiedadesCors;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsConfig implements Filter {

    private final PropiedadesCors propiedadesCors;

    public CorsConfig(PropiedadesCors propiedadesCors) {
        this.propiedadesCors = propiedadesCors;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", propiedadesCors.getUrlPermitida());
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS, HEAD");
        response.setHeader("Access-Control-Allow-Headers",
                "access-control-allow-methods, access-control-allow-origin, X-APP-RELAYSTATE, X-XSRF-TOKEN, Content-Type, Accept, Origin, Cookie, Authorization");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(((HttpServletRequest) req).getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }
}