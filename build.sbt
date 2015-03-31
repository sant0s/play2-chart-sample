name := """chart-sample"""

version := "0.1.0"

resolvers += Resolver.url("sant0s release repository", url("https://github.com/sant0s/release/raw/master"))(Resolver.ivyStylePatterns)

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "name.josesantos" %% "chart" % "0.1.0"
)
