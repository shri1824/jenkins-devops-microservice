pipeline {
    // agent {docker { image 'maven:latest'}}
    agent any
    environment {
        dockerHome = tool 'myDocker' // Assuming you have a Docker tool configured in Jenkins
        mavenHome = tool 'myMaven' // Assuming you have a Maven tool configured in Jenkins
        PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
        // MAVEN_HOME = '/usr/local/maven'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn --version'
                sh 'docker --version'
                echo 'Building...'
                echo "BUILD_NUMBER: ${BUILD_NUMBER}"
                echo "BUILD_URL: ${BUILD_URL}"
                // Add your build steps here
            }
        }
        stage('Compile') {
            steps {
                sh 'mvn clean compile'
                               // Add your compile steps here
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
                // Add your test steps here
            }
        }
        stage('Package') {
            steps {
                sh 'mvn clean package'
                // Add your package steps here
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    // def imageName = "shri18242/jenkins-devops-microservice:${BUILD_NUMBER}"
                    //sh "docker build -t ${imageName} ."
                     dockerImage = docker.build("shri18242/jenkins-devops-microservice:${BUILD_NUMBER}")
                    // Optionally, you can push the image to a registry here
                }
           }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', 'githubcredencial') {
                    //sh "docker push ${imageName}"
                    dockerImage.push();
                    dockerImage.push('latest'); // Optionally tag as latest
                    }
                }
            }
        }
        stage('Deploy') {
          steps {
            script {
                            // 2. Run the new container from the image you just pushed
                // Note: Replace 'your-docker-id' with your actual username
                sh 'docker run -d --name learning-jenkins -p 8085:8085 shri18242/jenkins-devops-microservice:latest'
            }
          } 
         }

    }
    post {
        always {
            echo 'This will always run after the stages.'
            // Add any cleanup steps here
        }
        success {
            echo 'This will run only if the stages succeed.'
            // Add any success steps here
        }        
        failure {
            echo 'This will run only if the stages fail.'
            // Add any failure steps here
        }
    }
}