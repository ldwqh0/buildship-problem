group = "com.xzcode"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

plugins {
    `java-library`
    `maven-publish`
    `eclipse`
    id("io.spring.dependency-management")
}

eclipse {
    classpath {
        plusConfigurations.plus(configurations.compileOnly)
    }
}


dependencyManagement {
    dependencies {
        dependencies {
            dependency("commons-io:commons-io:2.11.0")
            dependency("org.junit.jupiter:junit-jupiter-api:5.8.1")
            dependency("org.junit.jupiter:junit-jupiter-engine:5.8.1")
        }
    }
}



java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
    withSourcesJar()
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
        versionMapping {
            usage("java-api") {
                fromResolutionOf("runtimeClasspath")
            }
            usage("java-runtime") {
                fromResolutionResult()
            }
        }
    }
    repositories {
        mavenLocal()
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
