#### ?
This is a template written in Kotlin for creating high level plugins for Spigot servers.
It comes with configured gradle, debug server, mysql-pool (with jdbc, async querys and prepared statements), config and other helpful stuff.

#### Whats included

- [HikariCP](https://github.com/brettwooldridge/HikariCP) - managing mysql pool
- [Gradle plugin-yml](https://github.com/Minecrell/plugin-yml) - generating plugin.yml from gradle build config
- [Shadow](https://github.com/johnrengelman/shadow) - creating fat/uber JARs, apply file transforms, and relocate packages for applications and libraries
- [Kutils](https://github.com/hazae41/mc-kutils) - ultimate Kotlin library for Minecraft plugin development
- [Logback](https://github.com/qos-ch/logback) (optional) - get deep debug and trace logs

#### Installation

I recommand to use [JetBrains IntelliJ IDEA](https://www.jetbrains.com/de-de/idea/). There is also an gradle integration build-in.
To use this project just clone this repository and import the gradle project.

#### Plugin.yml
You can configure the plugin.yml at the bottom of the `build.gradle` file

#### Debug server

In this project you get a configured development server in gradle. To get started you have to put your spigot or paperspigot jar in `debug/config`. Name it `spigot.jar`.
To start the dev server run the following gradle tasks:

1. ```clean``` (in group "_debug")
2. ```jar``` (in group "build")
3. ```startDevServer``` (in group "_debug")
