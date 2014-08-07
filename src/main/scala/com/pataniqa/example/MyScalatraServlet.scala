package com.pataniqa.example

import java.io.File

import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import scala.io.Source

import org.json4s.DefaultFormats
import org.json4s.Formats
import org.scalatra.FutureSupport
import org.scalatra.ScalatraServlet
import org.scalatra.json.NativeJsonSupport
import org.scalatra.servlet.FileUploadSupport
import org.scalatra.servlet.MultipartConfig
import org.scalatra.swagger.ParamType
import org.scalatra.swagger.Swagger
import org.scalatra.swagger.SwaggerSupport
import org.slf4j.LoggerFactory

import _root_.akka.actor.ActorSystem

class MyScalatraServlet(implicit val system: ActorSystem, val swagger: Swagger) extends 
	MyScalatraWebAppStack with NativeJsonSupport with SwaggerSupport with FileUploadSupport with FutureSupport {

  protected implicit def executor: ExecutionContext = system.dispatcher

  val logger = LoggerFactory.getLogger(getClass)

  // Sets up automatic case class to JSON output serialization, required by
  // the JValueResult trait.
  protected implicit val jsonFormats: Formats = DefaultFormats

  protected val applicationDescription =
    "A simple file upload example using Swagger"

  // Before every action runs, set the content type to be in JSON format.
  before() {
    contentType = formats("json")
  }

  configureMultipartHandling(MultipartConfig(maxFileSize = Some(3 * 1024 * 1024)))

  val postCsvFuture =
    (apiOperation[Result]("csvf")
      parameter (bodyParam[File]("csv") description ("The CSV file") paramType (ParamType.Form))
      summary "Upload a CSV file using a Future")

  post("/csvf", operation(postCsvFuture)) {
    fileParams.get("csv") match {
      case Some(file) =>
        logger.info(s"Received ${file.getName} ${file.getSize}")
        val lines = Source.fromInputStream(file.getInputStream).getLines
        val csv = lines.mkString("\n")
        Future {
          logger.info(csv)
        }
        Result(csv)
      case None =>
        Result("no CSV file uploaded")
    }
  }

  val postCsv =
    (apiOperation[Result]("csv")
      parameter (bodyParam[File]("csv") description ("The CSV file") paramType (ParamType.Form))
      summary "Upload a CSV file")

  post("/csv", operation(postCsv)) {
    fileParams.get("csv") match {
      case Some(file) =>
        logger.info(s"Received ${file.getName} ${file.getSize}")
        val lines = Source.fromInputStream(file.getInputStream).getLines
        val csv = lines.mkString("\n")
        Result(csv)
      case None =>
        Result("no CSV file uploaded")
    }
  }
}

case class Result(result: String)
