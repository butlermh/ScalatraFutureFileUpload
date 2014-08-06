import org.scalatra.LifeCycle

import com.pataniqa.example.FileUploadSwagger
import com.pataniqa.example.MyScalatraServlet
import com.pataniqa.example.ResourcesApp

import javax.servlet.ServletContext

import _root_.akka.actor.{ Props, ActorSystem }

class ScalatraBootstrap extends LifeCycle {

  implicit val swagger = new FileUploadSwagger

  implicit val system = ActorSystem()

  override def init(context: ServletContext) {
    context.mount(new MyScalatraServlet, "/upload", "upload")
    context.mount(new ResourcesApp, "/api-docs")
  }

}
