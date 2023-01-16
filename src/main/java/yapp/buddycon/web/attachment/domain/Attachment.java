package yapp.buddycon.web.attachment.domain;

import yapp.buddycon.common.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Attachment extends BaseEntity {

  @Column(name = "file_name")
  private String fileName;

  @Column(name = "file_content_type")
  private String fileContentType;

  @Column(name = "path")
  private String path;
}
