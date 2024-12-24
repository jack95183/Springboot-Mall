pipeline {
    agent any
    environment {
        DOCKER_IMAGE = "jack95183/springboot-mall"
        KUBERNETES_NAMESPACE = "default"
        DEPLOYMENT_NAME = "springboot-mall"
        KUBECONFIG_CREDENTIALS_ID = 'kubeconfig-credentials'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/jack95183/Springboot-Mall.git'
            }
        }
        stage('Build') {
            steps {
                sh './mvnw clean package'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("$DOCKER_IMAGE:${env.BUILD_NUMBER}")
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credentials') {
                        docker.image("$DOCKER_IMAGE:${env.BUILD_NUMBER}").push()
                    }
                }
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                script {
                    withKubeConfig([credentialsId: env.KUBECONFIG_CREDENTIALS_ID]) {
                        kubectl("set image deployment/$DEPLOYMENT_NAME $DEPLOYMENT_NAME=$DOCKER_IMAGE:${env.BUILD_NUMBER} -n $KUBERNETES_NAMESPACE")
                    }
                }
            }
        }
    }
}

def kubectl(cmd) {
    sh "kubectl ${cmd}"
}