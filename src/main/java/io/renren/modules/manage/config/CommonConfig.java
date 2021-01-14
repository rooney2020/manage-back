package io.renren.modules.manage.config;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 请修改注释
 *
 * @author zhaoliyuan
 * @date 2021.01.07
 */
public class CommonConfig {
    public static final String URL = "/home/projects/upload";
    public static final String UPLOAD_PATH = "/home/projects/upload";
    public static final String RESOURCE_PREFIX = "/profile";

    public static final String PROV_CODE = "PROV_CODE";
    public static final String CITY_CODE = "CITY_CODE";
    public static final String AREA_CODE = "AREA_CODE";
    public static final String PROV_PREFIX = "PROV_";
    public static final String CITY_PREFIX = "CITY_";
    public static final String AREA_PREFIX = "AREA_";
    public static final String UNDER_DELIMETER = "_";

    /**
     * 获取完整的请求路径，包括：域名，端口，上下文访问路径
     *
     * @return 服务地址
     */
    public static String getUrl()
    {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return getDomain(request);
    }

    public static String getDomain(HttpServletRequest request)
    {
        StringBuffer url = request.getRequestURL();
        String contextPath = request.getServletContext().getContextPath();
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).append(contextPath).toString();
    }
}
