import com.twitter.finagle.builder.ServerBuilder
import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http.{Request, Response}
import com.twitter.util.Future
import java.net.InetSocketAddress
import util.Properties

object Web {
  def main(args: Array[String]) {
    val port = Properties.envOrElse("PORT", "8080").toInt
    println("Starting on port:"+port)
    ServerBuilder()
      .stack(Http.server)
      .name("hello-server")
      .bindTo(new InetSocketAddress(port))
      .build(new Hello)
    println("Started.")
  }
}

class Hello extends Service[Request, Response] {
  def apply(req: Request): Future[Response] = {
    val response = Response()
    response.setStatusCode(200)
    response.setContentString("Scala on Predix.io - Hello World!")
    Future(response)
  }
}