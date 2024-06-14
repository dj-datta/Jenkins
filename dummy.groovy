pipeline {
    agent any
    stages {
        stage('Pull') {
            steps {
                echo '"pull successfully"'
            }
        }
        stage('Build') {
            steps {
                echo '"Build successfully"'
            }
        }
        stage('Test') {
            steps {
                echo '"Test successfully"'
            }
        }
        stage('Deploy') {
            steps {
                echo '"Deploy successfully"'
            }
        }
    }
} 
