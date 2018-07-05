//package com.github.edgar615.spring.redis;
//
//@Configuration
//@ConditionalOnProperty(name = "redis.enabled", havingValue = "true")
//@EnableCaching
//public class RedisCacheConfig extends CachingConfigurerSupport implements CachingConfigurer {
//
//    @Value("${redis.host}")
//    private String host;
//
//    @Value("${redis.port}")
//    private Integer port;
//
//    @Value("${redis.expiration.timeout}")
//    private Integer expirationTimeout;
//
//    @Bean
//    public JedisConnectionFactory redisConnectionFactory() {
//        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
//        redisConnectionFactory.setHostName(host);
//        redisConnectionFactory.setPort(port);
//        redisConnectionFactory.setTimeout(10);
//        return redisConnectionFactory;
//    }
//
//    @Bean
//    public RedisTemplate<String, Set<String>> redisTemplate(@Autowired RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, Set<String>> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        return redisTemplate;
//    }
//
//    @Bean
//    public CacheManager cacheManager(@Autowired RedisTemplate redisTemplate) {
//        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
//        cacheManager.setDefaultExpiration(expirationTimeout);
//        return cacheManager;
//    }
//
//    @Override
//    public CacheErrorHandler errorHandler() {
//        return new RedisCacheErrorHandler();
//    }
//
//    @Slf4j
//    public static class RedisCacheErrorHandler implements CacheErrorHandler {
//
//        @Override
//        public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
//            log.info("Unable to get from cache " + cache.getName() + " : " + exception.getMessage());
//        }
//
//        @Override
//        public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
//            log.info("Unable to put into cache " + cache.getName() + " : " + exception.getMessage());
//        }
//
//        @Override
//        public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
//            log.info("Unable to evict from cache " + cache.getName() + " : " + exception.getMessage());
//        }
//
//        @Override
//        public void handleCacheClearError(RuntimeException exception, Cache cache) {
//            log.info("Unable to clean cache " + cache.getName() + " : " + exception.getMessage());
//        }
//    }
//}