pipeline {
    agent {
        docker {
            image 'maven:3.8.4-openjdk-17'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn --version'
                echo 'Building...'
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
        changed {
            echo 'This will run only if there is a change in the SCM.(build like from fail to success)'
            // Add any steps to handle changes here
        }
    }
}