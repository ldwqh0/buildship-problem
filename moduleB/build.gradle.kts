plugins {
    id("com.xzcode.java-conventions")
}
dependencies {
    compileOnly(project(":moduleA"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}
