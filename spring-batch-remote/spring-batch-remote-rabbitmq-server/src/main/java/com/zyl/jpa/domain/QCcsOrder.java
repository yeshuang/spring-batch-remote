package com.zyl.jpa.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCcsOrder is a Querydsl query type for CcsOrder
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCcsOrder extends EntityPathBase<CcsOrder> {

    private static final long serialVersionUID = 1178107172L;

    public static final QCcsOrder ccsOrder = new QCcsOrder("ccsOrder");

    public final NumberPath<Long> acctNbr = createNumber("acctNbr", Long.class);

    public final ComparablePath<Character> acctType = createComparable("acctType", Character.class);

    public final StringPath acqId = createString("acqId");

    public final StringPath authTxnTerminal = createString("authTxnTerminal");

    public final DatePath<java.util.Date> businessDate = createDate("businessDate", java.util.Date.class);

    public final StringPath cardNo = createString("cardNo");

    public final ComparablePath<Character> cardType = createComparable("cardType", Character.class);

    public final StringPath certId = createString("certId");

    public final StringPath certType = createString("certType");

    public final StringPath channelId = createString("channelId");

    public final StringPath city = createString("city");

    public final StringPath code = createString("code");

    public final StringPath commandType = createString("commandType");

    public final ComparablePath<Character> comparedInd = createComparable("comparedInd", Character.class);

    public final StringPath contactChnl = createString("contactChnl");

    public final StringPath contrNbr = createString("contrNbr");

    public final StringPath couponId = createString("couponId");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath createUser = createString("createUser");

    public final StringPath currency = createString("currency");

    public final StringPath dueBillNo = createString("dueBillNo");

    public final ComparablePath<Character> errInd = createComparable("errInd", Character.class);

    public final NumberPath<java.math.BigDecimal> failureAmt = createNumber("failureAmt", java.math.BigDecimal.class);

    public final StringPath flag = createString("flag");

    public final StringPath guarantyId = createString("guarantyId");

    public final NumberPath<Long> jpaVersion = createNumber("jpaVersion", Long.class);

    public final NumberPath<Integer> loanAgainTimes = createNumber("loanAgainTimes", Integer.class);

    public final NumberPath<java.math.BigDecimal> loanAmt = createNumber("loanAmt", java.math.BigDecimal.class);

    public final StringPath loanProdGroup = createString("loanProdGroup");

    public final StringPath loanUsage = createString("loanUsage");

    public final NumberPath<Long> logKv = createNumber("logKv", Long.class);

    public final DateTimePath<java.util.Date> lstUpdTime = createDateTime("lstUpdTime", java.util.Date.class);

    public final StringPath lstUpdUser = createString("lstUpdUser");

    public final ComparablePath<Character> matchInd = createComparable("matchInd", Character.class);

    public final StringPath memo = createString("memo");

    public final StringPath merchandiseOrder = createString("merchandiseOrder");

    public final StringPath merId = createString("merId");

    public final StringPath merName = createString("merName");

    public final StringPath message = createString("message");

    public final StringPath mobileNumber = createString("mobileNumber");

    public final ComparablePath<Character> offsetType = createComparable("offsetType", Character.class);

    public final ComparablePath<Character> onlineFlag = createComparable("onlineFlag", Character.class);

    public final StringPath openBank = createString("openBank");

    public final StringPath openBankId = createString("openBankId");

    public final DateTimePath<java.util.Date> optDatetime = createDateTime("optDatetime", java.util.Date.class);

    public final DateTimePath<java.util.Date> orberFailTime = createDateTime("orberFailTime", java.util.Date.class);

    public final StringPath orderBrief = createString("orderBrief");

    public final NumberPath<Long> orderId = createNumber("orderId", Long.class);

    public final ComparablePath<Character> orderStatus = createComparable("orderStatus", Character.class);

    public final DateTimePath<java.util.Date> orderTime = createDateTime("orderTime", java.util.Date.class);

    public final StringPath org = createString("org");

    public final NumberPath<Long> oriOrderId = createNumber("oriOrderId", Long.class);

    public final StringPath payBizCode = createString("payBizCode");

    public final StringPath payChannelId = createString("payChannelId");

    public final StringPath paymentChannel = createString("paymentChannel");

    public final StringPath payTerms = createString("payTerms");

    public final NumberPath<java.math.BigDecimal> premiumAmt = createNumber("premiumAmt", java.math.BigDecimal.class);

    public final ComparablePath<Character> premiumInd = createComparable("premiumInd", Character.class);

    public final StringPath priv1 = createString("priv1");

    public final StringPath productType = createString("productType");

    public final StringPath proofId = createString("proofId");

    public final StringPath purpose = createString("purpose");

    public final StringPath refNbr = createString("refNbr");

    public final StringPath requestTime = createString("requestTime");

    public final StringPath responseCode = createString("responseCode");

    public final StringPath responseMessage = createString("responseMessage");

    public final DatePath<java.util.Date> sendTime = createDate("sendTime", java.util.Date.class);

    public final StringPath serviceId = createString("serviceId");

    public final StringPath servicesn = createString("servicesn");

    public final DatePath<java.util.Date> setupDate = createDate("setupDate", java.util.Date.class);

    public final StringPath state = createString("state");

    public final StringPath status = createString("status");

    public final StringPath subBank = createString("subBank");

    public final StringPath subTerminalType = createString("subTerminalType");

    public final NumberPath<java.math.BigDecimal> successAmt = createNumber("successAmt", java.math.BigDecimal.class);

    public final NumberPath<Long> term = createNumber("term", Long.class);

    public final StringPath terminalDevice = createString("terminalDevice");

    public final NumberPath<java.math.BigDecimal> txnAmt = createNumber("txnAmt", java.math.BigDecimal.class);

    public final StringPath txnType = createString("txnType");

    public final StringPath usrName = createString("usrName");

    public QCcsOrder(String variable) {
        super(CcsOrder.class, forVariable(variable));
    }

    public QCcsOrder(Path<? extends CcsOrder> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCcsOrder(PathMetadata metadata) {
        super(CcsOrder.class, metadata);
    }

}

