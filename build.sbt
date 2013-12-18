name := "ArchiveItPrototype"

version := "1.0-SNAPSHOT"

EclipseKeys.withSource := true

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)     

play.Project.playJavaSettings
