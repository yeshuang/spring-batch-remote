package com.zyl.jpa.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCcsAcctingMerge is a Querydsl query type for CcsAcctingMerge
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCcsAcctingMerge extends EntityPathBase<CcsAcctingMerge> {

    private static final long serialVersionUID = -1205240845L;

    public static final QCcsAcctingMerge ccsAcctingMerge = new QCcsAcctingMerge("ccsAcctingMerge");

    public final StringPath accountingPeriod = createString("accountingPeriod");

    public final StringPath auxiliaryAccounting = createString("auxiliaryAccounting");

    public final DatePath<java.util.Date> businessDate = createDate("businessDate", java.util.Date.class);

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath createUser = createString("createUser");

    public final StringPath currency = createString("currency");

    public final StringPath fiscalYear = createString("fiscalYear");

    public final StringPath glOrg = createString("glOrg");

    public final StringPath glOrgName = createString("glOrgName");

    public final StringPath glVoucherGroup = createString("glVoucherGroup");

    public final StringPath glVoucherId = createString("glVoucherId");

    public final StringPath glVoucherType = createString("glVoucherType");

    public final NumberPath<Long> jpaVersion = createNumber("jpaVersion", Long.class);

    public final DateTimePath<java.util.Date> lstUpdTime = createDateTime("lstUpdTime", java.util.Date.class);

    public final StringPath lstUpdUser = createString("lstUpdUser");

    public final NumberPath<Long> mergeId = createNumber("mergeId", Long.class);

    public final StringPath org = createString("org");

    public final StringPath subjectCd = createString("subjectCd");

    public final NumberPath<java.math.BigDecimal> subjectCreditAmt = createNumber("subjectCreditAmt", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> subjectDebitAmt = createNumber("subjectDebitAmt", java.math.BigDecimal.class);

    public final StringPath subjectDesc = createString("subjectDesc");

    public final StringPath subjectName = createString("subjectName");

    public QCcsAcctingMerge(String variable) {
        super(CcsAcctingMerge.class, forVariable(variable));
    }

    public QCcsAcctingMerge(Path<? extends CcsAcctingMerge> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCcsAcctingMerge(PathMetadata metadata) {
        super(CcsAcctingMerge.class, metadata);
    }

}

