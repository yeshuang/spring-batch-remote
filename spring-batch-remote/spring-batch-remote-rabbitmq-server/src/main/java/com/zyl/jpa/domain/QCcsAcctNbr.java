package com.zyl.jpa.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCcsAcctNbr is a Querydsl query type for CcsAcctNbr
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCcsAcctNbr extends EntityPathBase<CcsAcctNbr> {

    private static final long serialVersionUID = -1680468863L;

    public static final QCcsAcctNbr ccsAcctNbr = new QCcsAcctNbr("ccsAcctNbr");

    public final NumberPath<Long> acctNbr = createNumber("acctNbr", Long.class);

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath createUser = createString("createUser");

    public final NumberPath<Long> jpaVersion = createNumber("jpaVersion", Long.class);

    public final DateTimePath<java.util.Date> lstUpdTime = createDateTime("lstUpdTime", java.util.Date.class);

    public final StringPath lstUpdUser = createString("lstUpdUser");

    public final StringPath org = createString("org");

    public QCcsAcctNbr(String variable) {
        super(CcsAcctNbr.class, forVariable(variable));
    }

    public QCcsAcctNbr(Path<? extends CcsAcctNbr> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCcsAcctNbr(PathMetadata metadata) {
        super(CcsAcctNbr.class, metadata);
    }

}

