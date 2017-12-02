name := "twitter-stack"
organization := "com.playground.twitter"
version := "1.0"
scalaVersion := "2.12.1"
parallelExecution in ThisBuild := false

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
)

assemblyMergeStrategy in assembly := {
  case "BUILD" => MergeStrategy.discard
  case "META-INF/io.netty.versions.properties" => MergeStrategy.last
  case other => MergeStrategy.defaultMergeStrategy(other)
}

Revolver.settings

lazy val versions = new {
  val finatra = "2.13.0"
  val guice = "4.0"
  val logback = "1.1.7"
  val typesafeconfig = "1.3.0"
  val quill = "2.0.0"
  val postgresql = "9.4.1208"
}

dependencyOverrides ++= Set(
  "com.google.guava" % "guava" % "19.0",
  "com.google.code.findbugs" % "jsr305" % "2.0.1"
)

libraryDependencies ++= Seq(
  "com.twitter" %% "finatra-http" % versions.finatra,
  "ch.qos.logback" % "logback-classic" % versions.logback,
  "com.typesafe" % "config" % versions.typesafeconfig,
  "org.postgresql" % "postgresql" % versions.postgresql,
  "io.getquill" %% "quill-jdbc" % versions.quill,

  "com.twitter" %% "finatra-http" % versions.finatra % "test",
  "com.twitter" %% "finatra-jackson" % versions.finatra % "test",
  "com.twitter" %% "inject-server" % versions.finatra % "test",
  "com.twitter" %% "inject-app" % versions.finatra % "test",
  "com.twitter" %% "inject-core" % versions.finatra % "test",
  "com.twitter" %% "inject-modules" % versions.finatra % "test",
  "com.google.inject.extensions" % "guice-testlib" % versions.guice % "test",

  "com.twitter" %% "finatra-http" % versions.finatra % "test" classifier "tests",
  "com.twitter" %% "finatra-jackson" % versions.finatra % "test" classifier "tests",
  "com.twitter" %% "inject-server" % versions.finatra % "test" classifier "tests",
  "com.twitter" %% "inject-app" % versions.finatra % "test" classifier "tests",
  "com.twitter" %% "inject-core" % versions.finatra % "test" classifier "tests",
  "com.twitter" %% "inject-modules" % versions.finatra % "test" classifier "tests",

  "org.mockito" % "mockito-core" % "1.9.5" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test",
  "org.scalatest" %% "scalatest" %  "3.0.0" % "test",
  "org.specs2" %% "specs2-mock" % "2.4.17" % "test")