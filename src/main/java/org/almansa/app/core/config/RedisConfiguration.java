package org.almansa.app.core.config;

import org.almansa.app.core.entity.member.SimpleMember;
import org.almansa.app.core.service.dto.LoginMemberSessionModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration("localhost", 6379);
		
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisConfig);
		return jedisConnectionFactory;
	}
	
	@Bean
	public RedisTemplate<String, LoginMemberSessionModel> memberRedisTemplate(){
		RedisTemplate<String, LoginMemberSessionModel> redisTemplate = new RedisTemplate<>();
		redisTemplate.setEnableTransactionSupport(true); // 트랜젝션 적용여부
		redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer<LoginMemberSessionModel>(LoginMemberSessionModel.class));
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		
		return redisTemplate;
	}
}
