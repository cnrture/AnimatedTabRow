plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.canerture.animatedtabrow"
    compileSdk = 34

    defaultConfig {
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

afterEvaluate {
    android.libraryVariants.forEach {
        publishing {
            publications {
                register<MavenPublication>(it.name) {
                    from(components.findByName(it.name))

                    groupId = "com.github.canerture"
                    artifactId = "animatedtablayout"
                    version = "1.0"
                }
            }
        }
    }
}

dependencies {
    implementation("androidx.compose.material3:material3:1.1.2")
}