package io.renren.modules.manage.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.manage.config.CommonConfig;
import io.renren.modules.manage.dao.ManageParamDao;
import io.renren.modules.manage.entity.CodeEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.manage.entity.ManageParamEntity;
import io.renren.modules.manage.service.ManageParamService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 参数表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
@RestController
@RequestMapping("/manage-param")
public class ManageParamController {
    @Autowired
    private ManageParamService manageParamService;
    @Autowired
    private ManageParamDao paramDao;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("manage:manageparam:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = manageParamService.getList(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{paramId}")
    @RequiresPermissions("manage:manageparam:info")
    public R info(@PathVariable("paramId") Long paramId){
		ManageParamEntity manageParam = manageParamService.getById(paramId);

        return R.ok().put("manageParam", manageParam);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manage:manageparam:save")
    public R save(@RequestBody ManageParamEntity manageParam){
        ValidatorUtils.validateEntity(manageParam, AddGroup.class);
		manageParamService.save(manageParam);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manage:manageparam:update")
    public R update(@RequestBody ManageParamEntity manageParam){
        ValidatorUtils.validateEntity(manageParam, UpdateGroup.class);
		manageParamService.updateById(manageParam);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manage:manageparam:delete")
    public R delete(@RequestBody Long[] paramIds){
		manageParamService.removeByIds(Arrays.asList(paramIds));

        return R.ok();
    }

    /**
     * 导入省市区code
     */
    @RequestMapping("test")
    public R test(@RequestBody CodeEntity[] codeEntities) {
        final Long PROV_PARENT = 3L;
        final Long CITY_PARENT = 4L;
        final Long AREA_PARENT = 5L;
        final String PROV_PREFIX = "PROV_";
        final String CITY_PREFIX = "CITY_";
        final String AREA_PREFIX = "AREA_";
        final String DELIMETER = "_";
        int provSize = codeEntities.length;
        int i = 0;
        int j = 0;
        int k = 0;
        for (CodeEntity prov : codeEntities) {
            i++;
            j=0;
            System.out.println("==============================================================================================================");
            System.out.println("省：" + i + " / " + provSize);
            ManageParamEntity param = new ManageParamEntity();
            param.setGroupId(PROV_PARENT);
            param.setParamName(PROV_PREFIX + prov.getCode());
            param.setParamValue(String.valueOf(prov.getCode()));
            param.setRemark(prov.getName());
            paramDao.insert(param);
            if (null != prov.getChildren()) {
                int citySize = prov.getChildren().length;
                for (CodeEntity city : prov.getChildren()) {
                    j++;
                    k=0;
                    System.out.println("==============================================================================================================");
                    System.out.println("省：" + i + " / " + provSize + " 市：" + j + " / " + citySize);
                    ManageParamEntity cityParam = new ManageParamEntity();
                    cityParam.setGroupId(CITY_PARENT);
                    cityParam.setParamName(PROV_PREFIX + prov.getCode() + DELIMETER + CITY_PREFIX + city.getCode());
                    cityParam.setParamValue(String.valueOf(city.getCode()));
                    cityParam.setRemark(city.getName());
                    paramDao.insert(cityParam);
                    if (null != city.getChildren()) {
                        int areaSize = city.getChildren().length;
                        for (CodeEntity area : city.getChildren()) {
                            System.out.println("==============================================================================================================");
                            System.out.println("省：" + i + " / " + provSize + " 市：" + j + " / " + citySize + " 区：" + ++k + " / " + areaSize);
                            ManageParamEntity areaParam = new ManageParamEntity();
                            areaParam.setGroupId(AREA_PARENT);
                            areaParam.setParamName(PROV_PREFIX + prov.getCode() + DELIMETER + CITY_PREFIX + city.getCode() + DELIMETER + AREA_PREFIX + area.getCode());
                            areaParam.setParamValue(String.valueOf(area.getCode()));
                            areaParam.setRemark(area.getName());
                            paramDao.insert(areaParam);
                        }
                    }
                }
            }
        }
        return R.ok();
    }

    /**
     * 获取省份列表
     */
    @GetMapping("/provs")
    public R provs() {
        List<ManageParamEntity> provs = paramDao.cities(CommonConfig.PROV_CODE, null);
        return R.ok().put("data", provs);
    }

    /**
     * 获取市级列表
     */
    @GetMapping("/cities")
    public R cities(@RequestParam("code") String code) {
        List<ManageParamEntity> cities = paramDao.cities(CommonConfig.CITY_CODE, code);
        return R.ok().put("data", cities);
    }

    /**
     * 获取区级列表
     */
    @GetMapping("/areas")
    public R areas(@RequestParam("code") String code) {
        List<ManageParamEntity> areas = paramDao.cities(CommonConfig.AREA_CODE, code);
        return R.ok().put("data", areas);
    }



}
