package http.pg.models;

import com.google.gson.annotations.SerializedName;

public enum ResultType {
  @SerializedName("ok")
  OK,
  @SerializedName("error")
  ERROR
}
