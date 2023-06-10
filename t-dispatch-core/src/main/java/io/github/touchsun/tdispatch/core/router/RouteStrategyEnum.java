package io.github.touchsun.tdispatch.core.router;

import io.github.touchsun.tdispatch.core.router.strategy.FirstRouter;
import io.github.touchsun.tdispatch.core.router.strategy.LastRouter;
import io.github.touchsun.tdispatch.core.router.strategy.ShardingBroadcastRouter;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 路由选择策略
 */
@Slf4j
public enum RouteStrategyEnum {

    /**
     * 优先选择第一个引擎
     */
    FIRST("优先选择第一个引擎", new FirstRouter()),

    /**
     * 优先选择最后一个引擎
     */
    LAST("优先选择最后一个引擎", new LastRouter()),

    /**
     * 轮询选择引擎
     */
    ROUND("轮询选择引擎", null),

    /**
     * 随机选择引擎
     */
    RANDOM("随机选择引擎", null),

    /**
     * 基于一致性哈希算法选择引擎，该算法可以有效地解决缓存和负载均衡问题
     */
    CONSISTENT_HASH("基于一致性哈希算法选择引擎", null),

    /**
     * 选择最不经常使用的引擎，即选择最近被使用次数最少的引擎
     */
    LEAST_FREQUENTLY_USED("选择最不经常使用的引擎", null),

    /**
     * 选择最近最少使用的引擎，即选择最近被使用时间最长的引擎
     */
    LEAST_RECENTLY_USED("选择最近最少使用的引擎", null),

    /**
     * 选择可用性最高的引擎，即选择当前可用性最高的引擎，
     * 如果该引擎不可用，则自动切换到下一个可用引擎
     */
    FAIL_OVER("选择可用性最高的引擎", null),

    /**
     * 选择负载最小的引擎
     */
    BUSY_OVER("选择负载最小的引擎", null),

    /**
     * 引擎分片广播
     */
    SHARDING_BROADCAST("引擎分片广播", new ShardingBroadcastRouter());

    RouteStrategyEnum(String title, EngineRouter router) {
        this.title = title;
        this.router = router;
    }

    /**
     * 路由策略的名称
     */
    @Getter
    private final String title;

    /**
     * 引擎路由器对象
     */
    @Getter
    private final EngineRouter router;

    /**
     * 根据名称匹配对应的路由策略
     *
     * @param name 路由策略名称
     * @param defaultItem 默认路由策略
     * @return 匹配到的路由策略
     */
    public static RouteStrategyEnum parse(String name, RouteStrategyEnum defaultItem){
        if (name != null) {
            for (RouteStrategyEnum item: RouteStrategyEnum.values()) {
                if (item.name().equals(name)) {
                    return item;
                }
            }
        }
        // 系统未配置对应策略, 直接返回默认
        log.warn("系统不支持的策略 - {}", defaultItem);
        return defaultItem;
    }

}