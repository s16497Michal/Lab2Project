package web.filters;

import model.User;
import org.apache.commons.lang3.StringUtils;
import web.SessionRegistry;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebFilter
public class MainFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        User currentUser = null;
        String url = ((HttpServletRequest)servletRequest).getRequestURL().toString();
        if (userRequestsRestrictedUrl(url)) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equalsIgnoreCase("session")) {
                    final String sessionId = cookie.getValue();
                    currentUser = SessionRegistry.sessionRegistry.get(sessionId);
                    break;
                }
            }
            if (currentUser == null) {
                HttpServletResponse  httpresponse = (HttpServletResponse) servletResponse;
                httpresponse.sendError(HttpServletResponse.SC_FORBIDDEN);
                return;
            }
            if (!currentUser.isAdminAccess() && wantsToAccessAdminPage(url)) {
                HttpServletResponse  httpresponse = (HttpServletResponse) servletResponse;
                httpresponse.sendError(HttpServletResponse.SC_FORBIDDEN);
            }
            if (!currentUser.isPremium() && wantsToAccessPremiomPage(url)) {
                HttpServletResponse  httpresponse = (HttpServletResponse) servletResponse;
                httpresponse.sendError(HttpServletResponse.SC_FORBIDDEN);
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
    private static List<String> ADMIN_PAGES = Arrays.asList("welcome_new_adm", "user_access");

    private boolean wantsToAccessAdminPage(String url) {
        for (String urlChunk : ADMIN_PAGES) {
            if (StringUtils.containsIgnoreCase(url, urlChunk)) {
                return true;
            }
        }
        return false;
    }

    private static List<String> PREMIUM_PAGES = Arrays.asList("welcome_new_premium");
    private boolean wantsToAccessPremiomPage(String url) {
        for (String urlChunk : PREMIUM_PAGES) {
            if (StringUtils.containsIgnoreCase(url, urlChunk)) {
                return true;
            }
        }
        return false;
    }

    private boolean userRequestsRestrictedUrl(String url) {
        List<String> restrictedUrls = new ArrayList(ADMIN_PAGES);
        restrictedUrls.addAll(PREMIUM_PAGES);
        for (String urlRestricted: restrictedUrls) {
            if (StringUtils.containsIgnoreCase(url, urlRestricted)) {
                return true;
            }
        }
        return false;
    }

    public void destroy() {

    }
}
