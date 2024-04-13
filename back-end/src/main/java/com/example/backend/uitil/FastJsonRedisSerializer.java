package com.example.backend.uitil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


/**
 * @projectName: Authentication_And_Authorization_Module
 * @package: com.example.backend.configuration
 * @className: redis
 * @author: Rainbow
 * @description: Redis使用FastJson序列化
 * @date: 2024/3/17 16:15
 * @version: 1.0
 */
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {
    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    private final Class<T> clazz;

    static {
        // 自1.2.25+版本，禁用部分autoType的功能，也就是@type这种指定类型的功能会被限制在一定范围内使用。反序列化对象时，需要检查是否开启autoType。没有开启就会报错。
        // Reference: https://blog.51cto.com/u_15851118/6453679
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        ParserConfig.getGlobalInstance().addAccept("org.springframework.security.core.authority.SimpleGrantedAuthority");
    }

    public FastJsonRedisSerializer(final Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(final T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        return JSON.toJSONString(t,
                SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(final byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        final String str = new String(bytes, DEFAULT_CHARSET);
        return JSON.parseObject(str, clazz);
    }

    protected JavaType getJavaType(final Class<?> clazz) {
        return TypeFactory.defaultInstance().constructType(clazz);
    }
}