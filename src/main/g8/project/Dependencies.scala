import sbt._

/**
  * Contains dependencies versions
  */
object Versions {

  lazy val jdkVersion: String = "1.8"

  lazy val akkaVersion: String = "2.4.2"
  lazy val levelDBVersion: String = "0.7"
  lazy val levelDBJniVersion: String = "1.8"

  lazy val logbackVersion: String = "1.1.5"
  lazy val ficusVersion: String = "1.2.2"
  lazy val scalaTimeVersion: String = "2.10.0"

  lazy val scalazVersion: String = "7.2.0"

  lazy val specs2Version: String = "3.7.1"
  lazy val specs2ScalazVersion: String = "0.4.0"

}

/**
  * Contains dependencies
  */
object Dependencies {

  /**
    * Contains compilation modules
    */
  private[Dependencies] object CompileModules {

    lazy val akka: ModuleID = "com.typesafe.akka" %% "akka-actor" % Versions.akkaVersion
    lazy val akkaPersistence: ModuleID = "com.typesafe.akka" %% "akka-persistence" % Versions.akkaVersion
    lazy val akkaSlf4j: ModuleID = "com.typesafe.akka" %% "akka-slf4j" % Versions.akkaVersion

    lazy val levelDB: ModuleID = "org.iq80.leveldb" % "leveldb" % Versions.levelDBVersion
    lazy val levelDBJni: ModuleID = "org.fusesource.leveldbjni" % "leveldbjni-all" % Versions.levelDBJniVersion

    lazy val logbackCore: ModuleID = "ch.qos.logback" % "logback-core" % Versions.logbackVersion
    lazy val logbackClassic: ModuleID = "ch.qos.logback" % "logback-classic" % Versions.logbackVersion
    lazy val ficus: ModuleID = "com.iheart" %% "ficus" % Versions.ficusVersion
    lazy val scalaTime: ModuleID = "com.github.nscala-time" %% "nscala-time" % Versions.scalaTimeVersion

    lazy val scalaz: ModuleID = "org.scalaz" %% "scalaz-core" % Versions.scalazVersion

  }

  /**
    * Contains testing modules
    */
  private[Dependencies] object TestModules {

    lazy val akkaTestkit: ModuleID = "com.typesafe.akka" %% "akka-testkit" % Versions.akkaVersion % "test"
    lazy val specs2: ModuleID = "org.specs2" %% "specs2-core" % Versions.specs2Version % "test"
    lazy val specs2Scalaz: ModuleID = "org.typelevel" %% "scalaz-specs2" % Versions.specs2ScalazVersion % "test"

  }

  import Dependencies.{CompileModules => C, TestModules => T}

  private[Dependencies] val akka: Seq[ModuleID] = Seq(C.akka, C.akkaPersistence, C.akkaSlf4j)
  private[Dependencies] val persistence: Seq[ModuleID] = Seq(C.levelDB, C.levelDBJni)
  private[Dependencies] val utils: Seq[ModuleID] = Seq(C.logbackCore, C.logbackClassic, C.ficus, C.scalaTime)
  private[Dependencies] val functional: Seq[ModuleID] = Seq(C.scalaz)
  private[Dependencies] val test: Seq[ModuleID] = Seq(T.akkaTestkit, T.specs2, T.specs2Scalaz)

  val all: Seq[ModuleID] = akka ++ persistence ++ utils ++ functional ++ test
}
