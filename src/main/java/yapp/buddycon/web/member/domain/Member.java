package yapp.buddycon.web.member.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import yapp.buddycon.common.domain.BaseEntity;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity {

  @Column(name = "client_id", unique = true)
  private Long clientId;

  @Column(name = "name")
  private String name;

}
