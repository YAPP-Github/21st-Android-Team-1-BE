package yapp.buddycon.web.gifticon.application.port.out;

import org.springframework.data.domain.Pageable;
import yapp.buddycon.web.gifticon.adapter.in.response.GifticonsResponseDto;

import java.util.List;

public interface GifticonQueryPort {

  List<GifticonsResponseDto> findUsableGifticonsSortedBy(Pageable pageable);
  List<GifticonsResponseDto> findUsedGifticonsSortedBy(Pageable pageable);

}
