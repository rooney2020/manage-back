package io.renren.modules.manage.controller;

import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.modules.manage.config.CommonConfig;
import io.renren.modules.manage.utils.FileUploadUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/common")
public class CommonController {
    @PostMapping("/upload")
    public R uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }
        try {
            // 文件路径
            String fileName = FileUploadUtil.upload(CommonConfig.UPLOAD_PATH, file);
            // 返回
            return R.ok().put("fileName", fileName);
        } catch (Exception e) {
            // 返回错误信息
            return R.error(e.getMessage());
        }
    }
}
