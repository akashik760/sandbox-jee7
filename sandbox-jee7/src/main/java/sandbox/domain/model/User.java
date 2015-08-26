package sandbox.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity
@Table( uniqueConstraints = @UniqueConstraint( columnNames = { "LOGIN", "joined_id" } ) )
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    public Long id;

    @Column( name = "LOGIN", length = 20 )
    public String login;

    @Column( length = 30 )
    public String name;

    @ManyToOne
    public Party joined;

    @Version
    public long version;

    /** 更新日(監査項目) */
    @Temporal( TemporalType.TIMESTAMP )
    public Date updated;

    // 変更時の自動設定
    @PrePersist
    @PreUpdate
    private void now() {
        //setUpdated( new Date() );
        this.updated = new Date();
    }

}
