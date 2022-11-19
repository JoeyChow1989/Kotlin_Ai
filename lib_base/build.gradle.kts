plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdk = AppConfig.compileSdkVersion
    buildToolsVersion = AppConfig.buildToolsVersion
    defaultConfig {
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {
    api(fileTree(mapOf("dir" to "libs", "include" to listOf("*jar"))))
    //Kotlin核心库
    api(DependenciesConfig.KTX_CORE)
    //Kotlin基础库
    api(DependenciesConfig.STD_LIB)
    //Android标准库
    api(DependenciesConfig.APP_COMPAT)
    //EventBus
    api(DependenciesConfig.EVENT_BUS)

    //ARouterR路由
    api(DependenciesConfig.AROUTER)




    api(project(":lib_network"))
    api(project(":lib_voice"))


}