# FileUploadExample #

Simple example that shows FileUpload in Scalatra working with Akka, Futures, Swagger and Swagger-UI via WebJars.

## Build & Run ##

```sh
$ cd FileUploadExample
$ ./sbt
> container:start
> browse
```

If `browse` doesn't launch your browser, manually open [http://localhost:8080/upload/swagger-ui/index.html](http://localhost:8080/upload/swagger-ui/index.html) in your browser.

This example uses code from Swagger-UI - see https://github.com/wordnik/swagger-ui

For more information see

- Introducing Webjars [http://www.jamesward.com/2012/04/25/introducing-webjars-web-libraries-as-managed-dependencies](http://www.jamesward.com/2012/04/25/introducing-webjars-web-libraries-as-managed-dependencies)
- Webjar repository [http://www.webjars.org/](http://www.webjars.org/)
- Webjar for Swagger-UI [https://github.com/webjars/swagger-ui](https://github.com/webjars/swagger-ui)
- Using Webjars in Scalatra [http://shzhangji.com/blog/2014/05/27/use-webjars-in-scalatra-project/](http://shzhangji.com/blog/2014/05/27/use-webjars-in-scalatra-project/)
