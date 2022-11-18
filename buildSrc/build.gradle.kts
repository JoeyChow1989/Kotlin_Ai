apply{
    plugin("kotlin")
}

buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", "1.7.10"))
    }
}

dependencies {
    implementation(gradleKotlinDsl())
    implementation(kotlin("stdlib", "1.7.10"))
}

repositories {
    gradlePluginPortal()
}