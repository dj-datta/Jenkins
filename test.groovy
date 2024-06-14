pipeline {
    agent any
    stages {
        stage('Pull') {
            steps {
                git 'https://github.com/sharadrathod/studentapp-ui.git'
            }
        }
        stage('Build') {
            steps { 
                sh 'mvn clean package '
            }
        }
        stage('Test') {
            steps {
                sh '''mvn sonar:sonar \\
  -Dsonar.projectKey=studentapp \\
  -Dsonar.host.url=http://52.91.116.200:9000 \\
  -Dsonar.login=108f1ac163e9f9d6ba1f4c3d2269f84981411431'''
            }
        }
        stage('Deploy') {
            steps {
                echo '"Deploy successfully"'
            }
        }
    }
} 
