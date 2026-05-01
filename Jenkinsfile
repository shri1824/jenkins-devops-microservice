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
 
        stage('Check GCP auth') {
            steps {
                sh 'gcloud auth list'
                // Add any additional GCP authentication checks here
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