//应用插件
plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(AppConfig.compileSdkVersion)
    buildToolsVersion(AppConfig.buildToolsVersion)
    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdkVersion(AppConfig.minSdkVersion)
        targetSdkVersion(AppConfig.targetSdkVersion)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

    }

    //签名配置
    signingConfigs {
        register("release") {
            //别名
            keyAlias = "key0"
            //别名密码
            keyPassword = "123456"
            //路径
            storeFile = file("src/main/jks/kotlin_ai.jsk")
            //密码
            storePassword = "123456"
        }
    }

    buildTypes {
        getByName("debug") {

        }
        getByName("release") {
            isMinifyEnabled = false
            //自动打包签名
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    //输出类型
    android.applicationVariants.all {
        //编译类型
        val buildType = this.buildType.name
        outputs.all {
            //输出APK
            if (this is com.android.build.gradle.internal.api.ApkVariantOutputImpl) {
                if (buildType == "release") {
                    this.outputFileName = "Kotlin_AI_V${defaultConfig.versionName}_$buildType.apk"
                }
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*jar"))))
    implementation(DependenciesConfig.KTX_CORE)
    implementation(DependenciesConfig.STD_LIB)
    implementation(DependenciesConfig.APP_COMPAT)

}