package io.renren.modules.manage.config;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class CommonConfig {
    public static final String URL = "/home/projects/upload";
    public static final String UPLOAD_PATH = "/home/projects/upload";
    public static final String RESOURCE_PREFIX = "/profile";

    public static final String PUNCH_LOCATION = "PUNCH_LOCATION";
    public static final String PUNCH_LONGITUDE = "PUNCH_LONGITUDE";
    public static final String PUNCH_LATITUDE = "PUNCH_LATITUDE";
    public static final String PROV_CODE = "PROV_CODE";
    public static final String CITY_CODE = "CITY_CODE";
    public static final String AREA_CODE = "AREA_CODE";
    public static final String VISIT_PROV = "VISIT_PROV";

    /**
     * 获取完整的请求路径，包括：域名，端口，上下文访问路径
     *
     * @return 服务地址
     */
    public static String getUrl() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return getDomain(request);
    }

    public static String getDomain(HttpServletRequest request) {
        StringBuffer url = request.getRequestURL();
        String contextPath = request.getServletContext().getContextPath();
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).append(contextPath).toString();
    }
}
