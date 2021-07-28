package com.athc.mongo.service

import com.athc.mongo.domain.Foo

interface FooService {
    fun create(foo: Foo): Boolean;
    fun list(): List<Foo>;
    fun detail(id: String): Foo;
    fun update(foo: Foo): Boolean;
    fun delete(id: String): Boolean;
}