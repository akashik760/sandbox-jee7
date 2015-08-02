package sandbox.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QParty is a Querydsl query type for Party
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QParty extends EntityPathBase<Party> {

    private static final long serialVersionUID = 88593178L;

    public static final QParty party = new QParty("party");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<User, QUser> members = this.<User, QUser>createList("members", User.class, QUser.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final DateTimePath<java.util.Date> updated = createDateTime("updated", java.util.Date.class);

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QParty(String variable) {
        super(Party.class, forVariable(variable));
    }

    public QParty(Path<? extends Party> path) {
        super(path.getType(), path.getMetadata());
    }

    public QParty(PathMetadata<?> metadata) {
        super(Party.class, metadata);
    }

}

