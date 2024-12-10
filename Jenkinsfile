pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // 使用公开仓库 URL
                git url: 'https://github.com/jack95183/Springboot-Mall.git'
            }
        }

        stage('Build') {
            steps {
                // 构建 Spring Boot 项目
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build('springboot-mall:latest')
                }
            }
        }

        stage('Deploy') {
            steps {
                // 运行 Docker 容器
                sh 'docker run -d -p 8080:8080 springboot-mall:latest'
            }
        }
    }
}
