package yapp.buddycon.web.attachment.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.web.attachment.application.port.out.AttachmentQueryPort;

@Repository
@RequiredArgsConstructor
public class AttachmentQueryRepository implements AttachmentQueryPort {

  private final AttachmentJpaRepository attachmentJpaRepository;
}
