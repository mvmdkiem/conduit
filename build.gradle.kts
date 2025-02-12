plugins {
    id("java-library")
}

group = "com.conduit"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // JUnit 5 설정
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // 기존 JUnit 5, SLF4J 의존성 유지
    testImplementation("org.mockito:mockito-core:5.4.0") // Mockito Core
    testImplementation("org.mockito:mockito-junit-jupiter:5.4.0") // JUnit 5용 Mockito 확장

    // SLF4J 및 Logback 추가
    implementation("org.slf4j:slf4j-api:2.0.9")
    runtimeOnly("ch.qos.logback:logback-classic:1.4.11")
}

tasks.test {
    useJUnitPlatform()
    jvmArgs = listOf("-Xmx1024m", "-XX:+UseG1GC", "-XX:MaxMetaspaceSize=256m")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}
