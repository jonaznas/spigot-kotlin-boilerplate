#### ?
This is a template written in Kotlin for creating high level plugins for Spigot servers.
It comes with configured gradle, debug server, command mapping with annotation, sql framework, config and other helpful stuff.

#### Whats included

- [HikariCP](https://github.com/brettwooldridge/HikariCP) - managing mysql pool
- [Exposed](https://github.com/JetBrains/Exposed) - sql framework
- [Shadow](https://github.com/johnrengelman/shadow) - creating fat/uber JARs, apply file transforms, and relocate packages for applications and libraries
- [Kutils](https://github.com/hazae41/mc-kutils) - ultimate Kotlin library for Minecraft plugin development
- [Logback](https://github.com/qos-ch/logback) (optional) - get deep debug and trace logs

#### Installation

I recommand to use [JetBrains IntelliJ IDEA](https://www.jetbrains.com/de-de/idea/). There is also an gradle integration build-in.
To use this project just clone this repository and import the gradle project.

#### Database

The Database is configured to PostgreSQL. To change it to MySQL, Oracle, SQLite, H2 or SQL Server take a look at [this documentation](https://github.com/JetBrains/Exposed/wiki/DataBase-and-DataSource)

#### Plugin.yml
You can configure the plugin.yml at the bottom of the `build.gradle` file

#### Debug server

In this project you get a configured development server in gradle. To get started you have to put your spigot or paperspigot jar in `debug/config`. Name it `spigot.jar`.
To start the dev server run the following gradle tasks:

1. ```clean``` (in group "_debug")
2. ```jar``` (in group "build")
3. ```startDevServer``` (in group "_debug")
