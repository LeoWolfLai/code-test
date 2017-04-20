name := "code test"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= {
	val akkaVer  = "2.4.8"
	Seq(
		"joda-time"                   %  "joda-time"                          % "2.8.1",
		"commons-codec"               % "commons-codec"                       % "1.7",
		"com.typesafe.akka"           %% "akka-actor"                         % akkaVer     withSources() withJavadoc(),
		"com.typesafe.akka"           %% "akka-cluster"                       % akkaVer     withSources() withJavadoc(),
		"com.typesafe.akka"           %% "akka-cluster-sharding"              % akkaVer     withSources() withJavadoc(),
		"com.typesafe.akka"           %% "akka-slf4j"                         % akkaVer     withSources() withJavadoc(),
		"com.typesafe.akka"           %% "akka-stream"                        % akkaVer     withSources() withJavadoc(),
		"com.typesafe.akka"           %% "akka-http-experimental"             % akkaVer     withSources() withJavadoc(),
		"com.typesafe.akka"           %% "akka-http-spray-json-experimental"  % akkaVer     withSources() withJavadoc()
	)
}