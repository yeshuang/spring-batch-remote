package com.zyl.jpa.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QZylGome is a Querydsl query type for ZylGome
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QZylGome extends EntityPathBase<ZylGome> {

    private static final long serialVersionUID = 153076708L;

    public static final QZylGome zylGome = new QZylGome("zylGome");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath card = createString("card");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath uuid = createString("uuid");

    public final ComparablePath<Character> v = createComparable("v", Character.class);

    public QZylGome(String variable) {
        super(ZylGome.class, forVariable(variable));
    }

    public QZylGome(Path<? extends ZylGome> path) {
        super(path.getType(), path.getMetadata());
    }

    public QZylGome(PathMetadata metadata) {
        super(ZylGome.class, metadata);
    }

}

