package mysql;

import java.sql.ResultSet;

public class OneResult {
  ResultSet result = null;

  public OneResult(ResultSet result) {
    this.result = result;
  }
}
