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
                 sh '/opt/maven/bin/mvn clean package '
            }
        }
        stage('Test') {
            steps {
                sh '''/opt/maven/bin/mvn sonar:sonar \\
                     -Dsonar.projectKey=studentapp \\
                     -Dsonar.host.url=http://100.26.177.100:9000 \\
                     -Dsonar.login=3b5d8530cea773afa33c2656625413b9b5503c47'''
            }
        }
        stage('Deploy') {
            steps {
                echo '"Deploy successfully"'
            }
        }
    }
} 
