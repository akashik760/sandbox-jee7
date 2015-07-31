package sandbox.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;

public class PartyTest {

    private static EntityManager getEm() {
        return Persistence.createEntityManagerFactory("ut")
                          .createEntityManager();
    }
    
    @Test 
    public void 永続化のテスト(){
        
        // [ready] ------------------------------------------------------------
        Party t1 = new Party();
        t1.name = "groupA";
        
        User m1 = new User();
        m1.login = "hoge";
        m1.name = "fuga";
        m1.joined = t1;
        
        //グループメンバーに追加
        t1.members = Arrays.asList( m1 );
        
        // [execute] ------------------------------------------------------------
        
        // エンティティマネージャの取得とトランザクション開始
        EntityManager em = getEm();
        em.getTransaction().begin();
        
        em.persist(t1);// 永続化コンテキストへの登録
        
        // データベースへの反映,コンテキスト破棄
        em.flush();
        em.clear();
        // [verify] ------------------------------------------------------------
        // DBから再取得
        Party act = em.find(Party.class, t1.id);
        assertThat(act.name, is("groupA"));
        // 関連先の情報も取得可能。
        assertThat(act.members.get(0).name, is("fuga"));
        
        em.getTransaction().commit();
    }
    
}
