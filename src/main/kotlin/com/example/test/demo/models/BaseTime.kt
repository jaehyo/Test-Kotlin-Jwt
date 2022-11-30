package com.example.test.demo

import javax.persistence.MappedSuperclass
import javax.persistence.EntityListeners
import javax.persistence.Column
import java.time.LocalDateTime
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.hibernate.annotations.CreationTimestamp

@MappedSuperclass
@EntityListeners( AuditingEntityListener::class )
abstract class BaseTime{

    @CreationTimestamp
    @Column(nullable = false , updatable = false)
    val createdAt : LocalDateTime? = null

    @CreationTimestamp
    @Column( nullable = false )
    val updatedAt : LocalDateTime? = null

}
