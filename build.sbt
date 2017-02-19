// Project areality written by Maxim Chepel

lazy val areality = (
    project in file(".")
  ).enablePlugins(
    ScalaJSPlugin
  ).settings(
    inThisBuild(List(
      organization := "expert.scalamorphing",
      scalaVersion := "2.11.8"
    )),
    name := "areality",
    clippyColorsEnabled := true,
    wartremoverErrors ++= Warts.unsafe,
    wartremoverErrors ++= Seq(
      ScalaJSWart.ArrayPartial,
      ScalaJSWart.UndefOrOpsPartial
    ),
    scalaSource in Compile := file(s"${baseDirectory.value.getAbsolutePath}/library"),
    scalaSource in Test := file(s"${baseDirectory.value.getAbsolutePath}/library-test"),
    version := "0.0.1",
    libraryDependencies := Seq(
      "org.scalactic" %%% "scalactic" % "3.0.1" % "test",
      "org.scalatest" %%% "scalatest" % "3.0.1" % "test",
      "com.lihaoyi" %%% "scalatags" % "0.6.2",
      "io.monix" %%% "monix" % "2.2.1",
      "io.monix" %%% "monix-cats" % "2.2.1"
    ),
    addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full),
    addCompilerPlugin("org.wartremover" %% "wartremover" % "2.0.2"),
    resolvers += Resolver.sonatypeRepo("releases"),
    addCompilerPlugin("com.softwaremill.clippy" %% "plugin" % "0.5.1" classifier "bundle")
  )

lazy val arealitySample = (
    project in file("./areality-sample")
  ).enablePlugins(
    ScalaJSPlugin
  ).settings(
    inThisBuild(List(
      organization := "expert.scalamorphing",
      scalaVersion := "2.11.8"
    )),
    name := "arealitySample",
    clippyColorsEnabled := true,
    wartremoverErrors ++= Warts.unsafe,
    wartremoverErrors ++= Seq(
      ScalaJSWart.ArrayPartial,
      ScalaJSWart.UndefOrOpsPartial
    ),
    scalaSource in Compile := file(s"${baseDirectory.value.getAbsolutePath}/app"),
    scalaSource in Test := file(s"${baseDirectory.value.getAbsolutePath}/test"),
    version := "0.0.1",
    libraryDependencies := Seq(
      "org.scalactic" %%% "scalactic" % "3.0.1" % "test",
      "org.scalatest" %%% "scalatest" % "3.0.1" % "test",
      "com.lihaoyi" %%% "scalatags" % "0.6.2",
      "io.monix" %%% "monix" % "2.2.1",
      "io.monix" %%% "monix-cats" % "2.2.1"
    ),
    addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full),
    addCompilerPlugin("org.wartremover" %% "wartremover" % "2.0.2"),
    resolvers += Resolver.sonatypeRepo("releases"),
    addCompilerPlugin("com.softwaremill.clippy" %% "plugin" % "0.5.1" classifier "bundle")
  ).dependsOn(areality)