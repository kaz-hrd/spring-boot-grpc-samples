import com.google.protobuf.gradle.id

plugins {
	java
	id("com.google.protobuf") version "0.9.5"
	id("maven-publish")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
description = "gRPC Protocol Buffers Library"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenLocal()
	mavenCentral()
}

dependencies {
	implementation("io.grpc:grpc-protobuf:1.67.1")
	implementation("io.grpc:grpc-services:1.67.1")
	implementation("com.google.protobuf:protobuf-java:4.28.2")
}

protobuf {
	protoc {
		artifact = "com.google.protobuf:protoc:4.28.2"
	}
	plugins {
		id("grpc") {
			artifact = "io.grpc:protoc-gen-grpc-java:1.67.1"
		}
	}
	generateProtoTasks {
		all().forEach {
			it.plugins {
				id("grpc") {
					option("@generated=omit")
				}
			}
		}
	}
}

// 公開設定
publishing {
	publications {
		create<MavenPublication>("maven") {
			from(components["java"])
			groupId = project.group.toString()
			artifactId = project.name
			version = project.version.toString()
		}
	}
}
