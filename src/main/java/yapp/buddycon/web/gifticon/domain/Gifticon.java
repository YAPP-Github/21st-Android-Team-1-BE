package yapp.buddycon.web.gifticon.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import yapp.buddycon.common.domain.BaseEntity;
import yapp.buddycon.web.attachment.domain.Attachment;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Gifticon extends BaseEntity {

  @Column(name = "member_id", nullable = false)
  private Long memberId;

  @OneToOne
  @JoinColumn(name = "attachment_id")
  private Attachment attachment;

  @Embedded
  private GifticonInfo gifticonInfo;

  @Column(name = "gifticon_state")
  @Enumerated(EnumType.STRING)
  private GifticonState gifticonState;

}
