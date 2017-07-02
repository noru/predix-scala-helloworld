
name := "hello scala"
version := "1.0"
scalaVersion := "2.12.2"

libraryDependencies += "com.twitter" %% "finagle-http" % "6.44.0"

enablePlugins(JavaServerAppPackaging)