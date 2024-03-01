pipeline {
    agent any
    
    environment {
        DOCKER_IMAGE_NAME = 'calculatorjava'
        GITHUB_REPO_URL = 'https://github.com/VedanteePathak/Calculator-Mini-Project.git'
    }
    
    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the GitHub repository
                git branch: 'main', url: "${GITHUB_REPO_URL}"
            }
        }
        
        stage('Build the Maven Project') {
            steps {
                // Build the Maven project
                sh 'mvn clean package'
            }
        }
        
        stage('Test the Maven project') { 
            steps {
                sh 'mvn test' 
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
        
        stage('Build the Docker Image') {
            steps {
                script {
                    // Build Docker image
                    docker.build("${DOCKER_IMAGE_NAME}", '.')
                }
            }
        }
        
        stage('Push the Docker Image') {
            steps {
                script{
                    docker.withRegistry('', 'DockerHubCred') {
                    sh 'docker tag "${DOCKER_IMAGE_NAME}" vedanteepathak/calculatorjava:latest'
                    sh 'docker push vedanteepathak/calculatorjava'
                    }
                 }
            }
        }
        
        stage('Run Ansible Playbook') {
            steps {
                script {
                    sh 'ansible-playbook deploy.yml'
                }
            }
        }
    }
    
}

