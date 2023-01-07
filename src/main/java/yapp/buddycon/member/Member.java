package yapp.buddycon.member;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import yapp.buddycon.common.domain.BaseEntity;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity {

  @Column(name = "client_id")
  private Long clientId;

  @Column(name = "name")
  private String name;

}
