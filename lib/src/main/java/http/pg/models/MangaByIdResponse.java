package http.pg.models;

import java.util.Date;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MangaByIdResponse {
  private String result;
  private Manga data;

  @Getter
  @Setter
  public class Manga {
    private String id;
    private Attributes attributes;

    @Getter
    @Setter
    public class Attributes {
      private Map<String, String> title;
      private Map<String, String>[] altTitles;
      private Map<String, String> description;
      private String publicationDemographic;
      private String status;
      private int year;
      private String publicRating;
      private Date createdAt;
      private Date updatedAt;
    }
  }
}
