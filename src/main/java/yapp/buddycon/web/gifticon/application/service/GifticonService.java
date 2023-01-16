package yapp.buddycon.web.gifticon.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import yapp.buddycon.web.gifticon.adapter.in.response.GifticonsResponseDto;
import yapp.buddycon.web.gifticon.application.port.in.GifticonUseCase;
import yapp.buddycon.web.gifticon.application.port.out.GifticonCommandPort;
import yapp.buddycon.web.gifticon.application.port.out.GifticonQueryPort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GifticonService implements GifticonUseCase {

  private final GifticonCommandPort gifticonCommandPort;
  private final GifticonQueryPort gifticonQueryPort;

}
