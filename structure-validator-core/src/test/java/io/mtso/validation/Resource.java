package io.mtso.validation;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Resource {
  static String loadToString(final String resourceName) {

    return streamToString(Resource.class.getResourceAsStream(resourceName));
  }

  static String streamToString(final InputStream inputStream) {

    try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
      return scanner.useDelimiter("\\A").next();
    }
  }
}
