import org.scalatra.LifeCycle

import com.pataniqa.example._

import _root_.akka.actor.ActorSystem
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {

  implicit val swagger = new FileUploadSwagger

  implicit val system = ActorSystem()

  override def init(context: ServletContext) {
    context.mount(new MyScalatraServlet, "/upload", "upload")
    context.mount(new ResourcesApp, "/api-docs")
  }

}
