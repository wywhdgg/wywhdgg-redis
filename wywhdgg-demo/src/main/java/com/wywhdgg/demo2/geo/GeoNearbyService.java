package com.wywhdgg.demo2.geo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 附近的ta服务示例
 * GeoNearbyService
 */
@Service
public class GeoNearbyService {

    // 参数可以是任何对象，默认由JDK序列化
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 上传位置
     */
    public void add(Point point, String userId) {
        redisTemplate.opsForGeo().add("user_geo", new RedisGeoCommands.GeoLocation<>(userId, point));
    }

    /**
     * 附近的人
     *
     * @param point 用户自己的位置
     * @param radius 范围，半径
     */
    public GeoResults<RedisGeoCommands.GeoLocation> near(Point point, int radius) {
        // 半径 100米
        Distance distance = new Distance(radius, RedisGeoCommands.DistanceUnit.METERS);
        Circle circle = new Circle(point, distance);
        // 附近5个人
        RedisGeoCommands.GeoRadiusCommandArgs geoRadiusCommandArgs = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeDistance().limit(5);
        GeoResults<RedisGeoCommands.GeoLocation> user_geo = redisTemplate.opsForGeo().radius("user_geo", circle, geoRadiusCommandArgs);
        return user_geo;
    }
}