package com.athc.mongo.controller

import com.athc.mongo.domain.Foo
import com.athc.mongo.service.FooService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("foo")
class FooController(
        private val fooService: FooService
) {

    @PostMapping("create")
    fun create(@RequestBody foo: Foo): Boolean = fooService.create(foo)
}