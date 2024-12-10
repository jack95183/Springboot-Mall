pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // 从 GitHub 仓库中检出代码
                git 'https://github.com/<your-github-username>/Springboot-Mall.git'
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

pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // 使用凭据检出代码
                git url: 'https://github.com/jack95183/Springboot-Mall.git', credentialsId: 'github-credentials'
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
