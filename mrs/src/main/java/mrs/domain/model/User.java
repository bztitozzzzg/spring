package mrs.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "usr")
@Data
public class User implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -2571841497467715495L;

    /**
     * ユーザID
     */
    @Id
    private String userId;

    /**
     * パスワード
     */
    private String password;

    /**
     * 氏
     */
    private String firstName;

    /**
     * 名
     */
    private String lastName;

    /**
     * ロール名
     */
    @Enumerated(EnumType.STRING)
    private RoleName roleName;
    
}
