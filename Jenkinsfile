pipeline {
    agent any
    
    environment {
        DOCKER_IMAGE_NAME = 'calculatorjava'
        GITHUB_REPO_URL = 'https://github.com/anarghya15/SPEMiniProject.git'
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
                    sh 'docker tag "${DOCKER_IMAGE_NAME}" anarghya15/calculatorjava:latest'
                    sh 'docker push anarghya15/calculatorjava'
                    }
                 }
            }
        }
        
        stage('Run Ansible Playbook') {
            steps {
                script {
                    ansiblePlaybook(
                        playbook: 'deploy.yml',
                        inventory: 'inventory'
                     )
                }
            }
        }
    }
    post {
        success {
            mail subject: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
      			body: """SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':
                Check console output at ${env.BUILD_URL}""", 
            	to: 'h.anarghya@iiitb.ac.in'
        }
        failure {
            mail subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
      			body: """FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':
                Check console output at ${env.BUILD_URL}""", 
            	to: 'h.anarghya@iiitb.ac.in'
        }
    }
}

