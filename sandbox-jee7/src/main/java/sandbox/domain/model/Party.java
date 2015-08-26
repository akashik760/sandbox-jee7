package sandbox.domain.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Party {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     public Long id;

     @Column(length = 30)
     public String name;
     
     // cascadeにより、関連エンティティ(Member)へ永続化のライフサイクルをあわせることを設定
     @OneToMany(mappedBy = "joined", cascade = CascadeType.ALL)
     public List<User> members;
     
     /** バージョン番号 */
     @Version // 楽観排他
     public long version;
     
     /** 更新日(監査項目) */
     @Temporal(TemporalType.TIMESTAMP)
     public Date updated;
     
     /**
      *  変更時の時刻設定など
      */
     @PrePersist 
     @PreUpdate
    public void now(){
//         setUpdated(new Date());
         updated = new Date();
     }

 }

