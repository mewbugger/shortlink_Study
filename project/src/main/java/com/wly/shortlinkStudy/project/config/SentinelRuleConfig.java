package com.wly.shortlinkStudy.project.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化限流配置
 */
@Component
public class SentinelRuleConfig implements InitializingBean {
    // 实现 InitializingBean 接口，在 bean 初始化后执行一些操作
    @Override
    public void afterPropertiesSet() throws Exception {
        // 创建一个空的规则列表
        List<FlowRule> rules = new ArrayList<>();
        // 创建一个流控规则对象 用于限制创建短连接接口的访问频率
        FlowRule createOrderRule = new FlowRule();
        // 设置资源名，这里通常指定需要进行限流的名称或接口路径
        createOrderRule.setResource("create_short-link");
        // 设置限流阈值的模式，这里使用QPS模式，即每秒允许的请求数
        createOrderRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 设置限流阈值，这里表示每秒最多允许处理1个请求
        createOrderRule.setCount(1);
        // 将创建好的流控规则添加到规则列表中
        rules.add(createOrderRule);
        // 调用 Sentinel 提供的管理器加载规则列表，将规则生效
        FlowRuleManager.loadRules(rules);
    }
}
