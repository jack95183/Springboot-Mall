pipeline {
    agent {
        docker {
            image 'maven:3.6.3-jdk-11'
            args '-v /var/jenkins_home:/var/jenkins_home'
        }
    }

    stages {
        stage('Checkout') {
            steps {
                dir('/var/jenkins_home/workspace') {
                    // 使用公开仓库 URL
                    git url: 'https://github.com/jack95183/Springboot-Mall.git'
                }
            }
        }

        stage('Build') {
            steps {
                dir('/var/jenkins_home/workspace/Springboot-Mall') {
                    // 构建 Spring Boot 项目
                    sh 'mvn clean package'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                dir('/var/jenkins_home/workspace/Springboot-Mall') {
                    script {
                        docker.build('springboot-mall:latest')
                    }
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
