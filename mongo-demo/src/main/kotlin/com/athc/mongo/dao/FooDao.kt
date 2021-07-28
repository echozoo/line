package com.athc.mongo.dao

import com.athc.mongo.domain.Foo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Component

@Component
open class FooDao() {

  @Autowired
  private lateinit var mongoTemplate: MongoTemplate;

  fun insert(foo: Foo): Foo {
    return mongoTemplate.insert(foo.copy(id = null))
  }

  fun selectOne(id: String): Foo? {
    return mongoTemplate.findOne(Query.query(Criteria.where("id").`is`(id)), Foo::class.java)
  }

  fun selectAll(): List<Foo> {
    return mongoTemplate.findAll(Foo::class.java)
  }

  fun update(foo: Foo): Long {
    return mongoTemplate.updateFirst(
        Query.query(Criteria.where("id").`is`(foo.id)), Update.update("name", foo.name), Foo::class.java
    ).modifiedCount
  }

  fun delete(id: String): Long {
    return mongoTemplate.remove(Query.query(Criteria.where("id").`is`(id)), Foo::class.java).deletedCount
  }
}