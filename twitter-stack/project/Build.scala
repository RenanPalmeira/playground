import sbt._

object ForkQuillBuild extends Build {

  lazy val root = Project("root", file(".")) dependsOn(soundPlayerProject)
  lazy val soundPlayerProject =
       RootProject(uri("git://github.com/alvinj/SoundFilePlayer.git"))

}