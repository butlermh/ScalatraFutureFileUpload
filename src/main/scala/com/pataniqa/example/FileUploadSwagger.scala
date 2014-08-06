package com.pataniqa.example

import org.scalatra.ScalatraServlet
import org.scalatra.swagger.{ApiInfo, NativeSwaggerBase, Swagger}

object FileUploadSwagger{
  val Info = ApiInfo(
    "File Upload API",
    "Docs for the File Upload API",
    "http://www.pataniqa.com",
    "patanqia@pataniqa.com",
    "MIT",
    "http://opensource.org/licenses/MIT")
}

class FileUploadSwagger extends Swagger(Swagger.SpecVersion, "1", FileUploadSwagger.Info)

class ResourcesApp(implicit val swagger: Swagger) extends ScalatraServlet with NativeSwaggerBase