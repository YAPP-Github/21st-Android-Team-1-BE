package yapp.buddycon.web.gifticon.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import yapp.buddycon.web.gifticon.adapter.in.response.GifticonsResponseDto;
import yapp.buddycon.web.gifticon.application.port.out.GifticonQueryPort;
import yapp.buddycon.web.gifticon.domain.GifticonState;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GifticonQueryRepository implements GifticonQueryPort {

  private final GifticonJpaRepository gifticonJpaRepository;

  @Override
  public List<GifticonsResponseDto> findUsableGifticonsSortedBy(Pageable pageable) {
    return gifticonJpaRepository.findSortedGifticonsAccordingToState(GifticonState.USABLE, pageable);
  }

  @Override
  public List<GifticonsResponseDto> findUsedGifticonsSortedBy(Pageable pageable) {
    return gifticonJpaRepository.findSortedGifticonsAccordingToState(GifticonState.USED, pageable);
  }
}
