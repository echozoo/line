package com.athc.mongo.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document("foo")
data class Foo(
    @Id
    var id: String?,

    @Indexed(name = "id_name")
    val name: String,
    val createTime: Long
)