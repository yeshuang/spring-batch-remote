package com.zyl.jpa.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCcsAcctId is a Querydsl query type for CcsAcctId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QCcsAcctId extends BeanPath<CcsAcctId> {

    private static final long serialVersionUID = 1746906488L;

    public static final QCcsAcctId ccsAcctId = new QCcsAcctId("ccsAcctId");

    public final NumberPath<Long> acctNbr = createNumber("acctNbr", Long.class);

    public final ComparablePath<Character> acctType = createComparable("acctType", Character.class);

    public QCcsAcctId(String variable) {
        super(CcsAcctId.class, forVariable(variable));
    }

    public QCcsAcctId(Path<? extends CcsAcctId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCcsAcctId(PathMetadata metadata) {
        super(CcsAcctId.class, metadata);
    }

}

