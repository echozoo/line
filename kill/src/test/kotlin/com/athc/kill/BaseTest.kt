package com.athc.kill

import com.athc.kill.config.KillAutoConfig
import com.athc.mybatis.config.MybatisConfig
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [KillAutoConfig::class, MybatisConfig::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
open class BaseTest