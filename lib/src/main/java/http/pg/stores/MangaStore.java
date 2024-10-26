package http.pg.stores;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;

import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Date;

import com.google.gson.Gson;

import java.net.http.HttpRequest;

import http.pg.Properties;
import http.pg.RequestException;
import http.pg.models.MangaByTitleResponse;
import http.pg.models.MangaByTitleResponse.Manga;

public class MangaStore {
  private static final HttpClient client = HttpClient.newHttpClient();
  private static final Gson gson = new Gson();

  private String id = null;

  private Manga manga = null;

  public MangaStore(Properties properties) {
    id = String.valueOf(properties.get("id"));
  }

  public void fetch()
      throws RequestException, InterruptedException, URISyntaxException, IOException {
    String uri = "https://api.mangadex.org/manga/" + id;

    HttpRequest request = HttpRequest.newBuilder(new URI(uri))
        .build();

    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    if (response.statusCode() < 200 || response.statusCode() > 299) {
      throw new RequestException(String.valueOf(response.statusCode()));
    }

    MangaByTitleResponse mangaByTitleResponse = gson.fromJson(response.body(), MangaByTitleResponse.class);

    manga = mangaByTitleResponse.getData();
  }

  public String getTitle() {
    return this.manga.getAttributes().getTitle().get("en");
  }

  public Date getUpdatedAt() {
    return manga.getAttributes().getUpdatedAt();
  }
}
