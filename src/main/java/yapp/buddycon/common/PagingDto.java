package yapp.buddycon.common;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Getter;

@Getter
public class PagingDto {

  @Min(value = 0)
  private int page = 0;
  @Min(value = 1)
  @Max(value = 1000)
  private int rowCount = 20;

}
