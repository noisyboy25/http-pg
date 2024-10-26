# REST API Client Library

A demo Java library for making REST API requests.

## Features

- Makes echo requests to the Postman API.
- Makes GET requests to the MangaDex API.

## Getting Started

### Installation

1. Clone the repository.
2. Build the JAR file with `./gradlew jar` (Linux) or `gradlew.bat jar` (Windows).
3. Add the JAR file to your project's classpath.

### Usage

1. **Echo Request to Postman API:**
```java
void echo() throws Exception {
    Library lib = new Library();
    String message = "Hello World";

    String result = lib.getEcho(message);
    System.out.println("Echo Response: " + result);
}
```
2. **Fetch Manga Information from MangaDex API:**
```java
void manga() throws Exception {
    String id = "259dfd8a-f06a-4825-8fa6-a2dcd7274230";
    Properties properties = new Properties();
    properties.put("id", id);
    MangaStore mangaStore = new MangaStore(properties);

    mangaStore.fetch();
    System.out.println("Manga Title: " + mangaStore.getTitle());
    System.out.println("Updated At: " + mangaStore.getUpdatedAt());
}
```
