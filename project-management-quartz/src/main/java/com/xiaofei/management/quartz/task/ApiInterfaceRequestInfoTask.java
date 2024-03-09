package com.xiaofei.management.quartz.task;

import cn.hutool.core.util.RandomUtil;
import com.xiaofei.management.api.service.IApiInterfaceRequestInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * 定时生成最近指定天数调用接口次数数据
 * ClassName: ApiInterfaceRequestInfoTask
 * Package: com.xiaofei.management.quartz.task
 *
 * @Author: XiaoFei
 * @Create: 2024/3/7 14:33
 * @Email: 1903078434@qq.com
 * @Version: 1.0
 */
@Component("apiInterfaceRequestInfo")
@Slf4j
public class ApiInterfaceRequestInfoTask {

    @Autowired
    private IApiInterfaceRequestInfoService apiInterfaceRequestInfoService;

    /**
     * 定时生成最近指定天数调用接口次数数据
     */
    public void generateRequestInfo() {
        log.info(("定时生成最近指定天数调用接口次数数据======start"));
        apiInterfaceRequestInfoService.generateRequestInfo(RandomUtil.randomInt(200, 1000), LocalDate.now());
        log.info(("定时生成最近指定天数调用接口次数数据======end"));
    }
}
