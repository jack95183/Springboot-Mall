pipeline {
    agent any
    environment {
        DOCKER_IMAGE = "jack95183/springboot-mall"
        KUBERNETES_NAMESPACE = "default"
        DEPLOYMENT_NAME = "springboot-mall"
        KUBECONFIG_CREDENTIALS_ID = 'kubeconfig-credentials'
    }
    tools {
        maven 'M3'  // 確保在 Jenkins 中已經配置了 Maven 工具
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/jack95183/Springboot-Mall.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t ${DOCKER_IMAGE}:${BUILD_NUMBER} .'
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    sh """
                        docker login -u your_dockerhub_username -p your_dockerhub_password
                        docker push ${DOCKER_IMAGE}:${BUILD_NUMBER}
                    """
                }
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                script {
                    withKubeConfig([credentialsId: KUBECONFIG_CREDENTIALS_ID]) {
                        sh "kubectl set image deployment/${DEPLOYMENT_NAME} ${DEPLOYMENT_NAME}=${DOCKER_IMAGE}:${BUILD_NUMBER} -n ${KUBERNETES_NAMESPACE}"
                    }
                }
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}
