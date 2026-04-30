pipeline {
    // agent {docker { image 'maven:latest'}}
    stages {
        stage('Build') {
            steps {
                // sh 'mvn --version'
                echo 'Building...'
                echo 'BUILD_NUMBER: ${env.BUILD_ID}'
                echo 'JOB_NAME: ${env.JOB_NAME}'
                // Add your build steps here
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                // Add your test steps here
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Add your deploy steps here
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