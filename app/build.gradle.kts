//引用插件
plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")

}

android {
    compileSdk = AppConfig.compileSdkVersion
    buildToolsVersion = AppConfig.buildToolsVersion
    defaultConfig {
        applicationId = AppConfig.application_Id
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        kapt {
            arguments {
                arg("AROUTER_MODULE_NAME", project.name)
            }
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
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

    ndkVersion = "20.0.5594570"
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*jar"))))

    implementation(project(":lib_base"))

    if (!ModuleConfig.isApp) {
        implementation(project(":module_app_manager"))
        implementation(project(":module_constellation"))
        implementation(project(":module_developer"))
        implementation(project(":module_joke"))
        implementation(project(":module_map"))
        implementation(project(":module_setting"))
        implementation(project(":module_voice_setting"))
        implementation(project(":module_weather"))
    }

    //运行时注解
    kapt(DependenciesConfig.AROUTER_COMPILER)

}