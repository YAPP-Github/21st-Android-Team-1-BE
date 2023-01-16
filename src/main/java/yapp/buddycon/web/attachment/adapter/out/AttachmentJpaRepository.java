package yapp.buddycon.web.attachment.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import yapp.buddycon.web.attachment.domain.Attachment;

public interface AttachmentJpaRepository extends JpaRepository<Attachment, Long> {
}
