import com.ewerk.gradle.plugins.tasks.QuerydslCompile

plugins {
    id("org.springframework.boot") version "2.2.7.RELEASE"
    id("org.asciidoctor.convert") version "1.5.9.2"
    java
    id("com.ewerk.gradle.plugins.querydsl") version "1.0.10"

}

group = "com.nespot2"
version = "0.0.1"
apply(plugin = "io.spring.dependency-management")

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
}

val querydslSrcDir = "$buildDir/generated/querydsl"

querydsl {
    library = "com.querydsl:querydsl-apt"
    jpa = true
    querydslSourcesDir = querydslSrcDir
}

tasks.getByName<QuerydslCompile>("compileQuerydsl") {
    options.annotationProcessorPath = configurations.getByName("querydsl")
}

configurations.getByName("querydsl") {
    extendsFrom(configurations.getByName("compileClasspath"))
}

sourceSets {
    getByName("main").java.srcDirs(listOf("src/main/java", querydslSrcDir))
}

val snippetsDir by extra { file("$buildDir/generated-snippets") }

tasks {

    test {
        outputs.dir(snippetsDir)
    }

    asciidoctor {
        inputs.dir(snippetsDir)
        dependsOn(test)
    }

    bootJar {
        dependsOn(asciidoctor)
        from("$buildDir/asciidoc/html5") {
            into("static/docs")
        }
    }
}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.auth0:java-jwt:3.8.3")
    implementation("com.querydsl:querydsl-jpa")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude("org.junit.vintage:junit-vintage-engine")
    }
    testImplementation("org.springframework.security:spring-security-test")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.5.7")
    implementation("org.passay:passay:1.6.0")

    asciidoctor("org.springframework.restdocs:spring-restdocs-asciidoctor:2.0.4.RELEASE")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc:2.0.4.RELEASE")
}