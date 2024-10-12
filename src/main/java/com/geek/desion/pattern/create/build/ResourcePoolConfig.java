package com.geek.desion.pattern.create.build;

import lombok.Getter;

/**
 * 资源池配置类
 */
@Getter
public class ResourcePoolConfig {
    /**
     * 资源名
     */
    private String name;
    /**
     * 最大资源总数
     */
    private int maxTotal;
    /**
     * 最大空闲资源数量
     */
    private int maxIdle;
    /**
     * 最小空闲资源
     */
    private int minIdle;

    public ResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    public static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;

        private int maxTotal = DEFAULT_MAX_TOTAL;

        private int maxIdle = DEFAULT_MAX_IDLE;

        private int minIdle = DEFAULT_MIN_IDLE;

        public ResourcePoolConfig builder(){
            return new ResourcePoolConfig(this);
        }
    }

}
