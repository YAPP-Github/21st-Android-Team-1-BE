package yapp.buddycon.web.gifticon.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yapp.buddycon.web.gifticon.application.port.out.GifticonCommandPort;

@Repository
@RequiredArgsConstructor
public class GifticonCommandRepository implements GifticonCommandPort {

  private final GifticonJpaRepository gifticonJpaRepository;


}
