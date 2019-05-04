name := "tasks-1"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.22",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.22" % Test
)
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.22"