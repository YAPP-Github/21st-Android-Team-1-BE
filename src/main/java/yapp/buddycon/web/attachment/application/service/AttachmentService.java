package yapp.buddycon.web.attachment.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yapp.buddycon.web.attachment.application.port.in.AttachmentUseCase;
import yapp.buddycon.web.attachment.application.port.out.AttachmentCommandPort;
import yapp.buddycon.web.attachment.application.port.out.AttachmentQueryPort;

@Service
@RequiredArgsConstructor
public class AttachmentService implements AttachmentUseCase {

  private final AttachmentCommandPort attachmentCommandPort;
  private AttachmentQueryPort attachmentQueryPort;
}
