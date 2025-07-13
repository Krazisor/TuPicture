package com.thr.picturebackend.api.imagesearch.sub;

import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpStatus;
import cn.hutool.json.JSONUtil;
import com.thr.picturebackend.exception.BusinessException;
import com.thr.picturebackend.exception.ErrorCode;
import com.thr.picturebackend.exception.ThrowUtils;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.internal.StringUtil;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取以图搜图的页面地址
 */
@Slf4j
public class GetImagePageUrlApi {
    public static String getImagePageUrl (String imageUrl) {
        try {
            Map<String, Object> formData = new HashMap<>();
            formData.put("image", imageUrl);
            formData.put("tn", "pc");
            formData.put("from", "pc");
            formData.put("image_source", "PC_UPLOAD_URL");
            // 获取当前时间戳
            long uptime = System.currentTimeMillis();
            String url = "https://graph.baidu.com/upload?uptime=" + uptime;
            String acsToken = "1752207989162_1752287643443_EOM13Lfq82CGKmsNwQZQln0c8LpNFV6uSvsPpg0PgQFf6SdsNCEJsiqiSuVCOT13Bg5qgDddo4Alw/yaUkDrGKbVuELPoXdGbFh4dbqcVtqKxeKNKQCEhWyFn6fmtXlJY71ocIMo1RolWMS5FwKgCo5VUsJS97SsO8rDkYxRKohvfE0V38Mse08dk9v4HpVRV/2WUeVhCIOFm0QpW73Vse+H+7BkEIW4Xq7NLhfBIe80TmAUgD37MqtjcC4V7fGSRDxrrm3BA0Ds+hv8dG/YNZ/8JaFSoJSim3+7GV+8S63XqYsXF2X/32TieJeAD0KOZy77awkC82M/5LXzcX8fanAp+dZ3brlR14+xzgRVkYDvi1/XSdaP1XYyyRrYh97HmsvjLikSi2XPFkQ6HKQewSi9YIvAYSXeQ4ZGENz/HJE76XmLkTiQbcScwf4lpDgq";
            HttpResponse httpResponse = HttpRequest.post(url)
                    .form(formData)
                    .timeout(5000)
                    .header("Acs-Token", acsToken)
                    .execute();
            ThrowUtils.throwIf(httpResponse.getStatus() != HttpStatus.HTTP_OK, ErrorCode.OPERATION_ERROR, "接口调用失败");
            String body = httpResponse.body();
            Map<String, Object> result = JSONUtil.toBean(body, Map.class);
            ThrowUtils.throwIf(result == null || !Integer.valueOf(0).equals(result.get("status")),
                    ErrorCode.OPERATION_ERROR, "接口调用失败");
            Map<String, Object> data = (Map<String, Object>) result.get("data");
            // 对url进行解码
            String rawUrl = data.get("url").toString();
            String searchResultUrl = URLUtil.decode(rawUrl, StandardCharsets.UTF_8);
            ThrowUtils.throwIf(StringUtil.isBlank(searchResultUrl), ErrorCode.OPERATION_ERROR, "未返回有效的结果地址");
            return searchResultUrl;
        } catch (Exception e) {
            log.error("调用百度以图搜图接口失败", e);
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "调用百度以图搜图接口失败");
        }
    }
}
