package io.renren.modules.manage.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.manage.config.CommonConfig;
import io.renren.modules.manage.entity.ManageMessageEntity;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.manage.entity.ManagePunchEntity;
import io.renren.modules.manage.service.ManagePunchService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;


/**
 * 打卡签到表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
@RestController
@RequestMapping("/manage-punch")
public class ManagePunchController extends AbstractController {
    @Autowired
    private ManagePunchService managePunchService;

    @GetMapping("/status")
    public R status() {
        ManagePunchEntity up = managePunchService.getStatus(getUserId(), 0);
        ManagePunchEntity down = managePunchService.getStatus(getUserId(), 1);
        if (up == null) {
            up = new ManagePunchEntity();
        }
        if (down == null) {
            down = new ManagePunchEntity();
        }
        return R.ok().put("up", up).put("down", down);
    }

    @GetMapping("/ispunched")
    public R isPunched() {
        ManagePunchEntity up = managePunchService.getStatus(getUserId(), 0);
        ManagePunchEntity down = managePunchService.getStatus(getUserId(), 1);
        return R.ok().put("up", up == null ? 0 : 1).put("down", down == null ? 0 : 1);
    }

    @PostMapping("/punch")
    public R punch(@RequestBody ManagePunchEntity entity) {
        ManagePunchEntity up = managePunchService.getStatus(getUserId(), 0);
        ManagePunchEntity down = managePunchService.getStatus(getUserId(), 1);
        entity.setUserId(getUserId());
        entity.setCreateTime(new Date());
        if (up == null) {
            ValidatorUtils.validateEntity(entity, AddGroup.class);
            entity.setPunchType(entity.getPunchType() == 0 ? 2 : 0);
            managePunchService.save(entity);
        } else {
            if (down == null) {
                ValidatorUtils.validateEntity(entity, AddGroup.class);
                entity.setPunchType(entity.getPunchType() == 0 ? 3 : 1);
                managePunchService.save(entity);
            } else {
                entity.setPunchId(down.getPunchId());
                ValidatorUtils.validateEntity(entity, UpdateGroup.class);
                entity.setPunchType(entity.getPunchType() == 0 ? 3 : 1);
                managePunchService.updateById(entity);
            }
        }

        return R.ok();
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        Integer current = null;
        if (params.get("page") != null && !"".equals(params.get("page"))) {
            current = Integer.parseInt((String) params.get("page"));
        }
        Integer limit = null;
        if (params.get("limit") != null && !"".equals(params.get("limit"))) {
            limit = Integer.parseInt((String) params.get("limit"));
        }
        String date = null;
        if (params.get("date") != null && !"".equals(params.get("date"))) {
            date = (String) params.get("date");
        }

        Page<Map> ipage = new Page<>(current, limit);
        PageUtils page = new PageUtils(managePunchService.selectUserPage(ipage, getUserId(), date));

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{punchId}")
    @RequiresPermissions("manage:managepunch:info")
    public R info(@PathVariable("punchId") Long punchId) {
        ManagePunchEntity managePunch = managePunchService.getById(punchId);

        return R.ok().put("managePunch", managePunch);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manage:managepunch:save")
    public R save(@RequestBody ManagePunchEntity managePunch) {
        managePunchService.save(managePunch);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manage:managepunch:update")
    public R update(@RequestBody ManagePunchEntity managePunch) {
        managePunchService.updateById(managePunch);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manage:managepunch:delete")
    public R delete(@RequestBody Long[] punchIds) {
        managePunchService.removeByIds(Arrays.asList(punchIds));

        return R.ok();
    }

}
