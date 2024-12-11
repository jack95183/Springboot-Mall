pipeline {
    agent any

    tools {
        maven 'Maven 3.9.9'
    }

    stages {
        stage('Checkout') {
            steps {
                // 从 GitHub 仓库中检出代码
                git url: 'https://github.com/jack95183/Springboot-Mall.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                // 构建 Spring Boot 项目
                sh 'mvn clean package'
            }
        }

        stage('Run') {
            steps {
                // 运行 Spring Boot 应用
                sh 'java -jar target/springboot-mall-0.0.1-SNAPSHOT.jar'
            }
        }
    }
}