package http.pg.models;

import java.util.Date;
import java.util.Map;

public class MangaByTitleResponse {
  public ResultType result;
  public Manga data;

  public class Manga {
    public String id;
    public Attributes attributes;

    public class Attributes {
      public Map<String, String> title;
      public Map<String, String>[] altTitles;
      public Map<String, String> description;
      public String publicationDemographic;
      public String status;
      public int year;
      public String publicRating;
      public Date createdAt;
      public Date updatedAt;
    }
  }
}
