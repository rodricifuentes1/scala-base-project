import sbt._

// -----------------------------------------------------
// Build information for project $name$
// -----------------------------------------------------
organization := "$project_organization$"
name := "$name;format="norm"$"
description := "$project_description$"

// -----------------------------------------------------
// Scala compiler configurations
// -----------------------------------------------------
scalaVersion := "$scala_version$"
scalacOptions ++= Seq(
  "-target:jvm-$jvm_version$", // Force compile with specified java version.
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-encoding", "UTF-8", // Specify character encoding used by source files.
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-language:existentials", // Existential types (besides wildcard types) can be written and inferred
  "-language:higherKinds", // Allow higher-kinded types
  "-language:implicitConversions", // Allow definition of implicit functions called views
  "-unchecked", // Enable detailed unchecked (erasure) warnings
  "-Xfatal-warnings", // Fail the compilation if there are any warnings.
  "-Xlint", // Enable recommended additional warnings.
  "-Yno-adapted-args", // Warn if an argument list is modified to match the receiver.
  "-Ywarn-dead-code", // Warn if dead code.
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard", // Warn when non-Unit expression results are unused.
  "-Xfuture", // Turn on future language features.
  "-Xcheckinit" // Checks objects initialization
)

// -----------------------------------------------------
// Resolvers and dependencies
// -----------------------------------------------------
resolvers += Resolver.jcenterRepo
libraryDependencies ++= Dependencies.all

// -----------------------------------------------------
// Projects definitions
// -----------------------------------------------------
lazy val root: Project = Project("$name;format="norm"$", file("."))

// -----------------------------------------------------
// Custom tasks
// -----------------------------------------------------
