pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }

    stages {

        stage('Build') {
            steps {
                sh '''
                   java -version
                   mvn -version
                   mvn clean package
                '''
            }
        }
    }

    post {
        success {
            echo 'Build completed successfully'
        }
        failure {
            echo 'Build failed'
        }
    }
}
