import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("com.github.johnrengelman.shadow") version "2.0.4"
    kotlin("jvm") version "1.3.71"
}

group = "dev.jonaz.plugin"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    jcenter()
    mavenCentral()
    maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven(url = "https://jitpack.io")
}

dependencies {
    /**
     * Use "compileOnly" to exclude from packing into the jar file
     */
    compileOnly("org.bukkit:bukkit:1.8.8-R0.1-SNAPSHOT")

    implementation("com.zaxxer:HikariCP:3.4.1")
    implementation("com.github.hazae41:mc-kutils:master-SNAPSHOT")
    implementation("ch.qos.logback:logback-classic:1.2.1")

    implementation("org.reflections:reflections:0.9.12")
    implementation("org.postgresql:postgresql:42.2.2")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3")
    implementation("org.jetbrains.exposed:exposed-core:0.22.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.22.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.22.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.61")
    implementation("org.jetbrains.exposed:exposed-java-time:0.22.1")

    shadow("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

tasks.named<ShadowJar>("shadowJar") {
    manifest {
        attributes(mapOf("Main-Class" to "$group/Main"))
    }
}

tasks.build {
    dependsOn("shadowJar")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
