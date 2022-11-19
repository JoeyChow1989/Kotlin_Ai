buildscript {

    repositories {
        mavenCentral()
        maven { setUrl("https://mvn.mob.com/android") }
        maven { setUrl("https://maven.aliyun.com/nexus/content/repositories/google") }
        maven { setUrl("https://jitpack.io") }
        maven { setUrl("https://repo1.maven.org/maven2/") }
        maven { setUrl("https://maven.aliyun.com/repository/public/") }
        maven { setUrl("https://maven.aliyun.com/nexus/content/repositories/jcenter") }
        google()

    }
    dependencies {
        classpath("com.android.tools.build:gradle:${KotlinConstants.gradle_version}")
        classpath("com.github.dcendents:android-maven-gradle-plugin:2.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
    }
}

allprojects {
    repositories {
        mavenCentral()
        maven { setUrl("https://mvn.mob.com/android") }
        maven { setUrl("https://maven.aliyun.com/nexus/content/repositories/google") }
        maven { setUrl("https://jitpack.io") }
        maven { setUrl("https://repo1.maven.org/maven2/") }
        maven { setUrl("https://maven.aliyun.com/repository/public/") }
        maven { setUrl("https://maven.aliyun.com/nexus/content/repositories/jcenter") }
        google()

    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}

