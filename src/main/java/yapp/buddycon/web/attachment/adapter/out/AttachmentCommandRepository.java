package yapp.buddycon.web.attachment.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.web.attachment.application.port.out.AttachmentCommandPort;

@Repository
@RequiredArgsConstructor
public class AttachmentCommandRepository implements AttachmentCommandPort {

  private final AttachmentJpaRepository attachmentJpaRepository;
}
