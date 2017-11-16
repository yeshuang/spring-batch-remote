package com.zyl.jpa.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QZylGomeTest is a Querydsl query type for ZylGomeTest
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QZylGomeTest extends EntityPathBase<ZylGomeTest> {

    private static final long serialVersionUID = 708504214L;

    public static final QZylGomeTest zylGomeTest = new QZylGomeTest("zylGomeTest");

    public final NumberPath<Short> age = createNumber("age", Short.class);

    public final StringPath comment = createString("comment");

    public final EnumPath<com.zyl.jpa.enums.GomeType> gometype = createEnum("gometype", com.zyl.jpa.enums.GomeType.class);

    public final NumberPath<Integer> jpaversion = createNumber("jpaversion", Integer.class);

    public final NumberPath<java.math.BigDecimal> money = createNumber("money", java.math.BigDecimal.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> num = createNumber("num", Long.class);

    public final StringPath uuid = createString("uuid");

    public QZylGomeTest(String variable) {
        super(ZylGomeTest.class, forVariable(variable));
    }

    public QZylGomeTest(Path<? extends ZylGomeTest> path) {
        super(path.getType(), path.getMetadata());
    }

    public QZylGomeTest(PathMetadata metadata) {
        super(ZylGomeTest.class, metadata);
    }

}

