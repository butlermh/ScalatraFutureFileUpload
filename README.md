# FileUploadExample #

FileUpload in Scalatra doesn't seem to work in AsyncResult blocks.

## Build & Run ##

```sh
$ cd FileUploadExample
$ ./sbt
> container:start
> browse
```

If `browse` doesn't launch your browser, manually open [http://localhost:8080/upload/swagger-ui/index.html](http://localhost:8080/upload/swagger-ui/index.html) in your browser.

This example uses code from Swagger-UI - see https://github.com/wordnik/swagger-ui
