package com.zyl.jpa.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCcsAcctingEntry is a Querydsl query type for CcsAcctingEntry
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCcsAcctingEntry extends EntityPathBase<CcsAcctingEntry> {

    private static final long serialVersionUID = -1212358611L;

    public static final QCcsAcctingEntry ccsAcctingEntry = new QCcsAcctingEntry("ccsAcctingEntry");

    public final NumberPath<Long> acctNbr = createNumber("acctNbr", Long.class);

    public final ComparablePath<Character> acctStatus = createComparable("acctStatus", Character.class);

    public final ComparablePath<Character> acctType = createComparable("acctType", Character.class);

    public final ComparablePath<Character> ageCodeGl = createComparable("ageCodeGl", Character.class);

    public final StringPath checkMark = createString("checkMark");

    public final StringPath contrNbr = createString("contrNbr");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath createUser = createString("createUser");

    public final StringPath currency = createString("currency");

    public final ComparablePath<Character> dbCrInd = createComparable("dbCrInd", Character.class);

    public final StringPath dueBillNo = createString("dueBillNo");

    public final StringPath glOrg = createString("glOrg");

    public final StringPath glVoucherGroup = createString("glVoucherGroup");

    public final StringPath glVoucherId = createString("glVoucherId");

    public final ComparablePath<Character> isOffset = createComparable("isOffset", Character.class);

    public final NumberPath<Long> jpaVersion = createNumber("jpaVersion", Long.class);

    public final StringPath loanCode = createString("loanCode");

    public final DateTimePath<java.util.Date> lstUpdTime = createDateTime("lstUpdTime", java.util.Date.class);

    public final StringPath lstUpdUser = createString("lstUpdUser");

    public final NumberPath<Long> orderId = createNumber("orderId", Long.class);

    public final StringPath org = createString("org");

    public final StringPath origTxnSeq = createString("origTxnSeq");

    public final StringPath owningBranch = createString("owningBranch");

    public final StringPath paymentChannelCd = createString("paymentChannelCd");

    public final StringPath paymentTraceNbr = createString("paymentTraceNbr");

    public final NumberPath<java.math.BigDecimal> postAmt = createNumber("postAmt", java.math.BigDecimal.class);

    public final DatePath<java.util.Date> postDate = createDate("postDate", java.util.Date.class);

    public final ComparablePath<Character> preAgeCodeGl = createComparable("preAgeCodeGl", Character.class);

    public final StringPath subjectCd = createString("subjectCd");

    public final StringPath subjectDesc = createString("subjectDesc");

    public final StringPath subjectDirct = createString("subjectDirct");

    public final StringPath subjectName = createString("subjectName");

    public final StringPath subjectRbInd = createString("subjectRbInd");

    public final StringPath txnCode = createString("txnCode");

    public final NumberPath<Long> txnId = createNumber("txnId", Long.class);

    public QCcsAcctingEntry(String variable) {
        super(CcsAcctingEntry.class, forVariable(variable));
    }

    public QCcsAcctingEntry(Path<? extends CcsAcctingEntry> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCcsAcctingEntry(PathMetadata metadata) {
        super(CcsAcctingEntry.class, metadata);
    }

}

